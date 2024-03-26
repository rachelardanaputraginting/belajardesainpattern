//Tanpa Strategi Pattern
//public class TanpaStrategi {
//    private String metodePengiriman;
//
//    public TanpaStrategi(String metodePengiriman) {
//        this.metodePengiriman = metodePengiriman;
//    }
//
//    public void prosesPengiriman() {
//        if (metodePengiriman.equals("reguler")) {
//            kirimDenganPengirimanReguler();
//        } else if (metodePengiriman.equals("ekspres")) {
//            kirimDenganPengirimanEkspres();
//        } else if (metodePengiriman.equals("ambil_sendiri")) {
//            ambilSendiri();
//        } else {
//            System.out.println("Metode pengiriman tidak valid.");
//        }
//    }
//
//    private void kirimDenganPengirimanReguler() {
//        System.out.println("Barang dikirim dengan pengiriman reguler.");
//    }
//
//    private void kirimDenganPengirimanEkspres() {
//        System.out.println("Barang dikirim dengan pengiriman ekspres.");
//    }
//
//    private void ambilSendiri() {
//        System.out.println("Barang akan diambil langsung di toko.");
//    }

// public static void main(String[] args) {
//     Pesanan pesanan1 = new Pesanan("reguler");
//     pesanan1.prosesPengiriman();

//     Pesanan pesanan2 = new Pesanan("ekspres");
//     pesanan2.prosesPengiriman();

//     Pesanan pesanan3 = new Pesanan("ambil_sendiri");
//     pesanan3.prosesPengiriman();
// }

//}

// Menggunakan Strategi Pattern
interface MetodePengiriman {
    void kirim();
}

class PengirimanEkspres implements MetodePengiriman {
    @Override
    public void kirim() {
        System.out.println("Barang dikirim dengan pengiriman ekspres.");
    }
}

class PengirimanReguler implements MetodePengiriman {
    @Override
    public void kirim() {
        System.out.println("Barang dikirim dengan pengiriman reguler.");
    }
}

class AmbilSendiri implements MetodePengiriman {
    @Override
    public void kirim() {
        System.out.println("Barang akan diambil langsung di toko.");
    }
}

class Pesanan {
    private MetodePengiriman metodePengiriman;

    public Pesanan(MetodePengiriman metodePengiriman) {
        this.metodePengiriman = metodePengiriman;
    }

    public void aturMetodePengiriman(MetodePengiriman metodePengiriman) {
        this.metodePengiriman = metodePengiriman;
    }

    public void prosesPengiriman() {
        metodePengiriman.kirim();
    }
}

class Shipping {
    public static void main(String[] args) {
        Pesanan pesanan1 = new Pesanan(new PengirimanReguler());
        pesanan1.prosesPengiriman();

        Pesanan pesanan2 = new Pesanan(new PengirimanEkspres());
        pesanan2.prosesPengiriman();

        Pesanan pesanan3 = new Pesanan(new AmbilSendiri());
        pesanan3.prosesPengiriman();
    }
}


