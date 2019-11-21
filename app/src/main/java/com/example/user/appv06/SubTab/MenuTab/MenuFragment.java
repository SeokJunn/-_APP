package com.example.user.appv06.SubTab.MenuTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.user.appv06.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuFragment extends Fragment {

    ExpandableListView expandableListView;
    CustomExpandableListAdapter adapter;
    ArrayList<GroupData> groupListDatas; // 그룹을 넣을 ArrayList
    ArrayList<ArrayList<ChildData>> childListDatas; // 하위 리스트들을 넣을  ArrayList의 ArrayList

    public MenuFragment() {
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
        childListDatas.get(sizeList).add(new ChildData(R.drawable.aaa,"고등어&밥","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"된장찌개","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"김치돼지찌개","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"순두부된장찌개","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"불고기야채비빔밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"참치야채비빔밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"김치불고기비빔밥&계란후라이","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"김치참치비빔밥&계란후라이","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"불고기&밥","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"된장찌개&비빔밥","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.aaa,"된장찌개&고등어","가격 : 5,000원"));
        // childListDatas.get(sizeList).add(new ChildData("볶음밥","가격 : 3000원"));


        groupListDatas.add(new GroupData("분식"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.abc,"일반김밥","가격 : 1,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.abc,"매콤불고기김밥/간장불고기김밥","가격 : 2,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.abc,"돈까스왕김밥 / 참치마요김밥","가격 : 2,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"라면(추가사리 참고)","가격 : 2,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"떡만두국","가격 : 3,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.abf,"잔치국수","가격 : 3,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"떡볶이","가격 : 2,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"순대","가격 : 2,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.abi,"김떡순","가격 : 4,300원"));

        groupListDatas.add(new GroupData("양식"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.aca,"돈까스","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.acb
                ,"카레돈까스 / 매콤돈까스","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"치즈돈까스 / 고구마돈까스","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.acd,"매콤치즈돈까스 / 매콤고구마돈까스","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.ace,"돈까스&오므라이스","가격 : 4,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.acf,"김치날치알덮밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.acg,"제육덮밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"닭갈비덮밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"중화비빔밥","가격 : 3,800원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.acj,"치킨마요덮밥","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.ack,"참치마요덮밥","가격 : 3,300원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"소불고기덮밥","가격 : 4,500원"));

        groupListDatas.add(new GroupData("스페셜"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.ada,"돼지국밥","가격 : 3,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.ada,"돼지순대국밥","가격 : 4,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"사천짜장밥","가격 : 3,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"카레덮밥","가격 : 3,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.ade,"양념순살치킨&밥","가격 : 4,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.adf,"간장순살치킨&밥","가격 : 4,000원"));

        groupListDatas.add(new GroupData("오늘의 메뉴"));
        childListDatas.add(new ArrayList<ChildData>());
        sizeList++;
        childListDatas.get(sizeList).add(new ChildData(R.drawable.aea,"매운돼지찜(월)","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"반계탕(화)","가격 : 5,000원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.aec,"매콤새우파스타(수)","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"새우볶음밥(목)","가격 : 4,500원"));
        childListDatas.get(sizeList).add(new ChildData(R.drawable.food,"대 박(금)","가격 : 4,400원"));




    }

}
