package com.volleyex.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.recyclier.viewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MC11 on 1/23/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Activity activity;
    private List<Movie> movieItems;
    //String imgArray[];
    public ImageLoader imageLoader;

    public ViewPagerAdapter(Activity act, List<Movie> movieItems) {
        this.movieItems = movieItems;
        activity=act;
        Log.d("Viewpageradapter", "" + movieItems.size());
        //imageLoader=new ImageLoader(activity.getApplicationContext());

        // TODO Auto-generated constructor stub
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return movieItems.size();//movieItems.size();
    }



    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0 == ((View) arg1);
    }
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        View view=null;
        LayoutInflater layoutinflater;
        layoutinflater = (LayoutInflater)collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutinflater.inflate(R.layout.send_message, null);
        int count=getCount();
        Log.d("count",""+count);
        TextView tv= (TextView)view. findViewById(R.id.title);
        TextView rating = (TextView)view. findViewById(R.id.rating);
        TextView genre = (TextView)view. findViewById(R.id.genre);
        TextView releaseYear = (TextView)view. findViewById(R.id.releaseYear);
        // image.setBackgroundResource(imgArray[position]);

       // tv.setText(Movie.getTitle().get(position));
        tv.setText(movieItems.get(position).getTitle());
        rating.setText( String.valueOf(movieItems.get(position).getRating()));
        genre.setText(String.valueOf(movieItems.get(position).getGenre()));
        releaseYear.setText(String.valueOf(movieItems.get(position).getYear()));
        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView)view.findViewById(R.id.thumbnail);
        //thumbnail image
        thumbNail.setImageUrl(movieItems.get(position).getThumbnailUrl(), imageLoader);

        ((ViewGroup) collection).addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // container.removeView((LinearLayout) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
