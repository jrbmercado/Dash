import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Customer {
    private String fName;
    private String lName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int zipcode;
    private String email;
    private String username;
    private String password;
    private double accountBalance;

    private HashMap<String, Double> transactionHistory = new HashMap<String, Double>();

    public void addTransaction(String bridgeName, Double amountCharged) {
        transactionHistory.put(bridgeName, amountCharged);
        System.out.println("You crossed " + bridgeName + ". The toll charged to your account is $" + amountCharged);
    }

    public void getHistory() {
        Set set = transactionHistory.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("Bridge Crossed: " + mentry.getKey() + " & Amount Charged: $");
            System.out.println(mentry.getValue());
        }
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void addFunds(double amount) {
        setAccountBalance(accountBalance + amount);
    }

    public void subtractFunds(double amount) {
        setAccountBalance(accountBalance - amount);
    }

    private Payment creditCard;
    private Vehicle car;

    Customer(String fName, String lName, String address1, String address2, String city, String state, int zipcode,
            String email, String username, String password, Payment creditCard, Vehicle car) {
        setfName(fName);
        setlName(lName);
        setAddress1(address1);
        setAddress2(address2);
        setCity(city);
        setState(state);
        setZipcode(zipcode);
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setCreditCard(creditCard);
        setCar(car);
        setAccountBalance(0);

    }

    public void updateAddress(String address1, String address2, String city, String state, int zipcode) {
        setAddress1(address1);
        setAddress2(address2);
        setCity(city);
        setState(state);
        setZipcode(zipcode);
    }

    public void updatePassword(String password) {
        setPassword(password);
    }

    public void updateCard(String cardName, String cardNum, String expDate, String ccv) {
        this.creditCard = new Payment(cardName, cardNum, expDate, ccv);
    }

    public void updateCar(String make, String model, String color, int year, String lPlate) {
        this.car = new Vehicle(make, model, color, year, lPlate);
    }

    public Vehicle getCar() {
        return this.car;
    }

    public void setCar(Vehicle car) {
        this.car = car;
    }

    public Payment getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Payment creditCard) {
        this.creditCard = creditCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (validPassword(password)) {
            this.password = password;
        } else {
            this.password = "";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (validUsername(username)) {
            this.username = username;
        } else {
            this.username = "";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    // Checking the input string meets eligibility requirements to be a username
    public boolean validUsername(String username) {
        if (username.matches("[a-z0-9]+") && username.length() >= 6) {
            return true;
        }
        return false;
    }

    // Checking the input string meets eligibility requirements to be a password
    public boolean validPassword(String password) {
        if (password.length() >= 8 && password.matches("[a-zA-Z0-9]+@") || password.matches("[a-zA-Z0-9]+!")) {
            return true;
        }
        return false;
    }

    // Check if username already exists in a "database" (dictionary)
    public boolean duplicateUsername(String username, Dictionary<String, String> dictionary) {
        Enumeration<String> e = dictionary.keys();
        while (e.hasMoreElements()) {
            if (e.nextElement().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Prints customer info

    public void getAccountInfo() {
        System.out.println("-- Customer Info -- ");
        System.out.println("First name: " + this.fName);
        System.out.println("Last name: " + this.lName);
        System.out.println("Address 1: " + this.address1);
        System.out.println("Address 2: " + this.address2);
        System.out.println("Zipcode: " + this.zipcode);
        System.out.println("State: " + this.state);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
    }

    public void getCardInfo() {
        System.out.println("-- Credit Card Info -- \n" + this.creditCard.getInfo());
    }

    public void getCarInfo() {
        System.out.println("-- Vehicle Info -- \n" + this.car.getInfo());
    }

}
