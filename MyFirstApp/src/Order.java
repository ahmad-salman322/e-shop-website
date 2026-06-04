import java.util.Date;

public class Order {

    Date dateTheOrder;
    private int numOrder;
    private static int counter = 100598;
    User applicant;
    private int totalPrice;
    private String purchases;
    //Database userThatOrder;

    public Date getDateTheOrder() {
        return this.dateTheOrder;
    }


    public Order(User applicant, Cart cart) {
        this.applicant = applicant;
        this.totalPrice = cart.getTotalPrice();
        purchases = cart.toString();
        this.numOrder = ++counter;
        this.dateTheOrder = new Date();
    }

    public int getNumOrder() {
        return this.numOrder;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }


    public String toString() {
        return "The date of order is:" + getDateTheOrder()
                + ",\nThe order delivery time is likely to be up to 5 working days." +
                "\nYour order number is: " + getNumOrder()
                + "\nPurchases :\n" + purchases
                + "\nThank you for purchasing. see you";
    }


}
