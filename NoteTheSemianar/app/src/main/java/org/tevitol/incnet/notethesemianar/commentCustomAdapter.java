package org.tevitol.incnet.notethesemianar;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import static org.tevitol.incnet.notethesemianar.R.color.other;

public class commentCustomAdapter extends BaseAdapter {
    String [] title;
    String [] desc;
    String [] color;
    Context context;
    String[] ids;
    private static LayoutInflater inflater=null;
    public commentCustomAdapter(Context mainActivity, String[] title, String[] desc, String[] color, String[] ids) {
        // TODO Auto-generated constructor stub
        this.title = title;
        this.desc = desc;
        this.color = color;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView title;
        TextView desc;
        TextView color;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.comment_listview, null);
        holder.title=(TextView) rowView.findViewById(R.id.comment_title);
        holder.title.setText(title[position]);

        holder.desc=(TextView) rowView.findViewById(R.id.comment_desc);
        holder.desc.setText(desc[position]);

        holder.color=(TextView) rowView.findViewById(R.id.comment_color);
        int colorId = 0;
        switch (color[position]){
            case "0":
                colorId = R.color.admin;
                break;
            case "1":
                colorId = R.color.user;
                break;
            case "2":
                colorId = other;
                break;
        }
        holder.color.setBackgroundColor(other);

        Log.v(title[position], color[position]);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent detailsPage = new Intent("org.tevitol.incnet.notethesemianar.viewComment");
                //detailsPage.putExtra("note_id", ids[position]);
                detailsPage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(detailsPage);
            }
        });

        return rowView;
    }
}
