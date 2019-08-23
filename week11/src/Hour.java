public class Hour {
    private String stringTime;
    private int[] intTime;
    private int comparableTime;

    public Hour(String hTime) {
        this.stringTime = hTime;
        String[] splitTime = hTime.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(splitTime[0]);
            seconds = Integer.parseInt(splitTime[1]);

        }catch (NumberFormatException e){
            minutes = 0;
            seconds = 0;
        }
        int[] ms = {minutes,seconds};
        this.intTime = ms;
        String mergeTime = splitTime[0] + splitTime[1];
        this.comparableTime = Integer.parseInt(mergeTime);
    }

    public String getStringTime() {
        return stringTime;
    }

    public void setStringTime(String stringTime) {
        this.stringTime = stringTime;
    }

    public int[] getIntTime() {
        return intTime;
    }

    public void setIntTime(int[] intTime) {
        this.intTime = intTime;
    }

    public int getComparableTime() {
        return comparableTime;
    }

    public void setComparableTime(int comparableTime) {
        this.comparableTime = comparableTime;
    }

    @Override
    public String toString() {
        return stringTime;
    }
}
