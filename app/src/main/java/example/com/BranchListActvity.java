package example.com.bbva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import java.util.ArrayList;

public class BranchListActvity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.branch_list_view);
        getSupportActionBar().setTitle("BBVA ATM & Branch Locator ");
        Intent intent = getIntent();
       ArrayList<BbvaBranches> list = intent.getExtras().getParcelableArrayList("List");
       ListAdapter adapter = new ListAdapter(this,list);
       ListView listView = (ListView) findViewById(R.id.listview);
       listView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.detail_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.list:
                Intent intent = new Intent(this,MapActivity.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
