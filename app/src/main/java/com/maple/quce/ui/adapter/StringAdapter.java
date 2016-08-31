package com.maple.quce.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maple.quce.R;
import com.maple.quce.base.AbsAdapter;

import java.util.List;

/**
 * @author maple
 * @time 16/6/6 下午3:19
 */
public class StringAdapter extends AbsAdapter<String> {


    public StringAdapter(Context context, List<String> datas) {
        super(context, datas);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.adapter_group_item, null);
//
//            holder = new ViewHolder();
//            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
//            holder.iv_select = (ImageView) convertView.findViewById(R.id.iv_select);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String str = getItem(position);
        holder.tv_name.setText(str);
//        holder.iv_select.setImageResource(R.drawable.ic_arrow_green);
        return convertView;
    }


    public class ViewHolder {
        TextView tv_name;
        ImageView iv_select;
    }

}
