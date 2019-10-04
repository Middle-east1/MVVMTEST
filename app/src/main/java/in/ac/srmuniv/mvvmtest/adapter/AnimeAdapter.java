package in.ac.srmuniv.mvvmtest.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import in.ac.srmuniv.mvvmtest.R;
import in.ac.srmuniv.mvvmtest.databinding.ItemNarotoBinding;
import in.ac.srmuniv.mvvmtest.model.AnimeModel;


public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.BestHotelViewHolder> {

    private Context context;
    List<AnimeModel> animeModelsList ;
    public AnimeAdapter(Context context) {
        this.context = context;
        this.animeModelsList = animeModelsList = new ArrayList<>();

    }

    @NonNull
    @Override
    public BestHotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          ItemNarotoBinding itemNarotoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_naroto,parent,false);
        return new BestHotelViewHolder(itemNarotoBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull BestHotelViewHolder holder, int position) {
        AnimeModel animeModel = animeModelsList.get(position);
        holder.itemNarotoBinding.setAnime(animeModel);
    }
    @Override
    public int getItemCount() {

        return animeModelsList.size();
    }

    public class BestHotelViewHolder extends RecyclerView.ViewHolder{
        ItemNarotoBinding  itemNarotoBinding ;
        public BestHotelViewHolder(@NonNull ItemNarotoBinding itemView) {
            super(itemView.getRoot());

            itemNarotoBinding = itemView;
        }
    }

    public void getdata(List<AnimeModel> animeModels){
        animeModelsList = animeModels;
        notifyDataSetChanged();


    }

}
