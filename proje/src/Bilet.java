public interface Bilet {
    void biletAl(); // bilet al methodu kendi içerisinde odemeYontemi ve biletKaydet methodunu da içerir ve
    // implement edildiği nesne üzerinden mainde çağırılır
    void odemeYontemi();
    void biletKaydet();
    void biletFiyati(int biletNumarasi, int baslangicSatir, int bitisSatir); //implement edildiği nesne üzerinden mainde çağırılır
}
