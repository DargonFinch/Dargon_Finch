package com.jiyun.mvptest.data.modeul;



import com.jiyun.mvptest.data.bean.Bean;

import java.util.ArrayList;

/**
 * Created by 龙雀 on 2018/5/3.
 */

public interface IModeul {
    void setOnDataChangeListener(OnDataChangListener listener);
    interface OnDataChangListener{
        void dataChange(ArrayList<Bean> mList);
    }
}
