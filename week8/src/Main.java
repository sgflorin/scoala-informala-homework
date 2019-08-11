/**
 * Homework Week 8
 *
 * @author Florin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        List <Student> sList = new ArrayList<>();
        sList.add(new Student("Walter", "White", 1968, "Male", 2675));
        sList.add(new Student("Jessie", "Pinkman", 1990, "Male", 2839));
        sList.add(new Student("Saul", "Goodman", 1975, "Male", 2413));
        sList.add(new Student("Mike", "Ehrmantraut", 1958, "Male", 3293));
        sList.add(new Student("Hank", "Schrader", 1968, "Male", 2802));

        List <Student> byAge = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("[1] Add student");
            System.out.println("[2] Delete student");
            System.out.println("[3] Retrieve all students by age");
            System.out.println("[4] Exit");

            int tempChoice = sc.nextInt();
            choice = tempChoice;

            switch (choice) {

                //Add student
                case 1:
                    String name = name();
                    String surname = surname();
                    int year = birthYear();
                    String gender = genderSelect();
                    int id = generateId();
                    sList.add(new Student(name,surname,year,gender,id));
                    System.out.println("Student successfully added! Press [Enter] to continue...");
                    try{System.in.read();}
                    catch(Exception e){}
                    break;

                //Remove student by ID
                case 2:
                    sList.forEach(System.out::println);
                    int x = removeStudent();
                    for (int i = 0; i < sList.size(); i++) {
                        if (sList.get(i).getId() == x){
                            sList.remove(i);
                            System.out.println("Student successfully removed! Press [Enter] to continue...");
                        }
                    }
                    try{System.in.read();}
                    catch(Exception e){}
                    break;

                //Retrieve students by age
                case 3:
                    System.out.println("Enter age: ");
                    int age = sc.nextInt();
                    int birthYear = 2019 - age;

                    for (int i = 0; i < sList.size(); i++) {
                        if (sList.get(i).getBirthYear() == birthYear){
                            byAge.add(sList.get(i));
                        }
                    }

                    if (byAge.isEmpty()) {
                        System.out.println("There are no " + age + " years old students.");
                    } else {
                        byAge.forEach(System.out::println);
                    }
                    byAge.clear();
                    System.out.println("Press [Enter] to continue...");
                    try{System.in.read();}
                    catch(Exception e){}
                    break;

                //Exit program
                case 4:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Error! Wrong Input");
                    break;
            }

        } while (choice != 4);

    }


    private static int removeStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID to remove him..");
        int id = sc.nextInt();
        return id;
    }

    private static String name() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name;
        do {
            System.out.println("Name: ");
            name = br.readLine();
            if (name.isEmpty() || name.contains(" ")) {
                System.out.println("Name field cannot be empty!");
            }
        } while (name.isEmpty() || name.contains(" "));
        return name;
    }

    private static String surname() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String surname;
        do {
            System.out.println("Surname: ");
            surname = br.readLine();
            if (surname.isEmpty() || surname.contains(" ")) {
                System.out.println("Surname field cannot be empty!");
            }
        } while (surname.isEmpty() || surname.contains(" "));
        return surname;
    }

    private static int birthYear(){
        Scanner sc = new Scanner(System.in);
        int year = 0;
        try {
            do {
                System.out.println("Year of birth: ");
                year = sc.nextInt();
                if (year < 1900 || year > 2001) {
                    System.out.println("Student must be born after 1900 and be 18 years old!");
                }
            } while (year < 1900 || year > 2001);
        } catch (InputMismatchException e) {
            System.err.println("Not a number!");
            System.exit(0);
        }
        return year;
    }

    private static String genderSelect() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gender;
        int a;
        String [] genders = {"Male", "male", "M", "m", "Female", "female", "F", "f"};
        do {
            System.out.println("Gender: ");
            gender = br.readLine();
            if (Arrays.asList(genders).contains(gender)) {
                a = 1;
            } else {
                a = -1;
                System.out.println("Not a real gender!");
            }
        } while (a != 1);
        return gender;
    }

    private static int generateId(){
        Random random = new Random();
        int id = random.nextInt(9000) + 1000;
        System.out.println("Student ID was automatically generated. ID: " + id);
        return id;
    }
}



