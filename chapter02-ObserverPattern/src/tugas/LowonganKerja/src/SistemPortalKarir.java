public class SistemPortalKarir implements Observer {
    private String lowonganTerbaru;

    @Override
    public void updateLowongan(String lowonganTerbaru) {
        this.lowonganTerbaru = lowonganTerbaru;
        System.out.println("Portal Karir menerima lowongan baru: " + lowonganTerbaru);
    }
}