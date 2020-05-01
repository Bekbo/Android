package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultTeam implements Parcelable {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("abbreviation")
    @Expose
    public String abbreviation;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("conference")
    @Expose
    public String conference;
    @SerializedName("division")
    @Expose
    public String division;
    @SerializedName("full_name")
    @Expose
    public String fullName;
    @SerializedName("name")
    @Expose
    public String name;

    protected ResultTeam(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.abbreviation = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.conference = ((String) in.readValue((String.class.getClassLoader())));
        this.division = ((String) in.readValue((String.class.getClassLoader())));
        this.fullName = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ResultTeam() {
    }

    public static final Creator<ResultTeam> CREATOR = new Creator<ResultTeam>() {
        @Override
        public ResultTeam createFromParcel(Parcel in) {
            return new ResultTeam(in);
        }

        @Override
        public ResultTeam[] newArray(int size) {
            return new ResultTeam[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(abbreviation);
        dest.writeValue(city);
        dest.writeValue(conference);
        dest.writeValue(division);
        dest.writeValue(fullName);
        dest.writeValue(name);
    }

    public int describeContents() {
        return 0;
    }

}
