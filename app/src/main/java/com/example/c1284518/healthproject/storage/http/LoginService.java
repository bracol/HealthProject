package com.example.c1284518.healthproject.storage.http;

import android.util.Log;

import com.example.c1284518.healthproject.model.entitites.Login;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by c1284518 on 04/12/2015.
 */
public class LoginService {

    private LoginService(){}

    public static final String URL = "http://10.11.50.167/api/user";

    public static Login getLogin(HttpURLConnection conn){
        Login login = null;
        try{
            //java.net.URL url = new URL(URL);
            //final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //conn.setRequestMethod("GET");
            //conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream is = conn.getInputStream();
                ObjectMapper objectMapper = new ObjectMapper();
                login = objectMapper.readValue(is, Login.class);
            }
            conn.disconnect();
        }catch (Exception e){
            Log.e(LoginService.class.getName(), e.getMessage());
        }
        return login;

    }




}
