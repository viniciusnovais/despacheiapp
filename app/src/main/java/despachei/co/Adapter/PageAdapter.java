package despachei.co.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import despachei.co.Fragment.ServiceFragment;

/**
 * Created by SENAI on 22/10/2016.
 */



public class PageAdapter extends FragmentPagerAdapter {
    private final int ABAS = 2;
    private ServiceFragment serviceFragment;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (serviceFragment == null) {
                    serviceFragment = new ServiceFragment();
                }
                return serviceFragment;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return ABAS;
    }
}
