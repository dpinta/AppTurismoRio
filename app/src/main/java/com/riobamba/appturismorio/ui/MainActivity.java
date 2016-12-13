package com.riobamba.appturismorio.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.riobamba.appturismorio.model.entity.User;
import com.riobamba.appturismorio.data.turismoRioDBHelper;

import butterknife.Bind;


public class MainActivity extends FormActivity {

    @Bind(R.id.tviUsername)
    TextView tviUsername;

    private User user;
    private  turismoRioDBHelper base;
    private Context contexto;

    private SQLiteDatabase db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base = new turismoRioDBHelper(contexto);
        db = base.getWritableDatabase();
        extras();
        injectView();
        ui();


    }

    private void ui() {
        tviUsername.setText("Welcome " + user.getFirstname()+" "+user.getLastname());
    }

    private void extras() {
        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null) {
                user= (User)bundle.getParcelable("ENTITY");
            }
        }
    }
}
