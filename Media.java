/**
 * Created by Andrew on 12/12/2016.
 */
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Connection;

import javax.imageio.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

//get_page,
public class Media {
    public static void main(String[] args) {
        BufferedImage image = null;
        URL urt;
        Document seed = null;
        Elements a = null;
        HashSet<String> unique_links = new HashSet<>();
        ArrayList<String> cleaned_links = new ArrayList<>();
        ArrayList<String> cleaned_links1 = new ArrayList<>();
        try {
            seed = get_page("https://en.wikipedia.org/wiki/Constellation");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (seed != null) {
            a = get_a(seed);
            cleaned_links = clean_links(a);
            for (String ur : cleaned_links) {
                unique_links.add(ur);
            }
        } else {
            System.out.println("invalid URL");
        }
        if (cleaned_links != null) {
            do {
                for (String url : cleaned_links) {
                    try {
                        seed = get_page(url);
                    } catch (IOException e) {
                        seed = null;
                        e.printStackTrace();
                    }
                    if (seed != null) {
                        a = get_a(seed);
                        cleaned_links1 = clean_links(a);
                        for (String ur : cleaned_links1) {
                            unique_links.add(ur);
                        }
                    }
                }
                cleaned_links = new ArrayList<>(unique_links);
            } while (unique_links.size() <= 100000);
            for(String link: unique_links){
                
                //image = ImageIO.read(ur);
                //ImageIO.write(image, "jpg", new File("C:\\Users\\Andrew\\Pictures\\Constellations"));
            }
        }
        //System.out.println(unique_links);

    }
    public static Document get_page(String link) throws IOException {
        Document doc = null; //Will return null if exception occurs.
        try {
            doc = Jsoup.connect(link).get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
        //If fails it will return null
    }
    public static Elements get_a(Document doc){
        Elements href = doc.select("a[href]");
        return href;
    }
    public static Elements get_media(Document doc){
        Elements href = doc.select("[src]");
        return href;
    }
    public static Elements get_imports(Document doc){
        Elements href = doc.select("link[href]");
        return href;
    }
    public static ArrayList clean_links(Elements links) {
        ArrayList<String> lin = new ArrayList<String>();
        for (Element a : links) {
            String b = a.attr("abs:href");
            lin.add(b);
        }
        return lin;
    }

}
