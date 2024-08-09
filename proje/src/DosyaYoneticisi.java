import java.io.*;

public class DosyaYoneticisi {

    File file = new File("kullaniciBilgileri.txt");

    //kullanici bilgilerini dosyaya kaydeden method
    public static void kullaniciBilgileriniYazdir(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("kullaniciBilgileri.txt"));
            //değişen, güncellenen verileri kisi.toString methodundan gelen veri ile dosyaya kaydeder
            for (Kisi kisi : KisiYonetimi.getKullaniciListesi()) {
                writer.write(kisi.toString());
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        //birden fazla kişi üye olduğu zaman eski üye olanlar dosyaya tekrar
        //yazılmaması için arraylisti temizler
        KisiYonetimi.getKullaniciListesi().clear();
    }
    //dosyadan kullaniciListesi arrayine verileri çeker
    public static void dosyadanGelenVeriyiArrayListeKaydet(){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("kullaniciBilgileri.txt"));

            String satir;
            while ((satir = reader.readLine()) != null){
                String[] veriler = satir.split("\\s+");
                //eğer kullanıcının ismi 2 kelimeden oluşuyorsa veriler[3]te e mail adresinden gelen @ sembolü bulunmalıdır
                //bulunuyorsa if bloğuna, bulunmuyorsa else bloğuna girer
                if(veriler[3].contains("@")){
                    String kullaniciAdi = veriler[0]+" "+veriler[1];
                    String kullaniciSoyIsim = veriler[2];
                    String kullaniciEMail = veriler[3];
                    String kullaniciSifre = veriler[4];
                    String kullaniciKrediKarti = veriler[5];

                    Kisi kisi = new Kisi(kullaniciAdi,kullaniciSoyIsim,kullaniciEMail,kullaniciSifre,kullaniciKrediKarti);
                    KisiYonetimi.getKullaniciListesi().add(kisi);
                }else {
                    String kullaniciAdi = veriler[0];
                    String kullaniciSoyIsim = veriler[1];
                    String kullaniciEMail = veriler[2];
                    String kullaniciSifre = veriler[3];
                    String kullaniciKrediKarti = veriler[4];

                    Kisi kisi = new Kisi(kullaniciAdi,kullaniciSoyIsim,kullaniciEMail,kullaniciSifre,kullaniciKrediKarti);
                    KisiYonetimi.getKullaniciListesi().add(kisi);
                }


            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }

}
