package com.example.do_an_android.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.do_an_android.Model.CartModel;
import com.example.do_an_android.Model.ProductModel;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.Model.Support;
import com.example.do_an_android.R;
import com.example.do_an_android._Fragment.CartFragment;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;


public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView back, imageProductDetail;
    TextView nameProductDetail, priceProductDetail, priceDiscountProductDetail, descriptionProdcutDetail;
    EditText quantityProductDetail;
    Button btnBuyNow, btnAddCart;
    ProductModel productModel;
    SharedPreferences sharedPreferencesCart;
    ArrayList<CartModel> listCart = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setControl();
        loadData();
        back.setOnClickListener(this);
        btnAddCart.setOnClickListener(this);
        btnBuyNow.setOnClickListener(this);
        sharedPreferencesCart = getSharedPreferences("cart", Context.MODE_PRIVATE);
        String cart = sharedPreferencesCart.getString("item_cart", "");

        CartModel[] cartModels = new Gson().fromJson(cart, CartModel[].class);
        if (cartModels != null)
            listCart = new ArrayList<CartModel>(Arrays.asList(cartModels));
        else
            listCart = new ArrayList<>();

    }

    private void loadData() {
        productModel = (ProductModel) getIntent().getSerializableExtra("productDetail");
        Picasso.get().load(Server.urlImage + productModel.getImage()).into(imageProductDetail);
        nameProductDetail.setText(productModel.getName());
        priceProductDetail.setText(Support.ConvertMoney(productModel.getPrice()));
        priceDiscountProductDetail.setText(Support.ConvertMoney(productModel.getPrice_discounted()));
        descriptionProdcutDetail.setText(productModel.getDescription());
    }

    private void setControl() {
        back = findViewById(R.id.backProductDetail);
        imageProductDetail = findViewById(R.id.imageProductDetail);
        nameProductDetail = findViewById(R.id.nameProductDetail);
        priceProductDetail = findViewById(R.id.priceProductDetail);
        priceDiscountProductDetail = findViewById(R.id.priceDiscountProductDetail);
        descriptionProdcutDetail = findViewById(R.id.descriptionProdcutDetail);
        quantityProductDetail = findViewById(R.id.quantityProductDetail);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        btnAddCart = findViewById(R.id.btnAddCart);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.backProductDetail:
                Intent i = new Intent(ProductDetailActivity.this, MainActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnAddCart:
                AddCart();
                break;
            case R.id.btnBuyNow:
                if(Integer.parseInt(quantityProductDetail.getText().toString())!=0) {
                    AddCart();
                    Intent intent = new Intent(ProductDetailActivity.this, MainActivity.class);
                    intent.putExtra("checkBuyNow", true);
                    startActivity(intent);
                }
                break;
        }
    }

    private void AddCart() {
        boolean check=false;
        int quantity= Integer.parseInt(quantityProductDetail.getText().toString());
        if(quantity==0)
            return;
        for(CartModel item : listCart)
        {
            if(item.getProductModel().getCode().equals(productModel.getCode())) {
                CartModel cartModel=item;
                listCart.remove(item);

                cartModel.setQuantity(cartModel.getQuantity()+quantity);
                check=true;
                listCart.add(cartModel);

                break;
            }
        }
        if(!check)
            listCart.add(new CartModel(productModel,Integer.parseInt(quantityProductDetail.getText().toString())));
        Toast.makeText(this,"Thêm sản phẩm thành công.",Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor editorCart = sharedPreferencesCart.edit();

        editorCart.putString("item_cart",new Gson().toJson(listCart));
        editorCart.commit();
    }
}