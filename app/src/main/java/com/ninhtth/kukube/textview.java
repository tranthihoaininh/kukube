package com.ninhtth.kukube;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class textview extends androidx.appcompat.widget.AppCompatTextView {
    public textview(Context context) {
        super(context);
    }

    public textview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public textview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //lay dai = rong
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int dai=getMeasuredWidth();
        setMeasuredDimension(dai,dai);
    }
}
