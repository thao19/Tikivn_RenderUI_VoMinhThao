package com.example.tikitest.ui.home.banner;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.tikitest.APIHelper.BaseRetrofit;
import com.example.tikitest.R;
import com.example.tikitest.datamodel.Banner.Banner;
import com.example.tikitest.datamodel.Banner.BannerRespone;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragmentBanner_child_home extends Fragment  {

    private FragmentBannerChildHomeViewModel mViewModel;
    private static fragmentBanner_child_home _Instance = null;

    private ViewFlipper viewFlipper;
    private ProgressBar progressBar;
    private List<Banner> bannerList;

    public static fragmentBanner_child_home newInstance() {
        return new fragmentBanner_child_home();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _Instance = this;
    }

    public static fragmentBanner_child_home get_Instance()
    {
        return  _Instance;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_banner_child_home, container, false);
        init(root);
        loadBanner();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentBannerChildHomeViewModel.class);
        // TODO: Use the ViewModel
    }

    public void init(View view)
    {
        viewFlipper = view.findViewById(R.id.viewflip);
        progressBar = view.findViewById(R.id.progress_cir);
    }

    public void loadBanner() // Call API and get all banners data
    {
        Call<BannerRespone> call = BaseRetrofit.getInstanceRetrofit().getAPI().getBanner();

        progressBar.isIndeterminate();

        call.enqueue(new Callback<BannerRespone>() {
            @Override
            public void onResponse(Call<BannerRespone> call, Response<BannerRespone> response) {
                BannerRespone bannerRespone = response.body();
                bannerList = new ArrayList<>();
                bannerList = bannerRespone.getData();

                for(int i =0;i<bannerList.size();i++)
                {
                    ImageView img = new ImageView(getContext());
                    Glide.with(img).load(bannerList.get(i).getImageUrl()).into(img);
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                    viewFlipper.addView(img);
                }

                progressBar.setVisibility(View.GONE);

                viewFlipper.setAutoStart(true);
                viewFlipper.setFlipInterval(3500);
                viewFlipper.startFlipping();

                viewFlipper.setOutAnimation(getContext(),R.anim.slide_out_left);
                viewFlipper.setInAnimation(getContext(), R.anim.slide_in_right);

            }

            @Override
            public void onFailure(Call<BannerRespone> call, Throwable t) {

            }
        });
    }


    public void UpdateBanner()
    {
        if(bannerList != null)
        {
            bannerList.clear();
            viewFlipper.removeAllViews();
            loadBanner();
        }
        else
        {
            loadBanner();
        }

    }
    public void updateProgressView()
    {
        viewFlipper.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }
}
