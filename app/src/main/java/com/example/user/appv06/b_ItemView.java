package com.example.user.appv06;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class b_ItemView extends LinearLayout {
    TextView ItemText1;


    public b_ItemView(Context context) {
        super(context);
        init(context);
    } //context가 뭘까 -> 앱에 대한 전반적인 정보를 가지고 있는 인터페이스, 안드로이드로부터 제공되는 추상클래스.

    public b_ItemView(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
        init(context);
    } // attributeSet이 뭘까

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) //xml 레이아웃의 정보를 객체화 하기 위해 LayoutInflater 를 참조함.
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.b_listview_item, this,true);

        ItemText1 = (TextView) findViewById(R.id.itemText1);
    } // LayoutInflater이 뭘까

    public void setB_Name (String b_name) {
        ItemText1.setText(b_name);
    }


}
