package com.example.wohlig.mycwac;

/**
 * Created by Wohlig on 01/10/15.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.commonsware.cwac.camera.CameraFragment;
import com.example.wohlig.mycwac.DemoCameraFragment;

import com.commonsware.cwac.camera.CameraHost;
import com.commonsware.cwac.camera.CameraHostProvider;
import com.commonsware.cwac.camera.SimpleCameraHost;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private DemoCameraFragment dcf = null;

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int index) {


        switch (index) {
            case 0:

                //return new DemoCameraFragment();
                //return new Test();
            case 1:

                //return new Test();
            case 2:

                //return new Test();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }


}