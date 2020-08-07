package com.example.tikitest.APIHelper;

import com.example.tikitest.datamodel.Banner.BannerRespone;
import com.example.tikitest.datamodel.FlashDeal.FlashDealRespone;
import com.example.tikitest.datamodel.QuickLink.QuickLinkRespone;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET(Constant.URL_BANNER)
    Call<BannerRespone> getBanner();

    @GET(Constant.URL_QUICKLINK)
    Call<QuickLinkRespone> getQuickLink();

    @GET(Constant.URL_FashDeal)
    Call<FlashDealRespone> getFlashDeal();

}
