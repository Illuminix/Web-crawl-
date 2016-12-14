/**
 * Created by Andrew on 12/12/2016.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

public class Scrape {
    public Document getPage(String link) throws IOException {
        Document doc = null; //Will return null if exception occurs.
        try {
            doc = Jsoup.connect(link).get();//Opens web page and saves html to doc.
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
        //If fails it will return null
    }
    public Elements getLinks(Document doc){
        Elements href = doc.select("a[href]");//Grabs links with href in the tag.
        return href;
    }
    public Elements getMedia(Document doc){
        Elements href = doc.select("[src]");//Grabs source links to images and other media (elements with src tags).
        return href;
    }
    public Elements getImports(Document doc){
        Elements href = doc.select("link[href]");//Grabs links with import tags.
        return href;
    }
    public ArrayList cleanLinksHref(Elements links) {//Fixes partial links .
        ArrayList<String> lin = new ArrayList<String>();
        for (Element a : links) {
            String b = a.attr("abs:href");
            lin.add(b);
        }
        return lin;
    }
    public ArrayList cleanLinksSrc(ArrayList<Element> links) {//Fixes partial source links.
        ArrayList<String> lin = new ArrayList<String>();
        for (Element a : links) {
            String b = a.attr("abs:src");
            lin.add(b);
        }
        return lin;
    }


}
