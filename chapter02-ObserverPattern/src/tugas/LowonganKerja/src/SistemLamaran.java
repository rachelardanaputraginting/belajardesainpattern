public class SistemLamaran implements Observer {
    private String lowonganTerbaru;

    @Override
    public void updateLowongan(String lowonganTerbaru) {
        this.lowonganTerbaru = lowonganTerbaru;
        System.out.println("Sistem Lamaran menerima lowongan baru: " + lowonganTerbaru);
    }
}