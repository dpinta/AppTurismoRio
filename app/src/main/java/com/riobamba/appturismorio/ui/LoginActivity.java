package com.riobamba.appturismorio.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.riobamba.appturismorio.model.modeloImagen;
import com.riobamba.appturismorio.model.modeloLugar;
import com.riobamba.appturismorio.data.operacionDB;
import com.riobamba.appturismorio.data.turismoRioDBHelper;
import com.riobamba.appturismorio.model.entity.User;
import com.riobamba.appturismorio.presenter.LoginPresenter;
import com.riobamba.appturismorio.view.LoginView;



public class LoginActivity extends FormActivity implements LoginView{

    private static final String TAG = "LoginActivity";
    private EditText eteUsername,etePassword;
    private View btnLogin,vLoading;

    private String username, password;
    private LoginPresenter loginPresenter;

    private  turismoRioDBHelper base;
    private Context contexto;
    private operacionDB objOperaciones;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        injectView();
        loginPresenter= new LoginPresenter();
        loginPresenter.addView(this);
        ui();
        //base = new turismoRioDBHelper(getBaseContext());
       // db = base.getWritableDatabase();
        objOperaciones= operacionDB.optenerInstancia(getApplicationContext());

        modeloLugar oLugar= new modeloLugar("1","san antonio","loma de quito","es una iglesia","-094954395","-987859");
        objOperaciones.insertarLugar(oLugar);
        objOperaciones.insertarImagen(new modeloImagen("1","imagen1", oLugar));
        objOperaciones.insertarImagen(new modeloImagen("2","imagen2", oLugar));
        objOperaciones.insertarImagen(new modeloImagen("3","imagen3", oLugar));

        modeloLugar oLugar1= new modeloLugar("2","la concepción","calles juan de lavalle y primera constituyente","es una iglesia construida en el año 1920","-094954395","-987859");
        objOperaciones.insertarLugar(oLugar1);
        objOperaciones.insertarImagen(new modeloImagen("4","imagen4", oLugar1));
        objOperaciones.insertarImagen(new modeloImagen("5","imagen5", oLugar1));
        objOperaciones.insertarImagen(new modeloImagen("6","imagen6", oLugar1));

        modeloLugar oLugar2= new modeloLugar("3","la concepción","calles juan de lavalle y primera constituyente","es una iglesia construida en el año 1920","-094954395","-987859");
        objOperaciones.insertarLugar(oLugar2);
        objOperaciones.insertarImagen(new modeloImagen("7","imagen7", oLugar2));
        objOperaciones.insertarImagen(new modeloImagen("8","imagen8", oLugar2));
        objOperaciones.insertarImagen(new modeloImagen("9","imagen9", oLugar2));








    }

    private void ui() {
        eteUsername = (EditText)findViewById(R.id.eteUsername);
        etePassword = (EditText)findViewById(R.id.etePassword);
        btnLogin = findViewById(R.id.btnLogin);
        vLoading = findViewById(R.id.vLoading);
        vLoading.setVisibility(View.GONE);
        events();
    }

    private void events() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn();
            }
        });
        etePassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event!=null){
                    Log.v(TAG,"keycode "+event.getKeyCode()+
                            " actionId "+actionId);
                }

                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    logIn();
                }
                return false;
            }
        });

    }

    private void logIn()
    {
        loginPresenter.login();
    }


    @Override
    public void showLoading() {
        vLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        vLoading.setVisibility(View.GONE);
    }

    @Override
    public boolean validate() {
        username = eteUsername.getText().toString().trim();
        password = etePassword.getText().toString().trim();

        eteUsername.setError(null);
        etePassword.setError(null);
        if(username.isEmpty())
        {
            eteUsername.setError(getString(R.string.msg_ingresar));
            return false;
        }
        if(password.isEmpty())
        {
            etePassword.setError(getString(R.string.msg_ingresar));
            return false;
        }
        return true;
    }

    @Override
    public void gotoMain(User user) {
        Bundle bundle= new Bundle();
        bundle.putParcelable("ENTITY",user);
        next(bundle,MainActivity.class,false);
    }

    @Override
    public void showMessageError(String message) {
        Log.v(TAG, " error " + message);
        showMessage(findViewById(R.id.container),message);
    }

    @Override
    public String getUserName() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Context getContext() {
        return this;
    }

}
