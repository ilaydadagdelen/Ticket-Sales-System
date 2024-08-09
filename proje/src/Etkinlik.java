import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class Etkinlik {
    private String ad;
    private String tarih;
    private String konum;
    public Etkinlik (String ad, String tarih, String konum) {
        this.ad = ad;
        this.tarih = tarih;
        this.konum = konum;
    }
    //soyut metot sınıflar içerisinde özelleştirilir
    public abstract void etkinlikKurallari() throws IOException;

    public String getAd() {
        return ad;
    }
    public String getTarih() {
        return tarih;
    }
    public String getKonum() {
        return konum;
    }

    public void bilgileriGoster() {
        System.out.println("Ad: " + getAd());
        System.out.println("Tarih: " + getTarih());
        System.out.println("Konum: " + getKonum());
    }

    //etkinlik hakkındaki bilgileri yazdırır
    public void etkinlikHakkinda(int baslangicSatir, int bitisSatir) throws IOException{
        //parametre olarak etkinlik bilgilerinin bulunduğu satır aralığını alır
        String dosyaYolu = "etkinlikHakkinda.txt";

        try {
            String satir;
            int anlikSatirNumarasi = 0;
            File dosya = new File(dosyaYolu);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dosya));
            while ((satir = bufferedReader.readLine()) != null) {
                anlikSatirNumarasi++;
                if (anlikSatirNumarasi >= baslangicSatir && anlikSatirNumarasi <= bitisSatir) { //belirli satır aralığını yazdırır
                    System.out.println(satir);
                }
                if (anlikSatirNumarasi > bitisSatir) {
                    break;
                }
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
