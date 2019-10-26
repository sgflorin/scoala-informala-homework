public class Person {
    private String name;
    private String stringDateOfBirth;
    private String gender;
    private String dayAndMonth;
    private String year;

    private enum Gender {MALE, FEMALE}

    public static Gender genderSorter (String input) {

        if (input.equalsIgnoreCase("male") || input.equalsIgnoreCase("0")){
            return Gender.MALE;
        } else if (input.equalsIgnoreCase("female") || input.equalsIgnoreCase("1")){
            return Gender.FEMALE;
        } else {
            throw new IllegalArgumentException("no enum constant!");
        }
    }

    public Person(String name, String dateOfBirth, String gender) {
        this.name = name;
        String[] date = dateOfBirth.split("-");
        this.dayAndMonth = date[1] + "-" + date[2];
        this.year = date[0];
        this.stringDateOfBirth = dateOfBirth;
        if(genderSorter(gender) == Gender.MALE){
            this.gender = "male";
        } else {
            this.gender = "female";
        }
    }

    public String getName() { return name; }

    public String getGender() { return gender; }

    public String getDayAndMonth() { return dayAndMonth; }

    public String getYear() { return year; }

    @Override
    public String toString() {
        return name + "  " + stringDateOfBirth + "  " + gender;
    }
}
