package com.james.novgorodapp.network;

import com.james.novgorodapp.pojos.MyObject;
import retrofit.Callback;
import retrofit.RestAdapter;

public class DataLoader {
    public static DataLoader sInstance;
    private NetworkConnector mConnector;

    private DataLoader(){
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://basis.seldon.ru")
                .build();
        mConnector = adapter.create(NetworkConnector.class);
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
        mConnector.getItems(searchstring, pageindex, pagesize, callback);
    }
}
