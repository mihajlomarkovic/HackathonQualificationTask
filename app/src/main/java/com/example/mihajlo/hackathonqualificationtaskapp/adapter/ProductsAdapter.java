package com.example.mihajlo.hackathonqualificationtaskapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mihajlo.hackathonqualificationtaskapp.dao.ProductDao;
import com.example.mihajlo.hackathonqualificationtaskapp.eventbus.OttoBus;
import com.example.mihajlo.hackathonqualificationtaskapp.eventbus.event.ProductsUpdated;
import com.example.mihajlo.hackathonqualificationtaskapp.model.Product;
import com.example.mihajlo.hackathonqualificationtaskapp.view.ProductsView;
import com.example.mihajlo.hackathonqualificationtaskapp.view.ProductsView_;
import com.squareup.otto.Subscribe;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihajlo on 24-May-17.
 */

@EBean
public class ProductsAdapter extends BaseAdapter {

    private List<Product> products = new ArrayList<>();

    @RootContext
    Context context;

    @Bean
    ProductDao productDao;

    @Bean
    OttoBus bus;

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProductsView productsView;

        if(convertView == null){
            productsView = ProductsView_.build(context);
        }else{
            productsView = (ProductsView) convertView;
        }

        productsView.bind(products.get(position));

        return productsView;
    }

    private void setProducts(List<Product> products){
        this.products = products;
        notifyDataSetChanged();
    }

    @Subscribe
    public void productsUpdated(ProductsUpdated event){
        setProducts(productDao.getProducts());
    }

}
