package com.mahuriventures.erp.desktop.manager.json.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mahuriventures.erp.desktop.manager.json.MarketPlaceJson;
import com.mahuriventures.erp.desktop.util.UIStaticConstants;
import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MarketPlaceJsonImpl  implements MarketPlaceJson{
    public JsonArray getMarketModules() throws Exception {
        URL url = new URL(UIStaticConstants.MARKET_MODULE_SERVER_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent","Mozila/5.0");
        int responseCode = con.getResponseCode();
        System.out.println("\n Sending GET requeset to url :"+UIStaticConstants.MARKET_MODULE_SERVER_URL);
        System.out.println("Response code :"+responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        String inputLine;
        StringBuffer response = new StringBuffer();
        while((inputLine = in.readLine()) !=null){
            response.append(inputLine);
        }

        in.close();


        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(response.toString());
        JsonArray jsonArray = jsonObject.getAsJsonArray("moduleList");

        System.out.println(jsonArray);
        return jsonArray;
    }
}
