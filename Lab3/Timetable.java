package Lab3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Timetable {
    public String NAZV;
    public int NUMR;
    public Date DATE;
    public LocalTime TIME;
    public Timetable(Scanner scanner) {
        System.out.println("Введіть назву пункту призначення");
        NAZV = scanner.nextLine();
        System.out.println("Введіть номер поїзда");
        NUMR = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введіть дату відправлення");
        String dateString = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            DATE = sdf.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Помилка");
            scanner.next();
            new Timetable(scanner);
        }
        System.out.println("Введіть час відправлення");
        String timeString = scanner.nextLine();
        try {
            TIME = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
        }
        catch (Exception e) {
            System.out.println("Помилка");
            scanner.next();
            new Timetable(scanner);
        }
    }

    public void print() {
        System.out.println(NAZV);
        System.out.println(NUMR);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(DATE));
        System.out.println(TIME);
        System.out.println();
    }
}
