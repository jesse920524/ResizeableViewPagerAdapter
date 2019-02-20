package jesse.dynamicviewpagerdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JesseFu on 2019/2/20.
 */

public class FruitEntity implements Parcelable{

    private String name;

    public FruitEntity() {
    }

    public FruitEntity(String name) {
        this.name = name;
    }

    protected FruitEntity(Parcel in) {
        name = in.readString();
    }

    public static final Creator<FruitEntity> CREATOR = new Creator<FruitEntity>() {
        @Override
        public FruitEntity createFromParcel(Parcel in) {
            return new FruitEntity(in);
        }

        @Override
        public FruitEntity[] newArray(int size) {
            return new FruitEntity[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FruitEntity{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
