import java.security.PKCS12Attribute;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Interface {

    // Holds username and Customer object pairs
    private static HashMap<String, Customer> customers = new HashMap<>();

    private static void fillCustomers() {
        String username1 = "bpatel";
        Payment p1 = new Payment("VISA", "4024007101486826", "042023", "728");
        Vehicle car1 = new Vehicle("Toyota", "Carolla", "Black", 2012, "6TRJ244");
        Customer c1 = new Customer("Bhumi", "Patel", "123 Heart St.", "Apt 2", "Hayward", "CA", 19234,
                "bhumi@gmail.com", username1, "Welcome1!", p1, car1);
        customers.put(username1, c1);

        String username2 = "jrbmercado";
        Payment p2 = new Payment("AMEX", "344922649319381", "062025", "902");
        Vehicle car2 = new Vehicle("Honda", "CRV", "Grey", 2009, "6LIK274");
        Customer c2 = new Customer("Justin", "Mercado", "450 Diamond St.", "", "San Jose", "CA", 95113,
                "justinreianmercado@gmail.com", username2, "Welcome1!", p2, car2);
        customers.put(username2, c2);
    }

    // Deletes a username and Customer object pair from the database
    private static void deleteCustomer(String userName) {
        if (customers.containsKey(userName)) {
            customers.remove(userName);
        }
    }

    private static void simulateCharge(Customer c1) {
        int bridgeNum = (int) (Math.random() * ((7 - 1) + 1) + 1);
        String location = "";
        double farePrice = 0.0;

        if (bridgeNum == 1) {
            location = "ANT";
            farePrice = 7.0;
        } else if (bridgeNum == 2) {
            location = "BEN";
            farePrice = 6.0;
        } else if (bridgeNum == 3) {
            location = "CAR";
            farePrice = 2.0;
        } else if (bridgeNum == 4) {
            location = "DUM";
            farePrice = 10.0;
        } else if (bridgeNum == 5) {
            location = "RIC";
            farePrice = 2.0;
        } else if (bridgeNum == 6) {
            location = "SFO";
            farePrice = 5.0;
        } else if (bridgeNum == 7) {
            location = "SMH";
            farePrice = 8.0;
        } else {
            location = "ERR";
            farePrice = 0.0;
        }

        c1.subtractFunds(farePrice);
        Double d1 = new Double(farePrice);
        c1.addTransaction(location, d1);

    }

    public static boolean login(String username, String password) {
        Customer tempCustomer;
        if (customers.containsKey(username)) {
            tempCustomer = customers.get(username);
            if (tempCustomer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // Fill a dummy dictionary to simulate database of usernames and customer
        // objects
        fillCustomers();

        String username = "";
        String password = "";

        Scanner myInput = new Scanner(System.in);
        int choice;
        boolean tryAgain = true;
        System.out.println();
        System.out.println("Welcome to DASH, a faster way to pay bridge tolls");

        // Login Menu
        while (tryAgain) {
            System.out.println();
            System.out.println("Please select an option: ");
            System.out.println();
            System.out.println("1 - Login");
            System.out.println("2 - Sign Up");
            System.out.println("0 - Exit");
            System.out.println();
            choice = myInput.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Username: ");
                    username = myInput.next();
                    System.out.print("Password: ");
                    password = myInput.next();
                    System.out.println();

                    Boolean knowsLogin = login(username, password);
                    if (knowsLogin) {
                        tryAgain = false;
                        break;
                    } else {
                        System.out.println("Try again, password or username incorrect");
                        break;
                    }
                case 2:
                    System.out.println("Sign up feature to be implimented");
                    tryAgain = false;
                    break;
                case 0:
                    System.out.println("Exiting...");
                    tryAgain = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }

        int choice1;
        Customer currentUser = customers.get(username);
        System.out.println("Hello " + currentUser.getfName() + " " + currentUser.getlName());
        tryAgain = true;

        while (tryAgain) {
            System.out.println();
            System.out.println("Please select an option: ");
            System.out.println();

            System.out.println("1 - View Account Info ");
            System.out.println("2 - Edit Address Info ");

            System.out.println();

            System.out.println("3 - View Vehicle Info ");
            System.out.println("4 - Edit Vehicle Info ");

            System.out.println();

            System.out.println("5 - Add funds ");
            System.out.println("6 - View Payment Info ");
            System.out.println("7 - Edit Card Info ");
            System.out.println("8 - Check Account Balance ");

            System.out.println();

            System.out.println("9 - Simulate Transaction ");
            System.out.println("10 - See Transaction History ");
            System.out.println();

            System.out.println("11 - Logout ");
            choice1 = myInput.nextInt();

            // TODO: USE FUNCTIONS AND MAKE IT PRETTY, THEN SEND IT OUT TO GITHUB
            switch (choice1) {
                // View Account Info
                case 1:
                    currentUser.getAccountInfo();
                    break;
                // Edit Address Info
                case 2:
                    String address1;
                    String address2;
                    String city;
                    String state;
                    int zipcode;

                    myInput.useDelimiter(System.lineSeparator());

                    System.out.println("Address 1: ");
                    address1 = myInput.next();

                    System.out.println("Address 2: ");
                    address2 = myInput.next();

                    System.out.println("City: ");
                    city = myInput.next();

                    System.out.println("State: ");
                    state = myInput.next();

                    System.out.println("Zip: ");
                    zipcode = myInput.nextInt();

                    currentUser.updateAddress(address1, address2, city, state, zipcode);
                    System.out.println("Successfully updated address");
                    break;
                // View Vehicle Info
                case 3:
                    currentUser.getCarInfo();
                    break;
                // Edit Vehicle Info
                case 4:
                    String make;
                    String model;
                    int year;
                    String color;
                    String lPlate;

                    myInput.useDelimiter(System.lineSeparator());

                    System.out.println("Make: ");
                    make = myInput.next();

                    System.out.println("Model: ");
                    model = myInput.next();

                    System.out.println("Color: ");
                    color = myInput.next();

                    System.out.println("License Plate: ");
                    lPlate = myInput.next();

                    System.out.println("Year: ");
                    year = myInput.nextInt();

                    currentUser.updateCar(make, model, color, year, lPlate);
                    System.out.println("Successfully updated car info");
                    break;
                // Add funds
                case 5:
                    double amount;
                    myInput.useDelimiter(System.lineSeparator());
                    System.out.println("Amount to add: ");
                    amount = myInput.nextDouble();
                    currentUser.addFunds(amount);
                    System.out.println("Successfully added funds");
                    break;
                // View payment info
                case 6:
                    currentUser.getCardInfo();
                    break;
                // Edit payment info
                case 7:
                    String cardName;
                    String cardNum;
                    String expDate;
                    String ccv;

                    myInput.useDelimiter(System.lineSeparator());

                    System.out.println("Card Name: ");
                    cardName = myInput.next();

                    System.out.println("Card Number: ");
                    cardNum = myInput.next();

                    System.out.println("Exp Date: ");
                    expDate = myInput.next();

                    System.out.println("CCV: ");
                    ccv = myInput.next();

                    currentUser.updateCard(cardName, cardNum, expDate, ccv);
                    System.out.println("Successfully updated card info");
                    break;
                // Check account balance
                case 8:
                    System.out.println("Account balance: " + currentUser.getAccountBalance());
                    break;
                // Simulate Transaction
                case 9:
                    simulateCharge(currentUser);
                    break;
                // See transaction history
                case 10:
                    currentUser.getHistory();
                    break;
                case 11:
                    System.out.println("Logging out...");
                    tryAgain = false;
                    break;
                default:
                    System.out.println("Wrong input, please try again");
            }
        }
    }
}
