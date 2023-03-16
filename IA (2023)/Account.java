import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.transform.TransformerException;
import java.io.OutputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;

public class Account {
    private static final String ACCOUNT_FILE = "account.xml";

    public void createAccount() {
        try {
            Scanner infoInput = new Scanner(System.in);

            System.out.println("\nWhat is your first name?\n ");
            String firstName = infoInput.nextLine();

            // infoInput.close();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // root element
            Element rootElement = doc.createElement("Account");
            // rootElement.setAttribute("xml:space", "preserve");
            doc.appendChild(rootElement);

            // user element
            Element user = doc.createElement("user");
            rootElement.appendChild(user);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(firstName));
            user.appendChild(name);

            // Starting wallet
            Element wallet = doc.createElement("wallet");
            wallet.appendChild(doc.createTextNode("500.00"));
            user.appendChild(wallet);

            Element accountActivatedDate = doc.createElement("accountActivatedDate");
            accountActivatedDate.appendChild(doc.createTextNode(java.time.LocalDate.now().toString()));
            user.appendChild(accountActivatedDate);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(ACCOUNT_FILE));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public String getUser() {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            String name = user.getElementsByTagName("name").item(0).getTextContent();

            return name;
        } catch (Exception e) {
            System.out.println("user does not exist");
        }
        return null;
    }

    public double getWallet() {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            String wallet = user.getElementsByTagName("wallet").item(0).getTextContent();

            return Double.parseDouble(wallet);
        } catch (Exception e) {
            System.out.println("user does not exist");
        }
        return 0;
    }

    public LinkedList<Stock> getStock() {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList stockList = doc.getElementsByTagName("Stock");

            LinkedList<Stock> stockLists = new LinkedList<Stock>();

            for (int i = 0; i < stockList.getLength(); i++) {
                Element stocks = (Element) stockList.item(i);
                String name = stocks.getElementsByTagName("name").item(0).getTextContent();
                String ticker = stocks.getElementsByTagName("ticker").item(0).getTextContent();
                int amountOfShares = Integer
                        .parseInt(stocks.getElementsByTagName("amountOfShares").item(0).getTextContent());
                Double stockPrice = Double
                        .parseDouble(stocks.getElementsByTagName("stockPrice").item(0).getTextContent());
                Double net = Double.parseDouble(stocks.getElementsByTagName("net").item(0).getTextContent());
                Double total = Double.parseDouble(stocks.getElementsByTagName("total").item(0).getTextContent());
                Double totalGained = Double
                        .parseDouble(stocks.getElementsByTagName("totalGained").item(0).getTextContent());
                String sector = stocks.getElementsByTagName("sector").item(0).getTextContent();

                Stock stock = new Stock(name, ticker, amountOfShares, stockPrice, net, total, totalGained, sector);
                stockLists.add(stock);
            }
            return stockLists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkUser() {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            String name = user.getElementsByTagName("name").item(0).getTextContent();

            return name;
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("\033[1m" + "  _________________________________________  " + "\033[0m");
            System.out.println("\033[1m" + " /                                         \\" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[32mHello there Investor!" + "\033[0m" + "\033[1m"
                    + "                   |" + "\033[0m");
            System.out.println("\033[1m" + "|                                           |" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[33mLooks like you are new here.\033[0m" + "\033[1m"
                    + "            |" + "\033[0m");
            System.out.println("\033[1m" + "|                                           |" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[36mLet's get you started with a \033[0m" + "\033[1m"
                    + "           |" + "\033[0m");
            System.out.println("\033[1m" + "|   \033[36mnew account!\033[0m" + "\033[1m"
                    + "                            |" + "\033[0m");
            System.out.println("\033[1m" + " \\_________________________________________/ " + "\033[0m");
            createAccount();
        }
        return null;
    }

    public double checkBalance() {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            double balance = Double.parseDouble(user.getElementsByTagName("wallet").item(0).getTextContent());

            return balance;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return 0;
    }

    public void updateBalance(double money) {
        try {
            System.out.println("THIS IS THE LIKE OMG LIKE WORKING LIKE" + money);
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            double balance = Double.parseDouble(user.getElementsByTagName("wallet").item(0).getTextContent());
            balance = Math.round((balance + money) * 100.00) / 100.00;
            System.out.println("Your new balance should be: " + balance);
            System.out.println("this is your balance: " + user.getElementsByTagName("wallet").item(0).getTextContent()
                    + "This is your money: " + money);
            user.getElementsByTagName("wallet").item(0).setTextContent(Double.toString(balance));
            System.out.println("GHUDFGHJKDFGHJDFJKGJKFHDGJKHDFJKGDFG"
                    + user.getElementsByTagName("wallet").item(0).getTextContent());
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(ACCOUNT_FILE));
            transformer.transform(source, result);
            System.out.println(source);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public void addStock(Stock stockInfo) {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            // doc.getDocumentElement().normalize();

            Element user = (Element) doc.getElementsByTagName("user").item(0);
            user.setAttribute("xml:space", "preserve");

            // Get the existing <Account> element
            Element account = (Element) doc.getElementsByTagName("Account").item(0);

            // Create a new <Stock> element
            Element stock = doc.createElement("Stock");

            // Create child elements for the stock information
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(stockInfo.getName()));
            stock.appendChild(name);

            Element ticker = doc.createElement("ticker");
            ticker.appendChild(doc.createTextNode(stockInfo.getTicker()));
            stock.appendChild(ticker);

            Element amountOfShares = doc.createElement("amountOfShares");
            amountOfShares.appendChild(doc.createTextNode(Integer.toString(stockInfo.getAmountOfShares())));
            stock.appendChild(amountOfShares);

            Element stockPrice = doc.createElement("stockPrice");
            stockPrice.appendChild(doc.createTextNode(Double.toString(stockInfo.getPrice())));
            stock.appendChild(stockPrice);

            Element net = doc.createElement("net");
            net.appendChild(doc.createTextNode(Double.toString(stockInfo.getNet())));
            stock.appendChild(net);

            Element total = doc.createElement("total");
            total.appendChild(doc.createTextNode(Double.toString(stockInfo.getTotal())));
            stock.appendChild(total);

            Element totalSpent = doc.createElement("totalSpent");
            totalSpent.appendChild(doc.createTextNode(Double.toString(stockInfo.getTotalMoneySpent())));
            stock.appendChild(totalSpent);

            Element totalGained = doc.createElement("totalGained");
            totalGained.appendChild(doc.createTextNode(Double.toString(stockInfo.getTotalMoneyGained())));
            stock.appendChild(totalGained);

            Element sector = doc.createElement("sector");
            sector.appendChild(doc.createTextNode(stockInfo.getSector()));
            stock.appendChild(sector);

            // Append the new <Stock> element to the existing <Account> element
            account.appendChild(doc.createTextNode("\n"));
            account.appendChild(stock);

            // Set the indent and indent amount properties on the transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // Write the transformed document to the input file
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);
            // preserveElement(doc);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void sellStock(String stock, int shares) {
        try {
            File inputFile = new File(ACCOUNT_FILE);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            double total = 0;

            NodeList stockList = doc.getElementsByTagName("Stock");
            for (int i = 0; i < stockList.getLength(); i++) {
                Element stockElement = (Element) stockList.item(i);
                if (stockElement.getElementsByTagName("ticker").item(0).getTextContent().equals(stock.toUpperCase())) {
                    int amountOfShares = Integer
                            .parseInt(stockElement.getElementsByTagName("amountOfShares").item(0).getTextContent());
                    if (amountOfShares >= shares) {
                        amountOfShares -= shares;
                        stockElement.getElementsByTagName("amountOfShares").item(0)
                                .setTextContent(Integer.toString(amountOfShares));
                        System.out.println("You have sold " + shares + " shares of " + stock);

                        Scraper scraper = new Scraper();
                        double price = scraper.findStockPrice(stock);
                        total = price * shares;

                        System.out.println("You have gained " + price * shares + " dollars");
                        break;
                    } else {
                        System.out.println("You do not have enough shares to sell");
                    }
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(inputFile);
            transformer.transform(source, result);

            updateBalance(total);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // public static void preserveElement(Document doc) {
    // Nodelist stockNodes = doc.getElementsByTagName("Stock");
    // for (int i = 0; i < stockNodes.getLength(); i++) {
    // Element stock = (Element) stockNodes.item(i);
    // stock.setAttribute("xml:space", "preserve");
    // }
    // TransformerFactory transformerFactory = TransformerFactory.newInstance();
    // Transformer transformer = transformerFactory.newTransformer();
    // transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    // transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount",
    // "4");
    // DOMSource source = new DOMSource(doc);
    // StreamResult result = new StreamResult(new File("account.xml"));
    // transformer.transform(source, result);

    // }

    // private static void writeXml(Document doc,
    // OutputStream output)
    // throws TransformerException {

    // TransformerFactory transformerFactory = TransformerFactory.newInstance();
    // Transformer transformer = transformerFactory.newTransformer();

    // // pretty print
    // transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");

    // DOMSource source = new DOMSource(doc);
    // StreamResult result = new StreamResult(output);

    // transformer.transform(source, result);

    // }

}
