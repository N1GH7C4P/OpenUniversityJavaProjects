public class Main {
    public static void main(String[] args) {
        Suunnat s = new Suunnat(3);
        s.lisaaKaari(1,2);
        s.lisaaKaari(2,3);
        s.lisaaKaari(3,1);
        System.out.println(s.muodosta()); // [(1,2), (2,3), (1,3)]
    }
}
