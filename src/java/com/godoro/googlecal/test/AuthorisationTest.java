/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.googlecal.test;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import java.io.IOException;

/**
 *
 * @author erolerten
 */
public class AuthorisationTest {

    public void setUp() throws IOException {
        HttpTransport httpTransport = new NetHttpTransport();
        JacksonFactory jsonFactory = new JacksonFactory();

        String clientId = "310094007194-mlp0aq7cqk7nauqhpomtu9ikuuicf5g6.apps.googleusercontent.com";
        String clientSecret = "310094007194-mlp0aq7cqk7nauqhpomtu9ikuuicf5g6@developer.gserviceaccount.com";

        String redirectUrl = "urn:ietf:wg:oauth:2.0:oob";
        String scope = "https://www.googleapis.com/auth/calendar";

        String authorizationUrl = new GoogleAuthorizationCodeRequestUrl(clientId, redirectUrl, scope)
                .build();

        System.out.println("Go to the following link in your browser:");
        System.out.println(authorizationUrl);

    }

}
