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

    public class Repo {

        private int id;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

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


}
