package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponsePlayers implements Parcelable {
    @SerializedName("data")
    @Expose
    public List<Player> data;
    @SerializedName("meta")
    @Expose
    public Meta meta;

    protected ResponsePlayers(Parcel in) {
        data = in.createTypedArrayList(Player.CREATOR);
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

    public static final Creator<ResponsePlayers> CREATOR = new Creator<ResponsePlayers>() {
        @Override
        public ResponsePlayers createFromParcel(Parcel in) {
            return new ResponsePlayers(in);
        }

        @Override
        public ResponsePlayers[] newArray(int size) {
            return new ResponsePlayers[size];
        }
    };
}
