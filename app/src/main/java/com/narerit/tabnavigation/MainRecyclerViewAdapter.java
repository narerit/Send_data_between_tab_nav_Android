package com.narerit.tabnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.narerit.tabnavigation.models.Promotions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Narerit on 7/22/2019.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    //vars
    private ArrayList<Promotions> mPromotions;
    private Context mContext;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(mPromotions.get(position).getPromotion_image())
                .fit().centerCrop().into(holder.promotions);
        Picasso.get().load(mPromotions.get(position).getBrand_image())
                .fit().centerCrop().into(holder.brand);
        holder.offer.setText(mPromotions.get(position).getOffer());
        holder.points.setText(mPromotions.get(position).getPoint());
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
        public ViewHolder(View view) {
            super(view);
            promotions = view.findViewById(R.id.img_promotion);
            brand = view.findViewById(R.id.img_logo);
            offer = view.findViewById(R.id.text_offer);
            points = view.findViewById(R.id.text_points);
        }
    }
}
