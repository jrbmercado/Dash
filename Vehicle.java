public class Vehicle {
    private String make;
    private String model;
    private String color;
    private int year;
    private String lPlate;

    Vehicle(String make, String model, String color, int year, String lPlate) {
        setMake(make);
        setModel(model);
        setColor(color);
        setYear(year);
        setLPlate(lPlate);
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLPlate() {
        return this.lPlate;
    }

    public void setLPlate(String lPlate) {
        this.lPlate = lPlate;
    }

    public String getInfo() {
        String x = "Make: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year
                + "\nColor: " + this.color + "\nLicense Plate: " + this.lPlate;
        return x;
    }

}
