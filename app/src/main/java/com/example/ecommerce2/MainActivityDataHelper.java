package com.example.ecommerce2;

import com.example.ecommerce2.model.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivityDataHelper {
    public static List<Product> getProducts() {
        List<Product> list = new ArrayList<>();

        list.add(new Product(
                "Earth X #0–12 (Complete Series)",
                "product1",
                "₹799",
                "A beautifully preserved complete run of Earth X, featuring the first appearance of Shalla-Bal and classic Marvel legends like Silver Surfer and the Fantastic Four. The books are in Very Fine/Near Mint condition — clean, crisp, and perfect for both collectors and casual readers."
        ));

        list.add(new Product(
                "Harley Quinn #1–38 + Our Worlds at War #1",
                "product2",
                "₹1,499",
                "A huge collection of Harley’s early adventures from DC’s wild 2000s. The set is in Good condition — well-read but still clean and complete. Minor scuffs, no missing pages, all the chaos and comedy you expect from Ms. Quinn!"
        ));

        list.add(new Product(
                "Uncanny X-Men #134 – 1st Dark Phoenix",
                "product3",
                "₹649",
                "This 1980 classic features the dramatic rise of Jean Grey as the Dark Phoenix, penned by Claremont with art by Byrne. A must-own issue in very solid condition — iconic, emotional, and timeless."
        ));

        list.add(new Product(
                "Venom: Lethal Protector #1–6",
                "product4",
                "₹699",
                "Venom’s first solo adventure! This high-grade 6-issue set is action-packed, with clean pages and sharp covers. If you're a symbiote fan, this is your holy grail without breaking the bank."
        ));

        list.add(new Product(
                "Captain Marvel #14 (1969) – Bronze Age Key",
                "product5",
                "₹299",
                "A glossy Bronze Age gem featuring an early Thanos prelude! This Very Good condition comic is a piece of Marvel history. Great addition to any vintage collection."
        ));

        return list;
    }
}
