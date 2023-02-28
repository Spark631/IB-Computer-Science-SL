import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class scraper {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://finance.yahoo.com/quote/META?p=AAPL&.tsrc=fin-srch").get();
        log(doc.title());

        Element price = doc.select("fin-streamer[data-field=regularMarketPrice]").last();
        log("Price: %s", price.text());

    }

    private static void log(String msg, String... vals) {
        System.out.println(String.format(msg, vals));
    }
}