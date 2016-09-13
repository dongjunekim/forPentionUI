package softwaredongjune.a0906forui.ViewProcess;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import softwaredongjune.a0906forui.View.FirstFragment;
import softwaredongjune.a0906forui.View.SecondFragment;

/**
 * **
 * Created by 김동준 on 2016-09-06.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return FirstFragment.newInstance(position + 1);
            case 1:
                return SecondFragment.newInstance(position + 2);
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "리스트뷰";
            case 1:
                return "달력";
        }
        return null;
    }
}