package com.james.novgorodapp;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by james on 02.06.15.
 */
public class DataLoader {
    public static DataLoader sInstance;
    private NetworkConector mConector;

    private DataLoader(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://basis.seldon.ru")
                .build();
        mConector = adapter.create(NetworkConector.class);
    }

    public static DataLoader get() {
        synchronized (DataLoader.class) {
            if (sInstance == null) {
                sInstance = new DataLoader();
            }
            return sInstance;
        }
    }

    public void getItems(String searchstring, int pageindex, int  pagesize, Callback<MyObject> callback){
        mConector.getItems(searchstring, pageindex, pagesize, callback);
    }
}
