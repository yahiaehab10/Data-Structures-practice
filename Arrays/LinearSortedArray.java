package Arrays;

public class LinearSortedArray {
    int nItems;
    int[] a;

    public void orderedInsert(int x) {
        if (nItems < a.length) {

            int insertionPos = 0;
            while (insertionPos < nItems && a[insertionPos] < x)
                insertionPos++;
            for (int k = nItems; k > insertionPos; k--)
                a[k] = a[k - 1];
            a[insertionPos] = x;
            nItems++;
        } else
            System.out.print("Array is Full!");
    }

    public int binarySearchIter(int x) {
        int low = 0;
        int high = nItems - 1;
        int pos;
        while (low < high) {
            pos = low + ((high - low) / 2);
            if (a[pos] == x)
                return pos;
            else {
                if (x > a[pos])
                    low = pos + 1;
                else
                    high = pos - 1;
            }
        }
        return -1;
    }

    public int binarySearchRec(int x) {
        return binarySearchRec(0, nItems - 1, x);
    }

    private int binarySearchRec(int i, int j, int x) {
        int pos = i + ((i + j) / 2);
        if (a[pos] == x)
            return pos;
        else if (a[pos] > x)
            return binarySearchRec(i, pos - 1, x);
        else if (a[pos] < x)
            return binarySearchRec(pos, j, x);
        return -1;
    }

    public void delete(int x) {
        int pos = this.binarySearchIter(x);
        if (pos == -1)
            System.out.println("Element not found!");
        else {
            // shift the rest of the elements by one position
            for (int i = pos; i < nItems - 1; i++)
                a[i] = a[i + 1];
            nItems--;
        }

    }

    public void displayArray(){
        for (int i = 0; i < nItems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
