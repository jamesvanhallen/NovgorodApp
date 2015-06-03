package com.james.novgorodapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        query();
        return v;
    }

    @Override
    public void onRefresh() {
        query();
    }

    public void query() {
        DataLoader.get().getItems("", 1, 20, new Callback<MyObject>() {
            @Override
            public void success(MyObject myObject, Response response) {
                ma.setItems(myObject.getResponse().getItems());
                swipeLayout.setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setTitle("Error")
                     .setMessage(error.getMessage())
                     .setNegativeButton("Cancel",
                             new DialogInterface.OnClickListener() {
                                 public void onClick(DialogInterface dialog, int id) {
                                     dialog.cancel();
                                 }
                             });
                alert.create();
                alert.show();

            }
        });
    }
}
