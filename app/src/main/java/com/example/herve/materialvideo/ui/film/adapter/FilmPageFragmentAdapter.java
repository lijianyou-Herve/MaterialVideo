package com.example.herve.materialvideo.ui.film.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.herve.materialvideo.ui.film.presenter.ItemBean;

import java.util.List;

/**
 * Created by Herve on 2016/8/7.
 */
public class FilmPageFragmentAdapter extends FragmentStatePagerAdapter {


    private List<Fragment> fragList;
    private List<ItemBean> itemBeanList;

    public FilmPageFragmentAdapter(FragmentManager fm, List<Fragment> fragList, List<ItemBean> itemBeanList) {
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

        return itemBeanList.get(position).getTitle();
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