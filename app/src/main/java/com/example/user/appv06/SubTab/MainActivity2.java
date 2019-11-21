package com.example.user.appv06.SubTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.user.appv06.R;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment2;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment3;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment4;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment5;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment6;
import com.example.user.appv06.SubTab.InfoTab.InfoFragment7;
import com.example.user.appv06.SubTab.MenuTab.MenuFragment;
import com.example.user.appv06.SubTab.MenuTab2.MenuFragment2;
import com.example.user.appv06.SubTab.Menutab3.MenuFragment3;
import com.example.user.appv06.SubTab.Menutab4.MenuFragment4;
import com.example.user.appv06.SubTab.Menutab5.MenuFragment5;
import com.example.user.appv06.SubTab.Menutab6.MenuFragment6;
import com.example.user.appv06.SubTab.Menutab7.Menutab6.MenuFragment7;
import com.example.user.appv06.SubTab.ReviewTab.ReviewFragment;

/* viewpager을 사용하여 Image Slider을 만들고 Imageview를 사용하여 dots indicator(. . .)을 표시한 예제
 *http://www.sanktips.com/2017/10/01/how-to-add-dots-indicator-to-image-slider-with-viewpager-in-android-studio/ 참조함
 * */
public class MainActivity2 extends AppCompatActivity{

    ViewPager imgviewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    // 탭 및 페이저 속성 정의
    final int TAB_COUNT = 3;
    MenuFragment one_one;
    MenuFragment2 one_two;
    MenuFragment3 one_three;
    MenuFragment4 one_four;
    MenuFragment5 one_five;
    MenuFragment6 one_six;
    MenuFragment7 one_seven;
    InfoFragment two_one;
    InfoFragment2 two_two;
    InfoFragment3 two_three;
    InfoFragment4 two_four;
    InfoFragment5 two_five;
    InfoFragment6 two_six;
    InfoFragment7 two_seven;
    ReviewFragment three;
    public static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2_activity_main);

        Intent intent = getIntent();
        name = intent.getStringExtra("building_name");

        imgviewPager = (ViewPager) findViewById(R.id.imageViewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        ImageViewpager_Adapter imageViewpagerAdapter = new ImageViewpager_Adapter(this);

        imgviewPager.setAdapter(imageViewpagerAdapter);

        // 프래그먼트 init
        one_one = new MenuFragment();
        one_two = new MenuFragment2();
        one_three = new MenuFragment3();
        one_four = new MenuFragment4();
        one_five = new MenuFragment5();
        one_six = new MenuFragment6();
        one_seven = new MenuFragment7();
        two_one = new InfoFragment();
        two_two = new InfoFragment2();
        two_three = new InfoFragment3();
        two_four = new InfoFragment4();
        two_five = new InfoFragment5();
        two_six = new InfoFragment6();
        two_seven = new InfoFragment7();
        three = new ReviewFragment();

        // 탭 Layout 정의
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        // 탭 생성 및 타이틀 입력
        tabLayout.addTab(tabLayout.newTab().setText("메뉴"));
        tabLayout.addTab(tabLayout.newTab().setText("정보"));
        tabLayout.addTab(tabLayout.newTab().setText("리뷰"));


        // 프래그먼트 페이저 작성
        ViewPager page_viewPager = (ViewPager) findViewById(R.id.pageViewPager);
        // 아답터 생성(PagerAdapter 클래스는 아래에서 구현할 것!)
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        page_viewPager.setAdapter(adapter);

        // 1. 페이저 리스너 : 페이저가 변경되었을때 탭을 바꿔주는 리스너(스와이프)
        page_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //이부분 안하면 스와이프로 페이지 넘길때 탭버튼은 변경안됨

        // 2. 탭 리스너 : 탭이 변경되었을 때 페이지를 바꿔저는 리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(page_viewPager));
        //이부분 안하면 탭버튼눌렀을때 페이지 변경안됨.


////////////////////////////////////////////////////도트 설정////////////////////////

        dotscount = imageViewpagerAdapter.getCount();//이미지 갯수에따른 도트카운트 변수 값 설정하기

        dots = new ImageView[dotscount];//이미지뷰 배열을 3개만듬.

        for (int i = 0; i < dotscount; i++) {//----------------이미지뷰페이저의 사진갯수에맞게 xml에 넣어둔 linearlayout에 도트이미지 생성

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//LayoutParms는 코드상에서  레이아웃을 동적 변화 시키기위한 클래스. 여기서는 도트 이미지를 달 layout의 width와 height를 설정하고있음.

            params.setMargins(8, 0, 8, 0);//도트 레이아웃에 넣을 리니어레이아웃 객체 params의 마진설정

            sliderDotspanel.addView(dots[i], params);
            //실제 도트를 달 linearLayout에 뷰를 추가함(아까 만든 리니어 레이아웃의 파라미터와, 도트이미지를).

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));//첫 도트 '실행중도트'로

//--------------------------


        //이미지뷰페이저(사진 슬라이더에 변화잇을시) 리스너 등록
        imgviewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //이 메소드는 프로그래밍 방식으로 시작된 부드러운 스크롤 또는 사용자가 시작한 터치 스크롤의 일부로 현재 페이지가 스크롤 될 때 호출됩니다.
            }

            @Override
            public void onPageSelected(int position) {//인자 : 현재 표시된 첫 페이지의 위치 인덱스
                //이미지 개수에 맞게 모두 비활동중 도트 이미지로 설정
                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                //지금 선택된 페이지 번호와 같은번째의 도트이미지를 활동중 도트 이미지로 설정
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*스크롤 상태가 변경되면 호출됩니다. 사용자가 드래그를 시작할 때, 호출기가 현재 페이지로 자동으로 이동하거나, 완전히 중지 / 유휴 상태 일때 검색하는 데 유용합니다.*/
            }
        });
    }


    //탭 페이지를 슬라이드했을때 페이지가 이동하도록하는 뷰페이저에 달 어뎁터 선언
    class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) { super(fm); }//생성자

        @Override
        public Fragment getItem(int position) { //현재의 탭 위치를 얻어와서
            Fragment fragment = null;
            switch (position) { //받아왔던 탭 위치에 맞게 프래그먼트를 변경시켜줌.
                case 0:
                    if (name.equals("복지관 학식"))
                        fragment = one_one;
                    else if(name.equals("웅지관"))
                        fragment = one_two;
                    else if(name.equals("8호관식당"))
                        fragment = one_three;
                    else if(name.equals("웰리앤"))
                        fragment = one_four;
                    else if(name.equals("복지관 교직원식당"))
                        fragment = one_five;
                    else if(name.equals("웅지관 교직원식당"))
                        fragment = one_six;
                    else if(name.equals("미즈"))
                        fragment = one_seven;
                    break;
                case 1:
                    if (name.equals("복지관 학식"))
                        fragment = two_one;
                    else if (name.equals("웅지관"))
                        fragment = two_two;
                    else if (name.equals("8호관식당"))
                        fragment = two_three;
                    else if (name.equals("웰리앤"))
                        fragment = two_four;
                    else if (name.equals("복지관 교직원식당"))
                        fragment = two_five;
                    else if (name.equals("웅지관 교직원식당"))
                        fragment = two_six;
                    else if (name.equals("미즈"))
                        fragment = two_seven;
                    break;
                case 2:
                    fragment = three;
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }
    }


}