package Random;

public class OverloadTes {
    private String name;
    private static int jumlahPlayer;

    OverloadTes(String name) {
        OverloadTes.jumlahPlayer++;
        this.name = name;
    }
    
    OverloadTes() {
        OverloadTes.jumlahPlayer++;
        this.name = "Player " + OverloadTes.jumlahPlayer;
    }

    void show() {
        System.out.println("Name : " + this.name);
    }
}
