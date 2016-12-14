package com.anandkumar.stagetest;

/**
 * Created by Anand on 12/14/2016.
 */
import com.google.gson.annotations.SerializedName;

public class Event {


    private String id;

    private String type;

    @SerializedName("public")
    private boolean isPublic;

    @SerializedName("created_at")
    private String createdTime;

    private Actor actor;
    private Repo repo;
    //private Payload payload;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public Actor getActor() {
        return actor;
    }

    public Repo getRepo() {
        return repo;
    }

    /*public Payload getPayload() {
        return payload;
    }*/
}
