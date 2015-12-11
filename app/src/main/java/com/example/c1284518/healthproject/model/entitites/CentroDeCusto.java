package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class CentroDeCusto implements Parcelable {

    int _id;
    String centro;

    public CentroDeCusto(int _id, String centro) {
        this._id = _id;
        this.centro = centro;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CentroDeCusto that = (CentroDeCusto) o;

        if (_id != that._id) return false;
        return !(centro != null ? !centro.equals(that.centro) : that.centro != null);

    }

    @Override
    public int hashCode() {
        int result = _id;
        result = 31 * result + (centro != null ? centro.hashCode() : 0);
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeString(this.centro);
    }

    protected CentroDeCusto(Parcel in) {
        this._id = in.readInt();
        this.centro = in.readString();
    }

    public static final Parcelable.Creator<CentroDeCusto> CREATOR = new Parcelable.Creator<CentroDeCusto>() {
        public CentroDeCusto createFromParcel(Parcel source) {
            return new CentroDeCusto(source);
        }

        public CentroDeCusto[] newArray(int size) {
            return new CentroDeCusto[size];
        }
    };
}
