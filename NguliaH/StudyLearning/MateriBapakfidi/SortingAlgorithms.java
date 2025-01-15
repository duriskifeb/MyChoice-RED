package NguliaH.StudyLearning.MateriBapakfidi;

import java.util.Stack;

public class SortingAlgorithms {

    public static void mergeSortIterative(int[] array) {
        int n = array.length;
        int[] temp = new int[n];
        for (int size = 1; size < n; size *= 2) {
            for (int left = 0; left < n - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(array, temp, left, mid, right);
            }
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        System.arraycopy(array, left, temp, left, right - left + 1);
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            array[k++] = temp[i++];
        }
    }

    public static void quickSortIterative(int[] array) {
        int n = array.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { 0, n - 1 });

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int low = range[0], high = range[1];
            if (low < high) {
                int pivotIndex = partition(array, low, high);
                stack.push(new int[] { low, pivotIndex - 1 });
                stack.push(new int[] { pivotIndex + 1, high });
            }
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = { 38, 27, 43, 3, 9, 82, 10 };

        long startTime = System.nanoTime();
        mergeSortIterative(array);
        long endTime = System.nanoTime();
        System.out.println("Sorted array using Merge Sort : ");
        printArray(array);
        System.out.println("Execution time: " + (endTime - startTime) + " ns" + "\n") ;

        // Reset the array for quick sort
        array = new int[] { 38, 27, 43, 3, 9, 82, 10 };

        // Measure and print execution time for quick sort
        startTime = System.nanoTime();
        quickSortIterative(array);
        endTime = System.nanoTime();
        System.out.println("Sorted array using Quick Sort : ");
        printArray(array);
        System.out.println("Execution time : " + (endTime - startTime) + " ns" + "\n");
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
