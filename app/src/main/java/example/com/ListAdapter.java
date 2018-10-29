package example.com.bbva;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    public ArrayList<BbvaBranches> list;
    Activity activity;
    public ListAdapter(Activity activity, ArrayList<BbvaBranches> list){
        super();
        this.activity = activity;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView Name;
        TextView Address;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater =  activity.getLayoutInflater();

        ViewHolder holder;
        if (view == null)
        {
            view = inflater.inflate(R.layout.row, null);
            holder = new ViewHolder();
            holder.Name = (TextView) view.findViewById(R.id.name);
            holder.Address = (TextView) view.findViewById(R.id.address);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        holder.Name.setText(list.get(i).getName());
        holder.Address.setText(list.get(i).getFormatted_address());


        return view;
    }
}
