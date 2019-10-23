public class Student {
    private String name;
    private String surname;
    private int birthYear;
    private String sex;
    private int id;

    public Student(String name, String surname, int birthYear, String sex, int id) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.sex = sex;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + surname + ". Age: " + (2019-birthYear) + " - ID: " + id;
    }
}

