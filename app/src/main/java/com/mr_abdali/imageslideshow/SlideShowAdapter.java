package com.mr_abdali.imageslideshow;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by Mr-Abdali on 4/20/2018.
 */

public class SlideShowAdapter extends PagerAdapter{

    //
    private Context context;
    LayoutInflater inflater;

    // array for images
    public int[] images = {
            R.drawable.angrybirds,
            R.drawable.cuttherope,
            R.drawable.worms3,
            R.drawable.clashofclans,
            R.drawable.talkingtom,
            R.drawable.asphalt8,
            R.drawable.pou,
            R.drawable.fruitninja,
            R.drawable.wheresmywhater
    };

    //constructor
    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    //

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        //<code></code>
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slideshow_layout,container,false);
        ImageView img = (ImageView) view.findViewById(R.id.imageView_id);
        //img.setImageResource(images[position]);
        // for speed slide show
        Glide.with(context).load(images[position]).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //<code></code>
                Snackbar.make(view,"Image" + (position + 1) ,Snackbar.LENGTH_LONG);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //<code></code>
        container.removeView((LinearLayout)object);
    }
}
