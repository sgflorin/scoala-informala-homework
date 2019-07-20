import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) throws IOException {

        //adding some stuff to the shop
        ArrayList<Animal> animalProducts = new ArrayList<>();
        animalProducts.add(new Animal("Milk", 21, "20/08/2019", 1, 5));
        animalProducts.add(new Animal("Eggs", 12, "23/08/2019", 0.05, 6));
        animalProducts.add(new Animal("Cheese", 30, "21/08/2019", 2, 3));
        animalProducts.add(new Animal("Sour cream", 45, "20/08/2019", 1, 5));

        ArrayList<Vegetal> vegetalProducts = new ArrayList<>();
        vegetalProducts.add(new Vegetal("Pumpkin", 23.5, "25/08/2019", 2, "B, C, A"));
        vegetalProducts.add(new Vegetal("Carrots", 20, "21/09/2019", 1, "B2, C, A"));
        vegetalProducts.add(new Vegetal("Onions", 15, "13/09/2019", 2, "C, A"));
        vegetalProducts.add(new Vegetal("Potatoes", 14.5, "04/09/2019", 2, "B, C"));

        ArrayList<Sales> salesList = new ArrayList<>();

        BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int choice;



        //repeat main menu until [4] Exit
        do {
            System.out.println("----------------------------------------");
            System.out.println("[1] Create a product and add it to stock\n" +
                    "[2] Sell product\n" +
                    "[3] Display daily sales report\n" +
                    "[4] Exit");
            System.out.println("----------------------------------------");
            int tempChoice = sc.nextInt();
            choice = tempChoice;

            //second menu (animal, vegetal)
            switch(choice) {

                case 1:
                    System.out.println("Product type\n" +
                            "----------------------------------------\n" +
                            "[1] Animal\n" +
                            "[2] Vegetal");
                    int secondChoice = sc.nextInt();

                    switch (secondChoice) {

                        case 1:
                            //adding new animal product values
                            System.out.println("Enter animal product: ");
                            String a1 = ob.readLine();
                            System.out.println("Enter price [eg. 23,6]: ");
                            double a2 = sc.nextDouble();
                            System.out.println("Enter expiration date [dd/mm/yyyy]: ");
                            String a3 = ob.readLine();
                            System.out.println("Enter weight in kilograms [eg. 35,5]: ");
                            double a4 = sc.nextDouble();
                            System.out.println("Enter storage temperature [eg. 7,6]: ");
                            double a5 = sc.nextDouble();

                            //creating the new animal product and adding it to the animal products list
                            animalProducts.add(new Animal(a1, a2, a3, a4, a5));
                            System.out.println("----------------------------------------");
                            System.out.println("Animal product added successfully!");
                            System.out.println("Press Enter to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            break;

                        case 2:
                            //adding new vegetal product values
                            System.out.println("Enter vegetal product: ");
                            String v1 = ob.readLine();
                            System.out.println("Enter price [eg. 4,5]: ");
                            double v2 = sc.nextDouble();
                            System.out.println("Enter expiration date [dd/mm/yyyy]: ");
                            String v3 = ob.readLine();
                            System.out.println("Enter weight in kilograms [eg. 5,9]: ");
                            double v4 = sc.nextDouble();
                            System.out.println("Enter vitamins [eg. A/B/B2 etc.]: ");
                            String v5 = ob.readLine();

                            //creating the new vegetal product and adding it to the vegetal products list
                            vegetalProducts.add(new Vegetal(v1, v2, v3, v4, v5));
                            System.out.println("----------------------------------------");
                            System.out.println("Vegetal product added successfully!");
                            System.out.println("Press Enter to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            break;
                        default:
                            System.out.println("Input Error! Press [Enter] to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            break;
                    } break;

                case 2:
                    System.out.println("Select the product type you want to sell:\n" +
                            "[1] Animal\n" +
                            "[2] Vegetal");
                    int thirdChoice = sc.nextInt();

                    //third menu for selling animal or vegetal products
                    switch (thirdChoice) {

                        case 1:
                            //animal product sale selection
                            System.out.println("Press [Enter] and select the animal product you want to sell from the list using [0] [1] [2] [3]...");
                            try{System.in.read();}
                            catch(Exception e){}
                            animalProducts.forEach(System.out::println);
                            int animalElement = sc.nextInt();

                            //recording the sale
                            salesList.add(new Sales(animalProducts.get(animalElement).getProduct(), animalProducts.get(animalElement).getPrice()));
                            String animalConfirmed = animalProducts.get(animalElement).getProduct();

                            //removing sold product from inventory
                            animalProducts.remove(animalElement);
                            System.out.println("You successfully sold the " + animalConfirmed + "! Press [Enter] to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            break;

                        case 2:
                            //vegetal product sale selection
                            System.out.println("Press [Enter] and select the vegetal product you want to sell from the list using [0] [1] [2] [3]...");
                            try{System.in.read();}
                            catch(Exception e){}
                            vegetalProducts.forEach(System.out::println);
                            int vegetalElement = sc.nextInt();

                            //recording the sale
                            salesList.add(new Sales(vegetalProducts.get(vegetalElement).getProduct(),vegetalProducts.get(vegetalElement).getPrice()));
                            String vegetalConfirmed = vegetalProducts.get(vegetalElement).getProduct();

                            //removing sold product from inventory
                            vegetalProducts.remove(vegetalElement);
                            System.out.println("You successfully sold the " + vegetalConfirmed + "! Press [Enter] to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            break;
                        default:
                            System.out.println("Input Error! Press [Enter] to continue...");
                            try{System.in.read();}
                            catch(Exception e){}
                            break;
                    }
                    break;

                case 3:
                    //checks if list is empty before proceeding
                    if (salesList.isEmpty()) {
                        System.out.println("You haven't sold anything today. Press Enter to continue...");
                        try{System.in.read();}
                        catch(Exception e){}

                        //totaling sales
                    } else {
                        double total = 0;
                        for(int i =0; i < salesList.size(); i++) {
                            total = total + salesList.get(i).getPrice();
                        }

                        //printing sale report
                        SimpleDateFormat t = new SimpleDateFormat("dd/MM/yyyy");
                        System.out.println("Daily sale report");
                        System.out.println("----------------------------------------");
                        salesList.forEach(System.out::println);
                        System.out.println("----------------------------------------");
                        System.out.println("Total: $" + total + "           Date: " + t.format(new Date()));
                        System.out.println("Press [Enter] to continue...");
                        try{System.in.read();}
                        catch(Exception e){}
                    }
                    break;

                case 4:
                    //quit program
                    vegetalProducts.forEach(System.out::println);
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Input Error! Press [Enter] to continue...");
                    try{System.in.read();}
                    catch(Exception e){}
                    break;
            }
        } while (choice !=4);
    }
}
