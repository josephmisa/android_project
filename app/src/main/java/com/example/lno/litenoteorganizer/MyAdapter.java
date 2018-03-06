package com.example.lno.litenoteorganizer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rizal Rey on 3/3/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public MyAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Spacecraft s=spacecrafts.get(position);

        holder.nameTxt.setText(s.getName());
        Picasso.with(c).load(s.getUri()).placeholder(R.drawable.add_image).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return spacecrafts.size();
    }
}
