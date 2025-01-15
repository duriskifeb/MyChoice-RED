package NguliaH.StudyLearning;

import java.util.*;

public class Home {

    // Kelas User
    static class User {
        String username;
        String password;
        String role; // Role sebagai pembeli atau penjual

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }
    }

    // Kelas HomeStore untuk pengelolaan pengguna
    static class HomeStore {
        private final LinkedList<User> users = new LinkedList<>();
        private final LinkedList<User> admins = new LinkedList<>();
        private final LinkedList<User> buyers = new LinkedList<>();
        private final LinkedList<User> sellers = new LinkedList<>();

        public HomeStore() {
            // Tambahkan admin default
            User admin = new User("admin", "admin123", "admin");
            admins.add(admin);
            users.add(admin);
        }

        public boolean register(String username, String password, String role) {
            if (isUsernameTaken(username)) {
                System.out.println("Username sudah terdaftar. Silakan pilih username lain.");
                return false;
            }

            User newUser = new User(username, password, role);
            users.add(newUser);

            // Tambahkan pengguna berdasarkan role
            switch (role.toLowerCase()) {
                case "admin":
                    admins.add(newUser);
                    break;
                case "pembeli":
                    buyers.add(newUser);
                    break;
                case "penjual":
                    sellers.add(newUser);
                    break;
                default:
                    System.out.println("Role tidak valid.");
                    return false;
            }

            System.out.println("Registrasi berhasil! Anda sekarang akan diarahkan ke halaman login.");
            return true;
        }

        public String login(String username, String password) {
            for (User user : users) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    System.out.println("Login berhasil. Selamat datang, " + username + "! Role Anda: " + user.role);
                    return user.role;
                }
            }
            System.out.println("Login gagal. Username atau password salah.");
            return null;
        }

        private boolean isUsernameTaken(String username) {
            for (User user : users) {
                if (user.username.equals(username)) {
                    return true;
                }
            }
            return false;
        }

        public void displayUsersByRole(String role) {
            System.out.println("\nDaftar pengguna dengan role: " + role);
            List<User> targetList = switch (role.toLowerCase()) {
                case "admin" -> admins;
                case "pembeli" -> buyers;
                case "penjual" -> sellers;
                default -> null;
            };

            if (targetList == null) {
                System.out.println("Role tidak valid.");
                return;
            }

            for (User user : targetList) {
                System.out.println(user.username);
            }
        }
    }

    // Metode utama
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HomeStore authSystem = new HomeStore();

        while (true) {
            System.out.println("\n=== Login & Register ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (choice) {
                case 1 -> registerUser(scanner, authSystem);
                case 2 -> loginUser(scanner, authSystem);
                case 3 -> {
                    System.out.println("Keluar dari aplikasi. Sampai jumpa!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void registerUser(Scanner scanner, HomeStore authSystem) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        System.out.print("Masukkan role (admin/pembeli/penjual): ");
        String role = scanner.nextLine().toLowerCase();

        if (!List.of("admin", "pembeli", "penjual").contains(role)) {
            System.out.println("Role tidak valid. Harus 'admin', 'pembeli', atau 'penjual'.");
            return;
        }

        boolean isRegistered = authSystem.register(username, password, role);
        if (isRegistered) {
            loginUser(scanner, authSystem); // Langsung arahkan ke login
        }
    }

    private static void loginUser(Scanner scanner, HomeStore authSystem) {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();
        String role = authSystem.login(username, password);

        if (role != null) {
            navigateToHome(role, scanner);
        }
    }

    private static void navigateToHome(String role, Scanner scanner) {
        System.out.println("\n=== Halaman Home ===");
        switch (role) {
            case "admin" -> adminHome(scanner);
            case "pembeli" -> buyerHome(scanner);
            case "penjual" -> sellerHome(scanner);
            default -> System.out.println("Role tidak dikenal.");
        }
    }

    private static void adminHome(Scanner scanner) {
        while (true) {
            System.out.println("\n[Admin Menu]");
            System.out.println("1. Lihat laporan");
            System.out.println("2. Kelola pengguna");
            System.out.println("3. Logout");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Menampilkan laporan...");
                case 2 -> System.out.println("Mengelola pengguna...");
                case 3 -> {
                    System.out.println("Logout berhasil.");
                    return;
                }
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }

    private static void buyerHome(Scanner scanner) {
        while (true) {
            System.out.println("\n[Buyer Menu]");
            System.out.println("1. Lihat produk");
            System.out.println("2. Lihat keranjang");
            System.out.println("3. Logout");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Menampilkan produk...");
                case 2 -> System.out.println("Menampilkan keranjang...");
                case 3 -> {
                    System.out.println("Logout berhasil.");
                    return;
                }
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }

    private static void sellerHome(Scanner scanner) {
        while (true) {
            System.out.println("\n[Seller Menu]");
            System.out.println("1. Tambah produk");
            System.out.println("2. Lihat produk");
            System.out.println("3. Logout");
            System.out.print("Pilih opsi: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Menambahkan produk...");
                case 2 -> System.out.println("Menampilkan produk...");
                case 3 -> {
                    System.out.println("Logout berhasil.");
                    return;
                }
                default -> System.out.println("Opsi tidak valid.");
            }
        }
    }
}
