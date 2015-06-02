package com.james.novgorodapp;



import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * Created by james on 02.06.15.
 */
public interface NetworkConector {

    @Headers("User-Agent: MOBILE")
    @FormUrlEncoded
    @POST("/companies/search/")
    void getItems(@Field("searchstring") String searchstring,
                  @Field("pageindex") int pageindex,
                  @Field("pagesize") int pagesize,
                  Callback<MyObject> callback);
}
