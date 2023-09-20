package com.example.cloudcomputingtutorial;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {
    @POST("/user/write")
    Call<CodeMessageResponse> userWrite(@Body NameIdData data);
}
