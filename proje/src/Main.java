import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        KisiYonetimi kisiYonetimi = new KisiYonetimi();
        DosyaYoneticisi dosyaYoneticisi = new DosyaYoneticisi();
        Scanner scanner = new Scanner(System.in);
        int secenek1, secenek2, secenek3, secenek4, secenek5, secenek6;
        Konser konser1 = new Konser("Buray Konseri", "07 Şubat Çar - 21:00", "TED Ankara Koleji - Ata Sahne");
        Konser konser2 = new Konser("Sıla Konseri", "09 Şubat Cum - 21:00", "TED Ankara Koleji - Ata Sahne");
        Konser konser3 = new Konser("Erol Evgin Konseri", "01 Mart Cum - 21:00", "TED Ankara Koleji - Ata Sahne");
        Konser konser4 = new Konser("Fatma Turgut Akustik Konseri", "08 Mart Cum / 20:00", "Yenimahalle Nazım Hikmet Kültür Merkezi");
        Konser konser5 = new Konser("Evrencan Gündüz Konseri", "19 Ocak Cum - 21:00", "IF Performance Hall");
        Konser konser6 = new Konser("CanOzan Konseri", "02 Şubat Cum - 20:00", "Yenimahalle Nazım Hikmet Kültür Merkezi");
        Konser konser7 = new Konser("Ufuk Beydemir Konseri", "04 Şubat Paz - 22:00", "6:45 KK Tunus");
        Tiyatro tiyatro1 = new Tiyatro("Aydınlıkevler Tiyatrosu", "25 Ocak Per - 21:00", "Congresium Ankara");
        Tiyatro tiyatro2 = new Tiyatro("Yeraltından Notlar Tiyatrosu", "08 Ocak - 20:00", "Ankara Yeni Sahne");
        Tiyatro tiyatro3 = new Tiyatro("Richard Tiyatrosu", "27 Ocak Cmt - 20:00", "MEB Şura Salonu");
        Tiyatro tiyatro4 = new Tiyatro("Çok Güzel Hareketler 2","18 Şubat Paz - 20:00","Yenimahalle Nazım Hikmet Kültür Merkezi-Genco Erkal Sahnesi");
        Tiyatro tiyatro5 = new Tiyatro("Morgue Sokağı Cinayeti Tiyatrosu","23 Ocak Sal - 20:00","CerModern Etkinlikleri");
        Tiyatro tiyatro6 = new Tiyatro("Notre Dame'ın Kamburu Müzikali","12 Şubat Pzt - 20:30","MEB Şura Salonu");
        Festival festival1 = new Festival("What A Fast","22 Ağustos - 25 Ağustos", "Foça Sahili - İzmir");
        Festival festival2 = new Festival("Kocaeli Müzik Festivali","10 Mayıs - 12 Mayıs", "Emex Otel - Kocaeli");
        Festival festival3 = new Festival("Sakarya Müzik Festivali","16 Mayıs - 18 Mayıs", "Del Lago Luxury Hotel - Sakarya");
        Festival festival4 = new Festival("Çanakkale Müzik Festivali","10 Mayıs - 12 Mayıs", "Sunsan Hotel - Çanakkale");
        Festival festival5 = new Festival("Bolu Müzik Festivali","11 Ekim - 13 Ekim", "VonResort Abant - Bolu");
        Festival festival6 = new Festival("Konya Müzik Festivali","24 Mayıs - 26 Mayıs", "Grand Hotel - Konya");
        StandUp standUp1 = new StandUp("Sergen Deveci Stand Up", "13 Ocak Cmt - 20:30", "Çankaya Sahne");
        StandUp standUp2 = new StandUp("Okan Cabalar Stand Up", "27 Ocak Cmt - 19:00", "Route Ankara Sahnesi");
        StandUp standUp3 = new StandUp("Doğu Demirkol Stand Up", "30 Ocak Salı - 20:30", "Yenimahalle Nazım Hikmet Kültür Merkezi");
        StandUp standUp4 = new StandUp("Mesut Süre 'Siz Hepiniz Ben Tek'", "06 Ocak Cmt - 20:30", "Çankaya Sahne");
        StandUp standUp5 = new StandUp("Berfu & Eser Yenenler - Çift Terapisi Stand Up", "31 Ocak Çar - 21:00", "MEB Şura Salonu");
        StandUp standUp6 = new StandUp("Aşkım Kapışmak ile İlişkiler Komedisi Stand Up", "17 Ocak Çar - 20:00", "MEB Şura Salonu");


        System.out.println("\nBİLET SATIŞ UYGULAMASINA HOŞGELDİNİZ!\n");
        do {
            System.out.println("""
                    Yapmak istediğiniz işlemi seçin\s
                    (1) Üye ol\s
                    (2) Zaten üyeyim\s
                    (0) Çıkış""");
            secenek1 = scanner.nextInt();
            switch (secenek1) {
                case 1:
                    try {
                        kisiYonetimi.uyeOl();
                        dosyaYoneticisi.kullaniciBilgileriniYazdir();
                    } catch (BilgiHatasiException exception) {
                        System.out.println(exception.getMessage());
                    }
                    break;
                case 2:
                    try {
                        kisiYonetimi.uyeGirisi();
                        do {
                            secenek1 = 1;
                            System.out.println("""
                                     ANA MENÜ :\s
                                     Biletler\s
                                        (1) Konser\s
                                        (2) Tiyatro\s
                                        (3) Festival\s
                                        (4) Stand Up\s
                                     (5) Hesabım\s
                                     (0) Hesaptan çık""");
                            secenek2 = scanner.nextInt();
                            switch (secenek2) {
                                case 1:
                                    do {
                                        secenek1 = 1;
                                        secenek2 = 1;
                                        System.out.println("(1) " + konser1.getAd());
                                        System.out.println("(2) " + konser2.getAd());
                                        System.out.println("(3) " + konser3.getAd());
                                        System.out.println("(4) " + konser4.getAd());
                                        System.out.println("(5) " + konser5.getAd());
                                        System.out.println("(6) " + konser6.getAd());
                                        System.out.println("(7) " + konser7.getAd());
                                        System.out.println("(0) GERİ");
                                        secenek3 = scanner.nextInt();
                                        switch (secenek3) {
                                            case 0:
                                                System.out.println("Bir önceki sayfaya dönülüyor...");
                                                break;
                                            case 1:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser1.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser1.etkinlikHakkinda(1, 30);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser1.biletFiyati(secenek5, 1, 31);
                                                                konser1.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser1.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 2:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser2.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser2.etkinlikHakkinda(31, 60);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser2.biletFiyati(secenek5, 31, 60);
                                                                konser2.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser2.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 3:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser3.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser3.etkinlikHakkinda(61, 90);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser3.biletFiyati(secenek5, 61, 90);
                                                                konser3.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser3.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 4:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser4.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser4.etkinlikHakkinda(91, 120);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser4.biletFiyati(secenek5, 91, 120);
                                                                konser4.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser4.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 5:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser5.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser5.etkinlikHakkinda(121, 133);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser5.biletFiyati(secenek5, 121, 133);
                                                                konser5.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser5.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 6:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser6.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser6.etkinlikHakkinda(134, 164);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser6.biletFiyati(secenek5, 134, 164);
                                                                konser6.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser6.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 7:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    konser7.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            konser7.etkinlikHakkinda(166, 176);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                konser7.biletFiyati(secenek5, 166, 176);
                                                                konser7.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                konser7.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            default:
                                                System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                        }
                                    } while (secenek3 != 0);
                                    break;
                                case 2:
                                    do {
                                        secenek1 = 1;
                                        secenek2 = 1;
                                        System.out.println("(1) " + tiyatro1.getAd());
                                        System.out.println("(2) " + tiyatro2.getAd());
                                        System.out.println("(3) " + tiyatro3.getAd());
                                        System.out.println("(4) " + tiyatro4.getAd());
                                        System.out.println("(5) " + tiyatro5.getAd());
                                        System.out.println("(6) " + tiyatro6.getAd());
                                        System.out.println("(0) GERİ");
                                        secenek3 = scanner.nextInt();
                                        switch (secenek3) {
                                            case 0:
                                                System.out.println("Bir önceki sayfaya dönülüyor...");
                                                break;
                                            case 1:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    tiyatro1.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            tiyatro1.etkinlikHakkinda(178, 225);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                tiyatro1.biletFiyati(secenek5, 178, 225);
                                                                tiyatro1.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                tiyatro1.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while (secenek4 != 0);
                                                break;
                                            case 2:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    tiyatro2.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            tiyatro2.etkinlikHakkinda(226, 258);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                tiyatro2.biletFiyati(secenek5, 226, 258);
                                                                tiyatro2.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                tiyatro2.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while (secenek4 != 0);
                                                break;
                                            case 3:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    tiyatro3.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            tiyatro3.etkinlikHakkinda(259, 289);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                tiyatro3.biletFiyati(secenek5, 259, 289);
                                                                tiyatro3.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                tiyatro3.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while (secenek4 != 0);
                                                break;
                                            case 4:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    tiyatro4.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            tiyatro4.etkinlikHakkinda(290, 334);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                tiyatro4.biletFiyati(secenek5, 290, 334);
                                                                tiyatro4.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                tiyatro4.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while (secenek4 != 0);
                                                break;
                                            case 5:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    tiyatro5.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            tiyatro5.etkinlikHakkinda(335, 349);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                tiyatro5.biletFiyati(secenek5, 335, 349);
                                                                tiyatro5.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                tiyatro5.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while (secenek4 != 0);
                                                break;
                                            case 6:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    tiyatro6.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            tiyatro6.etkinlikHakkinda(350, 380);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                tiyatro6.biletFiyati(secenek5, 350, 380);
                                                                tiyatro6.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                tiyatro6.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while (secenek4 != 0);
                                                break;
                                            default:
                                                System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                        }
                                    }while(secenek3!=0);
                                    break;
                                case 3:
                                    do {
                                        secenek1 = 1;
                                        secenek2 = 1;
                                        System.out.println("(1) " + festival1.getAd());
                                        System.out.println("(2) " + festival2.getAd());
                                        System.out.println("(3) " + festival3.getAd());
                                        System.out.println("(4) " + festival4.getAd());
                                        System.out.println("(5) " + festival5.getAd());
                                        System.out.println("(6) " + festival6.getAd());
                                        System.out.println("(0) GERİ");
                                        secenek3 = scanner.nextInt();
                                        switch (secenek3) {
                                            case 0:
                                                System.out.println("Bir önceki sayfaya dönülüyor...");
                                                break;
                                            case 1:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    festival1.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            festival1.etkinlikHakkinda(382, 392);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                festival1.biletFiyati(secenek5, 382, 392);
                                                                festival1.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                festival1.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 2:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    festival2.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            festival2.etkinlikHakkinda(393, 403);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                festival2.biletFiyati(secenek5, 393, 403);
                                                                festival2.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                festival2.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 3:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    festival3.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            festival3.etkinlikHakkinda(404, 413);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                festival3.biletFiyati(secenek5, 404, 413);
                                                                festival3.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                festival3.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 4:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    festival4.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            festival4.etkinlikHakkinda(414, 423);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                festival4.biletFiyati(secenek5, 414, 423);
                                                                festival4.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                festival4.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 5:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    festival5.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            festival5.etkinlikHakkinda(424, 433);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                festival5.biletFiyati(secenek5, 424, 433);
                                                                festival5.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                festival5.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 6:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    festival6.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            festival6.etkinlikHakkinda(434, 443);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                festival6.biletFiyati(secenek5, 434, 443);
                                                                festival6.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                festival6.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            default:
                                                System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                        }
                                    } while (secenek3 != 0);
                                    break;
                                case 4:
                                    do {
                                        secenek1 = 1;
                                        secenek2 = 1;
                                        System.out.println("(1) " + standUp1.getAd());
                                        System.out.println("(2) " + standUp2.getAd());
                                        System.out.println("(3) " + standUp3.getAd());
                                        System.out.println("(4) " + standUp4.getAd());
                                        System.out.println("(5) " + standUp5.getAd());
                                        System.out.println("(6) " + standUp6.getAd());
                                        System.out.println("(0) GERİ");
                                        secenek3 = scanner.nextInt();
                                        switch (secenek3) {
                                            case 0:
                                                System.out.println("Bir önceki sayfaya dönülüyor...");
                                                break;
                                            case 1:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    standUp1.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            standUp1.etkinlikHakkinda(444, 463);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                standUp1.biletFiyati(secenek5, 444, 463);
                                                                standUp1.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                standUp1.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 2:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    standUp2.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            standUp2.etkinlikHakkinda(464, 473);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                standUp2.biletFiyati(secenek5, 464, 473);
                                                                standUp2.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                standUp2.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 3:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    standUp3.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            standUp3.etkinlikHakkinda(474, 506);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                standUp3.biletFiyati(secenek5, 474, 506);
                                                                standUp3.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                standUp3.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 4:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    standUp4.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            standUp4.etkinlikHakkinda(507, 529);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                standUp4.biletFiyati(secenek5, 507, 529);
                                                                standUp4.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                standUp4.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 5:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    standUp5.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            standUp5.etkinlikHakkinda(530, 558);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                standUp5.biletFiyati(secenek5, 530, 558);
                                                                standUp5.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                standUp5.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            case 6:
                                                do {
                                                    secenek1 = 1;
                                                    secenek2 = 1;
                                                    secenek3 = 1;
                                                    standUp6.bilgileriGoster();
                                                    System.out.println("(1) Etkinlik hakkında daha fazla bilgi edinmek için");
                                                    System.out.println("(2) Etkinlik kurallarına göz atmak için");
                                                    System.out.println("(0) GERİ");
                                                    secenek4 = scanner.nextInt();
                                                    switch (secenek4) {
                                                        case 0:
                                                            System.out.println("Bir önceki sayfaya dönülüyor...");
                                                            break;
                                                        case 1:
                                                            secenek1 = 1;
                                                            secenek2 = 1;
                                                            secenek3 = 1;
                                                            secenek4 = 1;
                                                            standUp6.etkinlikHakkinda(559, 582);
                                                            secenek5 = scanner.nextInt();
                                                            if (secenek5 != 0) {
                                                                standUp6.biletFiyati(secenek5, 559, 582);
                                                                standUp6.biletAl();
                                                                secenek6 = scanner.nextInt();
                                                                if (secenek6 == 1) {
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                } else if (secenek6 == 0){
                                                                    secenek4 = 0;
                                                                    secenek3 = 0;
                                                                    secenek2 = 0;
                                                                } else {
                                                                    System.out.println("GERİ");
                                                                }
                                                            }
                                                            break;
                                                        case 2:
                                                            do {
                                                                standUp6.etkinlikKurallari();
                                                                System.out.println("(0) GERİ");
                                                                secenek5 = scanner.nextInt();
                                                            } while (secenek5 != 0);
                                                            break;
                                                        default:
                                                            System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                                    }
                                                } while(secenek4 != 0);
                                                break;
                                            default:
                                                System.out.println("Geçersiz seçenek. Lütfen tekrar deneyin.");
                                        }
                                    } while (secenek3 != 0);
                                    break;
                                case 5:
                                    int hesapSecenekSecim;
                                    do {
                                        System.out.println("""
                                                       Yapmak istediğiniz işlemi seçin :\s
                                                       Şifre değiştir (1)\s
                                                       Kredi kartı bilgisi ekle (2)\s
                                                       Kayıtlı kredi kartı bilgilerimi sil (3)\s
                                                       Kayıtlı kredi kartlarını görüntüle (4)\s
                                                       Biletlerimi görüntüle (5)\s
                                                       Geri(0)""");
                                        hesapSecenekSecim = scanner.nextInt();
                                        switch (hesapSecenekSecim) {
                                            case 1:
                                                try {
                                                    kisiYonetimi.sifreDegistir();
                                                    dosyaYoneticisi.kullaniciBilgileriniYazdir();
                                                    DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
                                                } catch (BilgiHatasiException e) {
                                                    System.out.println(e.getMessage());
                                                }
                                                break;
                                            case 2:
                                                kisiYonetimi.krediKartiEkle();
                                                dosyaYoneticisi.kullaniciBilgileriniYazdir();
                                                DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
                                                break;
                                            case 3:
                                                kisiYonetimi.krediKartiBilgileriSil();
                                                dosyaYoneticisi.kullaniciBilgileriniYazdir();
                                                DosyaYoneticisi.dosyadanGelenVeriyiArrayListeKaydet();
                                                break;
                                            case 4:
                                                kisiYonetimi.krediKartBilgileriGoruntule();
                                                break;
                                            case 5:
                                                kisiYonetimi.BiletGoruntule();
                                                break;
                                            default:
                                                break;
                                        }
                                    } while (hesapSecenekSecim != 0);
                                    break;
                                default:
                                    System.out.println("Hesabınızdan çıkış yapılıyor...");
                                    break;
                            }
                        } while (secenek2 != 0);
                        KisiYonetimi.getKullaniciListesi().clear();
                    } catch (BilgiHatasiException e) {
                        System.out.println(e.getMessage());
                        KisiYonetimi.getKullaniciListesi().clear();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 0:
                    System.out.println("Programdan çıkış yapılıyor...");
                    break;
            }
        } while (secenek1 != 0);
    }
}
