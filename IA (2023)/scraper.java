// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;

// import java.io.IOException;


// public class scraper {
//     public static void main(String[] args) throws IOException {
//         // Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
//         Document doc = Jsoup.connect("https://finance.yahoo.com/quote/amzn?p=AAPL&.tsrc=fin-srch").get();
//         log(doc.title());

//         // print out the price of the stock on yahoo finance
//         Elements price = doc.select("span[data-reactid='32']");
//         log(price.text());
//         // its not working



//         Elements newsHeadlines = doc.select("#mp-itn b a");
//         for (Element headline : newsHeadlines) {
//             log("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
//         }
//     }

//     private static void log(String msg, String... vals) {
//         System.out.println(String.format(msg, vals));
//     }
// }

// // // TODO Auto-generated method stub
// // String url = "https://www.marketwatch.com/investing/stock/aapl";
// // Document doc = Jsoup.connect(url).get();
// // String title = doc.title();
// // System.out.println(title);
// // Elements price = doc.select("bg-quote");
// // System.out.println(price.text());