package PBO.Polimorfisme.Barang;

import java.util.ArrayList;

class Barang {
    private String kodeBarang;
    private String namaBarang;
    private int harga = 0;
    private int jumlah = 0;

    Barang(String kodeBarang, String namaBarang, int harga, int jumlah) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    Barang(String kodeBarang, String namaBarang, int harga) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
    }

    public String getKodeBarang() {
        return this.kodeBarang;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void infoBarang() {
        System.out.println("Kode 	: " + kodeBarang);
        System.out.println("Nama 	: " + namaBarang);
        System.out.println("Harga 	: " + harga);
        System.out.println("Jumlah  : " + jumlah);
    }
}

class Superstore {
    private ArrayList<Barang> listBarang = new ArrayList<>();

    // Metode untuk menambah barang
    public void tambahBarang(String kodeBarang, String namaBarang, int harga) {
        System.out.println("Menambahkan Daftar Barang Baru");
        listBarang.add(new Barang(kodeBarang, namaBarang, harga));
        listBarang.get(listBarang.size() - 1).infoBarang();
        System.out.println("Jumlah barang 0, lakukan penambahan stock sebelum melakukan penjualan");
        System.out.println();
    }

    public void tambahBarang(String kodeBarang, String namaBarang, int harga, int jumlah) {
        System.out.println("Menambahkan Daftar Barang Baru");
        listBarang.add(new Barang(kodeBarang, namaBarang, harga, jumlah));
        listBarang.get(listBarang.size() - 1).infoBarang();
        System.out.println();
    }

    // Metode untuk memperbarui harga barang
    public void updateBarang(String kodeBarang, int harga) {
        for (Barang barang : listBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                barang.setHarga(harga);
                System.out.println("Harga barang berhasil diupdate.");
                return;
            }
        }
        System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
    }

    // Metode untuk memperbarui harga dan jumlah barang
    public void updateBarang(String kodeBarang, int harga, int jumlah) {
        for (Barang barang : listBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                barang.setHarga(harga);
                barang.setJumlah(jumlah);
                System.out.println("Harga dan jumlah barang berhasil diupdate.");
                return;
            }
        }
        System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
    }

    // Metode untuk penjualan barang tanpa diskon
    public void jualBarang(String kodeBarang, int jumlah) {
        Barang barang = findBarangByKode(kodeBarang);
        if (barang != null) {
            if (barang.getJumlah() >= jumlah) {
                int totalHarga = barang.getHarga() * jumlah;
                System.out.println("Total harga penjualan: " + totalHarga);
                barang.setJumlah(barang.getJumlah() - jumlah);
                System.out.println("\nPenjualan berhasil. Stock barang tersisa: " + barang.getJumlah());
            } else {
                System.out.println("Jumlah barang yang dijual melebihi jumlah stock yang tersedia.");
            }
        } else {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
        }
    }

    // Metode untuk penjualan barang dengan diskon
    public void jualBarang(String kodeBarang, int jumlah, int diskon) {
        Barang barang = findBarangByKode(kodeBarang);
        if (barang != null) {
            if (barang.getJumlah() >= jumlah) {
                int totalHarga = (barang.getHarga() * jumlah) * (100 - diskon) / 100;
                System.out.println("Total harga penjualan setelah diskon: " + totalHarga);
                barang.setJumlah(barang.getJumlah() - jumlah);
                System.out.println("\nPenjualan berhasil. Stock barang tersisa: " + barang.getJumlah());
            } else {
                System.out.println("Jumlah barang yang dijual melebihi jumlah stock yang tersedia.");
            }
        } else {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
        }
    }

    // proses multi barang
    public void jualBarangMulti(ArrayList<String> daftarKodeBarang, ArrayList<Integer> daftarJumlah) {
        if (daftarKodeBarang.size() != daftarJumlah.size()) {
            System.out.println("Jumlah kode barang dan jumlah barang tidak sesuai.");
            return;
        }

        for (int i = 0; i < daftarKodeBarang.size(); i++) {
            String kodeBarang = daftarKodeBarang.get(i);
            int jumlah = daftarJumlah.get(i);
            jualBarang(kodeBarang, jumlah);
        }
    }

    // Metode untuk menampilkan semua barang
    public void infoStockAllBarang() {
        System.out.println("Daftar Barang");
        if (!listBarang.isEmpty()) {
            for (Barang barang : listBarang) {
                System.out.println("\tKode Barang : " + barang.getKodeBarang());
                System.out.println("\tNama Barang : " + barang.getNamaBarang());
                System.out.println("\tHarga       : " + barang.getHarga());
                System.out.println("\tJumlah      : " + barang.getJumlah());
                System.out.println();
            }
        } else {
            System.out.println("Belum ada barang dalam list data");
        }
    }

    // Metode untuk mencari barang berdasarkan kode
    private Barang findBarangByKode(String kodeBarang) {
        for (Barang barang : listBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }
}

class DriverSuperStore {
    public static void main(String[] args) {
        Superstore st = new Superstore();

        Util.cls();
        Util.Header1();
        System.out.println("\nMenambah Barang\n");
        st.tambahBarang("AO1000", "Susu Bendera", 50000);
        st.tambahBarang("BO1000", "Kertas HVS", 28000, 3);
        st.tambahBarang("CO1000", "Kacang Kedelai", 4700, 5);
        st.infoStockAllBarang();

        System.out.println("Update Barang\n");
        st.updateBarang("CO1000", 10000);
        st.updateBarang("AO1000", 0);
        st.infoStockAllBarang();

        System.out.println("Penjualan Barang");
        st.jualBarang("BO1000", 10);
        st.jualBarang("CO1000", 5, 10);

        // Methode ini untuk multi barang
        ArrayList<String> daftarKodeBarang = new ArrayList<>();
        ArrayList<Integer> daftarJumlah = new ArrayList<>();
        daftarKodeBarang.add("AO1000");
        daftarKodeBarang.add("BO1000");
        daftarKodeBarang.add("CO1000");
        daftarJumlah.add(2);
        daftarJumlah.add(3);
        daftarJumlah.add(1);
        st.jualBarangMulti(daftarKodeBarang, daftarJumlah);
    }
}