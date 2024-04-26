import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab_8 {
    public static void main(String[] args) {
        sort();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть значення елементів першого масиву");
        String[] array = scanner.nextLine().split(" ");
        int [] first = new int[array.length];
        for (int i = 0; i < array.length; ++i)
            first[i] = Integer.parseInt(array[i]);
        System.out.println("Введіть значення елементів другого масиву");
        array = scanner.nextLine().split(" ");
        int[] second = new int[array.length];
        for (int i = 0; i < array.length; ++i)
            second[i] = Integer.parseInt(array[i]);
        int method;
        System.out.println("Оберіть алгоритм пошуку\n" +
                "1. Лінійний пошук.\n" +
                "2. Лінійний пошук з бар’єром.\n" +
                "3. Бінарний пошук.\n" +
                "4. Пошук Фібоначчі.\n" +
                "5. Пошук з перестановкою в початок.\n" +
                "6. Пошук с транспозицією");
        method = scanner.nextInt();
        ArraySearch search = new ArraySearch(second, method);
        int x;
        ArrayList<Integer> elementsRepeatMoreThanOnce = new ArrayList<>();
        for (int i = 0; i < first.length; ++i)
            if ((x = search.search(first[i])) != -1) {
                if (search.search(first[i], x + 1) != -1)
                    elementsRepeatMoreThanOnce.add(first[i]);
            }
        int[] elements = new int[elementsRepeatMoreThanOnce.size()];
        for (int i = 0; i < elements.length; ++i)
            elements[i] = elementsRepeatMoreThanOnce.get(i);
        System.out.println(Arrays.toString(elements));
        System.out.println("Оберіть алгоритм сортування\n" +
                "1. лінійної вставки (linear insert)\n" +
                "2. простого вибору (simple choice)\n" +
                "3. сортування обміном (бульбашкове сортування)\n" +
                "4. сортування Шелла\n" +
                "5. сортування злиттям\n" +
                "6. пірамідального сортування\n" +
                "7. сортування Хоара.");
        method = scanner.nextInt();
        ArraySort sort = new ArraySort(elements, method);
        elements = sort.sort();
        System.out.println(Arrays.toString(elements));
    }

    public static void sort() {
        int[] firstArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] secondArray = new int[] {5, 8, 1, 3, 9, 2, 7, 4, 6, 10};
        int[] thirdArray = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 1; i <= 7; ++i) {
            new ArraySort(firstArray.clone(), i).sort();
            new ArraySort(secondArray.clone(), i).sort();
            new ArraySort(thirdArray.clone(), i).sort();
        }
    }
}
