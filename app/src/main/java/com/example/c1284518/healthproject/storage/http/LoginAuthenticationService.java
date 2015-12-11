package com.example.c1284518.healthproject.storage.http;

import android.util.Base64;
import android.util.Log;

import com.example.c1284518.healthproject.model.entitites.Login;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by c1284518 on 03/12/2015.
 */
public class LoginAuthenticationService {

    private LoginAuthenticationService() {
    }

    ;

    //private static final String URL = "http://inovacoes.cast.com.br/api";
    private static final String URL = "http://10.11.50.167/api/user";


    public static Login getAuthentication(String user, String password) {
        Login login = null;
        try{
            java.net.URL url = new URL(URL);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            String sign = user + ":" + password;
            conn.setRequestProperty("Authorization", "Basic " + Base64.encodeToString(sign.getBytes(), Base64.NO_WRAP).replace("\n", ""));
            conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(2000);


            int responseCode = conn.getResponseCode();

            Log.i("getAdressByZipCode", "Codigo de retorno de requisição de cep: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                login = LoginService.getLogin(conn);
                conn.disconnect();
            }

        }catch (Exception e){
            Log.e(LoginAuthenticationService.class.getName(), e.getMessage());
        }
        return login;
    }


}
