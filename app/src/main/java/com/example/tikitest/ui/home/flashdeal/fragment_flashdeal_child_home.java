package com.example.tikitest.ui.home.flashdeal;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.tikitest.APIHelper.BaseRetrofit;
import com.example.tikitest.Adapter.AdapterFlashDeal;
import com.example.tikitest.R;
import com.example.tikitest.datamodel.FlashDeal.FlashDeal;
import com.example.tikitest.datamodel.FlashDeal.FlashDealRespone;
import com.example.tikitest.datamodel.FlashDeal.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_flashdeal_child_home extends Fragment  {

    private FragmentFlashdealChildHomeViewModel mViewModel;
    private static fragment_flashdeal_child_home _Instance = null;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private AdapterFlashDeal adapterFlashDeal;
    private List<FlashDeal> flashDealList;



    public static fragment_flashdeal_child_home newInstance() {
        return new fragment_flashdeal_child_home();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _Instance = this;
    }

    public static fragment_flashdeal_child_home get_Instance()
    {
        return  _Instance;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_flashdeal_child_home, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentFlashdealChildHomeViewModel.class);
        // TODO: Use the ViewModel

    }

    public void init(View view)
    {
        recyclerView = view.findViewById(R.id.recyclerview_flashdeal);
        progressBar = view.findViewById(R.id.progress_cir_flasldeal);

        loadFlashdeal();
    }

    public void loadFlashdeal() // Call API and get all Flashdeal data
    {

        Call<FlashDealRespone> call = BaseRetrofit.getInstanceRetrofit().getAPI().getFlashDeal();

        call.enqueue(new Callback<FlashDealRespone>() {
            @Override
            public void onResponse(Call<FlashDealRespone> call, Response<FlashDealRespone> response) {
                FlashDealRespone flashDealRespone = response.body();
                flashDealList = new ArrayList<>();
                flashDealList = flashDealRespone.getData();

                progressBar.setVisibility(View.GONE);
                adapterFlashDeal = new AdapterFlashDeal(getActivity(),flashDealList);
                recyclerView.setAdapter(adapterFlashDeal);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);


            }

            @Override
            public void onFailure(Call<FlashDealRespone> call, Throwable t) {

            }
        });
    }



    public void UpdateData()
    {
        if(flashDealList != null)
        {
            flashDealList.clear();
            adapterFlashDeal.notifyDataSetChanged();
            loadFlashdeal();
        }
        else {
            loadFlashdeal();
        }

    }

    public void updateProgressView()
    {
        progressBar.setVisibility(View.VISIBLE);
    }
}
