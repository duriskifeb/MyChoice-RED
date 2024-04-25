package PBO.Gojekin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Member {
    private String id;
    private String nama;
    private String telepon;
    private double saldo;

    public Member(String id, String nama, String telepon, double saldo) {
        this.id = id;
        this.nama = nama;
        this.telepon = telepon;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public double getSaldo() {
        return saldo;
    }

    public void topUpSaldo(double amount) {
        saldo += amount;
    }

    @Override
    public String toString() {
        return " Member id = " + id + "\n" + " nama = " + nama + "\n" + " saldo = " + saldo + "\n" + " telepon = "
                + telepon + "\n";
    }
}

class Driver extends Member {
    private String platNo;
    private String jenisKendaraan;

    public Driver(String id, String nama, String telepon, String platNo, String jenisKendaraan, double saldo) {
        super(id, nama, telepon, saldo);
        this.platNo = platNo;
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getPlatNo() {
        return platNo;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Driver : " + "\n" + " Plat nomer = " + platNo + "\n" + " jenisKendaraan = "
                + jenisKendaraan;
    }
}

class Customer extends Member {
    public Customer(String id, String nama, String telepon, double saldo) {
        super(id, nama, telepon, saldo);
    }
}

/// mulai program utama///

public class Gojek {
    private List<Member> members = new ArrayList<>();

    public void addDriver(String id, String nama, String telepon, String platNo, String jenisKendaraan, double saldo) {
        System.out.println();
        Driver driver = new Driver(id, nama, telepon, platNo, jenisKendaraan, saldo);
        members.add(driver);
        System.out.println(" Driver telah di tambahkan. \n" + driver + "\n");
    }

    public void addCustomer(String id, String nama, String telepon, double saldo) {
        System.out.println();
        Member customer = new Member(id, nama, telepon, saldo);
        members.add(customer);
        System.out.println(" Customer telah di tambahkan." + "\n" + customer + "\n");
    }

    public void topUpSaldo(String id, double amount) {
        System.out.println();
        Member member = findMemberById(id);
        if (member != null) {
            member.topUpSaldo(amount);
            System.out.println("Top Up Saldo\n" + member + "\n");
        } else {
            System.out.println("Top Up Saldo\nID: " + id + " tidak ditemukan");
        }
    }

    public void viewDriver(String id) {
        System.out.println();
        Member member = findMemberById(id);
        if (member instanceof Driver) {
            System.out.println("View Data Driver");
            System.out.println(member);
        } else if (member != null) {
            System.out.println("View Data Driver\nID: " + id + ". Bukan Driver");
        } else {
            System.out.println("View Data Driver\nID: " + id + " tidak ditemukan");
        }
    }

    public void viewCustomer(String id) {
        System.out.println();
        Member member = findMemberById(id);
        if (member instanceof Driver) {
            System.out.println("View Data Customer\nID: " + id + ". Bukan Customer");
        } else if (member != null) {
            System.out.println("View Data Customer");
            System.out.println(member);
        } else {
            System.out.println("View Data Customer\nID: " + id + " tidak ditemukan");
        }
    }

    private Member findMemberById(String id) {
        for (Member member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    // transaksi
    public void transaksi(String driverId, String customerId, double amount) {
        System.out.println();
        Driver driver = (Driver) findMemberById(driverId);
        Member customer = findMemberById(customerId);
        if (driver != null && customer != null) {
            System.out.println("Transaksi");
            System.out.println("Driver: " + driver);
            System.out.println("Customer: " + customer);
            if (driver.getSaldo() >= amount) {
                driver.topUpSaldo(-amount);
                customer.topUpSaldo(amount);
                System.out.println("Transaksi berhasil");
            } else {
                System.out.println("Saldo driver tidak mencukupi untuk transaksi");
            }
        } else {
            System.out.println("Transaksi gagal, ID tidak valid");
        }
    }

    public void showTopMembers(String type, int limit, boolean reverseOrder) {
        System.out.println();
        // Gunakan Comparator untuk mengurutkan berdasarkan saldo
        members.sort(Comparator.comparingDouble(Member::getSaldo));
        // Jika reverseOrder true, balik urutan
        if (reverseOrder) {
            Collections.reverse(members);
        }

        int count = 0;
        for (Member member : members) {
            if (count >= limit) {
                break;
            }
            // Filter tipe member sesuai dengan parameter type
            if ((type.equals("Driver") && member instanceof Driver) ||
                    (type.equals("Customer") && !(member instanceof Driver))) {
                System.out.println(member);
                count++;
            }
        }
    }
}

