package PBO.Polimorfisme.Bankers;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class RekeningBank {
    protected String noRekening;
    protected double saldo;
    protected String kartuId;

    public RekeningBank(String noRekening, double saldo, String kartuId) {
        this.noRekening = noRekening;
        this.saldo = saldo;
        this.kartuId = kartuId;
    }

    // private DecimalFormat rupiah;
    // public void kurensi() {
    // rupiah = new DecimalFormat("Rp #,##0.00");

    // }

    public void infoRekening() {
        DecimalFormat rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols Rp = new DecimalFormatSymbols();

        Rp.setCurrencySymbol("Rp ");
        Rp.setMonetaryDecimalSeparator(',');
        Rp.setGroupingSeparator('.');

        rupiah.setDecimalFormatSymbols(Rp);

        System.out.println("Nomor Rekening : " + noRekening);
        System.out.println("Total Saldo : " + rupiah.format(saldo));
        System.out.println("Kartu Identitas: " + kartuId);
    }

    public void transfer(double jumlah, RekeningBank rekeningTujuan) {
        DecimalFormat rupiah = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols Rp = new DecimalFormatSymbols();

        Rp.setCurrencySymbol("Rp ");
        Rp.setMonetaryDecimalSeparator(',');
        Rp.setGroupingSeparator('.');

        rupiah.setDecimalFormatSymbols(Rp);

        if (saldo >= jumlah) {
            saldo -= jumlah;
            rekeningTujuan.saldo += jumlah;
            System.out.println("\nTransfer berhasil dari rekening " + noRekening + " ke rekening "
                    + rekeningTujuan.noRekening + " sejumlah " + rupiah.format(jumlah));
        } else {
            System.out.println("\nSaldo tidak mencukupi.");
        }
    }
}

class RekeningPerorangan extends RekeningBank {
    private String namaNasabah;

    public RekeningPerorangan(String noRekening, String namaNasabah, double saldo, String kartuId) {
        super(noRekening, saldo, kartuId);
        this.namaNasabah = namaNasabah;
    }

    @Override
    public void infoRekening() {
        super.infoRekening();
        System.out.println("Jenis Rekening : Perorangan");
        System.out.println("Nama Nasabah : " + namaNasabah);
    }
}

class RekeningKorporat extends RekeningBank {
    private String namaPerusahaan;
    private String noIzinUsaha;
    private String namaPerwakilan;

    public RekeningKorporat(String noRekening, double saldo, String kartuId, String namaPerusahaan, String noIzinUsaha,
            String namaPerwakilan) {
        super(noRekening, saldo, kartuId);
        this.namaPerusahaan = namaPerusahaan;
        this.noIzinUsaha = noIzinUsaha;
        this.namaPerwakilan = namaPerwakilan;
    }

    @Override
    public void infoRekening() {
        super.infoRekening();
        System.out.println("Jenis Rekening : Korporat");
        System.out.println("Nama Perusahaan : " + namaPerusahaan);
        System.out.println("Nomor Izin Usaha : " + noIzinUsaha);
        System.out.println("Nama Perwakilan : " + namaPerwakilan);
    }
}

class Bank {
    private ArrayList<RekeningBank> rekeningList = new ArrayList<>();

    public void buatRekening(String jenis, String noRekening, double saldo, String kartuId, String namaNasabah,
            String namaPerusahaan, String noIzinUsaha, String namaPerwakilan) {
        if (jenis.equalsIgnoreCase("perorangan")) {
            rekeningList.add(new RekeningPerorangan(noRekening, namaNasabah, saldo, kartuId));
        } else if (jenis.equalsIgnoreCase("korporat")) {
            rekeningList
                    .add(new RekeningKorporat(noRekening, saldo, kartuId, namaPerusahaan, noIzinUsaha, namaPerwakilan));
        } else {
            System.out.println("\n==========================");
            System.out.println("\nJenis rekening tidak valid");
        }
    }

    public void transferSaldo(String noRekeningAsal, double jumlah, String... noRekeningTujuan) {
        if (noRekeningTujuan.length > 3) {
            System.out.println("\nHanya dapat mentransfer ke maksimal 3 rekening tujuan.");
            return;
        }

        RekeningBank rekeningAsal = cariRekening(noRekeningAsal);
        if (rekeningAsal != null) {
            if (rekeningAsal.saldo >= jumlah) {
                int jumlahRekTujuanValid = 0;
                for (String noRekTujuan : noRekeningTujuan) {
                    RekeningBank rekeningTujuan = cariRekening(noRekTujuan);
                    if (rekeningTujuan != null) {
                        jumlahRekTujuanValid++;
                    } else {
                        System.out.println("\nRekening tujuan dengan nomor " + noRekTujuan + " tidak ditemukan.");
                    }
                }

                if (jumlahRekTujuanValid > 0) {
                    for (String noRekTujuan : noRekeningTujuan) {
                        RekeningBank rekeningTujuan = cariRekening(noRekTujuan);
                        if (rekeningTujuan != null) {
                            rekeningAsal.transfer(jumlah, rekeningTujuan);
                        }
                    }
                } else {
                    System.out.println("\nTidak ada rekening tujuan yang valid untuk transfer.");
                }
            } else {
                System.out.println("\nSaldo tidak mencukupi untuk transfer.");
            }
        } else {
            System.out.println("\nRekening asal dengan nomor " + noRekeningAsal + " tidak ditemukan.");
        }
    }

    private RekeningBank cariRekening(String noRekening) {
        for (RekeningBank rekening : rekeningList) {
            if (rekening.noRekening.equals(noRekening)) {
                return rekening;
            }
        }
        return null;
    }

    public void infoRekening() {
        System.out.println("\n==========================");
        System.out.println("\nInformasi Rekening:");
        System.out.println();
        for (RekeningBank rekening : rekeningList) {
            rekening.infoRekening();
            System.out.println("\n==========================");
        }
    }
}

class jalanin {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.buatRekening("perorangan", "3445 6786 9897", 4000000, "1921680001", "riski", null, null, null);
        bank.buatRekening("korporat", "3445 8945 7645", 10000000, "1921680002", null, "PT pt an", "0956471113",
                "Agusan");
        bank.buatRekening("korporat", "3445 3698 0912", 12000000, "1921680003", null, "PT Pall", "0956471124",
                "Febian");
        bank.buatRekening("perorangan", "3445 1487 8524", 3000000, "1921680004", "yanti", null, null, null);
        bank.buatRekening("perorangan", "3445 7425 6913", 2000000, "1921680005", "yanto", null, null, null);
        bank.infoRekening();

        bank.transferSaldo("3445 6786 9897", 1000000, "3445 8945 7645", "3445 3698 0912", "3445 1487 8524",
                "3445 7425 6913", "1921680005");

        bank.transferSaldo("3445 6786 9897", 1000000, "3445 8945 7645", "3445 3698 0912", "1921680005");
        bank.infoRekening();

        bank.transferSaldo("3445 6786 9897", 3000000, "3445 8945 7645");
        bank.infoRekening();
    }
}
