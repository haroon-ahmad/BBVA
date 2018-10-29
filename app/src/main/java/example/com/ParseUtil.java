package example.com.bbva;

import android.location.Location;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseUtil {

    private static final String STATUS_OK="OK";
    private static final String RESULTS = "results";
    private static final String FORMATTED_ADDRESS="formatted_address";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ICON = "icon";
    private static final String LOCATION ="location";
    private static final String LATITUDE = "lat";
    private static final String LONGITUDE = "lng";
    private static final String GEOMETRY = "geometry";
    private static final String RATING = "rating";
    private String response;
    private JSONObject jsonResponse;
    private ArrayList<BbvaBranches> locationsList = new ArrayList<BbvaBranches>();

    ParseUtil(){

    }
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    public boolean parseLocations()
    {
        try {
            jsonResponse = new JSONObject(response);
            if(jsonResponse.getString("status").equals(STATUS_OK))
            {
                parseLocationsArray();
                return true;
            }
            else{

                return false;
            }
        }catch (Exception E)
        {
            return false;
        }

    }
    public void parseLocationsArray()
    {
        try {
            JSONArray results = jsonResponse.getJSONArray(RESULTS);
            for(int i =0; i<results.length();++i)
            {
                BbvaBranches branch = new BbvaBranches();
                JSONObject oneObject = results.getJSONObject(i);
                branch.setFormatted_address(oneObject.getString(FORMATTED_ADDRESS));
                branch.setId(oneObject.getString(ID));
                branch.setName(oneObject.getString(NAME));
                branch.setIcon((oneObject.getString(ICON)));
                branch.setRating((oneObject.getString(RATING)));
                JSONObject geometry = oneObject.getJSONObject(GEOMETRY);
                JSONObject location = geometry.getJSONObject(LOCATION);
                branch.setLat(location.getDouble(LATITUDE));
                branch.setLng(location.getDouble(LONGITUDE));

                locationsList.add(branch);


            }
        }
        catch (Exception e)
        {

        }
    }

    public ArrayList<BbvaBranches> getLocationsList() {
        return locationsList;
    }
}
