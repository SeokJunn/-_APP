package com.example.user.appv06.SubTab.ReviewTab;

//ListFragment를 상속한 새로운 클래스
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.example.user.appv06.R;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ReviewFragment extends Fragment {
//listFragment를 상속받을시(fragment xml파일엔 fragment태그로 하고,)  //return super.onCreateView(inflater, container, savedInstanceState);이렇게 뷰를 리턴해야만 됨. View에다가 fragment_review를 인플레이터한걸 return시 에러Your content must have a ListView whose id attribute is 'android.R.id.list' 발생함. 
    //fragment 상속받고, xml은 listview로 바꾸고, listview 객체 만들고 어댑터 설정해주면 끝!!
    ListViewAdapter adapter ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = (View)inflater.inflate(R.layout.fragment_review, container, false);


        final EditText editText = v.findViewById(R.id.newadapter);
        final ListView listview=(ListView)v.findViewById(R.id.reviewList);
        final Button ReviewBtn = (Button)v.findViewById(R.id.ReviewBtn);
        final RatingBar rating = (RatingBar) v.findViewById(R.id.ratingbar2);

        // Adapter 생성 및 Adapter 지정.
        adapter = new ListViewAdapter() ;
        listview.setAdapter(adapter) ;

        // 첫 번째 아이템 추가.
//        adapter.addItem(null, "2018.05.18", "돈까스 존맛탱");
//        // 두 번째 아이템 추가.
//        adapter.addItem(null, "2018.07.07", "살...려...조...살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조.....살...려...조...살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조....살...려...조.....") ;
//        // 세 번째 아이템 추가.
//        adapter.addItem(null,
//                "2018.08.11", "저장 취소버튼, 리뷰작성버튼 넣어야하는데...너무힘들다..ㅠㅠㅠㅠ") ;

        rating.setStepSize((float) 1);        //별 색깔이 1칸씩줄어들고 늘어남 0.5로하면 반칸씩 들어감
        rating.setRating((float) 0);      // 처음보여줄때(색깔이 한개도없음) default 값이 0  이다
        rating.setIsIndicator(false);           //true - 별점만 표시 사용자가 변경 불가 , false - 사용자가 변경가능

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar2, float rating,
                                        boolean fromUser) {

            }
        });

        ReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem(rating.getRating(), adapter.getTime(), editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        return v;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }


}
