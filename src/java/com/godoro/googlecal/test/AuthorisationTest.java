/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.googlecal.test;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

/**
 *
 * @author erolerten
 */
public class AuthorisationTest {

    public void setUp() throws IOException, GeneralSecurityException {
        HttpTransport httpTransport=GoogleNetHttpTransport.newTrustedTransport();
        JacksonFactory jsonFactory=JacksonFactory.getDefaultInstance();
        

        String clientId = "310094007194-mlp0aq7cqk7nauqhpomtu9ikuuicf5g6.apps.googleusercontent.com";
        String clientSecret = "tyPn3v610xkkY-dK_8GfPURu";

        String redirectUrl = "urn:ietf:wg:oauth:2.0:oob";
        String scope = "https://www.googleapis.com/auth/calendar";
        

        

    }

}
