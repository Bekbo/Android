package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGames implements Parcelable {
    @SerializedName("data")
    @Expose
    public List<Game> data;
    @SerializedName("meta")
    @Expose
    public Meta meta;

    protected ResponseGames(Parcel in) {
        data = in.createTypedArrayList(Game.CREATOR);
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

    public static final Creator<ResponseGames> CREATOR = new Creator<ResponseGames>() {
        @Override
        public ResponseGames createFromParcel(Parcel in) {
            return new ResponseGames(in);
        }

        @Override
        public ResponseGames[] newArray(int size) {
            return new ResponseGames[size];
        }
    };
}
