package com.narerit.tabnavigation;

import android.content.Context;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narerit.tabnavigation.models.Promotions;
import com.narerit.tabnavigation.utils.PromotionInfos;

import java.util.ArrayList;


public class PromotionFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "PromotionFragment";
    //widgets
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //vars
    private ArrayList<Promotions> mPromotions = new ArrayList<>();
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private MainRecyclerViewAdapter mMainRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: Inflate PromotionFragment.");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_promotions);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        initPromotions();
        return view;
    }

    private void initPromotions() {
        PromotionInfos promotionInfos = new PromotionInfos();
        if (mPromotions != null){
            mPromotions.clear();
        }
        for (Promotions promotion : promotionInfos.PromotionNames){
            mPromotions.add(promotion);
        }
        if (mMainRecyclerViewAdapter == null){
            initRecyclerView();
        }
    }

    private void initRecyclerView() {
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mMainRecyclerViewAdapter = new MainRecyclerViewAdapter(mPromotions,getActivity());
        mRecyclerView.setAdapter(mMainRecyclerViewAdapter);
    }


    @Override
    public void onRefresh() {
        initPromotions();
        onItemLoadComplete();
    }

    private void onItemLoadComplete() {
        mMainRecyclerViewAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
