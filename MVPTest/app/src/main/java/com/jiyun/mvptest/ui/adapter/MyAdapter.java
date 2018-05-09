package com.jiyun.mvptest.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.mvptest.R;
import com.jiyun.mvptest.data.bean.Bean;


import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 龙雀 on 2018/5/3.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> implements View.OnClickListener {
    private ArrayList<Bean> mList;
    private Context context;

    public MyAdapter(ArrayList<Bean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        Holder holder = new Holder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.name.setText(mList.get(position).getName());
        holder.content.setText(mList.get(position).getContent());
        Log.d("MyAdapter", mList.get(position).getImgs().get(2));
        Glide.with(context).load(mList.get(position).getImgs().get(1)).into(holder.img);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        TextView name, content;
        ImageView img;

        public Holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            content = itemView.findViewById(R.id.content);
            img = itemView.findViewById(R.id.img);
        }
    }

    public interface OnClick {
        void setOnClick(View v, int position);
    }

    private OnClick onClick;

    @Override
    public void onClick(View v) {
        if (onClick != null) {
            onClick.setOnClick(v, (Integer) v.getTag());
        }
    }

    public void setOnClickItem(OnClick onClickItem) {
        this.onClick = onClickItem;
    }
}
