public class Kisi {
    private String kullaniciAdi;
    private String kullaniciSoyIsim;
    private String kullaniciEMail;
    private String kullaniciSifre;
    private String kullaniciKrediKarti;
    Kisi(String kullaniciAdi, String kullaniciSoyIsim, String kullaniciEMail, String kullaniciSifre,String kullaniciKrediKarti){
        this.kullaniciAdi = kullaniciAdi;
        this.kullaniciSoyIsim = kullaniciSoyIsim;
        this.kullaniciEMail = kullaniciEMail;
        this.kullaniciSifre = kullaniciSifre;
        this.kullaniciKrediKarti = kullaniciKrediKarti;
    }
    Kisi(){}

    //bu method değişkenleri tek bir değişkende toplar
    @Override
    public String toString() {
        String info = "";
        info += getKullaniciAdi();
        info += ("\t");
        info += getKullaniciSoyIsim();
        info += "\t";
        info += getKullaniciEMail();
        info += "\t";
        info += getKullaniciSifre();
        info += "\t";
        info += getKrediKarti();

        return info;
    }



    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getKullaniciSoyIsim() {
        return kullaniciSoyIsim;
    }

    public void setKullaniciSoyIsim(String kullaniciSoyIsim) {
        this.kullaniciSoyIsim = kullaniciSoyIsim;
    }

    public String getKullaniciEMail() {
        return kullaniciEMail;
    }

    public void setKullaniciEMail(String kullaniciEMail) {
        this.kullaniciEMail = kullaniciEMail;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

    public String getKrediKarti() {
        return kullaniciKrediKarti;
    }

    public void setKrediKarti(String kullaniciKrediKarti) {
        this.kullaniciKrediKarti = kullaniciKrediKarti;
    }
}
