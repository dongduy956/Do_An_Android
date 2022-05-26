package com.example.do_an_android.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.do_an_android.Model.ProductModel;
import com.example.do_an_android.Model.Server;
import com.example.do_an_android.Model.Support;
import com.example.do_an_android.R;
import com.squareup.picasso.Picasso;


public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView back, imageProductDetail;
    TextView nameProductDetail, priceProductDetail, priceDiscountProductDetail, descriptionProdcutDetail;
    EditText quantityProductDetail;
    Button btnBuyNow, btnAddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setControl();
        loadData();
        back.setOnClickListener(this);
    }
    private void loadData() {
        ProductModel productModel= (ProductModel) getIntent().getSerializableExtra("productDetail");
        Picasso.get().load(Server.urlImage+productModel.getImage()).into(imageProductDetail);
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
            case  R.id.btnAddCart:
                break;
            case  R.id.btnBuyNow:
                break;
        }
    }
}