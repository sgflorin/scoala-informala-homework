/**
 * Tema week 7, TreeSet + HashMap
 *
 * @Author Florin
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("TreeSet by name");
        System.out.println("--------------------");
        Set<Persoane> psName = new TreeSet<Persoane>(new nameComp());
        psName.add(new Angajat("Alina", 21));
        psName.add(new Somer("Alex",35));
        psName.add(new Student("Maria",19));
        psName.add(new Student("Radu", 20));
        psName.add(new Angajat("Cristina", 28));
        psName.forEach(System.out::println);

        System.out.println("--------------------");
        System.out.println("TreeSet by age");
        System.out.println("--------------------");

        Set<Persoane> psAge = new TreeSet<>(new ageComp());
        psAge.add(new Angajat("Alina", 21));
        psAge.add(new Somer("Alex",35));
        psAge.add(new Student("Maria",19));
        psAge.add(new Student("Radu", 20));
        psAge.add(new Angajat("Cristina", 28));
        psAge.forEach(System.out::println);
        System.out.println(" ");

        List<Adresa> ads = new ArrayList<>();
        ads.add(new Adresa("Nucului",45));
        ads.add(new Adresa("Mihai Eminescu",21));
        ads.add(new Adresa("Soarelui",15));
        ads.add(new Adresa("Garii", 8));
        ads.add(new Adresa("Grivitei",3));

        List<Hobby> hobList = new ArrayList<>();
        hobList.add(new Hobby("Tenis",2, ads.get(3)));
        hobList.add(new Hobby("Catarat",3, ads.get(0)));
        hobList.add(new Hobby("Dungeons&Dragon",1, ads.get(2)));
        hobList.add(new Hobby("Pescuit",1, ads.get(4)));
        hobList.add(new Hobby("Dans",2, ads.get(1)));

        Persoane Alina = new Persoane("Alina",21);
        Persoane Alex = new Persoane("Alex",35);
        Persoane Maria = new Persoane("Maria",19);
        Persoane Radu = new Persoane("Radu",20);
        Persoane Cristina = new Persoane("Cristina", 28);

        Map hm = new HashMap<String,ArrayList<Hobby>>();
        hm.put(Alina,hobList.get(1));
        hm.put(Alex,hobList.get(4));
        hm.put(Maria,hobList.get(0));
        hm.put(Radu,hobList.get(2));
        hm.put(Cristina,hobList.get(3));


        System.out.println("Apasati [Enter] pentru a doua cerinta.");
        try{System.in.read();}
        catch(Exception e){}
        System.out.println("Alegeti persoana [1] [2] [3]..");
        System.out.println("[1] Alina");
        System.out.println("[2] Alex");
        System.out.println("[3] Maria");
        System.out.println("[4] Radu");
        System.out.println("[5] Cristina");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println(hm.get(Alina));
        } else if (choice == 2) {
            System.out.println(hm.get(Alex));
        } else if (choice == 3) {
            System.out.println(hm.get(Maria));
        } else if (choice == 4) {
            System.out.println(hm.get(Radu));
        } else if (choice == 5) {
            System.out.println(hm.get(Cristina));
        } else {
            System.out.println("Eroare: persoana " + choice + " nu exista!");
        }

    }
}

class nameComp implements Comparator<Persoane>{
    @Override
    public int compare (Persoane p1, Persoane p2){
        return p1.getName().compareTo(p2.getName());
    }
}

class ageComp implements Comparator<Persoane>{
    @Override
    public int compare(Persoane p1, Persoane p2){
        if(p1.getAge() > p2.getAge()) {
            return 1;
        } else {
            return -1;
        }
    }
}