package Customer;

public class Customer {
    /**
     * Class fields for storing customer information
     */
    private int id;
    private String secondName;
    private String firstName;
    private String middleName;
    private String address;
    private int age;
    private String numberCreditCarts;
    private int balance;

    /**
     * Constructor for initializing class objects
     * @param id
     * @param secondName
     * @param firstName
     * @param middleName
     * @param address
     * @param age
     * @param numberCreditCarts
     * @param balance
     */
    public Customer(int id, String secondName, String firstName, String middleName, String address, int age, String numberCreditCarts, int balance) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.age = age;
        this.numberCreditCarts = numberCreditCarts;
        this.balance = balance;
    }

    /**
     *  Getters and setters for each field
     */
    //getter/setter for ID

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    //getter/setter for SeconName

    public String getSecondName() {
        return secondName;

    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    //getter/setter for FirstName

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //getter/setter for Middle Name
    public String getMiddleName() {
        return middleName;

    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    //getter/setter for Address

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    //getter/setter for Age

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //getter/setter for Credit

    public String getNumberCreditCarts() {
        return numberCreditCarts;
    }
    public void setNumberCreditCarts(String numberCreditCarts) {
        this.numberCreditCarts = numberCreditCarts;
    }


    //getter/setter for Balance

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * The toString method for displaying customer information
     * @return
     */
    public String toString() {
        return "Customer ID: " + id +
                "\n Name: " + firstName + " " + secondName + " " + middleName +
                "\n Address: [ " + address + " ]" +
                " Age | " + age +
                " |\n CreditNumber: { " + numberCreditCarts +
                " } Balance: | " + balance + " |\n";
    }

    /**
     * Method to search for a customer by name
     * @param name
     * @return
     */
    public boolean printForName(String name){
        if(name == null){
            return false;
        }
        if(name.equalsIgnoreCase(getFirstName())){
            return true;
        }
        return false;
    }

    /**
     *  Method for finding customers in the balance range
     * @param from
     * @param to
     * @return
     */
    public boolean printRange(int from, int to){
        if(from >= to){
            return false;
        }
        if(from <= getBalance() && to >= getBalance()){
            return true;
        }
        return false;

    }

    /**
     * Method for withdrawing customers with debts
     * @param customers
     */
    public static void DebtonCreditCart(Customer[] customers) {
        int count = 0;
        for(int i = 0; i < customers.length; i++){
            if(customers[i].getBalance() < 0){
                System.out.println(customers[i]);
                count++;
            }
        }
        System.out.println("People who have Credits: | " + count + " |");
    }



}
