package com.tt.whorlviewlibrary;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 11.06.2016.
 */
public class WhorlViewProgressDialog extends ProgressDialog {
    private ArrayList<WhorlView> whorlViews=new ArrayList<WhorlView>();
    private int layoutResId;

    public WhorlViewProgressDialog(Context context) {
        super(context, R.style.whorlview_transparent_style);
        this.layoutResId=R.layout.whorlview_progress_dialog_default;
    }

    public WhorlViewProgressDialog(Context context, int theme) {
        super(context, theme);
        this.layoutResId=R.layout.whorlview_progress_dialog_default;
    }

    public WhorlViewProgressDialog withLayout(int layoutResId) {
        this.layoutResId=layoutResId;
        return this;
    }

    public WhorlViewProgressDialog withDefaultLayout() {
        this.layoutResId=R.layout.whorlview_progress_dialog_default;
        return this;
    }

    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);
        final ViewGroup rootView = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        whorlViews.clear();
        findWhorlViews(rootView);
        if(whorlViews.isEmpty())
            throw new IllegalArgumentException("At least one WhorlView need to be declared in layout!");
    }

    @Override
    public void show() {
        super.show();
        this.setContentView(layoutResId);
        for(WhorlView whorlView:whorlViews) {
            if(!whorlView.isCircling())
                whorlView.start();
        }
    }

    @Override
    public void dismiss() {
        super.dismiss();
        for(WhorlView whorlView:whorlViews) {
            if(!whorlView.isCircling())
                whorlView.start();
        }
    }

    @Override
    public void cancel() {
        super.cancel();
        for(WhorlView whorlView:whorlViews) {
            if(!whorlView.isCircling())
                whorlView.start();
        }
    }

    public WhorlView getWhorlView() {
        if(whorlViews.isEmpty())
            return null;
        return whorlViews.get(0);
    }

    public List<WhorlView> getWhorlViews() {
        if(this.isShowing())
            return whorlViews;
        return null;
    }

    private void findWhorlViews(ViewGroup parent) {
        View child;
        int count=parent.getChildCount();
        ArrayList<ViewGroup> childViewGroups=new ArrayList<>();
        for(int i=0; i < count; i++) {
            child=parent.getChildAt(i);
            if(child instanceof WhorlView)
                whorlViews.add((WhorlView )child);
            if(child instanceof ViewGroup)
                childViewGroups.add((ViewGroup )child);
        }
        for(ViewGroup childViewGroup:childViewGroups)
            findWhorlViews(childViewGroup);
    }
}
