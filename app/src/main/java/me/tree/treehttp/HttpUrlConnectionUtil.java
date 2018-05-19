package me.tree.treehttp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUrlConnectionUtil {
    public static String get(String url)throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(15 * 3000);
        connection.setReadTimeout(15 * 3000);

        int status = connection.getResponseCode();
        if(status == HttpStatus.SC_OK){
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[2048];
            int len;
            while((len = is.read(buffer)) != -1){
                out.write(buffer, 0 , len);
            }
            is.close();
            out.flush();
            out.close();
            return new String(out.toByteArray());
        }
    }

    public static String post(String url, String contect) throws IOException{
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(15 * 3000);
        connection.setReadTimeout(15 * 3000);
        connection.setDoOutput(true);

        OutputStream os = connection.getOutputStream();
        os.write(contect.getBytes());

        

    }
}
