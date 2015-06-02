package com.james.novgorodapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivityFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @InjectView(android.R.id.list)
    ListView lv;
    @InjectView(R.id.refresh)
    SwipeRefreshLayout swipeLayout;

    private MainAdapter ma;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, v);
        ma = new MainAdapter();
        lv.setAdapter(ma);
        swipeLayout.setOnRefreshListener(this);

        DataLoader.get().getItems("", 1, 20, new Callback<MyObject>() {
            @Override
            public void success(MyObject myObject, Response response) {
                ma.setItems(myObject.getResponse().getItems());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("response", error.getMessage());
            }
        });
        return v;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(false);

            }
        }, 4000);
    }
}
