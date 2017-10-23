package com.domily.android.domily.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.domily.android.domily.Fragments.ProductoFragment;
import com.domily.android.domily.Fragments.ProductoListaFragment;



public class PagerAdapter extends FragmentStatePagerAdapter {
    int nNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.nNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        ProductoListaFragment plf = new ProductoListaFragment();

        switch (position) {
            case 0:
                return  plf;
            case 1:
                ProductoFragment pf = new ProductoFragment();
                return  pf;
            case 2:
                return  plf;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }


}
