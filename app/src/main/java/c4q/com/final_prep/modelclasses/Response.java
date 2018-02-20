package c4q.com.final_prep.modelclasses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * Created by D on 2/18/18.
 */

public class Response {

    @SerializedName("results")
    ArrayList<User> user;

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public ArrayList<User> getUser() {
        return user;
    }
}
