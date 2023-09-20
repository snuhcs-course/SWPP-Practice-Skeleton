package com.example.cloudcomputingtutorial;


import com.google.gson.annotations.SerializedName;

public class NameIdData {
    @SerializedName("userName")
    String userName;

    @SerializedName("userId")
    String userId;

    public NameIdData(String userName, String userId){
        this.userName = userName;
        this.userId = userId;
    }
}