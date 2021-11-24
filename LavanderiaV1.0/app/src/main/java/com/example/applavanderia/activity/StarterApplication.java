package com.example.applavanderia.activity;


import android.app.Application;

import com.example.applavanderia.R;
import com.parse.Parse;
import com.parse.ParseACL;

public class StarterApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

// Habilite armazenamento local
        Parse.enableLocalDatastore(this);

        // Codigo de configuração do app
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
        


        //ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Opitionally enable public read access
        defaultACL.setPublicReadAccess(true);
        //ParseACL.setDefaultACL(defaultACL, true);

    }
}