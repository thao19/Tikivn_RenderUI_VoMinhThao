package com.example.tikitest.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tikitest.R;
import com.example.tikitest.datamodel.QuickLink.QuickLink;

import java.util.List;

public class AdapterQuickLink extends RecyclerView.Adapter<AdapterQuickLink.ViewHolder> {

    List<QuickLink> quickLinkList;
    Context mcontext;


    public AdapterQuickLink(List<QuickLink> quickLinkList, Context context)
    {
        this.mcontext = context;
        this.quickLinkList = quickLinkList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View quicklinkTopView = inflater.inflate(R.layout.item_quicklink,parent,false);
       ViewHolder viewHolder = new ViewHolder(quicklinkTopView);
       return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final QuickLink quickLink = quickLinkList.get(position);
        holder.Title.setText(quickLink.getTitle()+"");
        Glide.with(mcontext)
             .load(quickLink.getImageUrl())
             .into(holder.IMG);

        holder.IMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "Clicked QuickLink :" + quickLink.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quickLinkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView IMG;
        public TextView Title;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            IMG = itemView.findViewById(R.id.img_quickLink);
            Title = itemView.findViewById(R.id.title_quickLink);

        }
    }
}
