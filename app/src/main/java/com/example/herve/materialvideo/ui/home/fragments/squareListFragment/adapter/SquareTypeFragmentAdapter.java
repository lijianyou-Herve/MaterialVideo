package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.herve.materialvideo.base.BaseFragment;

import java.util.List;

public class SquareTypeFragmentAdapter extends FragmentStatePagerAdapter {


    private List<BaseFragment> fragList;
    private List<Object> itemBeanList;

    public SquareTypeFragmentAdapter(FragmentManager fm, List<BaseFragment> fragList, List<Object> itemBeanList) {
        super(fm);
        this.fragList = fragList;
        this.itemBeanList = itemBeanList;
    }


    @Override
    public Fragment getItem(int arg0) {

        return fragList.get(arg0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "第" + position + "Tab";
    }

    @Override
    public int getCount() {

        return fragList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup arg0, int arg1) {

        return super.instantiateItem(arg0, arg1);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        super.destroyItem(container, position, object);
    }

}