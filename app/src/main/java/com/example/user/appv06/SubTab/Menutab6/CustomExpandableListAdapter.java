package com.example.user.appv06.SubTab.Menutab6;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.appv06.R;

import java.util.ArrayList;

//ExpandableLIstDataPump 클래스의 데이터로 MainActivity를 제공하는 CustomExpandableListAdapter
public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    ArrayList<GroupData> groupDatas;
    ArrayList<ArrayList<ChildData>> childDatas;
    LayoutInflater inflater;


    public CustomExpandableListAdapter(Context c, ArrayList<GroupData> groupDatas, ArrayList<ArrayList<ChildData>> childDatas) {
        this.groupDatas = groupDatas;
        this.childDatas = childDatas;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ChildData getChild(int groupPosition, int childPosition) {
        return childDatas.get(groupPosition).get(childPosition);
        //n번째 그룹의 m번째 데이터를 return
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.menu_list_item, null);
        }
        ImageView foodImg = (ImageView)convertView.findViewById(R.id.foodImg);
        TextView foodName = (TextView) convertView.findViewById(R.id.foodName);
        TextView foodPrice = (TextView) convertView.findViewById(R.id. foodPrice);

        foodImg.setImageResource(childDatas.get(groupPosition).get(childPosition).getResId());
        foodName.setText(childDatas.get(groupPosition).get(childPosition).getName());
        foodPrice.setText(childDatas.get(groupPosition).get(childPosition).getPrice());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childDatas.get(groupPosition).size();
    }

    @Override
    public GroupData getGroup(int groupPosition) {
        return groupDatas.get(groupPosition);
    }


    @Override
    public long getGroupId(int i) {
        return 0;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.menu_list_group, null);
        }
        TextView listTitle= (TextView) convertView.findViewById(R.id.listTitle);
        listTitle.setTypeface(null, Typeface.BOLD);
        listTitle.setText(groupDatas.get(groupPosition).getGroupName());

        return convertView;
    }
    @Override
    public int getGroupCount() {
        return groupDatas. size();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}

