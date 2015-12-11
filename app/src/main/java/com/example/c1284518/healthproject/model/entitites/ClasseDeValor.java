package com.example.c1284518.healthproject.model.entitites;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class ClasseDeValor implements Parcelable {

    int _id;
    String classeValor;
    int fk_item;

    public ClasseDeValor(int _id, String classeValor, int fk_item) {
        this._id = _id;
        this.classeValor = classeValor;
        this.fk_item = fk_item;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getClasseValor() {
        return classeValor;
    }

    public void setClasseValor(String classeValor) {
        this.classeValor = classeValor;
    }

    public int getFk_item() {
        return fk_item;
    }

    public void setFk_item(int fk_item) {
        this.fk_item = fk_item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClasseDeValor that = (ClasseDeValor) o;

        if (_id != that._id) return false;
        if (fk_item != that.fk_item) return false;
        return !(classeValor != null ? !classeValor.equals(that.classeValor) : that.classeValor != null);

    }

    @Override
    public int hashCode() {
        int result = _id;
        result = 31 * result + (classeValor != null ? classeValor.hashCode() : 0);
        result = 31 * result + fk_item;
        return result;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeString(this.classeValor);
        dest.writeInt(this.fk_item);
    }

    protected ClasseDeValor(Parcel in) {
        this._id = in.readInt();
        this.classeValor = in.readString();
        this.fk_item = in.readInt();
    }

    public static final Parcelable.Creator<ClasseDeValor> CREATOR = new Parcelable.Creator<ClasseDeValor>() {
        public ClasseDeValor createFromParcel(Parcel source) {
            return new ClasseDeValor(source);
        }

        public ClasseDeValor[] newArray(int size) {
            return new ClasseDeValor[size];
        }
    };
}
