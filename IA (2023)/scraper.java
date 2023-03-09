import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;
import java.util.LinkedHashMap;

public class Scraper {

    public String findStock(String stockName) throws IOException {
        Document doc = Jsoup
                .connect("https://finance.yahoo.com/quote/" + stockName + "?p=" + stockName + "&.tsrc=fin-srch").get();

        // Gets the last fin-streamer element which contains the price of the selected
        Element price = doc.select("fin-streamer[data-field=regularMarketPrice]").last();

        // Gets the last fin-streamer element which contains the price of the selected
        Element title = doc.select("h1[class=D(ib) Fz(18px)]").first();

        // String scrapedPrice = log("Price: %s", price.text());
        // String scrapedTitle = log("Title: %s", title.text());

        String scrapedPrice = price.text();
        String scrapedTitle = title.text();

        return "Current price of " + scrapedTitle + " is " + scrapedPrice;

    }

    public Map<String, Double> createHashMap(String stockName) {
        LinkedHashMap<String, Double> data = new LinkedHashMap<String, Double>();

        try {
            Document doc = Jsoup.connect("https://finance.yahoo.com/quote/" + stockName + "/history?p=" + stockName)
                    .get();

            Elements rows = doc.select("table tbody tr");
            for (Element row : rows) {
                String date = row.select("td:nth-child(1) span").text();
                String closePrice = row.select("td:nth-child(5) span").text();

                double closePriceDouble = Double.parseDouble(closePrice);

                data.put(date, closePriceDouble);
            }

            DrawGraph draw = new DrawGraph(data);
            draw.graph(data);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return data;

    }

    // private static String log(String msg, String... vals) {
    // //formats the string with the given values
    // return String.format(msg, vals);
    // }
}