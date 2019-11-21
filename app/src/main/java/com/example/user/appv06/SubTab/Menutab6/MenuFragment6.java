package com.example.user.appv06.SubTab.Menutab6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.appv06.R;

import java.util.ArrayList;

//웅지관 교직원

public class MenuFragment6 extends Fragment {

    ExpandableListView expandableListView;
    CustomExpandableListAdapter adapter;
    ArrayList<GroupData> groupListDatas; // 그룹을 넣을 ArrayList
    ArrayList<ArrayList<ChildData>> childListDatas; // 하위 리스트들을 넣을  ArrayList의 ArrayList

    public MenuFragment6() {
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
        groupListDatas.add(new GroupData("11.26(월)"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"돈김치볶음","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"야채고로캐","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"동초무우겉절이","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"시금치무침","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"뼈쥐포조림","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"배추김치/깍두기","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"미역국","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"잡곡밥/흰밥","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"샐러드/드레싱","가격 : 총 : 5,000원"));

        groupListDatas.add(new GroupData("11.27(화)"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"후라이드치킨","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"야채짜장","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"고추된장무침","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"쥬키니호박볶음","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"새콤달콤무우지","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"배추김치/깍두기","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"김치콩나물국","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"잡곡밥/흰밥","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"샐러드/드레싱","가격 : 총 : 5,000원"));


        groupListDatas.add(new GroupData("11.28(수)"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"돈불고기","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"빨간어묵볶음","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"오이무침","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"콩나물맛살겨자무침","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"콩조림","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"배추김치/깍두기","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"짬뽕국","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"잡곡밥/흰밥","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"샐러드/드레싱","가격 : 총 : 5,000원"));

        groupListDatas.add(new GroupData("11.29(목)"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"빨간찜닭","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"고추튀김","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"야채소면무침","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"배추겉절이","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"건파래자반","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"배추김치/깍두기","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"다슬기들깨국","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"잡곡밥/흰밥","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"샐러드/드레싱","가격 : 총 : 5,000원"));

        groupListDatas.add(new GroupData("11.30(금)"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"꽁치김치찜","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"야채비빔만두","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"천사샐러드","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"단배추겉절이","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"명엽채조림","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"배추김치/깍두기","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"칼칼어묵국","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"잡곡밥/흰밥","가격 : 총 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.building,"샐러드/드레싱","가격 : 총 : 5,000원"));
    }


}
