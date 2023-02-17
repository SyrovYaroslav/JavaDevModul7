import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        System.out.println("Enter HTTP status code");
        Pattern pattern = Pattern.compile("\\d{3}");
        String line = scanner.nextLine();
        if (pattern.matcher(line).find()) {
            try {
                URL url = new URL("https://http.cat/" + line);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
                    System.out.println("There is not image for HTTP status " + line);
                } else {
                    httpStatusImageDownloader.downloadStatusImage(Integer.parseInt(line.trim()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please enter valid number");
        }
        scanner.close();
    }
}
