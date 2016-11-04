package com.example.manageproductsrecicled;

import android.app.Application;

import com.example.manageproductsrecicled.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductApplication  extends Application{

    private ArrayList<Product> productos = new ArrayList<Product>();

    @Override
    public void onCreate(){

        super.onCreate();
        AddProduct(new Product("Ibuprofeno", "Pastillas para dolor muscular", "Bayer", 5.99, 100, R.drawable.ibu, "1gr"));
        AddProduct(new Product("Paracetamol", "Pastillas para la gripe", "Monsanto", 3.58, 200, R.drawable.para, "1gr"));
        AddProduct(new Product("Dalsy", "Jarabe para tos", "Bayer", 3.58, 200, R.drawable.dalsy, "15gr"));
        AddProduct(new Product("Flogoprofen", "Pastillas para dolor muscular", "Bayer", 6.58, 100, R.drawable.ibu, "1gr"));
        AddProduct(new Product("Parafen", "Pastillas para la gripe", "Monsanto", 2.56, 200, R.drawable.para, "1gr"));

    }

    public void AddProduct(Product p){

       productos.add(p);


    }

    public ArrayList getProducts(){

        //Collections.sort(productos, Product.PRICE_COMPARATOR)
                                    //Expresion Lambda
        //Collections.sort(productos, ((o1,o2)->Double.compare(o1.getmPrice(), o2.getmPrice())));

        Collections.sort(productos);

        return productos;
    }

    public ArrayList getProducts(boolean asc){
        if(asc)
            Collections.sort(productos);
        else{
            Comparator c = Collections.reverseOrder();
            Collections.sort(productos, c);
        }
        return  productos;
    }


}





