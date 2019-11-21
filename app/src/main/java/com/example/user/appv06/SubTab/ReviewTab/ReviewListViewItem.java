package com.example.user.appv06.SubTab.ReviewTab;


import android.widget.RatingBar;

public class ReviewListViewItem {
    private String titleStr ;//제목
    private String descStr ;//설명
    private float starScore;//펼점


    public void setStar(float RB){ starScore = RB; }
    public void setTitle(String title) {
        titleStr = title ;
    }//각 변수에 인자로받은값 삽입
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public float getStar() { return this.starScore ; }
    public String getTitle() { return this.titleStr ; }
    public String getDesc() {
        return this.descStr ;
    }
}

