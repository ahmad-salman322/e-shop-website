import javax.swing.*;

public class Product {
    private int serialNumber;
    private String nameOfProduct;
    private double price;
    private int stock;
    private String description;
    private String type;
    private String path;

    Database data = new Database();

    // new product
    public Product(int serialNumber, String nameOfProduct, int price, String description, String type,String path) {
        this.serialNumber = serialNumber;
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        this.description = description;
        this.type = type;
        this.path = path;
    }

    public String toString() {
        return "Serial Number:" + this.serialNumber +
                "\nName Of Product:" + this.nameOfProduct +
                "\nDescription: " + this.description;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPathImg() {
        return this.path;
    }
   public void setPathImg(String path){
        this.path = path;
   }
}
