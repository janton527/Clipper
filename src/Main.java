import java.awt.datatransfer.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner inputStream = null;
        Date today = new Date();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String line;

        // Open the text file that contains what you would like to be in your clipboard
        try {
            inputStream = new Scanner(new FileInputStream("C:\\Users\\Jacob\\Desktop\\Clipper\\src\\clipboard.txt"));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        // Processes each line of the text file
        while (inputStream.hasNext()){
            line = inputStream.nextLine();

            // DL = Deadline, which will be followed by the date of the set deadline window (ie. + 4 days)
            if (line.contains("DL")){
                line += " " + today.getDeadline();

            // For inserting a deadline into the middle of a line
            }else if (line.contains("QQQ")){
                int index = line.indexOf("QQQ");
                line = line.substring(0,index) + today.getDeadline() + " " + line.substring(index+3);
            }

            //add the line to the clipboard and wait (adding too quickly causes lines to not be entered)
            StringSelection clip = new StringSelection(line);
            clipboard.setContents(clip, null);
            System.out.println("Adding to clipboard");
            Thread.sleep(300);
        }

        // Add today's deadline to the clipboard and beep to let the user know it's finished
        StringSelection clip = new StringSelection(today.getDeadline());
        clipboard.setContents(clip, null);
        System.out.println("DONE");
        Toolkit.getDefaultToolkit().beep();
    }
}
