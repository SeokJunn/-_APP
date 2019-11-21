package com.example.user.appv06;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class Tab1IndexAdapter extends ArrayAdapter<Tab1ProfileModel> {
    private LayoutInflater inflater;
    private SparseArray<WeakReference<View>> viewArray;

    public Tab1IndexAdapter(Context ctx, int txtViewId, List<Tab1ProfileModel> Tmodels) {
        super(ctx, txtViewId, Tmodels);
        this.viewArray = new SparseArray<WeakReference<View>>(Tmodels.size());
        this.inflater = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View cView, ViewGroup pView) {
        if(viewArray != null && viewArray.get(position) != null) {
            cView = viewArray.get(position).get();
            if(cView != null)
                return cView;
        }

        try {
            cView = inflater.inflate(R.layout.frg1_list_item, pView, false);

            ImageView profileView = (ImageView) cView.findViewById(R.id.img1);
            TextView nameView = (TextView) cView.findViewById(R.id.txt1);


            final Tab1ProfileModel Tmodel = getItem(position);
            profileView.setBackground(new ShapeDrawable(new OvalShape()));
            profileView.setClipToOutline(true);
            profileView.setImageResource(Tmodel.profile);
//            GradientDrawable drawble = (GradientDrawable)getContext().getDrawable(R.drawable.background_rounding);
//            profileView.setBackground(drawble);
//            profileView.setClipToOutline(true);
            nameView.setText(Tmodel.name);

        } finally {
            viewArray.put(position, new WeakReference<View>(cView));
        }
        return cView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void update() {
        viewArray.clear();
        notifyDataSetChanged();
    }
}
