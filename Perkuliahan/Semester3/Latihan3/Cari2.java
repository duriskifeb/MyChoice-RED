package Perkuliahan.Semester3.Latihan3;

class Note {
    int data;
    Note next;

    // Construktor untuk note
    Note(int d) {
        data = d;
        next = null;
    }
}

public class Cari2 {
    Note kepala;

    // fungction mengurutkan data
    public void urutkanData(int data) {
        Note nn = new Note(data);
        Note current = kepala;

        if (kepala == null || kepala.data >= nn.data) {
            nn.next = kepala;
            kepala = nn;
        } else {
            while (current.next!= null && current.next.data < nn.data) {
                current = current.next;
            }
            nn.next = current.next;
            current.next = nn;
        }
        System.out.println("Note baru " + data + "Sudah di ");
    }
}
