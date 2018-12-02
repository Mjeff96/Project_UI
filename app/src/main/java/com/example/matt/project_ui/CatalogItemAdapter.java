package com.example.matt.project_ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CatalogItemAdapter extends RecyclerView.Adapter<CatalogItemAdapter.ViewHolder> {
    List<CatalogItem> CatalogItemList;

    public CatalogItemAdapter(List<CatalogItem>CatalogItemList){
        this.CatalogItemList = CatalogItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CatalogItem catalogItem = CatalogItemList.get(position);

        holder.proView.setText(catalogItem.getProsItem());
        holder.conView.setText(catalogItem.getConsItem());
        holder.workoutView.setText(catalogItem.getWorkoutInfo());
        holder.workoutTitle.setText(catalogItem.getWorkoutTitle());
        holder.thumbnail.setImageResource(catalogItem.getImageID());
    }

    @Override
    public int getItemCount() {
        return CatalogItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView proView;
        TextView conView;
        TextView workoutView;
        TextView workoutTitle;
        ImageView thumbnail;

        public ViewHolder(View itemView){
            super(itemView);
            proView = (TextView)itemView.findViewById(R.id.pros_box);
            conView = (TextView)itemView.findViewById(R.id.negs_box);
            workoutView = (TextView)itemView.findViewById(R.id.workout_info_box);
            workoutTitle = (TextView)itemView.findViewById(R.id.workout_title_box);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail_img);
        }
    }
}
