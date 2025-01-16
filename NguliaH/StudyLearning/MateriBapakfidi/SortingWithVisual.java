package NguliaH.StudyLearning.MateriBapakfidi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SortingWithVisual {
    JFrame frame = new JFrame();
    JLabel sortingInfo = new JLabel();

    ArrayList<Integer> array = new ArrayList<>();
    Random random = new Random();
    int arraySize = 200;
    int barHeight;
    int frameX = 1020;
    int frameY = 550;

    public static void main(String[] args) throws InterruptedException {
        SortingWithVisual arr = new SortingWithVisual();
        arr.createFrame();

        arr.BubbleSortAsc();
        arr.BubbleSortDsc();
        arr.QuickSortAsc();
        arr.QuickSortDsc();
    }

    public void createFrame() {
        frame.setTitle("Sorting Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(frameX, frameY);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);

        // Label untuk keterangan sorting
        sortingInfo.setBounds(10, 10, frameX - 20, 30);
        sortingInfo.setForeground(Color.WHITE);
        sortingInfo.setHorizontalAlignment(JLabel.CENTER);
        sortingInfo.setOpaque(false);
        frame.add(sortingInfo);

        frame.setVisible(true);
    }

    public void generateBar() throws InterruptedException {
        Thread.sleep(5);
        frame.getContentPane().removeAll();
        frame.add(sortingInfo);

        for (int i = 0; i < array.size(); i++) {
            barHeight = array.get(i);

            JLabel label = new JLabel();
            label.setBounds(0 + (5 * i), frameY - barHeight - 45, 5, barHeight);
            label.setBackground(Color.WHITE);
            label.setOpaque(true);

            frame.add(label);
        }
        frame.repaint();
    }

    public void BubbleSortAsc() throws InterruptedException {
        setSortingInfo("Bubble Sort - Ascending");
        array.removeAll(array);
        generateArray();
        showArray();
        sortArrayBubbleAsc();
        showArray();
        System.out.println();
    }

    public void BubbleSortDsc() throws InterruptedException {
        setSortingInfo("Bubble Sort - Descending");
        array.removeAll(array);
        generateArray();
        showArray();
        sortArrayBubbleDsc();
        showArray();
        System.out.println();
    }

    public void QuickSortAsc() throws InterruptedException {
        setSortingInfo("Quick Sort - Ascending");
        array.removeAll(array);
        generateArray();
        showArray();
        sortArrayQuickAsc(0, array.size() - 1);
        generateBar();
        showArray();
        System.out.println();
    }

    public void QuickSortDsc() throws InterruptedException {
        setSortingInfo("Quick Sort - Descending");
        array.removeAll(array);
        generateArray();
        showArray();
        sortArrayQuickDsc(0, array.size() - 1);
        generateBar();
        showArray();
        System.out.println();
    }

    public void showArray() {
        System.out.print("Array : ");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    public void sortArrayBubbleAsc() throws InterruptedException {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - 1 - i; j++) {
                if (array.get(j) > array.get(j + 1)) { // Untuk ascending
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
            generateBar();
        }
    }

    public void sortArrayBubbleDsc() throws InterruptedException {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - 1 - i; j++) {
                if (array.get(j) < array.get(j + 1)) { // Untuk descending
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
            generateBar();
        }
    }

    public void sortArrayQuickAsc(int low, int high) throws InterruptedException {
        if (low < high) {
            int pivotIndex = partitionAsc(low, high);
            generateBar();
            sortArrayQuickAsc(low, pivotIndex - 1);
            sortArrayQuickAsc(pivotIndex + 1, high);
        }
    }

    private int partitionAsc(int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j) <= pivot) { // Untuk ascending
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        int temp = array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);
        return i + 1;
    }

    public void sortArrayQuickDsc(int low, int high) throws InterruptedException {
        if (low < high) {
            int pivotIndex = partitionDsc(low, high);
            generateBar();
            sortArrayQuickDsc(low, pivotIndex - 1);
            sortArrayQuickDsc(pivotIndex + 1, high);
        }
    }

    private int partitionDsc(int low, int high) {
        int pivot = array.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array.get(j) >= pivot) { // Untuk descending
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        int temp = array.get(i + 1);
        array.set(i + 1, array.get(high));
        array.set(high, temp);
        return i + 1;
    }

    public void generateArray() {
        for (int i = 1; i <= arraySize; i++) {
            array.add(random.nextInt(500));
        }
    }

    public void setSortingInfo(String info) {
        sortingInfo.setText(info);
    }
}
