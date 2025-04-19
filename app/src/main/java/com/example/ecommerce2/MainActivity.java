package com.example.ecommerce2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecommerce2.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome;
    RecyclerView recyclerView;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);
        recyclerView = findViewById(R.id.recyclerView);

        // Retrieve username from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("ComicAppPrefs", Context.MODE_PRIVATE);
        String username = prefs.getString("username", "admin");

        // Set the welcome message
        tvWelcome.setText("Welcome " + username);

        // Initialize product list and set up RecyclerView
        productList = getProducts();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter(this, productList));
    }

    private List<Product> getProducts() {
        List<Product> list = new ArrayList<>();

        // Adding products to the list
        list.add(new Product(
                "Earth X #0–12 (Complete Series)",
                "product1",
                "₹799",
                "A beautifully preserved complete run of Earth X, featuring the first appearance of Shalla-Bal and classic Marvel legends. VF/NM condition – clean, crisp, and ready for your shelf."
        ));

        list.add(new Product(
                "Harley Quinn #1–38 + Our Worlds at War",
                "product2",
                "₹1,499",
                "Massive set from DC’s 2000s era! Good condition with mild signs of wear. Harley’s wild early adventures all in one collection – chaotic fun guaranteed."
        ));

        list.add(new Product(
                "Uncanny X-Men #134 – Dark Phoenix",
                "product3",
                "₹649",
                "The legendary first appearance of Dark Phoenix. Strong condition, iconic art by Byrne, and powerful storytelling from Claremont. A collector’s must."
        ));

        list.add(new Product(
                "Venom: Lethal Protector #1–6",
                "product4",
                "₹699",
                "Symbiote fans rejoice! All six high-grade issues of Venom’s breakout solo series. Clean covers, sharp pages – a venomous vintage treat."
        ));

        list.add(new Product(
                "Captain Marvel #14 (1969)",
                "product5",
                "₹299",
                "Bronze Age key featuring Thanos prelude content. Glossy and well-kept – an affordable gem for classic Marvel lovers."
        ));

        return list;
    }
}
