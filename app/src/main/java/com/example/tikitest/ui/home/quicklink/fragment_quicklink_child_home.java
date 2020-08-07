package com.example.tikitest.ui.home.quicklink;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.tikitest.APIHelper.BaseRetrofit;
import com.example.tikitest.Adapter.AdapterQuickLink;
import com.example.tikitest.R;
import com.example.tikitest.datamodel.QuickLink.QuickLink;
import com.example.tikitest.datamodel.QuickLink.QuickLinkRespone;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class fragment_quicklink_child_home extends Fragment {

    private FragmentQuicklinkChildHomeViewModel mViewModel;
    private static fragment_quicklink_child_home _Instance = null;

    private RecyclerView recyclerViewTop,recyclerViewBot;
    private ProgressBar progressBar;
    private List<QuickLink> quickLinkListTop;
    private List<QuickLink> quickLinkListBot;
    private AdapterQuickLink adapterQuickLink ;

    public static fragment_quicklink_child_home newInstance() {
        return new fragment_quicklink_child_home();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _Instance = this;
    }
    public static fragment_quicklink_child_home get_Instance()
    {
        return  _Instance;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quicklink_child_home, container, false);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentQuicklinkChildHomeViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    public void init(View view)
    {
        recyclerViewTop = view.findViewById(R.id.recyclerview_quickTop);
        recyclerViewBot = view.findViewById(R.id.recyclerview_quickBot);
        progressBar = view.findViewById(R.id.progress_cir_quickLink);
        loadQuickLink();

    }

    public void loadQuickLink() // Call API and get all QuickLink data
    {
        Call<QuickLinkRespone> call = BaseRetrofit.getInstanceRetrofit().getAPI().getQuickLink();
        progressBar.isIndeterminate();

        call.enqueue(new Callback<QuickLinkRespone>() {
            @Override
            public void onResponse(Call<QuickLinkRespone> call, Response<QuickLinkRespone> response) {

                QuickLinkRespone quickLinkRespone = response.body();

                quickLinkListTop = new ArrayList<>();
                quickLinkListBot = new ArrayList<>();

                Log.d("data:",quickLinkRespone.getData().get(0).get(0).getTitle());

                for(int i = 0; i < quickLinkRespone.getData().get(0).size();i++)
                {
                        quickLinkListTop.add(quickLinkRespone.getData().get(0).get(i));
                }

                for(int i = 0; i < quickLinkRespone.getData().get(1).size();i++)
                {
                    quickLinkListBot.add(quickLinkRespone.getData().get(1).get(i));
                }

                Log.d("data11:",quickLinkListTop.get(0).getTitle()+"");
                progressBar.setVisibility(View.GONE);

                adapterQuickLink = new AdapterQuickLink(quickLinkListTop,getActivity());
                recyclerViewTop.setAdapter(adapterQuickLink);
                LinearLayoutManager linearLayoutManager_TopQuickLink = new LinearLayoutManager(getActivity());
                linearLayoutManager_TopQuickLink.setOrientation(RecyclerView.HORIZONTAL);
                recyclerViewTop.setLayoutManager(linearLayoutManager_TopQuickLink);


                adapterQuickLink = new AdapterQuickLink(quickLinkListBot,getActivity());
                recyclerViewBot.setAdapter(adapterQuickLink);
                LinearLayoutManager linearLayoutManager_BotQuickLink = new LinearLayoutManager(getActivity());
                linearLayoutManager_BotQuickLink.setOrientation(RecyclerView.HORIZONTAL);
                recyclerViewBot.setLayoutManager(linearLayoutManager_BotQuickLink);



            }


            @Override
            public void onFailure(Call<QuickLinkRespone> call, Throwable t) {

            }
        });
    }


    public void UpdateData()
    {
        if(quickLinkListTop != null || quickLinkListBot != null)
        {
            quickLinkListTop.clear();
            quickLinkListBot.clear();
            adapterQuickLink.notifyDataSetChanged();

            loadQuickLink();
        }
        else
        {
            loadQuickLink();
        }

    }

    public void updateProgressView()
    {
        progressBar.setVisibility(View.VISIBLE);
    }
}
