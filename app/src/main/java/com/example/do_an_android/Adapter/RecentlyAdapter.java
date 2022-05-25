package com.example.do_an_android.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_an_android.Model.ProductModel;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecentlyAdapter extends RecyclerView.Adapter<RecentlyAdapter.RecentlyView> {

    Context context;
    int layout;
    ArrayList<ProductModel> recentlyProductsList;

    public RecentlyAdapter(Context context, int layout, ArrayList<ProductModel> recentlyProductsList) {
        this.context = context;
        this.layout = layout;
        this.recentlyProductsList = recentlyProductsList;
    }

    @NonNull
    @Override
    public RecentlyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(layout, parent, false);

        return new RecentlyView(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull RecentlyView holder, int position) {

        ProductModel productModel=recentlyProductsList.get(position);
        Log.d("haha", "onBindViewHolder: "+productModel.getImage());
        Picasso.get().load(Server.urlImage+productModel.getImage()).into(holder.recentlyImageView);
        holder.recentlyName.setText(productModel.getName());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(context, ProductDetailActivity.class);
//                i.putExtra("name", recentlyViewedList.get(position).getName());
//                i.putExtra("image", recentlyViewedList.get(position).getBigimageurl());
//                i.putExtra("price",recentlyViewedList.get(position).getPrice());
//                i.putExtra("desc",recentlyViewedList.get(position).getDescription());
//                i.putExtra("qty",recentlyViewedList.get(position).getQuantity());
//                i.putExtra("unit",recentlyViewedList.get(position).getUnit());
//                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(i);
//                Log.d("duy", "onClick: ");
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return recentlyProductsList.size();
    }

    public  static class RecentlyView extends RecyclerView.ViewHolder{

        ImageView recentlyImageView;
        TextView recentlyName;

        public RecentlyView(@NonNull View itemView) {
            super(itemView);
            recentlyImageView = itemView.findViewById(R.id.productImageRecently);
            recentlyName = itemView.findViewById(R.id.productNameRecently);

        }
    }

}
