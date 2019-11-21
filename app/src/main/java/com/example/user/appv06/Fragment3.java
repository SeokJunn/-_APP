package com.example.user.appv06;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Fragment3 extends Fragment {

    public static Fragment3 newInstance(){
        Fragment3 fragment = new Fragment3();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment3,container,false);


        final TextView tv_result = (TextView)view.findViewById(R.id.tv_result);
        Button btn_roll = (Button) view.findViewById(R.id.btn_roll);

        final TextView tv_r2 = (TextView) view.findViewById(R.id.tv_r2);
        Button btn_r2 = (Button) view.findViewById(R.id.btn_r2);


        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random dice = new Random();
                String[] str = {"복지관", "웅지관", "8호관", "웰리스", "복지관교직원", "웅지관교직원", "사먹자!"};
                int result = (int)(Math.random()*7);

                tv_result.setText(str[result]);
            }
        });

        btn_r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random dice = new Random();
                String[] str = {"김밥", "돈까스", "비빔밥", "김치찌개", "만두국", "파스타", "사먹자!"};
                int result = (int)(Math.random()*7);

                tv_r2.setText(str[result]);
            }
        });

        return view;
    }
}