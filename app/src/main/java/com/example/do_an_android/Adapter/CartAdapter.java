package com.example.do_an_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.do_an_android.Model.CartModel;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.Model.Support;
import com.example.do_an_android.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    Context context;
    int layout;
    ArrayList<CartModel> lstCart;

    public CartAdapter(Context context, int layout, ArrayList<CartModel> lstCart) {
        this.context = context;
        this.layout = layout;
        this.lstCart = lstCart;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(context).inflate(layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartModel cart = lstCart.get(position);
        Picasso.get().load(Server.urlImage+cart.getProductModel().getImage()).into(holder.image);
       holder.quantity.setText(cart.getQuantity()+"");
        holder.subtotal.setText(Support.ConvertMoney(cart.getQuantity()*cart.getProductModel().getPrice()));
        holder.price.setText(Support.ConvertMoney(cart.getProductModel().getPrice()));
        holder.name.setText(cart.getProductModel().getName());
    }

    @Override
    public int getItemCount() {
        return lstCart.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, price, subtotal;
        EditText quantity;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_detail_cart);
            name = itemView.findViewById(R.id.name_detail_cart);
            price = itemView.findViewById(R.id.price_deatail_cart);
            subtotal = itemView.findViewById(R.id.subtotal_detail_cart);
            quantity = itemView.findViewById(R.id.quantity_detail_cart);
        }
    }
}
