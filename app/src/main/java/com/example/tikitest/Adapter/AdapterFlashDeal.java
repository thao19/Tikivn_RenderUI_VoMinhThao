package com.example.tikitest.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.bumptech.glide.Glide;
import com.example.tikitest.R;
import com.example.tikitest.datamodel.FlashDeal.FlashDeal;
import com.example.tikitest.datamodel.FlashDeal.Product;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterFlashDeal extends RecyclerView.Adapter<AdapterFlashDeal.ViewHolder> {

    static List<FlashDeal> productList;
    Context context;

    public AdapterFlashDeal(Context context, List<FlashDeal> productList)
    {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View FlashDealView = inflater.inflate(R.layout.item_flashdeal,parent,false);

        ViewHolder viewHolder = new ViewHolder(FlashDealView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final FlashDeal productFlasdDeal = productList.get(position);


        Glide.with(context).load(productFlasdDeal.getProduct().getThumbnailUrl()).into(holder.IMG);
        holder.IMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked FlashDeal: "+ productFlasdDeal.getProduct().getName(), Toast.LENGTH_SHORT).show();
            }
        });

        Locale locale = Locale.getDefault();
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        holder.Price.setText(nf.format(productFlasdDeal.getProduct().getPrice())+"");

        holder.Percent.setText( "-"+productFlasdDeal.getDiscountPercent()+ "%");

        holder.progressBar_Ordered.setMax(productFlasdDeal.getProgress().getQty());
        holder.progressBar_Ordered.setProgress(productFlasdDeal.getProgress().getQtyOrdered());


        if(productFlasdDeal.getProduct().getIsVisible())
        {
            holder.Text_ordered.setText("Đã bán " + productFlasdDeal.getProgress().getQtyOrdered());
        }
        else if(productFlasdDeal.getProduct().getIsFresh())
        {
            holder.Text_ordered.setText(R.string.string_progress_order);
        }
        else if(productFlasdDeal.getProduct().getIsFlower())
        {
            holder.Text_ordered.setText("Đã bán " + productFlasdDeal.getProgress().getQtyOrdered());
            holder.img_progress_order.setBackgroundResource(R.drawable.fire);
        }
        else {
            holder.Text_ordered.setText("Đã bán " + productFlasdDeal.getProgress().getQtyOrdered());
        }
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView IMG;
        public TextView Price;
        public TextView Percent;
        public ProgressBar progressBar_Ordered;
        public TextView Text_ordered;

        public ImageView img_progress_order;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            IMG = itemView.findViewById(R.id.imgProduct);
            Price = itemView.findViewById(R.id.priceFlashDeal);
            Percent = itemView.findViewById(R.id.pricePercent);
            progressBar_Ordered = itemView.findViewById(R.id.progress_FlashDeal);
            Text_ordered = itemView.findViewById(R.id.txtProgressOrder);
            img_progress_order = itemView.findViewById(R.id.img_progress_order);
        }
    }
}
