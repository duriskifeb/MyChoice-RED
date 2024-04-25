package Random;

public class Tes{
    public static void main(String[] args) {
        System.out.println("ayoo semangat");
        System.out.println("\n");
        //Overoading construktor :D

        OverloadTes p1 = new OverloadTes("komari");
        OverloadTes p2 = new OverloadTes();
        OverloadTes p3 = new OverloadTes();
        OverloadTes p4 = new OverloadTes("paimen");

        p1.show();
        p2.show();
        p3.show();
        p4.show();


    }
}