package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseTeams implements Parcelable {
    @SerializedName("data")
    @Expose
    public List<Team> data;
    @SerializedName("meta")
    @Expose
    public Meta meta;

    protected ResponseTeams(Parcel in) {
        data = in.createTypedArrayList(Team.CREATOR);
        meta = in.readParcelable(Meta.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(data);
        dest.writeParcelable(meta, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseTeams> CREATOR = new Creator<ResponseTeams>() {
        @Override
        public ResponseTeams createFromParcel(Parcel in) {
            return new ResponseTeams(in);
        }

        @Override
        public ResponseTeams[] newArray(int size) {
            return new ResponseTeams[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return data + " " + meta;
    }
}
