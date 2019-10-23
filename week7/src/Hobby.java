public class Hobby {
    private String hobby;
    private int freq;
    private Adresa adresa;

    public Hobby(String hobby, int freq, Adresa adresa) {
        this.hobby = hobby;
        this.freq = freq;
        this.adresa = adresa;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return hobby + ", frecventa: " + freq + " zile/saptamana. Adresa: " + adresa;
    }
}
