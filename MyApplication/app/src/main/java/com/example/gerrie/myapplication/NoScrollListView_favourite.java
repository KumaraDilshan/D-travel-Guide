package com.example.gerrie.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ListView;

// creates a list view with scrolling disabled
public class NoScrollListView_favourite extends ListView {

    public NoScrollListView_favourite(Context context) {
        super(context);
    }
    public NoScrollListView_favourite(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public NoScrollListView_favourite(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightMeasureSpec_custom = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec_custom);
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = getMeasuredHeight();
    }
}