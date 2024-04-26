import java.util.Arrays;

public class ArraySort {
    int[] a;
    int method;
    int comparisons = 0, swaps = 0;
    public ArraySort(int[] a, int method) {
        this.a = a;
        this.method = method;
    }
    public ArraySort(int[] a) {
        this.a = a;
        method = 7;
    }

    public int[] sort() {
        switch (method) {
            case 1:
                linearInsertionSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                bubbleSort();
                break;
            case 4:
                shellSort();
                break;
            case 5:
                mergeSort();
                break;
            case 6:
                heapSort();
                break;
            case 7:
                quickSort();
                break;
        }
        System.out.println("Кількість порівнянь: " + comparisons);
        System.out.println("Кількість перестановок: " + swaps);
        return a;
    }

    public void linearInsertionSort() {
        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int j = i - 1;
            comparisons++;
            while (j >= 0 && a[j] > current) {
                a[j + 1] = a[j];
                j--;
                swaps++;
                comparisons++;
            }
            a[j + 1] = current;
            System.out.println("Проміжний результат після ітерації " + i + ": " + Arrays.toString(a));
        }
    }

    public void selectionSort() {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                comparisons++;
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
                swaps++;
            }
            System.out.println("Проміжний результат після ітерації " + (i + 1) + ": " + Arrays.toString(a));
        }
    }

    public void bubbleSort() {
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - i - 1; j++) {
                comparisons++;
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) {
                break;
            }
            System.out.println("Проміжний результат після ітерації " + (i + 1) + ": " + Arrays.toString(a));
        }
    }

    public void shellSort() {
        int n = a.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = a[i];
                int j = i;

                comparisons++;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j -= gap;
                    swaps++;
                    comparisons++;
                }
                a[j] = temp;
            }
            System.out.println("Проміжний результат після кроку зі зростанням кроку " + gap + ": " + Arrays.toString(a));
        }
    }

    public void mergeSort() {
        mergeSort(0, a.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(a, left, leftArray, 0, n1);
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = a[middle + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            comparisons++;
            if (leftArray[i] <= rightArray[j]) {
                a[k] = leftArray[i];
                i++;
            } else {
                a[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = leftArray[i];
            i++;
            k++;
            swaps++;
        }
        while (j < n2) {
            a[k] = rightArray[j];
            j++;
            k++;
            swaps++;
        }
        System.out.println("Проміжний результат після злиття: " + Arrays.toString(a));
    }

    public void heapSort() {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            swaps++;
            heapify(i, 0);
            System.out.println("Проміжний результат після ітерації " + (n - i) + ": " + Arrays.toString(a));
        }
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && a[left] > a[largest]) {
            largest = left;
        }
        if (right < n && a[right] > a[largest]) {
            largest = right;
        }
        comparisons += 2;
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            swaps++;
            heapify(n, largest);
        }
    }

    public void quickSort() {
        quickSort(0, a.length - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
            System.out.println(Arrays.toString(a));
        }
    }

    private int partition(int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (a[j] < pivot) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                swaps++;
            }
        }
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        swaps++;
        return i + 1;
    }
}
