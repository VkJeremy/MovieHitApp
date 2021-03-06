package com.example.moviehitapp.business_logic.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.moviehitapp.annotations.Model;
import com.example.moviehitapp.utils.converters.MoviesConverter;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
@Model
public class MoviesResponse implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int response_id;
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    @TypeConverters(value = {MoviesConverter.class})
    private List<Movie> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getResponse_id() {
        return response_id;
    }

    public void setResponse_id(int response_id) {
        this.response_id = response_id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Movie> getResults() {
        return results;
    }

    public List<Movie> getMovies() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public void setMovies(List<Movie> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.page);
        dest.writeTypedList(this.results);
        dest.writeInt(this.totalResults);
        dest.writeInt(this.totalPages);
    }

    public MoviesResponse() {
    }

    private MoviesResponse(@NonNull Parcel in) {
        this.page = in.readInt();
        this.results = in.createTypedArrayList(Movie.CREATOR);
        this.totalResults = in.readInt();
        this.totalPages = in.readInt();
    }

    public static final Creator<MoviesResponse> CREATOR = new Creator<MoviesResponse>() {
        @Override
        public MoviesResponse createFromParcel(Parcel source) {
            return new MoviesResponse(source);
        }
        @Override
        public MoviesResponse[] newArray(int size) {
            return new MoviesResponse[size];
        }
    };

    @Override
    public int hashCode() {
        return page;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return this.hashCode() == Objects.requireNonNull(obj).hashCode();
    }
}
