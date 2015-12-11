package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * Created by c1284518 on 03/12/2015.
 */
public class Login implements Parcelable {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("login")
    private String login;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("occupationId")
    private long occupationId;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("Occupation")
    private Occupation occupation;

    @JsonProperty("Roles")
    private Roles[] roles;

    public Login(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(long occupationId) {
        this.occupationId = occupationId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Roles[] getRoles() {
        return roles;
    }

    public void setRoles(Roles[] roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Login login1 = (Login) o;

        if (id != login1.id) return false;
        if (occupationId != login1.occupationId) return false;
        if (name != null ? !name.equals(login1.name) : login1.name != null) return false;
        if (login != null ? !login.equals(login1.login) : login1.login != null) return false;
        if (email != null ? !email.equals(login1.email) : login1.email != null) return false;
        if (firstName != null ? !firstName.equals(login1.firstName) : login1.firstName != null)
            return false;
        if (surname != null ? !surname.equals(login1.surname) : login1.surname != null)
            return false;
        if (createdAt != null ? !createdAt.equals(login1.createdAt) : login1.createdAt != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(login1.updatedAt) : login1.updatedAt != null)
            return false;
        if (occupation != null ? !occupation.equals(login1.occupation) : login1.occupation != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(roles, login1.roles);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (int) (occupationId ^ (occupationId >>> 32));
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (roles != null ? Arrays.hashCode(roles) : 0);
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.login);
        dest.writeString(this.email);
        dest.writeString(this.firstName);
        dest.writeString(this.surname);
        dest.writeLong(this.occupationId);
        dest.writeString(this.createdAt);
        dest.writeString(this.updatedAt);
        dest.writeParcelable(this.occupation, 0);
        dest.writeParcelableArray(this.roles, 0);
    }

    protected Login(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.login = in.readString();
        this.email = in.readString();
        this.firstName = in.readString();
        this.surname = in.readString();
        this.occupationId = in.readLong();
        this.createdAt = in.readString();
        this.updatedAt = in.readString();
        this.occupation = in.readParcelable(Occupation.class.getClassLoader());
        this.roles = (Roles[]) in.readParcelableArray(Roles.class.getClassLoader());
    }

    public static final Creator<Login> CREATOR = new Creator<Login>() {
        public Login createFromParcel(Parcel source) {
            return new Login(source);
        }

        public Login[] newArray(int size) {
            return new Login[size];
        }
    };
}
