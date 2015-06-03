package com.james.novgorodapp.network;

import com.james.novgorodapp.pojos.MyObject;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

public interface NetworkConnector {

    @Headers("User-Agent: MOBILE")
    @FormUrlEncoded
    @POST("/companies/search/")
    void getItems(@Field("searchstring") String searchstring,
                  @Field("pageindex") int pageindex,
                  @Field("pagesize") int pagesize,
                  Callback<MyObject> callback);
}
