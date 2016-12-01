package com.riobamba.appturismorio.model.interactor;

import com.emedinaa.androidmvp.data.entity.request.LogInRaw;
import com.emedinaa.androidmvp.data.entity.response.LoginResponse;
import com.emedinaa.androidmvp.data.mapper.UserDataMapper;
import com.emedinaa.androidmvp.data.rest.ApiClient;
import com.emedinaa.androidmvp.model.entity.User;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by em on 22/04/16.
 */
public class LogInInteractor {

    private final UserDataMapper userDataMapper;

    public LogInInteractor(UserDataMapper userDataMapper) {
        this.userDataMapper = userDataMapper;
    }

    public void logIn(String email, String password,final LogInCallback logInCallback)
    {
        LogInRaw logInRaw= new LogInRaw();
        logInRaw.setUsername(email);
        logInRaw.setPassword(password);

        ApiClient.getMyApiClient().login(logInRaw, new Callback<LoginResponse>() {
            @Override
            public void success(LoginResponse loginResponse, Response response) {
                if(loginResponse!=null){
                    User user= userDataMapper.transformResponse(loginResponse);
                    logInCallback.onLogInSuccess(user);
                }else{
                    logInCallback.onLogInError("an error occurred...");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String message= "";
                if(error!=null)message= error.getMessage();
                logInCallback.onLogInError(message);
            }
        });
    }
}
