package com.riobamba.appturismorio.data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.riobamba.appturismorio.model.modeloLugar;

/**
 * Created by lllum on 14/12/2016.
 */

public class lugarCursorAdapter extends CursorAdapter {
 private operacionDB objOperacionDB=null;

    public lugarCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        final LayoutInflater inflater=LayoutInflater.from(context);

        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tv=(TextView) view;
        tv.setText(cursor.getString(cursor.getColumnIndex()));
    }
}
