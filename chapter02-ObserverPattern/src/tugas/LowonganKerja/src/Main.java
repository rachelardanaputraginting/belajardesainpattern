public class Main {
    public static void main(String[] args) {
        SistemLowongan sistemLowongan = new SistemLowongan();

        Observer sistemPerekrutan = new SistemPerekrutan();
        Observer portalKarir = new SistemPortalKarir();
        Observer sistemLamaran = new SistemLamaran();

        sistemLowongan.registerObserver(sistemPerekrutan);
        sistemLowongan.registerObserver(portalKarir);
        sistemLowongan.registerObserver(sistemLamaran);

        sistemLowongan.tambahLowonganBaru("Lowongan Programmer Java");
        sistemLowongan.tambahLowonganBaru("Lowongan Manajer Proyek");
    }
}