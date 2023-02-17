import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        try {
            URL url = new URL(httpStatusChecker.getStatusImage(code));
            InputStream inputStream = url.openStream();
            OutputStream outputStream = new FileOutputStream("src/main/java/images");
            byte[] buffer = new byte[2048];

            int length = 0;

            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
