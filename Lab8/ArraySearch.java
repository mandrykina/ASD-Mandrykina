public class ArraySearch {
    int[] a;
    int method;
    public ArraySearch(int[] a, int method) {
        this.a = a;
        this.method = method;
    }

    public int linear(int x, int i) {
        for (int j = i; j < a.length; ++j) {
            if (a[j] == x)
                return j;
        }
        return -1;
    }

    public int linearWithBarrier(int x, int i) {
        int[] aCopy = new int[a.length + 1];
        System.arraycopy(a, 0, aCopy, 0, a.length);
        aCopy[a.length] = x;
        for (int j = i; j < aCopy.length; ++j)
            if (aCopy[j] == x && j != aCopy.length - 1)
                return j;
        return -1;
    }

    public int binary(int x) {
        ArraySort sorted = new ArraySort(a);
        a = sorted.sort();
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (a[m] == x)
                return m;
            if (a[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public int fibonacci(int x) {
        ArraySort sorted = new ArraySort(a);
        a = sorted.sort();
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = fib1 + fib2;
        while (fib3 < a.length) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
        }
        int offset = -1;
        while (fib3 > 1) {
            int i = Math.min(offset + fib1, a.length - 1);
            if (a[i] < x) {
                fib3 = fib2;
                fib2 = fib1;
                fib1 = fib3 - fib2;
                offset = i;
            }
            else if (a[i] > x) {
                fib3 = fib1;
                fib2 = fib2 - fib1;
                fib1 = fib3 - fib2;
            }
            else
                return i;
        }
        if (fib2 == 1 && a[a.length - 1] == x)
            return a.length - 1;
        return -1;
    }

    public int moveToStart(int x, int i) {
        for (int j = i; j < a.length; ++j) {
            if (a[j] == x) {
                for (int k = j; k > 0; --k)
                    a[k] = a[k - 1];
                a[0] = x;
                return j;
            }
        }
        return -1;
    }

    public int transposition(int x, int i) {
        for (int j = i; j < a.length; ++j) {
            if (a[j] == x) {
                if (j > 0) {
                    a[j] = a[j - 1];
                    a[--j] = x;
                }
                return j;
            }
        }
        return -1;
    }

    public int search(int x, int i) {
        switch (method) {
            case 1:
                return linear(x, i);
            case 2:
                return linearWithBarrier(x, i);
            case 3, 4:
                if (i > 1 && a[i - 2] == x)
                    return i - 2;
                if (i < a.length && a[i] == x)
                    return i;
                return -1;
            case 5:
                return moveToStart(x, i);
            case 6:
                return transposition(x, i);
        }
        return -1;
    }

    public int search(int x) {
        return switch (method) {
            case 1 -> linear(x, 0);
            case 2 -> linearWithBarrier(x, 0);
            case 3 -> binary(x);
            case 4 -> fibonacci(x);
            case 5 -> moveToStart(x, 0);
            case 6 -> transposition(x, 0);
            default -> -1;
        };
    }
}
