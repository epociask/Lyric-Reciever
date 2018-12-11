import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.swing.text.Document;

public class WebReader {
   


    String get(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            System.out.println("BAD URL " + urlString + " error= " + e.getMessage());
            return null;
        }
        BufferedReader br = null;
        HttpURLConnection httpConn = null;
        try {
            URLConnection conn = url.openConnection();
            httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setReadTimeout(5000);  //5 seconds

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String readLine;
            while ((readLine = br.readLine()) != null) {
                //System.out.println(readLine);
                sb.append(readLine);
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Cannot establish connection to " + urlString + " error= " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Got Error reply on " + urlString + " error= " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    //do nothing here
                }
            }
            if (httpConn != null) {
                httpConn.disconnect();
            }
        }
    }
}
