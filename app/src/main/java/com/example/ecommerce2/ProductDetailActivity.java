package com.example.ecommerce2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerce2.model.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView imgDetail;
    TextView tvTitle, tvPrice, tvDesc;
    Button btnAddToCart;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        imgDetail = findViewById(R.id.imgDetail);
        tvTitle = findViewById(R.id.tvDetailTitle);
        tvPrice = findViewById(R.id.tvDetailPrice);
        tvDesc = findViewById(R.id.tvDetailDesc);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        productList = MainActivityDataHelper.getProducts(); // reuse data

        int index = getIntent().getIntExtra("productIndex", 0);
        Product product = productList.get(index);

        int imageRes = getResources().getIdentifier(product.imageName, "drawable", getPackageName());
        imgDetail.setImageResource(imageRes);
        tvTitle.setText(product.title);
        tvPrice.setText(product.price);
        tvDesc.setText(product.description);

        btnAddToCart.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("ComicAppPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            Set<String> cartSet = prefs.getStringSet("cart", new HashSet<>());
            cartSet = new HashSet<>(cartSet); // to make mutable
            cartSet.add(String.valueOf(index));

            editor.putStringSet("cart", cartSet);
            editor.apply();

            // Open Cart
            startActivity(new Intent(ProductDetailActivity.this, CartActivity.class));
        });
    }
}
