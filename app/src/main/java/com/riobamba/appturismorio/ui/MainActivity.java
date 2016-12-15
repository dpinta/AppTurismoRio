package com.riobamba.appturismorio.ui;

import android.app.ListActivity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.riobamba.appturismorio.data.operacionDB;
import com.riobamba.appturismorio.data.turismoRioDBHelper;
import com.riobamba.appturismorio.model.entity.User;

import butterknife.Bind;


public class MainActivity extends ListActivity {

    @Bind(R.id.tviUsername)
    TextView tviUsername;

    private User user;
    private  turismoRioDBHelper base;
    private Context contexto;
    private SQLiteDatabase db;
private Cursor cursor;
    private operacionDB objOreacionDb;
    private ListView lista;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        extras();
        //injectView();
        ui();
        lista=(ListView) findViewById(R.id.listView);
        cursor=objOreacionDb.cursorCargarInformacion("1");
        startManagingCursor(cursor);
        lista.setAdapter();




    }

    private void ui() {

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
