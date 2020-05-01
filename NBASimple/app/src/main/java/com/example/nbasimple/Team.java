package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class Team implements Parcelable {
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("abbreviation")
    @Expose
    String abbreviation ;
    @SerializedName("city")
    @Expose
    String city;
    @SerializedName("conference")
    @Expose
    String conference;
    @SerializedName("division")
    @Expose
    String division;
    @SerializedName("full_name")
    @Expose
    String full_name;
    @SerializedName("name")
    @Expose
    String name;

    public Team(){}

    protected Team(Parcel in) {
        id = in.readInt();
        abbreviation = in.readString();
        city = in.readString();
        conference = in.readString();
        division = in.readString();
        full_name = in.readString();
        name = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id+"");
        dest.writeString(abbreviation);
        dest.writeString(city);
        dest.writeString(conference);
        dest.writeString(division);
        dest.writeString(full_name);
        dest.writeString(name);
    }

    @NonNull
    @Override
    public String toString() {
        return abbreviation + " " + full_name +" " + id;
    }
}
