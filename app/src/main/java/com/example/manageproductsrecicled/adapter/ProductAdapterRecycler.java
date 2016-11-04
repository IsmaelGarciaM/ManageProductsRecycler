package com.example.manageproductsrecicled.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.manageproductsrecicled.ProductApplication;
import com.example.manageproductsrecicled.R;
import com.example.manageproductsrecicled.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by usuario on 24/10/16.
 */

public class ProductAdapterRecycler extends RecyclerView.Adapter<ProductAdapterRecycler.ProductViewHolder>{

    private List<Product> products;
    private Context context;
    public static boolean ASC = false;

    public ProductAdapterRecycler(Context context){
        this.context = context;
        products = new ArrayList<Product>(((ProductApplication)context.getApplicationContext()).getProducts());
    }

    //Infla el xml y devuelve el objeto view
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, null);
        return new ProductViewHolder(item);
    }

    //Asigna los datos del adapter a los widget
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.product_image.setImageResource(products.get(position).getmImage());
        holder.txvName.setText(products.get(position).getmName());
        holder.txvPrice.setText(products.get(position).getFormattedPrice());
        holder.txvStock.setText(products.get(position).getFormattedStock());

    }

    //saber cuántos viewHolder va a construir
    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{

            ImageView product_image;
            TextView txvName;
            TextView txvPrice;
            TextView txvStock;


        public ProductViewHolder(View item) {
            super(item);

            product_image = (ImageView) item.findViewById(R.id.imgProduct);
            txvName = (TextView) item.findViewById(R.id.txvNameItem);
            txvPrice = (TextView) item.findViewById(R.id.txvPriceItem);
            txvStock = (TextView) item.findViewById(R.id.txvStockItem);
        }
    }


    public List<Product> getAllProducts(){
        return products;
    }

    public void getProductsOrder( ){
        ASC = !ASC;
        products.clear();
        products.addAll(((ProductApplication)context.getApplicationContext()).getProducts(ASC));
        notifyDataSetChanged();
    }



}
