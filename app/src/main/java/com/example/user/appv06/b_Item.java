package com.example.user.appv06;
///한 아이템에 필요한 데이터들을 하나의 객체로 만드는 클래스//
public class b_Item {
    String b_name;

    public b_Item(String b_name){
        this.b_name = b_name;
    }

    public String getB_name (){
        return b_name;
    }

    public void setB_Name (String b_name){
        this.b_name = b_name;
    }


}