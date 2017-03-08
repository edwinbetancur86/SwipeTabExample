package com.edwinb.swipetabexample.Recycler;

/**
 * Created by EDWINB on 2/27/2017.
 */

public class Movie
{
    private String name;
    private int image;

    public Movie(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
