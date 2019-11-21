package com.example.user.appv06;

public class Tab1ProfileModel {

    private static String msg;
    public int profile;        // R.drawable.리소스 아이디
    public String name;         // 대화명


    public static Tab1ProfileModel newInstance(int profile, String name, String chat) {
        Tab1ProfileModel instance = new Tab1ProfileModel();
        instance.profile = profile;
        instance.name = name;

        return instance;
    }
}