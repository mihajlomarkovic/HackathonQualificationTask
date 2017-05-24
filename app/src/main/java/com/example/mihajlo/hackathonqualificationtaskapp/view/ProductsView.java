package com.example.mihajlo.hackathonqualificationtaskapp.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mihajlo.hackathonqualificationtaskapp.R;
import com.example.mihajlo.hackathonqualificationtaskapp.model.Product;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Mihajlo on 24-May-17.
 */

@EViewGroup(R.layout.products_view)
public class ProductsView extends LinearLayout{

    @ViewById
    TextView productTitle;

    public ProductsView(Context context) {
        super(context);
    }

    public void bind (Product product){
        productTitle.setText(product.getTitle());
    }

}
