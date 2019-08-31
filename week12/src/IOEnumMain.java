/**
 * Week 12 - IO & Enums Homework
 *
 * This program reads 2 text files (file1.txt, file2.txt) containing information about people.
 * Person objects are created from each line and added to a list.
 * The different types of entries in the gender field are handled by an enum.
 * Females who celebrate their birthdays today are filtered and printed.
 * The console output is also written on a file (output.txt)
 *
 * @author Florin
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class IOEnumMain  {

    public static void main(String[] args) throws FileNotFoundException {

        PrintStream write = new PrintStream(new FileOutputStream("output.txt"));
        List<Person> people = readFromFile("file1.txt");
        List<Person> secondFile = readFromFile("file2.txt");
        people.addAll(secondFile);

        SimpleDateFormat monthAndDay = new SimpleDateFormat("MM-dd");
        String today = monthAndDay.format(new Date());

        for (int i = 0; i<people.size(); i++){

            if (people.get(i).getDayAndMonth().contains(today) && people.get(i).getGender().contains("female")){

                String output = people.get(i).getName() + " (" + people.get(i).getYear() + ") it's your birthday! You're "
                        +  (2019 - Integer.parseInt(people.get(i).getYear()) + " years old!");

                System.out.println(output);
                write.println(output);

            }
        }
    }

    private static List<Person> readFromFile(String fileName) {
        List<Person> Persons = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
            String line = br.readLine();

            while (line != null) {
                String[] elements = line.split(",");
                Person Person = createPerson(elements);
                Persons.add(Person);
                line = br.readLine();
            }

        } catch (IOException e) {
            System.err.println("IO Error!");
        }
        return Persons;
    }

    private static Person createPerson(String[] element){
        String name = element[0];
        String date = element[1];
        String gender = element[2];

        return new Person(name,date,gender);
    }
}
