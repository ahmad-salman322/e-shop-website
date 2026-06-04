import java.util.HashMap;

public class Database {
    HashMap<Integer, User> users;
    HashMap<Integer, Product> products;
    //   HashMap<Integer, Product> cart;

    Database() {
        users = new HashMap<>();
        products = new HashMap<>();
        //cart = new HashMap<>();
    }

    //add the user to the data base
    public void addUser(User user) {
        users.put(user.getID(), user);
    }

    //add the product to the data base
    public void addProduct(Product product) {
        products.put(product.getSerialNumber(), product);

    }


public Product getProduct(int serialNumberOfProduct){

      return products.get(serialNumberOfProduct);
}

//    public void addToTheCart(int quantity, Product product) {
//        cart.put(quantity, product);
//    }
}
