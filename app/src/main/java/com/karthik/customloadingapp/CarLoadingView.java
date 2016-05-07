package com.karthik.customloadingapp;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by karthikrk on 07/05/16.
 */
public class CarLoadingView extends LinearLayout {
    /**
     * variables used in the custom view
     **/
    private ImageView first,second,third,fourth;
    private Handler handler;
    private int position;


    //in order to create programmatically
    public CarLoadingView(Context context) {
        super(context);
    }


    //to inflate from the xml
    public CarLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.car_loading_row,this);
        first = (ImageView) findViewById(R.id.img_1);
        second = (ImageView)findViewById(R.id.img_2);
        third = (ImageView)findViewById(R.id.img_3);
        fourth = (ImageView)findViewById(R.id.img_4);

        handler = new Handler();
        positionswitcher.run();
    }

    /**
     * This thread is responsible for switching view position
     */
    Runnable positionswitcher = new Runnable() {
        @Override
        public void run() {
            switchPosition(position);
            position++;
            //re run the same thread after the duration of 250 ms
            handler.postDelayed(positionswitcher,250);
        }
    };

    private void switchPosition(int position){
        int highlightedPosition = position%4;

        first.setImageResource(R.mipmap.dark_city_car);
        second.setImageResource(R.mipmap.dark_sedan);
        third.setImageResource(R.mipmap.dark_suv);
        fourth.setImageResource(R.mipmap.dark_sportcar);

        switch (highlightedPosition){
            case 0:
                first.setImageResource(R.mipmap.city_car);
                break;
            case 1:
                second.setImageResource(R.mipmap.sedan);
                break;
            case 2:
                third.setImageResource(R.mipmap.suv);
                break;
            case 3:
                fourth.setImageResource(R.mipmap.sportcar);
                break;
        }
    }
}
