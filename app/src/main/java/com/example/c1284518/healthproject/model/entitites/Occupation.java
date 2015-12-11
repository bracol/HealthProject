package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by c1284518 on 03/12/2015.
 */
public class Occupation implements Parcelable {

    @JsonProperty("id")
    private long id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("createdAt")
    private String createdAt;


    public Occupation(){}

    public Occupation(long id, String description, String createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Occupation that = (Occupation) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        return !(createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.description);
        dest.writeString(this.createdAt);
    }

    protected Occupation(Parcel in) {
        this.id = in.readLong();
        this.description = in.readString();
        this.createdAt = in.readString();
    }

    public static final Parcelable.Creator<Occupation> CREATOR = new Parcelable.Creator<Occupation>() {
        public Occupation createFromParcel(Parcel source) {
            return new Occupation(source);
        }

        public Occupation[] newArray(int size) {
            return new Occupation[size];
        }
    };
}
