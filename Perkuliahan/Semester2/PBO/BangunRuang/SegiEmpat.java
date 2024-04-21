package PBO.BangunRuang;

class SegiEmpat {
    // Atribut panjang dan lebar
    protected double panjang, lebar;

    // Konstruktor default SegiEmpat
    public SegiEmpat() {
        panjang = 0;
        lebar = 0;
    }

    // Metode untuk mengatur nilai panjang
    public void setPanjang(double p) {
        panjang = p;
    }

    // Metode untuk mengatur nilai lebar
    public void setLebar(double l) {
        lebar = l;
    }

    // Metode untuk menghitung luas segi empat
    public double luas() {
        return (panjang * lebar);
    }
}

class Balok extends SegiEmpat {
    // Atribut tambahan tinggi
    protected double tinggi;

    // Konstruktor default Balok
    public Balok() {
        super(); // Memanggil konstruktor dari superclass SegiEmpat
        tinggi = 0;
    }

    // Metode untuk mengatur nilai tinggi
    public void setTinggi(double t) {
        tinggi = t;
    }

    // Metode untuk menghitung volume balok
    public double volume() {
        return (panjang * lebar * tinggi); // Menggunakan atribut dari superclass SegiEmpat
    }
}

class Kubus extends SegiEmpat {
    // Konstruktor kubus
    public Kubus(double sisi) {
        // Memanggil konstruktor superclass SegiEmpat dan mengatur nilai panjang dan
        // lebar
        super();
        setPanjang(sisi);
        setLebar(sisi);
    }

    // Metode untuk mengatur nilai tinggi (sama dengan panjang sisi pada kubus)
    public void setTinggi(double sisi) {
        setPanjang(sisi);
        setLebar(sisi);
    }

    // Mengoverride metode volume untuk menghitung volume kubus
    @Override
    public double luas() {
        // Menggunakan atribut panjang (yang sudah diatur sebagai sisi) untuk menghitung
        // luas kubus
        return 6 * panjang * panjang;
    }
}
