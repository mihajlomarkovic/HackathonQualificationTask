package com.example.mihajlo.hackathonqualificationtaskapp.dao;

import com.example.mihajlo.hackathonqualificationtaskapp.eventbus.OttoBus;
import com.example.mihajlo.hackathonqualificationtaskapp.eventbus.event.ProductsUpdated;
import com.example.mihajlo.hackathonqualificationtaskapp.model.Product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mihajlo on 24-May-17.
 */
@EBean(scope = EBean.Scope.Singleton)
public class ProductDao {

    public static final String PRODUCT_TAG = "products";

    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    private List<Product> products = new ArrayList<>();

    private Map<String, Product> productMap = new HashMap<>();

    @Bean
    OttoBus bus;

    @AfterInject
    public void init(){
        database.getReference(PRODUCT_TAG).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productMap = dataSnapshot.getValue(new GenericTypeIndicator<Map<String, Product>>(){});
                publish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void write(Product product){
        final DatabaseReference databaseReference = database.getReference(PRODUCT_TAG).push();
        product.setId(databaseReference.getKey());
        databaseReference.setValue(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void publish(){
        products.clear();
        if(productMap != null){
            products.addAll(productMap.values());
        }
        // post to event bus
        bus.post(new ProductsUpdated());
    }
}
