package despachei.co.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import despachei.co.Fragment.Fragment1;
import despachei.co.Fragment.Fragment2;
import despachei.co.Fragment.Fragment3;

public class PageAdapter extends FragmentPagerAdapter {
    private String[] titlesFragmentTabs;

    public PageAdapter(FragmentManager fm, String[] titlesFragmentTabs) {
        super(fm);
        this.titlesFragmentTabs=titlesFragmentTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.titlesFragmentTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titlesFragmentTabs[position];
    }
}


