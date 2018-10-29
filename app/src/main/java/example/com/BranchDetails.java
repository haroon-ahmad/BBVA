package example.com.bbva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BranchDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_details);
        BbvaBranches branch = getIntent().getExtras().getParcelable("BranchDetail");
        TextView name = (TextView) findViewById(R.id.Detail_name);
        name.setText(branch.getName());
        TextView address = (TextView) findViewById(R.id.detail_address);
        address.setText("Address:    " + branch.getFormatted_address());
        TextView location = (TextView) findViewById(R.id.location);
        location.setText("Lat: " + branch.getLat() + " Long: "+ branch.getLng());
        TextView id = (TextView) findViewById(R.id.branch_id);
        id.setText("ID: " + branch.getId());
        TextView rating = (TextView) findViewById(R.id.rating);
        rating.setText("Rating: " + branch.getRating());
    }
}
