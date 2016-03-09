package com.volleyex.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.recyclier.viewdemo.R;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MC11 on 12/7/2015.
 */

public class SendMessage extends AppCompatActivity {
    private List<Movie> movieItems = new ArrayList<Movie>();;
    List<Movie> AllItems=new ArrayList<Movie>();

    //private MyPagerAdapter myadapter;
    private int indexPosition;
   ViewPagerAdapter viewpageradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpage);

        Bundle in = getIntent().getExtras();
        AllItems= (ArrayList<Movie>)in.getSerializable("listvalue");
        String title = in.getString("EXTRA_TITLE");
        String image = in.getString("EXTRA_image");
        Double rating1 = in.getDouble("EXTRA_rating");
        ArrayList<String> genre1 = in.getStringArrayList("EXTRA_genre");
       Integer year = in.getInt("EXTRA_year");
       indexPosition = in.getInt("position");
        Toast.makeText(getApplicationContext(), "From SendMessage"+indexPosition,Toast.LENGTH_LONG).show();
        Movie movie = new Movie();
        movie.setTitle(title.toString());
        movie.setThumbnailUrl(image);
        movie.setRating(rating1);
        movie.setGenre(genre1);
        movie.setYear(year);
        movieItems.add(movie);

        ViewPager viewpager=(ViewPager)findViewById(R.id.myfivepanelpager);
        viewpageradapter=new ViewPagerAdapter(this,AllItems);
        viewpager.setAdapter(viewpageradapter);
        viewpager.setCurrentItem(indexPosition);

}
}
