package NguliaH.StudyLearning;

import java.util.Stack;

public class POSUndoStack {
    private Stack<String> itemStack;
    private Stack<String> undoStack;

    public POSUndoStack() {
        itemStack = new Stack<>();
        undoStack = new Stack<>();
    }

    // Add item to the stack
    public void addItem(String item) {
        itemStack.push(item);
        System.out.println("Added item: " + item);
    }

    // Undo last added item
    public void undo() {
        if (!itemStack.isEmpty()) {
            String lastItem = itemStack.pop();
            undoStack.push(lastItem);
            System.out.println("Undo: Removed item " + lastItem);
        } else {
            System.out.println("No items to undo.");
        }
    }

    // Redo last undo
    public void redo() {
        if (!undoStack.isEmpty()) {
            String lastUndo = undoStack.pop();
            itemStack.push(lastUndo);
            System.out.println("Redo: Added item " + lastUndo);
        } else {
            System.out.println("No actions to redo.");
        }
    }

    public void displayItems() {
        System.out.println("Current items in the cart: " + itemStack);
    }

    public static void main(String[] args) {
        POSUndoStack pos = new POSUndoStack();
        pos.addItem("Apple");
        pos.addItem("Banana");
        pos.displayItems();

        pos.undo();
        pos.displayItems();

        pos.redo();
        pos.displayItems();
    }
}
