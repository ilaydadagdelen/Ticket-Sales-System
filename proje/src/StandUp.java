import java.io.*;
import java.util.Scanner;

public class StandUp extends Etkinlik implements Bilet{
    private String biletFiyati;
    KisiYonetimi kisiYonetimi = new KisiYonetimi();

    Scanner scanner = new Scanner(System.in);
    public StandUp (String ad, String tarih, String konum) {
        super(ad, tarih, konum);
    }

    @Override
    public String getAd() {
        return super.getAd();
    }


    // etkinlik sınıfında tanımlanmış ve gövdesi yazılmış methodu super komutuyla overrride eder
    @Override
    public void bilgileriGoster() {
        super.bilgileriGoster();
    }

    // etkinlik sınıfında tanımlanmış ve gövdesi yazılmış methodu super komutuyla overrride eder
    @Override
    public void etkinlikHakkinda(int baslangicSatir, int bitisSatir) throws IOException {
        super.etkinlikHakkinda(baslangicSatir, bitisSatir);
    }

    // etkinlik sınıfında tanımlanmış abstract metotu özelleştirir
    @Override
    public void etkinlikKurallari() throws IOException {
        String dosyaYolu = "etkinlikKurallari.txt";

        try {
            File dosya = new File(dosyaYolu);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dosya));

            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                System.out.println(satir);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //kullanıcı bilet seçimini tamamladıktan sonra bilet satın alma işlemlerini gerçekleştirir
    @Override
    public void biletAl() {
        System.out.println("Bileti satın almak ister misiniz?");
        do {
            String secim = scanner.next();
            if (secim.equalsIgnoreCase("evet")) {
                System.out.println("Satın alım işlemleri başlatılıyor...");
                odemeYontemi();  // olumlu cevap alınırsa kredi kartı işlemlerini başlatır
                biletKaydet();  // satın alınan bileti daha sonradan görüntüleyebilmek için dosyaya kaydeder
                DosyaYoneticisi.kullaniciBilgileriniYazdir();
                DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
                break;
            } else if (secim.equalsIgnoreCase("hayır")) {
                System.out.println("Bir önceki sayfaya gitmek için 0'a basın");
                break;
            } else {
                System.out.println("Lütfen geçerli bir cevap girin!!");
            }
        } while (true);

    }


    // bilet satın alınmak istendiğinde ödeme işlemlerini başlatan method
    @Override
    public void odemeYontemi() {
        for (Kisi kisi : KisiYonetimi.getKullaniciListesi()) {
            //Emaile ait kart var mı kontrol eder
            if (kisi.getKullaniciEMail().equals(KisiYonetimi.geteMailTut())){
                if (kisi.getKrediKarti().equals("null")) {  // kredi kartı bilgileri yoksa
                    System.out.println("Mevcut kredi kartı bilginiz bulunmamaktadır.\s" +
                            "Satın alma işlemi için kredi kartı bilgisi eklemeniz gerekmektedir.");
                    kisiYonetimi.krediKartiEkle(); // yeni kredi kartı ekleme işlemi başlatılır
                    System.out.println("Kredi kartınız: " + kisi.getKrediKarti());
                    System.out.println("Bu kartınızla işleme devam etmek istediğinizden emin misiniz?\s" +
                            "Devam etmek istiyorsanız evet istemiyorsanız hayır yazınız.");
                    do {
                        String secim = scanner.next();
                        if (secim.equalsIgnoreCase("evet")) {
                            System.out.println("Satın alım işleminiz başarıyla tamamlanmıştır!");
                            System.out.println("Biletiniz: "); //bileti bastırır
                            System.out.println("___________________________");
                            System.out.println(getAd());
                            System.out.println(kisi.getKullaniciAdi() + " " + kisi.getKullaniciSoyIsim());
                            System.out.println();
                            System.out.println(getTarih());
                            System.out.println(getKonum());
                            System.out.println("____________________________\n");
                            System.out.println("(1) Ana Menü");
                            System.out.println("(0) Hesabımdan çıkış yap");
                            return;
                        } else if (secim.equalsIgnoreCase("hayır")) {
                            kisiYonetimi.krediKartiBilgileriSil(); // kullanıcıya ait kredi kartı bilgilerini siler
                            kisiYonetimi.krediKartiEkle(); // yeni kredi kartı ekleme işlemi başlatılır
                            System.out.println("Satın alım işleminiz başarıyla tamamlanmıştır!");
                            System.out.println("Biletiniz: ");
                            System.out.println("___________________________");
                            System.out.println(getAd());
                            System.out.println(kisi.getKullaniciAdi() + " " + kisi.getKullaniciSoyIsim());
                            System.out.println();
                            System.out.println(getTarih());
                            System.out.println(getKonum());
                            System.out.println("____________________________\n");
                            System.out.println("(1) Ana Menü");
                            System.out.println("(0) Hesabımdan çıkış yap");
                            return;
                        } else {
                            System.out.println("Lütfen geçerli bir cevap giriniz!");
                        }
                    } while (true);

                } else { // kayıtlı kart bilgileri varsa
                    System.out.println("Kayıtlı kredi kartınız mevcut !");
                    System.out.println("Kredi kartınız: " + kisi.getKrediKarti());
                    System.out.println("Bu kartınızla işleme devam etmek istediğinizden emin misiniz?\s" +
                            "Devam etmek istiyorsanız evet istemiyorsanız hayır yazınız.");
                    do {
                        String secim = scanner.next();
                        if (secim.equalsIgnoreCase("evet")) {
                            System.out.println("Satın alım işleminiz başarıyla tamamlanmıştır!");
                            System.out.println("Biletiniz: ");
                            System.out.println("___________________________");
                            System.out.println(getAd());
                            System.out.println(kisi.getKullaniciAdi() + " " + kisi.getKullaniciSoyIsim());
                            System.out.println();
                            System.out.println(getTarih());
                            System.out.println(getKonum());
                            System.out.println("____________________________\n");
                            System.out.println("(1) Ana Menü");
                            System.out.println("(0) Hesabımdan çıkış yap");
                            return;
                        } else if (secim.equalsIgnoreCase("hayır")) {  //başka kart kullanmak istiyorsa
                            kisiYonetimi.krediKartiBilgileriSil(); //önceki kart bilgileri silinir
                            kisiYonetimi.krediKartiEkle(); //yeni kart bilgileri eklenir
                            System.out.println("Satın alım işleminiz başarıyla tamamlanmıştır!");
                            System.out.println("Biletiniz: ");
                            System.out.println("___________________________");
                            System.out.println(getAd());
                            System.out.println(kisi.getKullaniciAdi() + " " + kisi.getKullaniciSoyIsim());
                            System.out.println();
                            System.out.println(getTarih());
                            System.out.println(getKonum());
                            System.out.println("____________________________\n");
                            System.out.println("(1) Ana Menü");
                            System.out.println("(0) Hesabımdan çıkış yap");
                            return;
                        } else {
                            System.out.println("Lütfen geçerli bir cevap giriniz!");
                        }
                    } while (true);
                }


            }
        }
    }

    //dosyadan bilet fiyatını çeken method
    @Override
    public void biletFiyati(int biletNumarasi, int baslangicSatir, int bitisSatir) {
        // parametre olarak seçilen bilet numarası ve dosyadaki etkinlik bilgilerinin başlangıç bitiş satırları alınır.
        String dosyaYolu = "etkinlikHakkinda.txt";
        try {
            String satir;
            int anlikSatirNumarasi = 0;
            File dosya = new File(dosyaYolu);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dosya));
            while ((satir = bufferedReader.readLine()) != null) {
                anlikSatirNumarasi++;
                if (anlikSatirNumarasi >= baslangicSatir && anlikSatirNumarasi <= bitisSatir) { //belirli satır aralığında işlem yapar
                    try {
                        if (satir.contains("(" + biletNumarasi + ")")) {  //o satır aralığındaki bilet numarasını bulur
                            biletFiyati = satir.substring(satir.length() - 10);// satırın son 10 karakteri yani bilet fiyatını yazdırır
                            System.out.println("Bilet ücreti: " + biletFiyati);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Hata: Sayı bulunamadı!");
                    }
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


    //satın alınan bileti dosyaya kaydetme işlemini gerçekleştiren metot
    @Override
    public  void biletKaydet() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("bilettakip.txt",true));
            writer.write(KisiYonetimi.geteMailTut() + " " + getAd() + " " + getBiletFiyati()); // hesap ve kişi bilgilerini yazdırır
            writer.newLine();  // Her kullanıcı için yeni bir satır ekler
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public String getBiletFiyati() {
        return biletFiyati;
    }

    public void setBiletFiyati(String biletFiyati) {
        this.biletFiyati = biletFiyati;
    }
}