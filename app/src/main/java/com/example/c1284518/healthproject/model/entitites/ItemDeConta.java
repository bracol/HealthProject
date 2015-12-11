package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class ItemDeConta implements Parcelable {

    int _id;
    String item;
    int fk_centro_id;


    public ItemDeConta(int _id, String item, int fk_centro_id) {
        this._id = _id;
        this.item = item;
        this.fk_centro_id = fk_centro_id;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getFk_centro_id() {
        return fk_centro_id;
    }

    public void setFk_centro_id(int fk_centro_id) {
        this.fk_centro_id = fk_centro_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDeConta that = (ItemDeConta) o;

        if (_id != that._id) return false;
        if (fk_centro_id != that.fk_centro_id) return false;
        return !(item != null ? !item.equals(that.item) : that.item != null);

    }

    @Override
    public int hashCode() {
        int result = _id;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + fk_centro_id;
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeString(this.item);
        dest.writeInt(this.fk_centro_id);
    }

    protected ItemDeConta(Parcel in) {
        this._id = in.readInt();
        this.item = in.readString();
        this.fk_centro_id = in.readInt();
    }

    public static final Parcelable.Creator<ItemDeConta> CREATOR = new Parcelable.Creator<ItemDeConta>() {
        public ItemDeConta createFromParcel(Parcel source) {
            return new ItemDeConta(source);
        }

        public ItemDeConta[] newArray(int size) {
            return new ItemDeConta[size];
        }
    };
}
