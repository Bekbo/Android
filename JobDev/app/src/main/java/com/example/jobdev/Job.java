package com.example.jobdev;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class Job implements Parcelable {
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("company")
    @Expose
    public String company;
    @SerializedName("company_url")
    @Expose
    public String companyUrl;
    @SerializedName("location")
    @Expose
    public String location;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("company_logo")
    @Expose
    public String companyLogo;

    public Job(){}

    protected Job(Parcel in) {
        id = in.readString();
        type = in.readString();
        title = in.readString();
        url = in.readString();
        createdAt = in.readString();
        company = in.readString();
        companyUrl = in.readString();
        companyLogo = in.readString();
        location = in.readString();
        description = in.readString();

    }

    public static final Creator<Job> CREATOR = new Creator<Job>() {
        @Override
        public Job createFromParcel(Parcel in) {
            return new Job(in);
        }

        @Override
        public Job[] newArray(int size) {
            return new Job[size];
        }
    };

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCompanyUrl() {
        return companyUrl;
    }
    public void setCompanyUrl(String companyUrl) {
        this.companyUrl = companyUrl;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompanyLogo() {
        return companyLogo;
    }
    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(createdAt);
        dest.writeString(company);
        dest.writeString(companyUrl);
        dest.writeString(companyLogo);
        dest.writeString(location);
        dest.writeString(description);
    }


}