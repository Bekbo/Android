package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player implements Parcelable
{
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("first_name")
    @Expose
    public String firstName;
    @SerializedName("height_feet")
    @Expose
    public Integer heightFeet;
    @SerializedName("height_inches")
    @Expose
    public Integer heightInches;
    @SerializedName("last_name")
    @Expose
    public String lastName;
    @SerializedName("position")
    @Expose
    public String position;
    @SerializedName("team")
    @Expose
    public Team team;
    @SerializedName("weight_pounds")
    @Expose
    public Integer weightPounds;

    public Player(){}

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    protected Player(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.firstName = ((String) in.readValue((String.class.getClassLoader())));
        this.heightFeet = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.heightInches = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.lastName = ((String) in.readValue((String.class.getClassLoader())));
        this.position = ((String) in.readValue((String.class.getClassLoader())));
        this.team = ((Team) in.readValue((Team.class.getClassLoader())));
        this.weightPounds = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(firstName);
        dest.writeValue(heightFeet);
        dest.writeValue(heightInches);
        dest.writeValue(lastName);
        dest.writeValue(position);
        dest.writeValue(team);
        dest.writeValue(weightPounds);
    }

    public int describeContents() {
        return 0;
    }

}