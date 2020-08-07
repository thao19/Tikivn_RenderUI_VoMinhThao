package com.example.tikitest.ui.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.tikitest.APIHelper.BaseRetrofit;


import com.example.tikitest.NetworkHelper.NetworkChangeReceiver;
import com.example.tikitest.R;
import com.example.tikitest.datamodel.Banner.BannerRespone;
import com.example.tikitest.ui.home.banner.fragmentBanner_child_home;
import com.example.tikitest.ui.home.flashdeal.fragment_flashdeal_child_home;
import com.example.tikitest.ui.home.quicklink.fragment_quicklink_child_home;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private HomeViewModel homeViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    fragment_flashdeal_child_home mfragment_flashdeal_child_home;
    fragment_quicklink_child_home mfragment_quicklink_child_home;
    fragmentBanner_child_home mfragmentBanner_child_home;

    private static HomeFragment _Instance = null;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        /* final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
         */
        swipeRefreshLayout = (SwipeRefreshLayout) root.findViewById(R.id.pulltorefresh);
        swipeRefreshLayout.setOnRefreshListener(this);


        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _Instance = this;
    }

    public static HomeFragment get_Instance()
    {
        return  _Instance;
    }

    @Override
    public void onRefresh() {

        // Check network connection
        // if network connection is available -> pull to refresh

        ConnectivityManager connMgr = (ConnectivityManager) getActivity()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // fetch data
        mfragment_quicklink_child_home.get_Instance().updateProgressView();

        final Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                ReloadQuickLink();

                ReloadFlashDeal();
            }
        });
        thr.start();



        mfragment_flashdeal_child_home.get_Instance().updateProgressView();
        final Thread thr1 = new Thread(new Runnable() {
            @Override
            public void run() {

                ReloadFlashDeal();

            }
        });
        thr1.start();

        fragmentBanner_child_home.get_Instance().updateProgressView();
        final Thread thr2 = new Thread(new Runnable() {
            @Override
            public void run() {

                ReloadBanner();

            }
        });
        thr2.start();
        }
        else
        {
            Toast.makeText(getActivity(), "Không có kết nối mạng, kiểm tra lại đường truyền", Toast.LENGTH_SHORT).show();
            swipeRefreshLayout.setRefreshing(false);
        }

    }
    public void ReloadFlashDeal()
    {
        swipeRefreshLayout.setRefreshing(true);
        mfragment_flashdeal_child_home.get_Instance().UpdateData();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void ReloadQuickLink()
    {
        swipeRefreshLayout.setRefreshing(true);
        mfragment_quicklink_child_home.get_Instance().UpdateData();
        swipeRefreshLayout.setRefreshing(false);

    }

    public void ReloadBanner()
    {
        swipeRefreshLayout.setRefreshing(true);
        mfragmentBanner_child_home.get_Instance().UpdateBanner();
        swipeRefreshLayout.setRefreshing(false);
    }




}
