package com.goline.goline.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.goline.goline.view.fragment.ConsultorioFragment;
import com.goline.goline.view.fragment.ContatoFragment;
import com.goline.goline.view.fragment.SobreFragment;

/**
 * Created by danilofernandocavalcanti on 01/12/16.
 */

public class PagerAdapterActivityMain extends FragmentPagerAdapter {

    private String[] mTabTitles;

    public PagerAdapterActivityMain(FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.mTabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SobreFragment();
            case 1:
                return new ConsultorioFragment();
            case 2:
                return new ContatoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
