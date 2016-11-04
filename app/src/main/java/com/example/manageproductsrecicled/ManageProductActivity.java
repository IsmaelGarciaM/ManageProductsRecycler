package com.example.manageproductsrecicled;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.manageproductsrecicled.model.Product;

public class ManageProductActivity extends AppCompatActivity {

   /* EditText edName;
    EditText edDesc;
    EditText edBrand;
    EditText edDose;
    EditText edPrice;
    EditText edStock;
    Button btnAcceptAdd;
    Button btnCancelAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product);

        edName = (EditText) findViewById(R.id.edtName);
        edDesc = (EditText) findViewById(R.id.edtDescription);
        edBrand = (EditText) findViewById(R.id.edtBrand);
        edDose = (EditText) findViewById(R.id.edtDose);
        edPrice = (EditText) findViewById(R.id.edtPrice);
        edStock = (EditText) findViewById(R.id.edtStock);

        btnAcceptAdd = (Button) findViewById(R.id.btnOk);
        btnCancelAdd = (Button) findViewById(R.id.btnCancelAdd);



        btnAcceptAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CheckAdd();

            }
        });

        btnAcceptAdd.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


            }
        });
    }



    private void CheckAdd(){
        try{
            Product p = new Product(String.valueOf(edName.getText()), String.valueOf(edDesc.getText()), String.valueOf(edBrand.getText()),
                    Double.parseDouble(String.valueOf(edPrice.getText())), Integer.parseInt(String.valueOf(edStock.getText())),
                    65, String.valueOf(edDose.getText()));
            ((ProductApplication)getApplicationContext()).AddProduct(p);
        }catch (Exception e){}
    }*/

}
