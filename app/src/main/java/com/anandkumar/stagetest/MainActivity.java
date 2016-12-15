package com.anandkumar.stagetest;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private Button submitButton;
    private EditText inputName;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputLayout = (TextInputLayout) findViewById(R.id.input_layout_userName);
        textInputLayout.setHint("Enter User Name");
        submitButton = (Button) findViewById(R.id.submit);
        inputName = (EditText) findViewById(R.id.input_userName);
        inputName.addTextChangedListener(new MyTextWatcher(inputName));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName()) {
                    return;
                } else {

                    showDialog();
                    //TODO: Read Github REST API
                    GithubInterface githubService=GithubClient.getClient().create(GithubInterface.class);

                    Call<List<Event>> events=githubService.listEvents(inputName.getText().toString());

                    events.enqueue(new Callback<List<Event>>() {
                        @Override
                        public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {

                            dismissDialog();
                            if(response.isSuccessful()){
                                List<Event> activities=response.body();

                                /*for(Event e:activities){
                                    Log.d("Event Type :: ",e.getType());
                                }*/

                                //TODO: Add all events to recyclerview.
                            }else{
                                Toast.makeText(MainActivity.this,"Please Enter Correct User Name",Toast.LENGTH_SHORT).show();
                            }




                        }

                        @Override
                        public void onFailure(Call<List<Event>> call, Throwable t) {

                                Log.d("Failure",t.toString());
                        }
                    });
                }
            }
        });
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
        }

        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_userName:
                    validateName();
                    break;

            }
        }
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private void showDialog(){
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public void dismissDialog(){
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
