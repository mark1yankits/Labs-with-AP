package Main;

import Customer.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         *  create an array of objects of class type
         *  and use the Customer constructor to fill our array
         */
        Customer[] customer  = new Customer[]{
                new Customer(1, "Kits", "Markiyan", "Romanovich", "Lviv.obl",  18, "1234 1234 1234 1234", 80000),
                new Customer(2, "Vivchar", "Olecsandr", "Ivanovich", "Ternopil",  17, "3456 4321 5000 0036", -12000),
                new Customer(3, "Zubach", "Ruslan", "Igorovich", "Lviv",  18, "0004 0056 7345 0045", 450000),
                new Customer(4, "Verechinskiy", "Nazar", "Romanovich", "Lviv.",  18, "4566 6665 4545 1111", 1200456),
                new Customer(5, "Veremchuk", "Taras", "Romanovich", "Rivne",  18, "0101 4615 6700 0312", -20000),
                new Customer(6, "Stachichin", "Yura", "Yaroslavovich", "Novo-Volinsk",  18, "4501 4615 8701 0312", 89000),
                new Customer(7, "Borovets", "Mikola", "Yuriyovich", "Rasne-2",  17, "5677  0054  0000  0001", 126000),
                new Customer(8, "Zivoronko", "Roman", "Igorovich", "Lviv",  18, "0009 1111 2343 5565", -200900),
                new Customer(9, "Bevz", "Evgeniy", "Victorovich", "Uman",  20, "6677  1154  2323  0401", 155000),
                new Customer(10, "Okilka", "Marta", "Yuriyvna", "Lviv",  18, "4545 5454 4431 1112", 203400),

        };
        /**
         * declaration of the String variable to give the user
         * a choice whether he wants to see the entire Client database
         *
         */
        String choice;
        System.out.println("if you want cheack all list write Y or no any key: \n");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextLine();

        /**
         *If the user selected “Y”, we display the full list of customers
         */
        if(choice.equalsIgnoreCase("y")|| choice.equalsIgnoreCase("Y")) {
            for(int i =0; i< customer.length;i++){
                System.out.println(customer[i].toString());
            }
        }
        /**
         * Request a name to search for clients in the client system
         * and check for correctness of the name
         */
        String nameSearch;
        System.out.println("Enter name for searching in Banking systems:");
        Scanner scan = new Scanner(System.in);
        nameSearch = scan.nextLine();
        if(nameSearch== null || nameSearch.isEmpty() || nameSearch.matches("\\d+")) {
            System.out.println("Invalid range\n");
        }else {
            System.out.println("\nName for Searching in Banking system \n" + nameSearch);
        }
        /**
         * Search for customers by name
         */
        for(int i= 0 ; i< customer.length;i++){
            if(customer[i].printForName(nameSearch)){
                System.out.println(customer[i].toString());
            }
        };

        /**
         * Ask the user for the range to search by balance
         */

        System.out.println("\nEnter data to search in a range:\n");
        int startWith;
        int endWith;
        System.out.println("Enter start with: ");
        startWith = scan.nextInt();
        System.out.println("Enter end with: ");
        endWith = scan.nextInt();

        System.out.println("\n");
        // Print the entered range
        System.out.println(startWith + " <= " + "Range " + " <= "+ endWith);
        /**
         * Search for customers with a balance within a specified range
         */
        for(int i =0; i< customer.length;i++){
            if(customer[i].printRange(startWith,endWith)){
                System.out.println(customer[i].toString());
            }
        }
        System.out.println("\n");

        /**
         * We withdraw customers who have debts
         */
        System.out.println("\nPeople who  have  credit  on owner Bank cart: \n");

        Customer.DebtonCreditCart(customer);
    }
}
