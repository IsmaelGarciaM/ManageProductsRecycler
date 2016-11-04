package com.example.manageproductsrecicled;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @autor: Ismael Garcia
 * @version: 1.0
 * Class that checks a login with specific business rules
 */
public class LogIn extends AppCompatActivity implements ILogin.View{

    private ILogin.Presenter loginMvp;
    private EditText edtUser;
    private EditText edtPassword;
    private Button btnOk;
    private TextInputLayout tilUser;
    private TextInputLayout tilPass;
    private final String TAG = ".manageproducts";
    private TextView txvForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        loginMvp = new LogInPresenter(this); //We pass the view (activity)
        edtUser = (EditText) findViewById(R.id.edtUser);
        edtPassword = (EditText) findViewById(R.id.edtPass);
        btnOk = (Button) findViewById(R.id.btnLogIn);
        tilUser = (TextInputLayout) findViewById(R.id.tiluser);
        tilPass = (TextInputLayout) findViewById(R.id.tilpassword);
        txvForget = (TextView) findViewById(R.id.txvForget);

        Typeface font = Typeface.createFromAsset(getAssets(), "scary_halloween_font.ttf");
        txvForget.setTypeface(font);

        txvForget.setMovementMethod(LinkMovementMethod.getInstance());
        edtUser.setText("User");
        edtPassword.setText("aaaaaaA3");
        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilUser.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Presenter checks if password meets business rules
                if(loginMvp.validateCredentials(edtUser.getText().toString(), edtPassword.getText().toString())) {
                    Intent intent = new Intent(LogIn.this, ProductActivity.class);
                    startActivity(intent);
                }


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Aplicacion iniciada.");

    }

    @Override
    public void onDestroy(){
        super.onStop();
        Log.d(TAG, "Activity destriuda");
    }

    @Override
    public void setMessageError(String error, int idview) {
        //Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

        switch (idview) {

            case R.id.tiluser: tilUser.setError(error);
                break;
            case R.id.tilpassword: tilPass.setError(error);
                break;
        }
    }

}
