/**
 * Created by Andrew on 12/12/2016.
 */


import javax.imageio.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
public class Media extends Scrape {
    public Image getImage(URL url) {
        Image image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
        }
        return image;//Returns image bytes
    }
    public InputStream mp3In(URL url) {
        URLConnection connect = null;
        try {
            connect = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in_stream = null;
        try {
            in_stream = connect.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in_stream;
    }
    public void mp3Save(InputStream stream, File file) throws IOException {
        OutputStream outstream = null;
        try {
            outstream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[4096];
        int len;
        while ((len = stream.read(buffer)) > 0) {
            try {
                outstream.write(buffer, 0, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}