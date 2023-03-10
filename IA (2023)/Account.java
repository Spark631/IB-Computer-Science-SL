import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.Scanner;

public class Account {
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

            StreamResult result = new StreamResult(new File("account.xml"));
            transformer.transform(source, result);

            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error" + e);
        }
    }

    public String readUser() {
        try {
            File inputFile = new File("account.xml");
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
            File inputFile = new File("account.xml");
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
            File inputFile = new File("account.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);
            double balance = Double.parseDouble(user.getElementsByTagName("wallet").item(0).getTextContent());
            balance =  Math.round((balance - money) * 100.00)/ 100.00;
            System.out.println("BALANCEEEEEE: " + balance);
            user.getElementsByTagName("wallet").item(0).setTextContent(Double.toString(balance));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("account.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public void addStock(Stock stockInfo) {
        try {
            File inputFile = new File("account.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList userList = doc.getElementsByTagName("user");
            Element user = (Element) userList.item(0);

            Element stock = doc.createElement("stock");
            user.appendChild(stock);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(stockInfo.getName()));
            stock.appendChild(name);

            Element ticker = doc.createElement("ticker");
            ticker.appendChild(doc.createTextNode(stockInfo.getTicker()));
            ticker.appendChild(ticker);

            Element amountOfShares = doc.createElement("amountOfShares");
            amountOfShares.appendChild(doc.createTextNode(Integer.toString(stockInfo.getAmountOfShares())));
            stock.appendChild(amountOfShares);

            // Element stockPrice = doc.createElement("stockPrice");
            // stockPrice.appendChild(doc.createTextNode(Double.toString(stockInfo.getStockPrice())));
            // stock.appendChild(stockPrice);

            // Element stockQuantity = doc.createElement("stockQuantity");
            // stockQuantity.appendChild(doc.createTextNode(Integer.toString(stockInfo.getStockQuantity())));
            // stock.appendChild(stockQuantity);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("account.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
