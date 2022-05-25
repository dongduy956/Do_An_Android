package com.example.do_an_android._Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.do_an_android.Adapter.CartAdapter;
import com.example.do_an_android.Model.CartModel;
import com.example.do_an_android.R;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    Context context;
    ArrayList<CartModel> lstCart;
    RecyclerView recyclerView;
    public CartFragment(Context context) {
        this.context=context;
        lstCart=new ArrayList<>();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setControl(view);
        setData();
    }

    private void setData() {
        lstCart.add(new CartModel(R.drawable.card1,"Sản phẩm test 1","5","100.000","500.000"));
        lstCart.add(new CartModel(R.drawable.card2,"Sản phẩm test 2","10","60.000","600.000"));
        CartAdapter cartAdapter=new CartAdapter(context,R.layout.item_cart,lstCart);
        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
    }

    private void setControl(View view) {
        recyclerView=view.findViewById(R.id.recycleviewcart);
    }
}