package com.riobamba.appturismorio.presenter;

/**
 * Created by emedinaa on 16/04/16.
 */
public interface Presenter<T> {

    void addView(T view);
    void removeView();
}
