package PBO.Pegawai;


public class Pegawai {
    final int GAJI_POKOK = 1000000;
    final int TUNJANGAN_TRANSPORT_PER_HARI = 50000;
    final int TUNJANGAN_KESAHATAN_MANAJER = 1000000;
    final int TUNJANGAN_KESAHATAN_DIREKTUR = 2000000;
    final int TUNJANGAN_BENSIN_DIREKTUR = 500000;

    String nama;
    String status;
    int jumlahHariKerja;
    int tunjanganTransport;
    int tunjanganKesehatan;

    Pegawai(String nama, String status, int jumlahHariKerja) {
        this.nama = nama;
        this.status = status;
        this.jumlahHariKerja = jumlahHariKerja;
        this.tunjanganTransport = PerhitunganTransport();
        this.tunjanganKesehatan = PerhitunganKesehatan();
    }

    int PerhitunganTransport() {
        return TUNJANGAN_TRANSPORT_PER_HARI * jumlahHariKerja;
    }

    int PerhitunganKesehatan() {
        if (status.equalsIgnoreCase("Manajer")) {
            return TUNJANGAN_KESAHATAN_MANAJER;
        } else if (status.equalsIgnoreCase("Direktur")) {
            return TUNJANGAN_KESAHATAN_DIREKTUR;
        }
        return 0;
    }

    int calculateGajiPokok() {
        if (status.equalsIgnoreCase("Staf")) {
            return GAJI_POKOK;
        } else if (status.equalsIgnoreCase("Manajer")) {
            return GAJI_POKOK * 2;
        } else if (status.equalsIgnoreCase("Direktur")) {
            return GAJI_POKOK * 4;
        }
        return 0;
    }

    int hitungGaji() {
        int gajiPokok = calculateGajiPokok();
        return gajiPokok + tunjanganTransport + tunjanganKesehatan;
    }

    void printGaji() {
        System.out.println("\nNama: " + nama + "\nStatus : " + status + "\nGaji : " + hitungGaji());
    }
}

class Staf extends Pegawai {
    Staf(String nama, int jumlahHariKerja) {
        super(nama, "Staf", jumlahHariKerja);
    }
}

class Manajer extends Pegawai {
    Manajer(String nama, int jumlahHariKerja) {
        super(nama, "Manajer", jumlahHariKerja);
    }
}

class Direktur extends Pegawai {
    Direktur(String nama, int jumlahHariKerja) {
        super(nama, "Direktur", jumlahHariKerja);
    }
}

class Main {
    public static void main(String[] args) {
        Manajer manajer1 = new Manajer("Tono", 23);
        Manajer manajer2 = new Manajer("Joko", 23);
        Direktur direktur1 = new Direktur("Budi", 24);
        Staf staf1 = new Staf("Asep", 20);
        Staf staf2 = new Staf("Tini", 20);

        // Awal berjalanya program..
        System.out.println("=== Perhitungan Gaji Karyawan ===");

        // memanggil object pegawai
        manajer1.printGaji();
        manajer2.printGaji();
        direktur1.printGaji();
        staf1.printGaji();
        staf2.printGaji();
    }
}
