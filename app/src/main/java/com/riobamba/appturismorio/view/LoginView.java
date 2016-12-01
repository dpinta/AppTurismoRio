package com.riobamba.appturismorio.view;

import com.riobamba.appturismorio.model.entity.User;

/**
 * Created by emedinaa on 21/08/15.
 */
public interface LoginView  extends BaseView{

    void showLoading();
    void hideLoading();
    boolean validate();
    void gotoMain(User user);
    void showMessageError(String message);
    String getUserName();
    String getPassword();
}
