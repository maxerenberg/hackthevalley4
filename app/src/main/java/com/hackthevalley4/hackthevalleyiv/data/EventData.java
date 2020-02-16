package com.hackthevalley4.hackthevalleyiv.data;


import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import  org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hackthevalley4.hackthevalleyiv.Model.Event;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EventData {
    private String eventTitle = "Title1";
    private String eventDate = "Date";
    private String eventDesciption = "Description";
    private String eventLocation = "Location";


//    public static void main(String[] args) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//
//        Event obj = mapper .readValue(new URL("https://hackthevalley4-268306.appspot.com"), Event.class);
//        System.out.println(obj);
//    }


}
