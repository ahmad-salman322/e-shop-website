//import java.util.HashMap;
//
//public class Admin {
//    private String adminName;
//    HashMap<Integer, Product> listProducts;
//    private String list;
//   // private int quantity;
//
//
//    public Admin() {
//        listProducts = new HashMap<>();
//    }
//
//    public void addProduct(Product product) {
//        listProducts.put(product.getSerialNumber(), product);
//    }
//
//    public void removeProdcut(Product product){
//        listProducts.remove(product);
//    }
//
//    public void updateQuantity(Product product, int quantity) {
//    product.setStock(quantity);
//    }
//
//    public void list(){
//
//        listProducts.forEach((product, quantity) -> {
//            this.list += product.toString() + "\nQuantity: " + quantity + "\n\n";
//        });
//    }
//
//}
