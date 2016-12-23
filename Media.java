/**
 * Created by Andrew on 12/12/2016.
 */


import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
public class Media extends Scrape {
   public static void mp3Save(String url,String path) throws IOException {
        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();

        OutputStream outstream = new FileOutputStream(new File(path));
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) > 0) {
            outstream.write(buffer, 0, len);
        }
        outstream.close();
    }
}
