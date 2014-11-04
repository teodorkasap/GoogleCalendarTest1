/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.googlecal.test;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import java.io.IOException;


/**
 *
 * @author erolerten
 */
public class AuthorisationTest {
    
    
    public void setUp() throws IOException{
        HttpTransport httpTransport=new NetHttpTransport();
        JacksonFactory jsonFactory=new JacksonFactory();
        
        
        
    }
    
}
