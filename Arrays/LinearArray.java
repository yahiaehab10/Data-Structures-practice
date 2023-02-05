package Arrays;

public class LinearArray {
    private int arr[];
    private int nItems;

    void insertLast(int x) {
        arr[nItems - 1] = x;
    }

    void insertFirst(int x) {
        arr[0] = x;
    }

    int linearSearch(int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    void delete(int x){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x)
                arr[i] = -1;
        }
    }

    public static void main(String[] args) {

    }
}