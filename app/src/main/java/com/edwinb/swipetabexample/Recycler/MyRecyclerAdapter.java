package com.edwinb.swipetabexample.Recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.edwinb.swipetabexample.R;

import java.util.ArrayList;

/**
 * Created by EDWINB on 2/27/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Movie> movies;

    public MyRecyclerAdapter(Context c, ArrayList<Movie> movies)
    {
        this.c = c;
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model, null);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setImageResource(movies.get(position).getImage());
        holder.setListeners();

        // Listener
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(c, movies.get(pos).getName(), Toast.LENGTH_SHORT).show();

                switch (v.getId())
                {
                    case R.id.img_delete:
                        Log.i("Tag", "img_delete has been reached!");
                        removeItem(pos);
                        break;

                    case R.id.img_copy:
                        Log.i("Tag", "img_copy has been reached!");
                        copyItem(pos, movies);
                        break;
                }

            }
        });

    }

    private void removeItem(int position)
    {
        movies.remove(position);
        //notifyItemRemoved(position);
        //notifyItemRangeChanged(position, movies.size());
        notifyDataSetChanged(); // This one is slower and doesn't work properly
    }

    private void copyItem(int position, ArrayList<Movie> movies)
    {
        movies.add(position, movies.get(position));
        //notifyItemInserted(position);
        //notifyItemRangeChanged(position, movies.size());
        notifyDataSetChanged(); // This one is slower and doesn't work properly
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
