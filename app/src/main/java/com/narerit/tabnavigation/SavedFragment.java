package com.narerit.tabnavigation;


import android.content.Context;
import android.content.SharedPreferences;
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
import java.util.HashSet;
import java.util.Set;


public class SavedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "SavedFragment";
    private ArrayList<Promotions> mPromotions = new ArrayList<>();
    private MainRecyclerViewAdapter mMainRecyclerViewAdapter;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView:  Init SavedFragment.");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_saved);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_saved);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        getSavedPromotions();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && mMainRecyclerViewAdapter != null){
            getSavedPromotions();
            mMainRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    private void getSavedPromotions() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("promotions", Context.MODE_PRIVATE);
        Set<String> savedPromotions = sharedPreferences.getStringSet("saved_promotions",new HashSet<String>());

        PromotionInfos promotionInfos = new PromotionInfos();
        if (mPromotions != null){
            mPromotions.clear();
        }
        for (Promotions promotion : promotionInfos.PromotionNames){
            if (savedPromotions.contains(promotion.getName()))
            mPromotions.add(promotion);
        }
        if (mMainRecyclerViewAdapter == null){
            initRecyclerView();
        }
    }

    private void initRecyclerView() {
        mMainRecyclerViewAdapter = new MainRecyclerViewAdapter(mPromotions, getActivity());
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(
                2, LinearLayoutManager.VERTICAL
        );
        mRecyclerView.setAdapter(mMainRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
    }

    @Override
    public void onRefresh() {
        getSavedPromotions();
        onItemLoadComplete();
    }

    private void onItemLoadComplete() {
        mMainRecyclerViewAdapter.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
