package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by c1284518 on 04/12/2015.
 */
public class Roles implements Parcelable {

    @JsonProperty("occupationId")
    long occupationId;

    @JsonProperty("login")
    String login;

    @JsonProperty("name")
    String name;

    @JsonProperty("Occupation")
    Occupation Occupation;

    @JsonProperty("updatedAt")
    String updatedAt;

    @JsonProperty("createdAt")
    String createdAt;

    @JsonProperty("id")
    long id;

    @JsonProperty("surname")
    String surname;

    @JsonProperty("firstName")
    String firstName;

    @JsonProperty("email")
    String email;

    @JsonProperty("UserRole")
    UserRole userRoles;


    public Roles(){}

    public long getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(long occupationId) {
        this.occupationId = occupationId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.c1284518.healthproject.model.entitites.Occupation getOccupation() {
        return Occupation;
    }

    public void setOccupation(com.example.c1284518.healthproject.model.entitites.Occupation occupation) {
        Occupation = occupation;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRole userRoles) {
        this.userRoles = userRoles;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.occupationId);
        dest.writeString(this.login);
        dest.writeString(this.name);
        dest.writeParcelable(this.Occupation, 0);
        dest.writeString(this.updatedAt);
        dest.writeString(this.createdAt);
        dest.writeLong(this.id);
        dest.writeString(this.surname);
        dest.writeString(this.firstName);
        dest.writeString(this.email);
        dest.writeParcelable(this.userRoles, 0);
    }

    protected Roles(Parcel in) {
        this.occupationId = in.readLong();
        this.login = in.readString();
        this.name = in.readString();
        this.Occupation = in.readParcelable(com.example.c1284518.healthproject.model.entitites.Occupation.class.getClassLoader());
        this.updatedAt = in.readString();
        this.createdAt = in.readString();
        this.id = in.readLong();
        this.surname = in.readString();
        this.firstName = in.readString();
        this.email = in.readString();
        this.userRoles = in.readParcelable(UserRole.class.getClassLoader());
    }

    public static final Creator<Roles> CREATOR = new Creator<Roles>() {
        public Roles createFromParcel(Parcel source) {
            return new Roles(source);
        }

        public Roles[] newArray(int size) {
            return new Roles[size];
        }
    };
}
