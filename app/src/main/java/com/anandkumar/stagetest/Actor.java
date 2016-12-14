package com.anandkumar.stagetest;

/**
 * Created by Anand on 12/14/2016.
 */
import com.google.gson.annotations.SerializedName;

public class Actor {

    private int id;

    private String login;

    @SerializedName("display_login")
    private String displayLogin;
    @SerializedName("gravatar_id")
    private String gravatarId;
    private String url;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayLogin() {
        return displayLogin;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
