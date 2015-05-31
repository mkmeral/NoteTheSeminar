package org.tevitol.incnet.notethesemianar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class mainCustomAdapter extends BaseAdapter{
    String [] presenters;
    String [] topics;
    Context context;
    int imageId = R.drawable.seminar;
    String [] ids;
    private static LayoutInflater inflater=null;
    public mainCustomAdapter(Context mainActivity, String[] presenters, String[] topics, String[] ids) {
        // TODO Auto-generated constructor stub
        this.presenters = presenters;
        this.topics = topics;
        this.ids = ids;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return presenters.length;
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
        TextView tvTopic;
        TextView tvPresenter;
        TextView tvNo;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.main_listview, null);
        holder.tvPresenter=(TextView) rowView.findViewById(R.id.presenter_list_view);
        holder.tvPresenter.setText(presenters[position]);

        holder.tvTopic=(TextView) rowView.findViewById(R.id.topic_list_view);
        holder.tvTopic.setText(topics[position]);


        holder.img=(ImageView) rowView.findViewById(R.id.image_list_view);
        holder.img.setImageResource(imageId);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent detailsPage = new Intent("org.tevitol.incnet.notethesemianar.details");
                detailsPage.putExtra("ID", ids[position]);
                context.startActivity(detailsPage);
            }
        });

        return rowView;
    }

}