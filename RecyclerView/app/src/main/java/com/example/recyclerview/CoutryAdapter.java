package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoutryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    //Nhận dư liệu truyền từ ngoài vào
    private List<Country> countries;

    public CoutryAdapter(List<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.CountryViewHolder holder, int position) {
        country country = countries.get(position);
        holder.img_Flag.setImageResource(country)

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    //Dinh nghĩa VienHolder
    class CountryViewHolder extends ReyclerView.ViewHolder{
        imageView imvFlag;
        TextView txtName;
        TextView txtCapital;
        public CountryViewHolder(@NonNull View itemView) {
            Super(itemView);
            imvFlag = itemView.findView
        }
    }
}
