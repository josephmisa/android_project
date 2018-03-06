package com.example.lno.litenoteorganizer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rizal Rey on 3/3/2018.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameTxt;
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img= (ImageView) itemView.findViewById(R.id.spacecraftImg);

    }
}
