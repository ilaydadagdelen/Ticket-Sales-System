import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class KisiYonetimi {
    private static ArrayList<Kisi> kullaniciListesi = new ArrayList<>();
    private static String eMailTut;

    Scanner scanner = new Scanner(System.in);

    public static ArrayList<Kisi> getKullaniciListesi() {
        return kullaniciListesi;
    }

    public static String geteMailTut() {
        //E maili tutar ve şifre değiştirirken veya kredi kartı eklerken o e maile eklemesi için gerekli
        return eMailTut;
    }

    // Üye olma methodu
    public void uyeOl() throws BilgiHatasiException {
        DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
        System.out.println("İsminizi giriniz :");
        String kullaniciAdi = scanner.nextLine();
        System.out.println("Soyadınızı giriniz :");
        String kullaniciSoyIsim = scanner.nextLine();
        System.out.println("E-Mail adresinizi giriniz (@ ve .com içermelidir) :");
        String kullaniciEMailKontrol = scanner.nextLine();
        String kullaniciEMail;
        if (kullaniciEMailKontrol.contains("@") && kullaniciEMailKontrol.contains(".com")) {
            int noktaninIndexi = kullaniciEMailKontrol.indexOf(".com");
            if (noktaninIndexi + 4 == kullaniciEMailKontrol.length()) {
                kullaniciEMail = kullaniciEMailKontrol;
                for (Kisi kisi : kullaniciListesi) {
                    if (kisi.getKullaniciEMail()
                            .equals(kullaniciEMail)) {
                        throw new BilgiHatasiException("E-mailinize kayıtlı hesabınız vardır.");
                    }
                }
            } else {
                throw new BilgiHatasiException(".com'un devamına yazı yazmayınız !");
            }
        } else {
            throw new BilgiHatasiException("E-mail adresiniz @ ve .com içermelidir !");
        }
        System.out.println("Kullanıcı şifrenizi giriniz :");
        String kullaniciSifre = scanner.nextLine();
        System.out.println("Hesabınız başarıyla oluşturulmuştur.");
        Kisi kisi = new Kisi(kullaniciAdi, kullaniciSoyIsim, kullaniciEMail, kullaniciSifre, null);
        getKullaniciListesi().add(kisi);
    }

    // Üye girişi methodu
    public void uyeGirisi() throws BilgiHatasiException {
        //E Mail ve şifre karşılaştırması için dosyadaki verileri çeker ve KullaniciListesi arraylistine kaydeder
        DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
        System.out.println("E-Mail adresinizi giriniz :");
        String kullaniciEMail = scanner.nextLine();
        System.out.println("Kullanıcı şifrenizi giriniz :");
        String kullaniciSifre = scanner.nextLine();
        boolean girisBasariliise = false;
        for (Kisi kisi : getKullaniciListesi()) {
        //for döngüsü ile bütün arraylist taranır ve if döngüsü ile e mail ve şifre eşleşmesi doğrulanır
            if (kullaniciEMail.equals(kisi.getKullaniciEMail()) && kullaniciSifre.equals(kisi.getKullaniciSifre())) {
                //daha sonra şifre değiştirme methodları için e mail adresi eMailTut değişkenine kaydedilir
                eMailTut = kullaniciEMail;
                System.out.println("\nGiriş Başarılı\n");
                System.out.println("Merhaba " + kisi.getKullaniciAdi().toUpperCase());
                System.out.println();
                girisBasariliise = true;
            }

        }
        if (!girisBasariliise) {
            throw new BilgiHatasiException("Kullanıcı E-Maili veya şifresi yanlış");
        }
    }
    //şifre değiştirme methodu
    public void sifreDegistir() throws BilgiHatasiException {
        System.out.println("Eski şifrenizi giriniz :");
        String kullaniciEskiSifre = scanner.nextLine();
        boolean eskiSifreBulundu = false;
        //kullanıcıdan eski şifresini sorar ve kullaniciEskiSifre değişkenine kaydeder
        for (Kisi kisi : getKullaniciListesi()) {
            //for döngüsü ile bütün arraylisti tarar ve if döngüsünde eMailTut değişkenindeki e mail ile
            //arraylistteki e maili eşleştirir ve kullanicinin girdiği şifre doğru ise işleme devam eder
            if (kisi.getKullaniciEMail().equals(eMailTut) && kullaniciEskiSifre.equals(kisi.getKullaniciSifre())) {
                eskiSifreBulundu = true;
                System.out.println("Yeni şifreyi giriniz :");
                String kullaniciYeniSifre = scanner.nextLine();
                System.out.println("Oluşturmak isteğiniz yeni şifreyi tekrar giriniz :");
                String kullaniciTekrarYeniSifre = scanner.nextLine();
                //kullanıcıdan yeni şifresini iki defa ister ikisi de aynıysa şifre güncellenir
                if (kullaniciYeniSifre.equals(kullaniciTekrarYeniSifre)) {
                    kisi.setKullaniciSifre(kullaniciYeniSifre);
                    System.out.println("Şifre başarı ile değiştirildi.");
                } else {
                    throw new BilgiHatasiException("Değiştirmek istediğiniz şifre ile tekrar girdiğiniz şifre uyuşmuyor !");
                }

            }

        }
        if (!eskiSifreBulundu) {
            throw new BilgiHatasiException("Eski şifreniz girdiğiniz şifre değil");
        }
    }
    //kredi kartı ekleme methodu
    public void krediKartiEkle() {
        for (Kisi kisi : kullaniciListesi) {
            //arraylist taranır ve if bloğunda eMailTut ile e mail eşleştirilir
            if (kisi.getKullaniciEMail().equals(eMailTut)) {
                //eğer kredi kartı değerinde null yazıyorsa if bloğuna girer null kayıtlı kredi kartı olmadığı anlamına gelir
                if (kisi.getKrediKarti().equals("null")) {
                    System.out.println("Kredi kartı numaranızı giriniz: ");
                    String kullaniciKrediKarti = scanner.nextLine();
                    System.out.println("Kartınızın arka yüzündeki 3 haneli güvenlik kodunu giriniz: ");
                    String krediKartiGuvenlikKodu = scanner.nextLine();
                    System.out.println("Kartınızın son kullanma tarihinin ay kısmını giriniz: ");
                    String krediKartiAy = scanner.nextLine();
                    System.out.println("Kartınızın son kullanma tarihinin yıl kısmını giriniz");
                    String krediKartiYil = scanner.nextLine();
                    //if bloğundaki şartlar doğrulandıysa kişiye ait kredi kartı sisteme eklenir
                    if (kullaniciKrediKarti.length() == 16 && krediKartiGuvenlikKodu.length() == 3 && krediKartiAy.length() == 2 && krediKartiYil.length() == 4) {
                        kisi.setKrediKarti(kullaniciKrediKarti);
                    } else {
                        System.out.println("Bilgilerinizi tekrar kontrol ediniz !");
                    }

                } else {
                    System.out.println("Kayıtlı kredi kartınız mevcut !");
                }
            }
        }
    }
    //kredi kartı bilgilerini silme methodu
    public void krediKartiBilgileriSil() {
        boolean kartBulundu = false;
        for (Kisi kisi : kullaniciListesi) {
            //arraylist taranır ve eMailTut değişkenindeki e mail ile o kişinin kredi kartı bilgileri eşleştirilir
            //eğer kredi kartı ekliyse bu if bloğuna girer
            if (kisi.getKullaniciEMail().equals(eMailTut) && kisi.getKrediKarti() != null) {
                System.out.println("Kayıtlı kredi kartı bilgilerinizin silinmesini istiyorsanız evet istemiyorsanız hayır yazınız: ");
                String cevap = scanner.nextLine();
                //cevabın evet olması halinde if bloğuna girer ve kişiye ait kredi kartını sistemden siler ve yerine null yazar
                if (cevap.equalsIgnoreCase("evet")) {
                    kisi.setKrediKarti("null");
                    System.out.println("Kredi kartı bilgileriniz başarıyla silinmiştir!");
                //cevabın hayır olması halinde işlem sonlandırılır
                } else if (cevap.equalsIgnoreCase("hayır")) {
                    return;
                } else {
                    System.out.println("Lütfen geçerli bir cevap giriniz!");
                }
                kartBulundu = true;
            }
        }
        if (!kartBulundu) {
            System.out.println("Kayıtlı kredi kartınız bulunmamaktadır!");
        }
    }
    //kredi kartı bilgilerini görüntüleme methodu
    public void krediKartBilgileriGoruntule() {
        for (Kisi kisi : kullaniciListesi) {
            if (kisi.getKullaniciEMail().equals(eMailTut)) {
                //kişiye ait kredi kartı bilgisinde null yazmıyorsa if bloğuna girer ve kişiye kayıtlı kredi kartlarını gösterir
                if (!kisi.getKrediKarti().equals("null")) {
                    System.out.println("Kayıtlı kredi kartlarınız: " + kisi.getKrediKarti());
                } else {
                    System.out.println("Kayıtlı kredi kartınız bulunmamaktadır!");
                }
            }
        }
    }

    public void BiletGoruntule() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("bilettakip.txt"));
            boolean biletBulundu = false;

            String satir;
            System.out.println("Biletlerim:");
            while ((satir = reader.readLine()) != null) {
                String[] veriler = satir.split("\\s+",2);  // 2 parametresi satırı ilk boşluğu görünce ikiye bölüyor böylece emailden sonrasını yazdırabiliyor
                if (veriler[0].equals(eMailTut)) {
                    if (veriler.length > 1) {  // emailden sonrası boşsa yazdırmasın diye, hata kontrolü gibi düşünülebilir
                        System.out.println(veriler[1]);
                        biletBulundu = true;  //döngü sağlansın diye break;i kaldırdım
                    }
                }
            }
            System.out.println();

            if (!biletBulundu) {
                System.out.println("Bilet bulunamadı.\n");
            }

            // Dosyayı kapat
            reader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
