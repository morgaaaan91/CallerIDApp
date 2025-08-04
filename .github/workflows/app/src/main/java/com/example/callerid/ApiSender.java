package com.example.callerid;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiSender {
    public static void sendCallerInfo(String number) {
        try {
            URL url = new URL("http://YOUR_POS_SERVER/caller");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String json = "{\"caller\": \"" + number + "\", \"time\": \"" + System.currentTimeMillis() + "\"}";
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            conn.getResponseCode();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
