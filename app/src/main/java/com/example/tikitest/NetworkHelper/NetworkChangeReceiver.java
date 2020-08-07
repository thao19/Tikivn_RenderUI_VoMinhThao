package com.example.tikitest.NetworkHelper;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.tikitest.ui.home.HomeFragment;
import com.example.tikitest.ui.home.banner.fragmentBanner_child_home;
import com.example.tikitest.ui.home.flashdeal.fragment_flashdeal_child_home;
import com.example.tikitest.ui.home.quicklink.fragment_quicklink_child_home;


public class NetworkChangeReceiver extends BroadcastReceiver {
    /** Called when the activity is first created. */

   HomeFragment homeFragment;

    @Override
    public void onReceive(Context context, Intent intent)
    {
        try
        {
            if (isOnline(context))
            {
                    if(homeFragment.get_Instance() != null)
                    {
                        LoadData();
                    }

            } else {
                Toast.makeText(context, "Vui lòng kiểm tra lại kết nối mạng !", Toast.LENGTH_SHORT).show();

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            //should check null because in airplane mode it will be null
            return (netInfo != null && netInfo.isConnected());
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void LoadData()
    {
            homeFragment.get_Instance().ReloadBanner();

            homeFragment.get_Instance().ReloadQuickLink();

            homeFragment.get_Instance().ReloadFlashDeal();

    }
}