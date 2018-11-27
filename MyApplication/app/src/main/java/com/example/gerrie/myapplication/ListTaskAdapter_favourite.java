package com.example.gerrie.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ferdousur Rahman Sarker on 10/23/2017.
 */

public class ListTaskAdapter_favourite extends BaseAdapter {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListTaskAdapter_favourite(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ListTaskViewHolder_favourite holder = null;
        if (convertView == null) {
            holder = new ListTaskViewHolder_favourite();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.task_list_row_favourite, parent, false);
            holder.task_image = (TextView) convertView.findViewById(R.id.task_image_favourite);
            holder.task_name = (TextView) convertView.findViewById(R.id.task_name_favourite);
            holder.task_date = (TextView) convertView.findViewById(R.id.task_date_favourite);
            convertView.setTag(holder);
        } else {
            holder = (ListTaskViewHolder_favourite) convertView.getTag();
        }
        holder.task_image.setId(position);
        holder.task_name.setId(position);
        holder.task_date.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try{
            holder.task_name.setText(song.get(TaskHome_favourite.KEY_TASK));
            holder.task_date.setText(song.get(TaskHome_favourite.KEY_DATE));

            /* Image */
            ColorGenerator generator = ColorGenerator.MATERIAL;
            int color = generator.getColor(getItem(position));
            holder.task_image.setTextColor(Color.parseColor("FF00796B"));
            holder.task_image.setText(Html.fromHtml("&#11044;"));
            /* Image */

            }catch(Exception e) {}
        return convertView;
    }
}

class ListTaskViewHolder_favourite {
    TextView task_image;
    TextView task_name, task_date;
}