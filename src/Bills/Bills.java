package Bills;
import Controllers.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public interface Bills
{
    Controller controller = new Controller();


    Scanner scanner = new Scanner(System.in);

    LocalDateTime currentDateTime = LocalDateTime.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");

    String formattedDateTime = currentDateTime.format(formatter);
    int start_Rang = 200;
    int end_Range = 600;
    Random r = new Random();
    public void Pay_Bill(int position,char w);
}
