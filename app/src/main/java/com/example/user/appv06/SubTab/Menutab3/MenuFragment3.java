package com.example.user.appv06.SubTab.Menutab3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.appv06.R;

import java.util.ArrayList;


//8호관
public class MenuFragment3 extends Fragment {

    ExpandableListView expandableListView;
    CustomExpandableListAdapter adapter;
    ArrayList<GroupData> groupListDatas; // 그룹을 넣을 ArrayList
    ArrayList<ArrayList<ChildData>> childListDatas; // 하위 리스트들을 넣을  ArrayList의 ArrayList

    public MenuFragment3() {
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
        groupListDatas.add(new GroupData("한식"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.caa,"고등어&밥","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cab,"된장찌개","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cac,"김치돼지찌개","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cad,"순두부된장찌개","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cae,"불고기야채비빔밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.caf,"참치야채비빔밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cag,"김치불고기비빔밥&계란후라이","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cah,"김치참치비빔밥&계란후라이","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.cai,"불고기&밥","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.aaa,"된장찌개&비빔밥","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.abf,"된장찌개&고등어","가격 : 5,000원"));
        // childListDatas.get(sizeList).add(new ChildData("볶음밥","가격 : 3000원"));







    }


}
