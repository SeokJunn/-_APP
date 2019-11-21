package com.example.user.appv06.SubTab.Menutab4;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.user.appv06.R;

import java.util.ArrayList;


//웰리앤
public class MenuFragment4 extends Fragment {

    ExpandableListView expandableListView;
    CustomExpandableListAdapter adapter;
    ArrayList<GroupData> groupListDatas; // 그룹을 넣을 ArrayList
    ArrayList<ArrayList<ChildData>> childListDatas; // 하위 리스트들을 넣을  ArrayList의 ArrayList

    public MenuFragment4() {
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
        groupListDatas.add(new GroupData("우동"));
        childListDatas.add(new ArrayList<ChildData>());
        childListDatas.get(sizeList).add(new ChildData(R.drawable.daa,"냄비우동","가격 : 3,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dab,"알밥&우동","가격 : 4,200원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dac,"냄비김치우동","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dad,"고기알밥","가격 : 4,200원"));

        groupListDatas.add(new GroupData("찌개"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dae,"삼겹살김치찌개","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.daf,"김치돈까스나베","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dag,"비빔밥&된장찌개","가격 : 4,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dah,"공기밥","가격 : 1,000원"));

        groupListDatas.add(new GroupData("돈가스"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dai,"순살돈가스","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.daj,"치킨가스","가격 : 3,800원원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dak,"치즈함박스테이크","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dal,"치즈돈가스","가격 : 4,300원"));

        groupListDatas.add(new GroupData("덮밥"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dam,"불고기비빔밥","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dan,"치킨마요덮밥","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dao,"불고기덮밥","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.daa,"불고기마요덮밥","가격 : 43,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dab,"제육덮밥","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.dac,"제육비빔밥","가격 : 3,800원"));



    }


}
