import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code){
        String result = "";
        try {
            URL url = new URL("https://http.cat/" + code);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                result += "https://http.cat/" + code + ".jpg";
            }
            if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                throw new IOException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}


