package com.example.user.appv06;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.appv06.SubTab.MainActivity2;

import java.util.ArrayList;

public class Building_1 extends AppCompatActivity {

    B_Adapter adapter;
    String[] values0 = {"8호관식당","복지관 학식","웅지관","웰리앤"};
    String[] values1 = {"미즈","버거킹"};
    String[] values2 = {"웅지관 교직원식당","복지관 교직원식당"};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.building_1);

        Intent intent = getIntent();
        int position1 = intent.getExtras().getInt("position");

        ListView listView = (ListView) findViewById(R.id.cafeteria);
        TextView building_title = (TextView) findViewById(R.id.building_title);
        adapter = new B_Adapter();
        if(position1==0) {
            for (int i = 0; i < values0.length; i++) {
                adapter.addItem(new b_Item(values0[i]));
                building_title.setText("학생식당");
            }
        }
        else if(position1==1) {
            for (int i = 0; i < values1.length; i++) {
                adapter.addItem(new b_Item(values1[i]));
                building_title.setText("외부식당");
            }
        }
        else if (position1==2) {
            for (int i = 0; i < values2.length; i++) {
                adapter.addItem(new b_Item(values2[i]));
                building_title.setText("교직원식당");
            }
        }

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                b_Item item = (b_Item) adapter.getItem(position);
               // Toast.makeText(getApplicationContext(), "선택 : " + item.getB_name(),
                      //  Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Building_1.this,MainActivity2.class);
                intent.putExtra("building_name",item.getB_name());
                startActivity(intent);
            }
        });
    }

    ///BaseAdapter는 어댑터 클래스가 기본적으로 가져야하는 메소드들이 정의 되어 있음.
            class B_Adapter extends BaseAdapter {

                ArrayList<b_Item> items = new ArrayList<b_Item>(); //각 아이템의 데이터를 담고있는 b_Item객체를 저장할 ArrayList 생성

                @Override
                public int getCount() {
                    return items.size(); //전체 아이템 개수 리턴 각 아이템의 인덱스를 알아냄**
                }

                public void addItem(b_Item item) {
                    items.add(item);
                }

                @Override
                public Object getItem(int position) {
                    return items.get(position);
                }  //이게 뭘까..

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup viewGroup) {
                    b_ItemView view = new b_ItemView(getApplicationContext());
                    b_Item item = items.get(position);
                    view.setB_Name(item.getB_name());

                    return view;
                } //각 아이템에 보일 뷰를 설정하는 메소드 ** 리턴할 뷰를 잘 설정해야함. ViewGroup 은 이 뷰를 포함하고 있는 부모 컨테이너 객체
            }

        }
