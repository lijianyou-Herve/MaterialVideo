package com.example.herve.materialvideo.view.customviews;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * Created by Herve on 2016/6/19.
 */
public class CustomToolbar extends Toolbar {
    public CustomToolbar(Context context) {
        super(context);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setLogoDescription(CharSequence description) {
        super.setLogoDescription(description);
    }

    @Override
    public void setLogo(@DrawableRes int resId) {

        super.setLogo(resId);
    }
}
