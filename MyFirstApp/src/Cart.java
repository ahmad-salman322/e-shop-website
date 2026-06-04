import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.SplittableRandom;

public class Cart {
    // private User owner;
    protected HashMap<Product, Integer> cart;
    private int totalPrice;
    private String inTheCart;
    private Database data = new Database();

    public Cart() {
        this.totalPrice = 0;
        cart = new HashMap<>();
    }

    public HashMap<Product, Integer> cartInOrder() {
        return cart;
    }

    public void addToTheCart(Product product, int quantity) {
        cart.put(product, quantity);
    }

    public void updateQuantity(Product product, int quantity) {
        addToTheCart(product, quantity);
    }

    public void remooveProduct(int quantityRemove, Product product) {
        // while (quantityRemove < 1)
        //   System.out.println("Error");
//        if (quantityRemove < 1) {
//            System.out.println("Error");
//        }
//       else {
        cart.remove(product, quantityRemove);
        //      }
    }

    /// //////////    /////////////    /////////////    /////////////
    public int getTotalPrice() {
        int sum = 0;
        cart.forEach((product, quantity) -> {
            this.totalPrice += quantity * product.getPrice();
        });
        sum = this.totalPrice;
        this.totalPrice = 0;
        return sum;
    }

    public String toString() {
        this.inTheCart = "";
        cart.forEach((product, quantity) -> {
            this.inTheCart += product.toString() + "\nQuantity: " + quantity + "\nPrice this: " + (quantity * product.getPrice()) + "\n\n";
        });
        return this.inTheCart + "\nTotal price: " + getTotalPrice() + "\n";
    }

    //      public int x = 10, y = 20;

//    public void toDisplay(JPanel panel){
//        panel.removeAll();
//        panel.setLayout(new GridLayout(0, 3, 20, 20));  // 3 أعمدة، 20px مسافة
//
//        for (var entry : cart.entrySet()) {
//            Product product = entry.getKey();
//            int quantity = entry.getValue();
//
//            JPanel itemPanel = new JPanel(new BorderLayout());
//            itemPanel.setBackground(Color.white);
//
//            JLabel label = new JLabel(makeAnImage150x150(product.getPathImg()));
//            JTextArea textArea = new JTextArea(
//                    product.getNameOfProduct() +
//                            "\nQuantity: " + quantity +
//                            "\nPrice this: " + (quantity * product.getPrice())
//            );
//            textArea.setEditable(false);
//
//            itemPanel.add(label, BorderLayout.CENTER);
//            itemPanel.add(textArea, BorderLayout.SOUTH);
//
//            panel.add(itemPanel);
//        }
//
//        panel.revalidate();
//        panel.repaint();
//    }


//    public void toDisplay(JPanel panel) {
//        int[] p = {10, 20};
//        //String displyProductsInCart;
//        cart.forEach((product, quantity) -> {
//            //  JPanel panelH = new JPanel();
//           // panel.setBounds(p[0], p[1], 300, 300);
//            JLabel label = new JLabel(makeAnImage150x150(product.getPathImg()));
//            label.setBounds(p[0], p[1], 150, 150);
//            panel.add(label);
//            //panelH.add(label);
//
//            JTextArea textArea = new JTextArea(product.toString() + "\nQuantity: " + quantity + "\nPrice this: " + (quantity * product.getPrice()));
//            textArea.setBackground(Color.white);
//            textArea.setBounds(p[0], p[1] + 120, 300, 300);
//            panel.add(textArea);
//            //panelH.add(textArea);
//            //panel.add(label);
//            //frame.add(panel);
//            if (p[0] < 1000)
//                p[0] += 150;
//            if (p[0] >= 1000) {
//                p[0] = 10;
//                p[1] += 150;
//            }
//            //   panel.add(panelH);
//        });
//
//
//    }


  /*  public void toDisplay(JPanel panel) {
        int[] a = {10, 20};
        cart.forEach(((product, integer) -> {
            JLabel label = new JLabel(makeAnImage150x150(product.getPathImg()));
            label.setBounds(a[0], a[1], 150, 150);
            panel.add(label);
            if (a[0] <= 600)
                a[0] += 150;
            else {
                a[0] = 0;
                a[1] += 150;
            }

        }));


    }
*/

    public void toDisplay(JPanel panel) {
        panel.removeAll();
        panel.setLayout(new GridLayout(0, 3, 20, 20)); // 3 أعمدة

        for (var entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
            itemPanel.setBackground(Color.WHITE);

            JLabel imageLabel = new JLabel(makeAnImage150x150(product.getPathImg()));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            JTextArea info = new JTextArea(
                    product.getNameOfProduct() +
                            "\nQuantity: " + quantity +
                            "\nPrice: " + (quantity * product.getPrice()) + " $"
            );
            info.setEditable(false);
            info.setFont(new Font("Arial", Font.PLAIN, 14));
            info.setBackground(Color.WHITE);

            itemPanel.add(imageLabel);
            itemPanel.add(info);

            panel.add(itemPanel);
        }

        panel.revalidate();
        panel.repaint();
    }


    protected ImageIcon makeAnImage150x150(String path) {
        ImageIcon startIcon = new ImageIcon(getClass().getResource(path));
        Image img = startIcon.getImage();
        Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public boolean isEmpty() {
        return cart.size() == 0;
    }

    public void clearCart() {
        cart.clear();

    }

}