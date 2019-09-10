/**
 * Week 13 - Java8
 *
 * This program reads a file chosen by the user containing people's names and date of birth.
 * The data is sorted alphabetically and filtered by a certain month.
 * The final list is printed in a file chosen by the user.
 *
 * @author Florin
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Java8Main {
    public static void main(String[] args) throws IOException {

        String []argument  = userInputs();
        String inFile = argument[0];
        String month = argument[1];
        String outFile = argument[2];

        List <Person> people = readFromFile(inFile);
        List <Person> refinedList = people.stream().
                sorted(Comparator.comparing(p -> p.getFirstName())).
                filter(p -> p.getMonth().contains(month)).
                collect(Collectors.toList());

        PrintStream write = new PrintStream(new FileOutputStream(outFile));
        refinedList.forEach(write::println);

        System.out.println("The result was written in " + outFile + " successfully! Press [Enter] to exit...");
        try{System.in.read();}
        catch(Exception e){}

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

    private static String[] userInputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter file name (for the homework example to work please enter 'Week13_input.txt'): ");
        String infile = br.readLine();

        System.out.println("Enter a month [1-12] to see whose birthday is this month: ");
        String month = br.readLine();

        System.out.println("Name your output file [eg. output.txt]: ");
        String outFile = br.readLine();

        String [] userInputs = {infile,month,outFile};
        return userInputs;
    }


}
