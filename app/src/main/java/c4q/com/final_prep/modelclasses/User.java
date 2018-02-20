package c4q.com.final_prep.modelclasses;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by D on 2/18/18.
 */

public class User implements Parcelable {

    private Name name;
    private Location location;
    private Picture picture;

    private String email;
    private String dob;
    private String cell;

    public User(Name name, Location location, Picture picture, String email, String dob, String cell) {
        this.name = name;
        this.location = location;
        this.picture = picture;
        this.email = email;
        this.dob = dob;
        this.cell = cell;
    }

    protected User(Parcel in) {
        email = in.readString();
        dob = in.readString();
        cell = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(dob);
        parcel.writeString(cell);
    }
}
