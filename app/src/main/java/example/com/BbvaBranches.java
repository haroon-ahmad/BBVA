package example.com.bbva;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

public class BbvaBranches implements Parcelable {
    private String formatted_address;
    private String id;
    private String name;
    private String icon;
    private double lat;
    private double lng;
    private String rating;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    protected BbvaBranches(Parcel in) {
        formatted_address = in.readString();
        id = in.readString();
        name = in.readString();
        icon = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
        rating = in.readString();
    }

    public static final Creator<BbvaBranches> CREATOR = new Creator<BbvaBranches>() {
        @Override
        public BbvaBranches createFromParcel(Parcel in) {
            return new BbvaBranches(in);
        }

        @Override
        public BbvaBranches[] newArray(int size) {
            return new BbvaBranches[size];
        }
    };

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public BbvaBranches()
    {

    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public LatLng getLocation()
    {
        LatLng location = new LatLng(getLat(),getLng());
        return location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(formatted_address);
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(icon);
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
        parcel.writeString(rating);
    }
}
