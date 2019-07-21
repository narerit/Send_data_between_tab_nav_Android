package com.narerit.tabnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.like.LikeButton;
import com.like.OnLikeListener;
import com.narerit.tabnavigation.models.Promotions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Narerit on 7/22/2019.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    //vars
    private ArrayList<Promotions> mPromotions;
    private Context mContext;
    private static final String SAVED_PROMOTIONS = "saved_promotions";
    private static final String PROMOTIONS = "promotions";

    public MainRecyclerViewAdapter(ArrayList<Promotions> promotions, Context context) {
        mPromotions = promotions;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotions_card,parent
                ,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picasso.get().load(mPromotions.get(position).getPromotion_image())
                .fit().centerCrop().into(holder.promotions);
        Picasso.get().load(mPromotions.get(position).getBrand_image())
                .fit().centerCrop().into(holder.brand);
        holder.offer.setText(mPromotions.get(position).getOffer());
        holder.points.setText(mPromotions.get(position).getPoint());
        holder.like.setLiked(checkIfSaved(mPromotions.get(position).getName()));

        holder.like.setOnLikeListener(new OnLikeListener() {

            @Override
            public void liked(LikeButton likeButton) {
                SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PROMOTIONS, Context.MODE_PRIVATE);
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                Set<String> savedPromotions = mSharedPreferences.getStringSet(SAVED_PROMOTIONS, new HashSet<String>());
                savedPromotions.add(mPromotions.get(position).getName());
                mEditor.putStringSet(SAVED_PROMOTIONS,savedPromotions);
                mEditor.commit();
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PROMOTIONS, Context.MODE_PRIVATE);
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                Set<String> savedPromotions = mSharedPreferences.getStringSet(SAVED_PROMOTIONS, new HashSet<String>());
                savedPromotions.remove(mPromotions.get(position).getName());
                mEditor.remove(SAVED_PROMOTIONS);
                mEditor.commit();
                mEditor.putStringSet(SAVED_PROMOTIONS, savedPromotions);
                mEditor.commit();
            }
        });

    }

    private boolean checkIfSaved(String name) {
        SharedPreferences mSharedPreferences = mContext.getSharedPreferences(PROMOTIONS, Context.MODE_PRIVATE);
        Set<String> savedPromotions = mSharedPreferences.getStringSet(SAVED_PROMOTIONS, new HashSet<String>());
        return savedPromotions.contains(name);
    }


    @Override
    public int getItemCount() {
        return mPromotions.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView promotions;
        ImageView brand;
        TextView offer;
        TextView points;
        LikeButton like;
        public ViewHolder(View view) {
            super(view);
            promotions = view.findViewById(R.id.img_promotion);
            brand = view.findViewById(R.id.img_logo);
            offer = view.findViewById(R.id.text_offer);
            points = view.findViewById(R.id.text_points);
            like = view.findViewById(R.id.star_button);

        }
    }
}
