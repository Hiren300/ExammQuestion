package com.example.ecommerce2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerce2.model.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CartActivity extends AppCompatActivity {

    LinearLayout cartItemsContainer;
    TextView tvTotalPrice;
    Button btnClearCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartItemsContainer = findViewById(R.id.cartItemsContainer);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnClearCart = findViewById(R.id.btnClearCart);

        SharedPreferences prefs = getSharedPreferences("ComicAppPrefs", Context.MODE_PRIVATE);
        Set<String> cartSet = prefs.getStringSet("cart", new HashSet<>());
        List<Product> productList = MainActivityDataHelper.getProducts();

        double total = 0.0;

        for (String indexStr : cartSet) {
            int index = Integer.parseInt(indexStr);
            Product product = productList.get(index);

            TextView itemView = new TextView(this);
            itemView.setText(product.title + "\n" + product.price);
            itemView.setPadding(0, 0, 0, 24);
            cartItemsContainer.addView(itemView);

            // Extract price number
            try {
                total += Double.parseDouble(product.price.replaceAll("[^\\d.]", ""));
            } catch (Exception e) {
                e.printStackTrace(); // In case of parsing issues
            }
        }

        tvTotalPrice.setText("Total: ₹" + String.format("%.2f", total));

        btnClearCart.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.remove("cart");
            editor.apply();
            cartItemsContainer.removeAllViews();
            tvTotalPrice.setText("Total: $0.00");
        });
    }
}
