public class SistemPerekrutan implements Observer {
    private String lowonganTerbaru;

    @Override
    public void updateLowongan(String lowonganTerbaru) {
        this.lowonganTerbaru = lowonganTerbaru;
        System.out.println("Sistem Perekrutan menerima lowongan baru: " + lowonganTerbaru);
    }
}