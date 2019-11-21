package com.example.user.appv06.SubTab.Menutab7.Menutab6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.appv06.R;

import java.util.ArrayList;

//웅지관 교직원

public class MenuFragment7 extends Fragment {

    ExpandableListView expandableListView;
    CustomExpandableListAdapter adapter;
    ArrayList<GroupData> groupListDatas; // 그룹을 넣을 ArrayList
    ArrayList<ArrayList<ChildData>> childListDatas; // 하위 리스트들을 넣을  ArrayList의 ArrayList

    public MenuFragment7() {
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
        groupListDatas.add(new GroupData("SWEET CHILI BASED PAN CHEESE"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"갈릭 베이컨","가격 : 총 : 7,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"크림 고구마","가격 : 총 : 7,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"베이컨 포테이토","가격 : 총 : 8,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"불고기 크림 치즈","가격 : 총 : 7,500원"));

        groupListDatas.add(new GroupData("OVEN SPAGHETTI"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"샐러드 스파게티","가격 : 총 : 7,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"베이컨 크림 스파게티","가격 : 총 : 7,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"매운 토마토 스파게티","가격 : 총 : 8,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"맵지 않은 토마토 스파게티","가격 : 총 : 7,500원"));
    }


}
