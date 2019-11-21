package com.example.user.appv06;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class Tab1IndexAdapterSetting extends ArrayAdapter<Tab1ProfileModel> {
    private LayoutInflater inflater;
    private SparseArray<WeakReference<View>> viewArray;

    public Tab1IndexAdapterSetting(Context ctx, int txtViewId, List<Tab1ProfileModel> models) {
        super(ctx, txtViewId, models);
        this.viewArray = new SparseArray<WeakReference<View>>(models.size());
        this.inflater = (LayoutInflater) ctx.getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View cView, ViewGroup pView) {
        if(viewArray != null && viewArray.get(position) != null) {
            cView = viewArray.get(position).get();
            if(cView != null)
                return cView;
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
