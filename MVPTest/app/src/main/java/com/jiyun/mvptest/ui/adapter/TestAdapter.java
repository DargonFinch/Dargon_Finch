package com.jiyun.mvptest.ui.adapter;

import android.graphics.BitmapFactory;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jiyun.mvptest.R;
import com.jiyun.mvptest.data.bean.Bean;

import java.util.List;

/**
 * Created by 龙雀 on 2018/5/9.
 */

public class TestAdapter extends BaseMultiItemQuickAdapter<Bean,BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TestAdapter(List<Bean> data) {
        super(data);
        addItemType(Bean.ONE, R.layout.item_one);
        addItemType(Bean.TWO, R.layout.item_two);
    }

    @Override
    protected void convert(BaseViewHolder helper, Bean item) {

    switch (helper.getItemViewType()){
        case Bean.ONE:
//            helper.setImage
//            BitmapFactory.decodeStream()
            break;
    }
    }
}
