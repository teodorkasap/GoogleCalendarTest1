/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.godoro.googlecal.test;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author erolerten
 */
public class AuthorisationTest {

    public static void main(String[] args) {
        try {
            setUp();

        } catch (IOException e) {
            System.out.println(e.getMessage());

        } catch (GeneralSecurityException g) {
            System.out.println(g.getMessage());
        }

    }

    public static void setUp() throws IOException, GeneralSecurityException {
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();

        String clientId = "615218358964-41ldsj2bgjukoooumb7p0ls452fsiag5.apps.googleusercontent.com";
        String clientSecret = "KytU04to3VYfpj1j-viGMIXf";

        String redirectUrl = "urn:ietf:wg:oauth:2.0:oob";
        String scope = "https://www.googleapis.com/auth/calendar";

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow(httpTransport, jsonFactory, clientId, clientSecret,
                Collections.singleton(scope));
        String authorizationUrl = flow.newAuthorizationUrl()
                .setRedirectUri(redirectUrl).build();

        System.out.println("Go to following link on your browser");
        System.out.println(authorizationUrl);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("what is the authorization code?");
        String code = in.readLine();

        GoogleTokenResponse reponse = flow.newTokenRequest(code)
                .setRedirectUri(redirectUrl).execute();

        Credential credential = new GoogleCredential.Builder()
                .setTransport(httpTransport).setJsonFactory(jsonFactory)
                .setClientSecrets(clientId, clientSecret).build()
                .setFromTokenResponse(reponse);

        Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credential)
                .setApplicationName(authorizationUrl)
                .setApplicationName("mySecondProject").build();

//        String pageToken = null;
//        
//        do {
//            Events events = service.events().list("primary").setPageToken(pageToken).execute();
//            
//                    
//                    
//            List<Event> items = events.getItems();
//            for (Event event : items) {
//                System.out.println(event.getSummary());
//            }
//            pageToken = events.getNextPageToken();
//        } while (pageToken != null);
        
        Event event=new Event();
        event.setSummary("appointment");
        event.setLocation("somewhere");

        
        ArrayList<EventAttendee> attendees = new ArrayList<EventAttendee>();
        attendees.add(new EventAttendee().setEmail("email@erolerten.com"));
        
        event.setAttendees(attendees);
        
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime()+3600);
        DateTime start = new DateTime(startDate, TimeZone.getTimeZone("UTC"));
        event.setStart(new EventDateTime().setDateTime(start));
        DateTime end= new DateTime(endDate, TimeZone.getTimeZone("UTC"));
        event.setEnd(new EventDateTime().setDateTime(end));
        
        Event createdEvent= service.events().insert("primary", event).execute();
        
        System.out.println(createdEvent.getId());

    }

}
