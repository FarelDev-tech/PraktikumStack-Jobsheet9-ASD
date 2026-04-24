public class StackSurat08 {
    Surat08[] stack;
    int top;
    int size;

    public StackSurat08(int size) {
        this.size = size;
        stack = new Surat08[size];
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Surat08 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack Penuh! Tidak bisa menerima surat izin lagi.");
        }
    }

    public Surat08 pop() {
        if (!isEmpty()) {
            Surat08 surat = stack[top];
            top--;
            return surat;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat08 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack Kosong! Tidak ada surat yang masuk.");
            return null;
        }
    }

    public void cariSurat(String nama) {
        boolean ditemukan = false;
        if (!isEmpty()) {
            System.out.println("Hasil Pencarian Surat Atas Nama: " + nama);
            // Mencari dari tumpukan paling atas ke bawah
            for (int i = top; i >= 0; i--) {
                if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                    System.out.println("- Ditemukan pada tumpukan ke-" + (top - i + 1) + " (dari atas)");
                    System.out.println("  ID Surat: " + stack[i].idSurat);
                    System.out.println("  Kelas: " + stack[i].kelas);
                    System.out.println("  Jenis Izin: " + (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                    System.out.println("  Durasi: " + stack[i].durasi + " hari");
                    System.out.println("---------------------------------");
                    ditemukan = true;
                }
            }
            if (!ditemukan) {
                System.out.println("Surat atas nama " + nama + " tidak ditemukan dalam tumpukan.");
            }
        } else {
            System.out.println("Stack Kosong! Belum ada surat yang masuk.");
        }
    }
}