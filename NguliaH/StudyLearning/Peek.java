package NguliaH.StudyLearning;

import java.util.Stack;

/**
 * Peek
 */
public class Peek {

    public static void main(String[] args) {
        Stack<String> stk = new Stack<>();

        //menambahkan elemen ke stack 
        stk.push("A");
        stk.push("B");
        stk.push("C");

        if (!stk.isEmpty()) {
            String topItem = stk.peek();
            System.out.println("inimenampilkan data yang dari peek atas : " + topItem);
        }
    }
}