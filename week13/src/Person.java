public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String month;

    public Person(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        String [] splitDate = dateOfBirth.split("-");
        String tempMonth = splitDate[1];
        String[] splitMonth = tempMonth.split("");
        String fixedMonth;
        if (splitMonth[0].contains("0")){
            fixedMonth = splitMonth[1];
        } else {
            fixedMonth = splitMonth[0]+splitMonth[1];
        }
        this.month = fixedMonth;

    }

    public String getFirstName() { return firstName; }

    public String getMonth() { return month; }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

