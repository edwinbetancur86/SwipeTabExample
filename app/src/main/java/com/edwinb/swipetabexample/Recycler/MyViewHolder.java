package com.edwinb.swipetabexample.Recycler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.edwinb.swipetabexample.R;

/**
 * Created by EDWINB on 2/27/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView nameTxt;
    private ImageView imgDelete, imgCopy;
    ItemClickListener itemClickListener;

    public MyViewHolder(View itemView) {
        super(itemView);

        nameTxt = (TextView) itemView.findViewById(R.id.nameTxt);
        img = (ImageView) itemView.findViewById(R.id.movieImage);
        imgDelete = (ImageView) itemView.findViewById(R.id.img_delete);
        imgCopy = (ImageView) itemView.findViewById(R.id.img_copy);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener = ic;
    }


    @Override
    public void onClick(View v) {

        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }

    public void setListeners()
    {
        imgDelete.setOnClickListener(MyViewHolder.this);
        imgCopy.setOnClickListener(MyViewHolder.this);
    }

}
