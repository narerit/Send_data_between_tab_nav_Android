package com.narerit.tabnavigation.utils;

import android.net.Uri;

import com.narerit.tabnavigation.R;
import com.narerit.tabnavigation.models.Promotions;

/**
 * Created by Narerit on 7/22/2019.
 */
public class PromotionInfos {
    public Promotions[] PromotionNames = {
            Pizza, Sushi, Salad, Gym, Movie
    };

    public static final String uri = Uri.parse("android.resource://com.narerit.tabnavigation/").toString();

    public static final Promotions Pizza = new Promotions(
            uri + R.drawable.pizza, uri + R.drawable.pizza_logo,
            "15% Off all menus.","300"
    );
    public static final Promotions Sushi = new Promotions(
            uri + R.drawable.sushi, uri + R.drawable.sushi_logo,
            "10% Off all menus.","500"
    );
    public static final Promotions Salad = new Promotions(
            uri + R.drawable.salad, uri + R.drawable.salad_logo,
            "5% Off all menus.","150"
    );
    public static final Promotions Gym = new Promotions(
            uri + R.drawable.gym, uri + R.drawable.gym_logo,
            "30% Off all days","700"
    );
    public static final Promotions Movie = new Promotions(
            uri + R.drawable.movie, uri + R.drawable.movie_logo,
            "20% Off all movies.","1500"
    );
}
