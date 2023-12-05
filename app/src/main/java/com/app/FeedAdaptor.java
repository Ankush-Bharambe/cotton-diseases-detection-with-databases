package com.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedAdaptor extends RecyclerView.Adapter<FeedAdaptor.Viewholder>{
    private Context context;
    private ArrayList<FeedModal> feedModalArrayList;

    // Constructor
    public FeedAdaptor(Context context, ArrayList<FeedModal > courseModelArrayList) {
        this.context = context;
        this.feedModalArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public FeedAdaptor.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  FeedAdaptor.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        FeedModal model = feedModalArrayList.get(position);
        holder.feedheading.setText(model.getHeadline());
        holder.feeddesc.setText("" + model.getDesc());
        holder.feeddate.setText(model.getDate());
    }

    @Override
    public int getItemCount() {

        return feedModalArrayList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView feedimg;
        private TextView feedheading, feeddesc,feeddate;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            feedheading = itemView.findViewById(R.id.feedheading);
            feeddesc = itemView.findViewById(R.id.feeddesc);
            feedimg = itemView.findViewById(R.id.feedimg);
            feeddate = itemView.findViewById(R.id.feeddate);
        }
    }
}

