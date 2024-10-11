#include <iostream>

int main() {
    // Deklarasi variabel
    int num1, num2, sum;

    // Input angka dari pengguna
    std::cout << "Masukkan angka pertama: ";
    std::cin >> num1;

    std::cout << "Masukkan angka kedua: ";
    std::cin >> num2;

    // Penjumlahan dua angka
    sum = num1 + num2;

    // Output hasil penjumlahan
    std::cout << "Hasil penjumlahan: " << sum << std::endl;

    return 0;
}
