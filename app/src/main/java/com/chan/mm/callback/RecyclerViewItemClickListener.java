package com.chan.mm.callback;

import android.view.View;

/**
 * Created by chan on 2016/9/6.
 */
public interface RecyclerViewItemClickListener<T> {

    void onItemClick(View itemView, int position,T data);
}
