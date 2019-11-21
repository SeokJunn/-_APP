package com.example.user.appv06;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment {

    String[] values = {"학생식당","외부식당","교직원식당"};

    public static interface SelectionCallback {
        public void onSelected(int position);
    }////

    public SelectionCallback callback;

    public static Fragment1 newInstance(){
        Fragment1 fragment = new Fragment1();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof SelectionCallback) {
            callback = (SelectionCallback) context;
        }
    }// 26~ onAttach() 메소드는 해당 프래그먼트가 어떤 액티비티에 올라갔는지를 알 수 있는 콜백 메소드이다.

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.list1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);//ArrayAdapter 를 이용해 values 값들을 넣고 그걸 리스트 뷰에 setAdapter 하면 각 줄에 데이터가 보이게 된다.

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (callback != null) {
                    callback.onSelected(position); //MainActivity 에 있는 onSelected() 를 실행
                }
            }
        });   // setOnItemClickListener() 는 리스트뷰의 어떤 아이템을 선택했는지 알아낸 후 처리하고 싶을때 사용. 몇번째 아이템인지 position을 통해 확인 가능.

        return rootView;
    }
}