package NguliaH.Praktik4;

class Barang {
    private int id;
    private String nama;
    private int stok;

    public Barang(int id, String nama, int stok) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String info() {
        return id + " " + nama + " " + stok;
    }
}

class Node {
    Barang data;
    Node next;

    Node(Barang b) {
        data = b;
        next = null;
    }
}