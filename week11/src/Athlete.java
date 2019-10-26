public class Athlete {
    private int number;
    private String name;
    private String country;
    private Hour time;
    private String range1;
    private String range2;
    private String range3;

    public Athlete(int number, String name, String country, Hour time, String range1, String range2, String range3) {
        this.number = number;
        this.name = name;
        this.country = country;
        this.time = time;
        this.range1 = range1;
        this.range2 = range2;
        this.range3 = range3;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Hour getTime() {
        return time;
    }

    public void setTime(Hour time) {
        this.time = time;
    }

    public String getRange1() {
        return range1;
    }

    public void setRange1(String range1) {
        this.range1 = range1;
    }

    public String getRange2() {
        return range2;
    }

    public void setRange2(String range2) {
        this.range2 = range2;
    }

    public String getRange3() {
        return range3;
    }

    public void setRange3(String range3) {
        this.range3 = range3;
    }

    @Override
    public String toString() {
        return number + " - " + name + "  " + country + "  Time: " + time;
    }

}


