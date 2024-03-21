package Lab3;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            System.out.println("Введіть кількість поїздів");
            N = scanner.nextInt();
            scanner.nextLine();
        } while (N <= 0);
        Timetable[] TRAIN = new Timetable[N];
        for (int i = 0; i < N; ++i)
            TRAIN[i] = new Timetable(scanner);
        sort(TRAIN);
        System.out.println("Введіть пункт призначення");
        String NAZV = scanner.nextLine();
        print(TRAIN, NAZV);
        scanner.close();
    }
    public static void sort(Timetable[] TRAIN) {
        for (int i = 1; i < TRAIN.length; ++i) {
            int j = i;
            while (j > 0 && (TRAIN[j].DATE.compareTo(TRAIN[j - 1].DATE) < 0 ||
                    (TRAIN[j].DATE.compareTo(TRAIN[j - 1].DATE) == 0 && TRAIN[j].TIME.compareTo(TRAIN[j - 1].TIME) < 0))) {
                Timetable temp = TRAIN[j];
                TRAIN[j] = TRAIN[j - 1];
                TRAIN[j - 1] = temp;
                --j;
            }
        }
        print(TRAIN);
    }

    public static void print(Timetable[] TRAIN) {
        for (Timetable train : TRAIN)
            train.print();
    }

    public static void print(Timetable[] TRAIN, String NAZV) {
        int COUNT = 0;
        for (Timetable train : TRAIN) {
            if (train.NAZV.equals(NAZV)) {
                ++COUNT;
                train.print();
            }
        }
        if (COUNT == 0)
            System.out.println("Нема потягів, що відправляються в " + NAZV);
    }
}
