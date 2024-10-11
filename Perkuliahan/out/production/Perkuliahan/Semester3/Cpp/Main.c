#include <stdio.h>

// Fungsi untuk menghitung luas alas segitiga
float hitungLuasAlas(float alas, float tinggiSegitiga) {
    return 0.5 * alas * tinggiSegitiga;
}

// Fungsi untuk menghitung volume limas segitiga
float volumeLimasSegitiga(float luasAlas, float tinggiLimas) {
    return (1.0/3.0) * luasAlas * tinggiLimas;
}

// Fungsi untuk menghitung volume prisma segitiga
float volumePrismaSegitiga(float luasAlas, float tinggiPrisma) {
    return luasAlas * tinggiPrisma;
}

int main() {
    float alas, tinggiSegitiga, tinggiLimas, tinggiPrisma, luasAlas, volumeLimas, volumePrisma;

    // Input untuk alas dan tinggi segitiga
    printf("Masukkan panjang alas segitiga: ");
    scanf("%f", &alas);
    
    printf("Masukkan tinggi segitiga: ");
    scanf("%f", &tinggiSegitiga);

    // Menghitung luas alas segitiga
    luasAlas = hitungLuasAlas(alas, tinggiSegitiga);

    // Input tinggi limas dan prisma
    printf("Masukkan tinggi limas segitiga: ");
    scanf("%f", &tinggiLimas);
    
    printf("Masukkan tinggi prisma segitiga: ");
    scanf("%f", &tinggiPrisma);

    // Menghitung volume limas dan prisma
    volumeLimas = volumeLimasSegitiga(luasAlas, tinggiLimas);
    volumePrisma = volumePrismaSegitiga(luasAlas, tinggiPrisma);

    // Output hasil volume
    printf("Volume Limas Segitiga: %.2f\n", volumeLimas);
    printf("Volume Prisma Segitiga: %.2f\n", volumePrisma);

    return 0;
}
