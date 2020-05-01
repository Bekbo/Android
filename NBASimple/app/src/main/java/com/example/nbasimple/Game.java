package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game implements Parcelable {
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("date")
    @Expose
    String date;
    @SerializedName("home_team")
    @Expose
    Team home_team;
    @SerializedName("home_team_score")
    @Expose
    int home_team_score;
    @SerializedName("period")
    @Expose
    int period;
    @SerializedName("postseason")
    @Expose
    boolean postseason;
    @SerializedName("season")
    @Expose
    int season;
    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("time")
    @Expose
    String time;
    @SerializedName("visitor_team")
    @Expose
    Team away_team;
    @SerializedName("visitor_team_score")
    @Expose
    int visitor_team_score;

    protected Game(Parcel in) {
        id = in.readInt();
        date = in.readString();
        home_team = in.readParcelable(Team.class.getClassLoader());
        home_team_score = in.readInt();
        period = in.readInt();
        postseason = in.readByte() != 0;
        season = in.readInt();
        status = in.readString();
        time = in.readString();
        away_team = in.readParcelable(Team.class.getClassLoader());
        visitor_team_score = in.readInt();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(date);
        dest.writeParcelable(home_team, flags);
        dest.writeInt(home_team_score);
        dest.writeInt(period);
        dest.writeByte((byte) (postseason ? 1 : 0));
        dest.writeInt(season);
        dest.writeString(status);
        dest.writeString(time);
        dest.writeParcelable(away_team, flags);
        dest.writeInt(visitor_team_score);
    }

    @NonNull
    @Override
    public String toString() {
        return home_team + " " + away_team + " " + season + " " + status + " "  + date;
    }
}
