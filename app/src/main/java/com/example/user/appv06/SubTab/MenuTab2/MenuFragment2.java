package com.example.user.appv06.SubTab.MenuTab2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.appv06.R;

import java.util.ArrayList;

//웅지관

public class MenuFragment2 extends Fragment {

    ExpandableListView expandableListView;
    CustomExpandableListAdapter adapter;
    ArrayList<GroupData> groupListDatas; // 그룹을 넣을 ArrayList
    ArrayList<ArrayList<ChildData>> childListDatas; // 하위 리스트들을 넣을  ArrayList의 ArrayList

    public MenuFragment2() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        expandableListView = (ExpandableListView)v.findViewById(R.id.expandableListView);//main activity의 expandableListView xml와 연결
        setData();
        adapter = new CustomExpandableListAdapter(getContext(), groupListDatas, childListDatas);
        expandableListView.setAdapter(adapter);
       //xml 확장리스트뷰와 어뎁터를 연결함.

        return v;
    }


    private void setData(){ // 값들을 하드코딩하여 셋팅하는 곳.
        groupListDatas = new ArrayList<GroupData> ();
        childListDatas = new ArrayList<ArrayList<ChildData>>();
        int sizeList = 0;//리스트 싸이즈 0으로 해두고,
        //이거 왜해야하는거지?

        //먼가 이패턴인거같은데, group에 데이터 넣고, child순서가 안부터, chilData넣고, 그걸 안쪽ArrayList에 add 하고,  그 add했던 놈을 , get으로 불러온뒤에 , 바깥쪽 arraylist에 넣는것.
        groupListDatas.add(new GroupData("A코너"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.baa,"순두부찌개","가격 : 3,100원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bab,"된장찌개&비빔밥야채","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bab,"부대찌개","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bab,"참치찌개","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bab,"된장찌개&모듬튀김","가격 : 4,500원"));



        groupListDatas.add(new GroupData("B코너"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;

        childListDatas.get(sizeList).add(new ChildData(R.drawable.bba,"참치마요덮밥","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbb,"마파두부덮밥","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbc,"함박오므라이스","가격 : 4,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbd,"닭다리치킨덮밥","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbe,"제왕돈까스","4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbe,"치즈돈까스","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbe,"고구마치즈돈까스","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.bbh,"오무라이스","가격 : 3,300원"));





    }


}
