import java.awt.datatransfer.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        Date today = new Date(LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        //create first text and save it to the clipboard
        StringSelection myText = new StringSelection("Seller info requested, DL " + today.getDeadline());
        clipboard.setContents(myText, myText);

        //create second text and save it to the clipboard
        StringSelection myText1 = new StringSelection("some other text");
        clipboard.setContents(myText1, myText1);
    }
}
