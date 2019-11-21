package com.example.user.appv06;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-10-11.
 * FragmentPagerAdapter 를 상속받는 아답터를 정의한다.
 */
public class Frg1_PagerAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fList;

    // 아답터 생성자
    public Frg1_PagerAdapter(FragmentManager fm, ArrayList<Fragment> fList) {
        super(fm);
        this.fList = fList;
    }

    // 해당 프라그먼트 호출 함수.
    @Override
    public Fragment getItem(int position) {
        return this.fList.get(position);
    }

    @Override
    public int getCount() {
        return fList.size();
    }
}