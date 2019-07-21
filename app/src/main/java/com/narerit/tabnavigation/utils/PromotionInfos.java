package com.narerit.tabnavigation.utils;

import android.net.Uri;

import com.narerit.tabnavigation.R;
import com.narerit.tabnavigation.models.Promotions;

/**
 * Created by Narerit on 7/22/2019.
 */
public class PromotionInfos {
    public Promotions[] PromotionNames = {
            Pizza, Sushi, Salad, Gym, Movie, Nike
    };

    public static final String uri = Uri.parse("android.resource://com.narerit.tabnavigation/").toString();

    public static final Promotions Pizza = new Promotions(
            uri + R.drawable.pizza, uri + R.drawable.pizza_logo,
            "15% OFF ALL MENUS.","300","pizza"
    );
    public static final Promotions Sushi = new Promotions(
            uri + R.drawable.sushi, uri + R.drawable.sushi_logo,
            "10% OFF ALL MENUS.","500","sushi"
    );
    public static final Promotions Salad = new Promotions(
            uri + R.drawable.salad, uri + R.drawable.salad_logo,
            "5% OFF ALL MENUS.","150","salad"
    );
    public static final Promotions Gym = new Promotions(
            uri + R.drawable.gym, uri + R.drawable.gym_logo,
            "30% OFF ALL DAYS","700","gym"
    );
    public static final Promotions Movie = new Promotions(
            uri + R.drawable.movie, uri + R.drawable.movie_logo,
            "20% OFF ALL MOVIES.","1500","movie"
    );
    public static final Promotions Nike = new Promotions(
            uri + R.drawable.nike, uri + R.drawable.nike_logo,
            "20% OFF ALL PRODUCTS.","1500","nike"
    );
}
