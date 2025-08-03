package src.src;

public class MergeSort
{

    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    public int countInversions() {
        if (arr == null || arr.length == 0) return 0;
        return divide(0, arr.length - 1);
    }

    private int divide(int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            count += divide(left, mid);
            count += divide(mid + 1, right);
            count += mergeAndCount(left, mid, right);
        }

        return count;
    }

    private int mergeAndCount(int left, int mid, int right) {
        int[] leftArr = java.util.Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = java.util.Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left, inversions = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                inversions += (leftArr.length - i);
            }
        }

        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return inversions;
    }

    // Optional test
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 3, 5};
        MergeSort counter = new MergeSort(input);
        int result = counter.countInversions();
        System.out.println("Inversion Count: " + result);
    }
}

