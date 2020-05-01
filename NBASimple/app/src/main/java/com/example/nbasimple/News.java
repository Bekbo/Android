package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News implements Parcelable {
    @PrimaryKey
    @NonNull
    @SerializedName("NewsID")
    @Expose
    public Integer newsID;
    @SerializedName("Source")
    @Expose
    public String source;
    @SerializedName("Updated")
    @Expose
    public String updated;
    @SerializedName("TimeAgo")
    @Expose
    public String timeAgo;
    @SerializedName("Title")
    @Expose
    public String title;
    @SerializedName("Content")
    @Expose
    public String content;
    @SerializedName("Url")
    @Expose
    public String url;
    @SerializedName("TermsOfUse")
    @Expose
    public String termsOfUse;
    @SerializedName("Author")
    @Expose
    public String author;
    @SerializedName("Categories")
    @Expose
    public String categories;
    @SerializedName("PlayerID")
    @Expose
    public Integer playerID;
    @SerializedName("TeamID")
    @Expose
    public Integer teamID;
    @SerializedName("Team")
    @Expose
    public String team;
    @SerializedName("PlayerID2")
    @Expose
    public Object playerID2;
    @SerializedName("TeamID2")
    @Expose
    public Object teamID2;
    @SerializedName("Team2")
    @Expose
    public Object team2;
    public News() {}

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    protected News(Parcel in) {
        this.newsID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.updated = ((String) in.readValue((String.class.getClassLoader())));
        this.timeAgo = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.content = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.termsOfUse = ((String) in.readValue((String.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
        this.categories = ((String) in.readValue((String.class.getClassLoader())));
        this.playerID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.teamID = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.team = ((String) in.readValue((String.class.getClassLoader())));
        this.playerID2 = ((Object) in.readValue((Object.class.getClassLoader())));
        this.teamID2 = ((Object) in.readValue((Object.class.getClassLoader())));
        this.team2 = ((Object) in.readValue((Object.class.getClassLoader())));
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(newsID);
        dest.writeValue(source);
        dest.writeValue(updated);
        dest.writeValue(timeAgo);
        dest.writeValue(title);
        dest.writeValue(content);
        dest.writeValue(url);
        dest.writeValue(termsOfUse);
        dest.writeValue(author);
        dest.writeValue(categories);
        dest.writeValue(playerID);
        dest.writeValue(teamID);
        dest.writeValue(team);
        dest.writeValue(playerID2);
        dest.writeValue(teamID2);
        dest.writeValue(team2);
    }
}
