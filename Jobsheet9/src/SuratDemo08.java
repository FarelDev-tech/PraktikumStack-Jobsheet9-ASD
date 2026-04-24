import java.util.Scanner;

public class SuratDemo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Inisialisasi kapasitas stack, misalnya 5 surat
        StackSurat08 stackSurat = new StackSurat08(5); 
        int pilih = 0;

        do {
            System.out.println("=== Sistem Pengelolaan Surat Izin ===");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat (Berdasarkan Nama)");
            System.out.println("5. Keluar Program");
            System.out.print("Pilih menu (1-5): ");
            pilih = sc.nextInt();
            sc.nextLine(); // membersihkan buffer

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan ID Surat: ");
                    String id = sc.nextLine();
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Masukkan Jenis Izin (S/I): ");
                    char jenis = sc.nextLine().toUpperCase().charAt(0);
                    System.out.print("Masukkan Durasi (hari): ");
                    int durasi = sc.nextInt();
                    sc.nextLine(); // membersihkan buffer

                    Surat08 suratMasuk = new Surat08(id, nama, kelas, jenis, durasi);
                    stackSurat.push(suratMasuk);
                    System.out.println("Surat atas nama " + nama + " berhasil diterima ke dalam tumpukan!");
                    break;

                case 2: // Proses Surat Izin [cite: 345]
                    Surat08 diproses = stackSurat.pop();
                    if (diproses != null) {
                        System.out.println("Detail Surat Izin:");
                        System.out.println("ID Surat : " + diproses.idSurat);
                        System.out.println("Nama : " + diproses.namaMahasiswa);
                        System.out.println("Kelas : " + diproses.kelas);
                        System.out.println("Jenis Izin : " + (diproses.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                        System.out.println("Durasi : " + diproses.durasi + " hari");
                        System.out.println("Surat berhasil diproses");
                    }
                    break;

                case 3:
                    Surat08 teratas = stackSurat.peek();
                    if (teratas != null) {
                        System.out.println("Surat Izin Terakhir (Posisi Teratas):");
                        System.out.println("ID Surat: " + teratas.idSurat);
                        System.out.println("Nama: " + teratas.namaMahasiswa);
                        System.out.println("Kelas: " + teratas.kelas);
                        System.out.println("Jenis Izin: " + (teratas.jenisIzin == 'S' ? "Sakit" : "Izin Keperluan Lain"));
                        System.out.println("Durasi: " + teratas.durasi + " hari");
                    }
                    break;

                case 4: // Cari Surat 
                    System.out.print("Masukkan Nama Mahasiswa yang dicari: ");
                    String namaCari = sc.nextLine();
                    stackSurat.cariSurat(namaCari);
                    break;

                case 5:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih menu 1-5.");
            }
        } while (pilih != 5);
        
        sc.close();
    }
}