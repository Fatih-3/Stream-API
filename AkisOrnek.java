import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Urun {
    private int id;
    private String ad;
    private double fiyat;

    public Urun(int id, String ad, double fiyat) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    @Override
    public String toString() {
        return "Urun{id=" + id + ", ad='" + ad + "', fiyat=" + fiyat + "}";
    }
}

class Musteri {
    private int id;
    private String isim;
    private int yas;

    public Musteri(int id, String isim, int yas) {
        this.id = id;
        this.isim = isim;
        this.yas = yas;
    }

    public int getId() {
        return id;
    }

    public String getIsim() {
        return isim;
    }

    public int getYas() {
        return yas;
    }

    @Override
    public String toString() {
        return "Musteri{id=" + id + ", isim='" + isim + "', yas=" + yas + "}";
    }
}

public class AkisOrnek {
    public static void main(String[] args) {
        List<Urun> urunler = new ArrayList<>();
        urunler.add(new Urun(1, "Laptop", 15000.0));
        urunler.add(new Urun(2, "Telefon", 8000.0));
        urunler.add(new Urun(3, "Tablet", 4000.0));
        urunler.add(new Urun(4, "Monitör", 2000.0));

        List<Musteri> musteriler = new ArrayList<>();
        musteriler.add(new Musteri(1, "Ali", 28));
        musteriler.add(new Musteri(2, "Ayşe", 35));
        musteriler.add(new Musteri(3, "Can", 22));
        musteriler.add(new Musteri(4, "Deniz", 30));

        List<Urun> pahaliUrunler = urunler.stream()
                .filter(u -> u.getFiyat() > 5000)
                .collect(Collectors.toList());
        System.out.println("Pahalı Ürünler (Fiyat > 5000): " + pahaliUrunler);

        List<Musteri> yasliMusteriler = musteriler.stream()
                .filter(m -> m.getYas() > 30)
                .collect(Collectors.toList());
        System.out.println("Yaşı 30'dan Büyük Müşteriler: " + yasliMusteriler);

        List<String> urunAdlari = urunler.stream()
                .map(Urun::getAd)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Ürün Adları (Büyük Harf): " + urunAdlari);

        List<Musteri> atlananMusteriler = musteriler.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Atlanan Müşteriler (İlk 2 Atlansın): " + atlananMusteriler);

        List<Urun> siraliUrunler = urunler.stream()
                .sorted((u1, u2) -> Double.compare(u1.getFiyat(), u2.getFiyat()))
                .collect(Collectors.toList());
        System.out.println("Fiyatına Göre Sıralı Ürünler: " + siraliUrunler);

        List<Urun> dropWhileOrnegi = urunler.stream()
                .dropWhile(u -> u.getFiyat() < 5000)
                .collect(Collectors.toList());
        System.out.println("dropWhile Kullanımı (Fiyat < 5000 Olanları Atla): " + dropWhileOrnegi);

        List<Urun> skipOrnegi = urunler.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("skip Kullanımı (İlk 3 Ürünü Atla): " + skipOrnegi);
    }
}
