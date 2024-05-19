class Telor {
    private Telor telor;
    private String jenis, bawang;
    private Integer garam, gula;

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public Integer getGaram() {
        return garam;
    }

    public void setGaram(Integer garam) {
        this.garam = garam;
    }

    public Integer getGula() {
        return  gula;
    }

    public void setGula(Integer gula) {
        this.gula = gula;
    }

    public String getBawang(){
        return bawang;
    }

    public void setBawang(String bawang) {
        this.bawang = bawang;
    }

    public String formatTaburan() {
        return garam + " taburan jari";
    }
}

class MasakTelor {
    private Telor telor;

    public MasakTelor() {
        this.telor = new Telor();
    }

    public void jenis(String jenis) {
        telor.setJenis(jenis);
    }

    public void garam(Integer garam) {
        telor.setGaram(garam);
    }

    public void gula(Integer gula) {
        telor.setGula(gula);
    }

    public void bawang(String bawang) {
        telor.setBawang(bawang);
    }

    public Telor hasilMasak() {
        return telor;
    }

    public void masakYangLain() {
        telor = new Telor();
    }
}

class MasakTelorByRachel {
    public static void main(String[] args) {
        MasakTelor masak = new MasakTelor();

        masak.jenis("Digoreng");
        masak.garam(1);
        masak.gula(1);
        masak.bawang("Bombai");

        Telor telorDadar = masak.hasilMasak();

        System.out.println("Masak Telor Dadar:");
        System.out.println("Jenis: " + telorDadar.getJenis());
        System.out.println("Garam: " + telorDadar.getGaram() + " taburan jari");
        System.out.println("Gula: " + telorDadar.formatTaburan());
        System.out.println("Bawang: " + telorDadar.getBawang());

        masak.masakYangLain();

        masak.jenis("Direbus");
        masak.garam(1);
        
        Telor telorRebus = masak.hasilMasak();

        System.out.println("\nMasal Telor Rebus:");
        System.out.println("Jenis: " + telorRebus.getJenis());
        System.out.println("Garam: " + telorRebus.formatTaburan());
    }
}

