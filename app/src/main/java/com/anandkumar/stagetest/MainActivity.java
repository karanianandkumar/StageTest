package com.anandkumar.stagetest;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private Button submitButton;
    private EditText inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textInputLayout=(TextInputLayout)findViewById(R.id.input_layout_userName);
        textInputLayout.setHint("Enter User Name");
        submitButton=(Button)findViewById(R.id.submit);
        inputName=(EditText)findViewById(R.id.input_userName);
        inputName.addTextChangedListener(new MyTextWatcher(inputName));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName()) {
                    return;
                }else{
                    //TODO: Read Github REST API
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

}
