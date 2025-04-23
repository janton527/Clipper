import java.awt.datatransfer.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner inputStream = null;
        Date today = new Date(LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String line;

        try {
            inputStream = new Scanner(new FileInputStream("clipboard.txt"));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        while (inputStream.hasNext()){
            line = inputStream.nextLine();
            if (line.contains("DL") || line.contains("UTL")){
                line += " " + today.getDeadline();
            }else if (line.contains("QQQ")){
                int index = line.indexOf("QQQ");
                line = line.substring(0,index) + today.getDeadline() + " " + line.substring(index+3);
            }
            StringSelection clip = new StringSelection(line);
            clipboard.setContents(clip, null);
            System.out.println("Adding to clipboard");
            Thread.sleep(500);
        }

        StringSelection clip = new StringSelection(today.getDeadline());
        clipboard.setContents(clip, null);
        System.out.println("DONE");
    }
}
