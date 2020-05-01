package com.example.nbasimple;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta implements Parcelable {
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("current_page")
    @Expose
    public Integer currentPage;
    @SerializedName("next_page")
    @Expose
    public Integer nextPage;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("total_count")
    @Expose
    public Integer totalCount;

    protected Meta(Parcel in) {
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currentPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.perPage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public static final Creator<Meta> CREATOR = new Creator<Meta>() {
        @Override
        public Meta createFromParcel(Parcel in) {
            return new Meta(in);
        }

        @Override
        public Meta[] newArray(int size) {
            return new Meta[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalPages);
        dest.writeValue(currentPage);
        dest.writeValue(nextPage);
        dest.writeValue(perPage);
        dest.writeValue(totalCount);
    }
}
