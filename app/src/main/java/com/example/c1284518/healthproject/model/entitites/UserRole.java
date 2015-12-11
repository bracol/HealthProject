package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by c1284518 on 11/12/2015.
 */
public class UserRole implements Parcelable {

    @JsonProperty("userId")
    long userId;
    @JsonProperty("roleId")
    long roleId;

    public UserRole(){}

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.userId);
        dest.writeLong(this.roleId);
    }

    protected UserRole(Parcel in) {
        this.userId = in.readLong();
        this.roleId = in.readLong();
    }

    public static final Parcelable.Creator<UserRole> CREATOR = new Parcelable.Creator<UserRole>() {
        public UserRole createFromParcel(Parcel source) {
            return new UserRole(source);
        }

        public UserRole[] newArray(int size) {
            return new UserRole[size];
        }
    };
}
