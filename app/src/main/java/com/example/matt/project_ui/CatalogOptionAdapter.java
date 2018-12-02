package com.example.matt.project_ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CatalogOptionAdapter extends RecyclerView.Adapter<CatalogOptionAdapter.ViewHolder> {

    List<CatalogOption> CatalogOptionList;

    public CatalogOptionAdapter(List<CatalogOption>CatalogOptionList){
        this.CatalogOptionList = CatalogOptionList;
    }

    @NonNull
    @Override
    public CatalogOptionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catalog_option,parent,false);
        CatalogOptionAdapter.ViewHolder viewHolder = new CatalogOptionAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogOptionAdapter.ViewHolder holder, int position) {
        CatalogOption catalogOption = CatalogOptionList.get(position);

        holder.optionText.setText(catalogOption.getOptionText());
    }

    @Override
    public int getItemCount() {
        return CatalogOptionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView optionText;

        public ViewHolder(View itemView){
            super(itemView);
            optionText = (TextView)itemView.findViewById(R.id.option_text);
        }
    }
}
