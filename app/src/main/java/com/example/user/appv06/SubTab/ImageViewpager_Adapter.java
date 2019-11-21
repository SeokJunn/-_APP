package com.example.user.appv06.SubTab;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import static com.example.user.appv06.SubTab.MainActivity2.name;
import com.example.user.appv06.R;


public class ImageViewpager_Adapter extends PagerAdapter {

    //MainActivity2 mainName= new MainActivity2();
    // String a=mainName.getName();

    private Context context;// 어따쓸라고 필요한걸까
    private LayoutInflater layoutInflater;//부분화면 xml을 메모리에 객체화 하기위해 필요
    private Integer[] images1 = {R.drawable.a1,R.drawable.a2,R.drawable.a3};//왜 사진 아이디들을 Integer에 담지?-> 아이디값이 Integer값이라서.
    private Integer[] images2 = {R.drawable.b1,R.drawable.b2,R.drawable.b2};
    private Integer[] images3 = {R.drawable.c1 ,R.drawable.c2,R.drawable.slide3};
    private Integer[] images4 = {R.drawable.d1 ,R.drawable.c2,R.drawable.slide3};
    private Integer[] images5 = {R.drawable.e1 ,R.drawable.c2,R.drawable.slide3};
    private Integer[] images6 = {R.drawable.f1 ,R.drawable.f2,R.drawable.slide3};
    private Integer[] images7 = {R.drawable.m1 ,R.drawable.m2,R.drawable.m3};

    public ImageViewpager_Adapter(Context context) {//생성자 만든거같고...
        this.context = context;
    }//생성자

    @Override //사용 가능한 뷰 수를 반환 : 필수 구현 *
    public int getCount() {//PagerAdapter의
        // Log.d("a 의 값 : ", String.valueOf(images.length));해보니 3... 그냥 inflater 할 창의 갯수 찾는듯
        return images1.length;
    }


    @Override//페이지뷰가 instantiateItem()에 의해 반환된 특정 키 객체와 연관되는지 여부 결정 : 필수 구현 *
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override//주어진 위치에 대한 페이지를 생성 : 필수 구현 *
    public Object instantiateItem(ViewGroup container, final int position) {

        //1인자: 페이지가 표시될 뷰, 2인자: 인스턴스화 할 페이지의 위치
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);//이미지뷰가 담긴 레이아웃을 객체화
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);//custom_layout에 있는 이미지뷰 xml와 연결하여 객체화

        if (name.equals("복지관 학식"))
            imageView.setImageResource(images1[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        else if(name.equals("웅지관"))
            imageView.setImageResource(images2[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        else if(name.equals("8호관식당"))
            imageView.setImageResource(images3[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        else if(name.equals("웰리앤"))
            imageView.setImageResource(images4[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        else if(name.equals("복지관 교직원식당"))
            imageView.setImageResource(images5[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        else if(name.equals("웅지관 교직원식당"))
            imageView.setImageResource(images6[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        else if(name.equals("미즈"))
            imageView.setImageResource(images7[position]);//현재 위치의 이미지를 이미지뷰에 연결시킴
        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override//주어진 위치에 대한 페이지를 제거 : 필수 구현 *
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}