package com.james.novgorodapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivityFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @InjectView(android.R.id.list)
    ListView lv;
    @InjectView(R.id.refresh)
    SwipeRefreshLayout swipeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, v);

        swipeLayout.setOnRefreshListener(this);


        return v;
    }

    @Override
    public void onRefresh() {

    }
}
