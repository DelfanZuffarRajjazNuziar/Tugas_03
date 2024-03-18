public class Kereta {
    private Ticket ticket;
    private int sisaTiket;
    private String namaKereta;

    // Default constructor
    public Kereta() {
        ticket = new Ticket();
        sisaTiket = 1000; // Batas tiket terjual untuk kereta komuter
        namaKereta = "komuter";
    }

    // Overload constructor
    public Kereta(String namaKereta, int jumlahTiket) {
        ticket = new Ticket();
        sisaTiket = jumlahTiket;
        this.namaKereta = namaKereta;
    }

    // Overload method tambahTiket untuk kereta komuter
    public void tambahTiket(String namaPenumpang) {
        if (sisaTiket > 0) {
            String[] newPenumpang = ticket.getNamaPenumpang();
            if (newPenumpang == null) {
                newPenumpang = new String[0];
            }
            newPenumpang = addElement(newPenumpang, namaPenumpang);
            ticket.setNamaPenumpang(newPenumpang);
            System.out.println("==================================================");
            System.out.println("Tiket berhasil dipesan");
            sisaTiket--;
        }

    }

    // Overload method tambahTiket untuk KAJJ (kereta api jarak jauh)
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        System.out.println("==================================================");
        String[] newPenumpang = ticket.getNamaPenumpang();
        if (newPenumpang == null) {
            newPenumpang = new String[0];
        }
        if ((sisaTiket) > 0){newPenumpang = addElement(newPenumpang, namaPenumpang);
        ticket.setNamaPenumpang(newPenumpang);

        String[] newAsal = ticket.getAsal();
        if (newAsal == null) {
            newAsal = new String[0];
        }
        newAsal = addElement(newAsal, asal);
        ticket.setAsal(newAsal);

        String[] newTujuan = ticket.getTujuan();
        if (newTujuan == null) {
            newTujuan = new String[0];
        }
        newTujuan = addElement(newTujuan, tujuan);
        ticket.setTujuan(newTujuan);

        sisaTiket--;
        if (sisaTiket < 30){
            System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + sisaTiket);
        } 
        else{
            System.out.println("Tiket berhasil dipesan");
        }
        } else{System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");}
    }

    public void tampilkanTiket() {
        System.out.println("==================================================");
        System.out.println("Daftar penumpang kereta api " + namaKereta + ":");
        System.out.println("----------------------------");
        String[] penumpang = ticket.getNamaPenumpang();
        String[] asal = ticket.getAsal();
        String[] tujuan = ticket.getTujuan();

        for (int i = 0; i < penumpang.length; i++) {
            System.out.println("Nama: " + penumpang[i]);
            if (asal != null && asal.length > i) {
                System.out.println("Asal: " + asal[i]);
            }
            if (tujuan != null && tujuan.length > i) {
                System.out.println("Tujuan: " + tujuan[i]);
                System.out.println("----------------------------");
            }
        }
    }

    private String[] addElement(String[] array, String element) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
}
