package com.edwinb.swipetabexample.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edwinb.swipetabexample.R;
import com.edwinb.swipetabexample.Recycler.Movie;
import com.edwinb.swipetabexample.Recycler.MyRecyclerAdapter;

import java.util.ArrayList;

/**
 * Created by EDWINB on 2/27/2017.
 */

public class DramaFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.drama_fragment, null);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.myRecyclerDrama);

        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        rv.setAdapter(new MyRecyclerAdapter(this.getActivity(), getDramaMovies()));

        return v;
    }


    private ArrayList<Movie> getDramaMovies()
    {
        ArrayList<Movie> movies = new ArrayList<>();

        Movie movie = new Movie("Star Wars", R.drawable.drummer_music_news);
        movies.add(movie);

        movie = new Movie("Ghost Rider", R.drawable.drum_beats);
        movies.add(movie);

        movie = new Movie("Game of Thrones", R.drawable.drum_fills);
        movies.add(movie);

        movie = new Movie("Ghost", R.drawable.drum_kit_news);
        movies.add(movie);

        return movies;
    }



    // SET TITLE FOR THE FRAGMENT
    @Override
    public String toString() {
        return "Drama";
    }
}
