package baway.com.loadsss.util;

import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class NetUtil {


    public static String getDataFromServer(String url){

        HttpURLConnection connection = null;
        try {
            URL url1 = new URL(url);
            connection = (HttpURLConnection) url1.openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if(connection.getResponseCode() == connection.HTTP_OK){
                CharStreams.toString(new InputStreamReader(connection.getInputStream()));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
