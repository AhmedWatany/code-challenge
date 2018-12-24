package TajawalTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import org.openqa.selenium.WebElement;

public class CSV {

    public void writeIntoCSVFile(List<WebElement> priceList) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("PriceList.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("Price List");
        sb.append('\n');
        for (int i = 0; i < priceList.size(); i++) {
            //the additional "\"" to write the price as it is and not use the comma in the price to be a delimiter 
            sb.append("\"" + priceList.get(i).getText() + "\"");
            sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
    }
}
