package com.example.manageproductsrecicled;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.manageproductsrecicled.adapter.ProductAdapterRecycler;
import com.example.manageproductsrecicled.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity{

    public static final int ADD_PRODUCT = 0;
    public static final int EDIT_PRODUCT = 0;

    private ProductAdapterRecycler adapter;
    private RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        adapter = new ProductAdapterRecycler(this);
        rcv = (RecyclerView) findViewById(R.id.rcvProducts);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);


    }

    /*Método que infla el menu en la activity
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflador para los menus, le paso el xml
        getMenuInflater().inflate(R.menu.menu_products, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /*Método para cuando se seleccione el elemento del menu
    True si quiero que se propague el efecto, false si no
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_product:
                Intent i = new Intent(ProductActivity.this, ManageProductActivity.class );
                startActivityForResult(i, ADD_PRODUCT );
                break;

            case R.id.action_sort_alphabetically:
                adapter.getProductsOrder();
                break;

            case R.id.action_settings_account:
                Intent intent = new Intent(ProductActivity.this, AccountSettings.class);
                startActivity(intent);
                break;

            case R.id.action_settings_general:
                Intent inten = new Intent(ProductActivity.this, GeneralSettings.class);
                startActivity(inten);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_PRODUCT){
            if(resultCode == RESULT_OK){
                //Add product
            }
            else{

            }

        }
    }
}
