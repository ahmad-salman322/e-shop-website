import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

//31/12/2025
import java.util.concurrent.TimeUnit;

public class GUI {

    User user;
    Database data = new Database();
    Cart cart = new Cart();
    private static JButton login;
    private static JLabel success;
    private static JButton order;
    private static JButton addToCart = new JButton();
    private static JButton menuButton = new JButton();
    private static JButton back = new JButton();
    private static JPanel cartPanel = new JPanel();
    private static JFrame store = new JFrame("Store");
    private static JFrame cartFrame = new JFrame("Cart");
    private static JButton validationButton = new JButton("Card Validation");

    private void buttons(JFrame startFrame, JFrame frame, JPanel panel, Product product) {

        ImageIcon backIcon = new ImageIcon(getClass().getResource("/arrow.png"));
        Image backS = backIcon.getImage();
        Image scaledBackToStore = backS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon backImg = new ImageIcon(scaledBackToStore);
        back.setIcon(backImg);
        back.setBounds(1400, 20, 100, 100);
        panel.add(back);

        if (startFrame.getTitle().equals("Laptops") || frame.getTitle().equals("Laptops") && (product.getType().equals("Laptops"))) {
            back.addActionListener(e -> {
                laptops();
            });
        } else if ((startFrame.getTitle().equals("Store")) && (product.getType().equals("Laptops"))) {
            back.addActionListener(e -> {
                laptops();
            });
        } else if (startFrame.getTitle().equals("Store")) {
            back.addActionListener(e -> {
                store();
            });
        } else if ((startFrame.getTitle().equals("Store")) && (frame.getTitle().equals("Phones"))) {
            back.addActionListener(e -> {
                phones();
            });
        } else if (frame.getTitle().equals("Laptops"))
            back.addActionListener(e -> {
                store();
            });
/////// ??????
        else
            back.addActionListener(e -> {
                store();
            });
    }

    /// ///////edit this  -=-=-=-=-=-=
    // addToCart img
    ImageIcon addToCartIcon = new ImageIcon(getClass().getResource("/add-to-cart.png"));
    Image addToCartS = addToCartIcon.getImage();
    Image scaledAddToCart = addToCartS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon addToCartIconImg = new ImageIcon(scaledAddToCart);

    //order Img
    ImageIcon orderIcon = new ImageIcon(getClass().getResource("/order-now.png"));
    Image orderS = orderIcon.getImage();
    Image scaledOrder = orderS.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
    ImageIcon orderImg = new ImageIcon(scaledOrder);

    protected void start() {
        // Create the main frame
        JFrame startFrame = new JFrame("Welcom to salZon");
        startFrame.setLayout(null);

        // Create the main panel (background container)
        JPanel startPanle = new JPanel();
        startPanle.setLayout(null);


        // Welcome text at the top
        JTextArea textArea = new JTextArea(
                "Hello and welcom to salZon store\n   Pleas enter your informion"
        );

        // Text area used as a label for the password field
        JTextArea pass = new JTextArea("Enter a strong password");

        JTextField ID = new JTextField();
        JTextField name = new JTextField();
        JPasswordField passwordField = new JPasswordField("");

        login = new JButton("LogIn");
        JLabel lo = new JLabel();

        ImageIcon icon = new ImageIcon(getClass().getResource("/salZon-logo-transparent.png"));
        startFrame.setIconImage(icon.getImage());

        ImageIcon loginLogo = new ImageIcon(getClass().getResource("/sign-in.png"));
        login.setIcon(loginLogo);

        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon startIcon = new ImageIcon(scaledImg);

        JLabel label = new JLabel(startIcon);
        label.setBounds(660, 50, 200, 200); // logo position

        // Frame settings
        startFrame.setSize(2500, 2500);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setVisible(true);

        // Panel settings (purple background)
        startFrame.add(startPanle);
        startPanle.setBounds(0, 0, 2500, 2500);
        startPanle.setBackground(new Color(30, 30, 46));
        startPanle.setVisible(true);

        startPanle.add(label);
        label.setVisible(true);

        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Serif", Font.PLAIN, 20));
        //        textArea.setBounds(200, 250, 400, 60);
        textArea.setBounds(660, 250, 400, 60);
        startPanle.add(textArea);

        pass.setEditable(false);
        pass.setOpaque(false);
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Serif", Font.PLAIN, 20));
        //        pass.setBounds(230, 430, 200, 30);
        pass.setBounds(660, 430, 200, 30);
        startPanle.add(pass);

        ID.setBounds(660, 380, 200, 20);
        startPanle.add(ID);
        ID.setVisible(true);

        name.setBounds(660, 410, 200, 20);
        startPanle.add(name);
        name.setVisible(true);

        passwordField.setBounds(660, 470, 200, 20);
        startPanle.add(passwordField);
        passwordField.setVisible(true);

        startPanle.add(login);
        login.setBounds(660, 500, 70, 30);

        login.addActionListener(e -> {
            int userId = Integer.parseInt(ID.getText().trim());
            String userName = name.getText();
            String userPass = new String(passwordField.getPassword());
            user = new User(userId, userName, userPass);
            success = new JLabel("");
            success.setBounds(680, 530, 300, 20);
            success.setForeground(Color.green);
            startPanle.add(success);
            if (user.getID() != 0 &&
                    user.getUserName() != null && !user.getUserName().isEmpty() &&
                    user.getPassword() != null && !user.getPassword().isEmpty()) {
                data.addUser(user);
                success.setText("Hello and welcome to salZon " + user.getUserName());

              // ?? 31/12/2025
                store();
            }
            JButton toStore = new JButton("toStore");
            startPanle.add(toStore);
            toStore.setBounds(660, 560, 100, 30);
            toStore.addActionListener(e1 -> {
                store();

//                try {
//                    TimeUnit.SECONDS.sleep(5);
//                } catch (InterruptedException ex) {
//                    throw new RuntimeException(ex);
//                }
                startFrame.dispose();

            });
        });


    }
    protected void store() {
        // Frame
//        JFrame store = new JFrame("Store");
        store.setLayout(new BorderLayout());
        store.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        store.setBounds(0, 0, 2500, 2500);

        // Icon cart
        ImageIcon cartIcon = new ImageIcon(getClass().getResource("/shopping-cart.png"));
        store.setIconImage(cartIcon.getImage());
        Image cartS = cartIcon.getImage();
        Image scaledCart = cartS.getScaledInstance(50, 50, 50);
        ImageIcon cartImg = new ImageIcon(scaledCart);

        // Panel
        JPanel storePanle = new JPanel();
        storePanle.setLayout(null);
        storePanle.setBackground(new Color(30, 30, 46));
        storePanle.setBounds(0, 0, 2500, 2500);

        /// **********Product***********   **********Product***********    ***********Product**********    ************Product*********   **********Product***********

        // Lenovo IdeaPad Slim 3
        addToScreen(lenovoIdeaPadSlim3, "/img.png", store, storePanle, 10, 220);

        // Asus Vivobook 15
        addToScreen(AsusVivobook15, "/asusVivobook.jpg", store, storePanle, 210, 220);

        // Apple MacBook Pro 14
        addToScreen(AppleMacBookPro14, "/Apple MacBook Pro 14.jpg", store, storePanle, 410, 220);

        // Asus TUF Gaming F15 (2023)
        addToScreen(AsusTUFGamingF15_2023, "/asusTUF.jpg", store, storePanle, 610, 220);

        // Samsung Galaxy S25 Ultra
        addToScreen(samsungS25Ultra, "/samsungS25Ultra150p.jpg", store, storePanle, 810, 220);

        // iPhone 16 Pro
        addToScreen(iPhone16Pro, "/iphone16pro.jpg", store, storePanle, 1010, 220);

        /// **********Product***********   **********Product***********    ***********Product**********    ************Product*********   **********Product***********

        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setSize(2500, 2500);

        // settings
        productPanel.setSize(2500, 2500);
        productPanel.setBackground(new Color(30, 30, 46));
        productPanel.setBounds(20, 20, 2500, 2500);

        // salZon logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/salZon-horizontal.png"));
        Image logoIcon = logo.getImage();
        Image scaled = logoIcon.getScaledInstance(1000, 170, Image.SCALE_SMOOTH);
        ImageIcon logoImg = new ImageIcon(scaled);

        JLabel logoLable = new JLabel(logoImg);
        logoLable.setLayout(null);
        logoLable.setBounds(250, 0, 1000, 200);

        productPanel.add(logoLable);

        // Cart button
        JButton cartButton = new JButton();
        cartButton.setBounds(10, 20, 100, 100);
        cartButton.setBorderPainted(false);
        cartButton.setFocusPainted(false);
        cartButton.setContentAreaFilled(false);
        cartButton.setIcon(makeAnImage100x100("/shopping-cart_c.png"));
        storePanle.add(cartButton);

        cartButton.addActionListener(e -> {
            store.dispose();
            cartFrame.setLayout(null);
            cartFrame.setVisible(true);
            cartFrame.setBounds(0, 0, 2500, 2500);

            // JPanel cartPanel = new JPanel();
            cartPanel.setLayout(null);
            cartPanel.setBounds(0, 0, 2500, 2500);
            cartPanel.setBackground(new Color(30, 30, 46));

            // button order
            JButton orderButton = new JButton("   Order   ");
            orderButton.setBackground(Color.YELLOW);
            orderButton.setForeground(Color.WHITE);
            orderButton.setFont(new Font("Arial", Font.PLAIN, 20));
            orderButton.setBounds(1200, 600, 300, 50);

            orderButton.addActionListener(e1 -> {
                order();
            });

            cartPanel.add(orderButton);


            //  cart.toDisplay(cartPanel);
            //  System.out.println(cart.toString());
            // cart.toDisplay(/*cartFrame,*/ cartPanel);
            cartFrame.add(cartPanel);


        });


        //menu
        menu(store, menuButton);

        storePanle.add(productPanel);
        store.add(storePanle, BorderLayout.CENTER);
        store.setVisible(true);
    }
    protected void phones() {
        JFrame phones = new JFrame("Phones");
        phones.setLayout(null);
        phones.setSize(2500, 2500);

        // Product Panle
        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setSize(2500, 2500);
        productPanel.setBackground(new Color(30, 30, 46));


        //----------------------------------------------------------------------------------------------------------------
        // Samsung Galaxy S25 Ultra
        addToScreen(samsungS25Ultra, "/samsungS25Ultra150p.jpg", phones, productPanel, 20, 20);

        // iPhone 16 Pro
        addToScreen(iPhone16Pro, "/iphone16pro.jpg", phones, productPanel, 240, 20);
        //----------------------------------------------------------------------------------------------------------------


        /// Buttons
        // back to phones button
        back.addActionListener(e -> {
            phones();
        });
        buttons(phones, phones, productPanel, general);

        phones.add(productPanel);
        phones.setVisible(true);
    }
    protected void laptops() {
        JFrame laptops = new JFrame("Laptops");
        laptops.setLayout(new BorderLayout());
        laptops.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        laptops.setBounds(0, 0, 2500, 2500);

        // Panel
        JPanel laptopsPanel = new JPanel();
        laptopsPanel.setLayout(null);
        laptopsPanel.setBackground(new Color(30, 30, 46));
        laptopsPanel.setBounds(0, 0, 2500, 2500);


        /// *********************   *********************    *********************    *********************   *********************  *********************   *********************
        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setSize(2500, 2500);

        //-----------------------------------------------------------------------------------------------------------------------------------------
        /// idepad
        addToScreen(lenovoIdeaPadSlim3, "/img.png", laptops, productPanel, 10, 20);
        //-----------------------------------------------------------------------------------------------------------------------------------------
        /// asusVivobook
        addToScreen(AsusVivobook15, "/asusVivobook.jpg", laptops, productPanel, 265, 20);
        //-----------------------------------------------------------------------------------------------------------------------------------------
        /// Apple
        addToScreen(AppleMacBookPro14, "/Apple MacBook Pro 14.jpg", laptops, productPanel, 550, 20);
        //-----------------------------------------------------------------------------------------------------------------------------------------
        ///  asusTUF 15
        addToScreen(AsusTUFGamingF15_2023, "/asusTUF.jpg", laptops, productPanel, 920, 20);
        // -------------------------------------------------------------------------------------------------------

        // settings
        productPanel.setSize(2500, 2500);
        productPanel.setBackground(new Color(30, 30, 46));
        productPanel.setBounds(20, 20, 2500, 2500);

        // back button
        buttons(laptops, laptops, laptopsPanel, lenovoIdeaPadSlim3);
        laptops.add(productPanel);
        laptops.add(laptopsPanel);
        laptops.setVisible(true);
    }
    private void order() {
        JFrame orderFrame = new JFrame("Order");
        orderFrame.setLayout(null);
        orderFrame.setBounds(500, 100, 300, 300);
        orderFrame.setVisible(true);

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(null);
        orderPanel.setBounds(0, 0, 300, 300);
        orderPanel.setBackground(new Color(30, 30, 46));

        JTextArea setOnlyVisaCard = new JTextArea("Plaes enter your detalis of Visa card");
        setOnlyVisaCard.setEditable(false);
        setOnlyVisaCard.setBackground(new Color(30, 30, 46));
        setOnlyVisaCard.setForeground(Color.WHITE);
        setOnlyVisaCard.setBounds(50, 10, 300, 20);

        JTextField numOfCard = new JTextField("XXXX XXXX XXXX XXXX");
        JTextField ccv = new JTextField("XXX");
        JTextField expCard = new JTextField("MM/YY");

        numOfCard.setBounds(50, 30, 200, 30);
        ccv.setBounds(50, 80, 100, 30);
        expCard.setBounds(160, 80, 90, 30);

        numOfCard.setForeground(Color.GRAY);
        numOfCard.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (numOfCard.getText().equals("XXXX XXXX XXXX XXXX")) {
                    numOfCard.setText("");
                    numOfCard.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (numOfCard.getText().isEmpty()) {
                    numOfCard.setForeground(Color.GRAY);
                    numOfCard.setText("XXXX XXXX XXXX XXXX");
                }
            }
        });

        // Placeholder: CCV
        ccv.setForeground(Color.GRAY);
        ccv.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (ccv.getText().equals("XXX")) {
                    ccv.setText("");
                    ccv.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (ccv.getText().isEmpty()) {
                    ccv.setForeground(Color.GRAY);
                    ccv.setText("XXX");
                }
            }
        });


        // Placeholder: Expiration Date
        expCard.setForeground(Color.GRAY);
        expCard.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (expCard.getText().equals("MM/YY")) {
                    expCard.setText("");
                    expCard.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (expCard.getText().isEmpty()) {
                    expCard.setForeground(Color.GRAY);
                    expCard.setText("MM/YY");
                }
            }


        });

        validationButton.setBounds(50, 120, 150, 10);
        orderPanel.add(validationButton);
        validationButton.addActionListener(e -> {
            if (isValid(numOfCard.getText())) {
                JTextArea vadidCard = new JTextArea("Is valid card");
                vadidCard.setEditable(false);
                vadidCard.setBackground(new Color(30, 30, 46));
                vadidCard.setForeground(Color.GREEN);
                vadidCard.setBounds(50, 200, 150, 30);
                orderPanel.add(vadidCard);
            } else {
                JTextArea vadidCard = new JTextArea("Is InValid card");
                vadidCard.setBounds(50, 200, 300, 30);
                vadidCard.setEditable(false);
                vadidCard.setBackground(new Color(30, 30, 46));
                vadidCard.setForeground(Color.RED);
                orderPanel.add(vadidCard);
            }
        });

        // orderPanel.add(validationButton);
        orderPanel.add(setOnlyVisaCard);
        orderPanel.add(numOfCard);
        orderPanel.add(ccv);
        orderPanel.add(expCard);

        orderFrame.add(orderPanel);
    }
    private static boolean isValid(String numOfCard) {
        int sum = 0;
        for (int end = numOfCard.length() - 1; end >= 0; end--) {
            int x = Integer.parseInt(String.valueOf(numOfCard.charAt(end)));
            if (end % 2 == 0) {
                if (x * 2 > 9)
                    sum += (x * 2 - 9);
                else
                    sum += (x * 2);
            } else
                sum += x;
        }

        if (sum % 10 == 0)
            return true;
        else
            return false;
    }
    protected JTextArea createDescription(String text) {
        JTextArea area = new JTextArea(text);
        area.setEditable(false);
        area.setForeground(Color.WHITE);
        area.setBackground(new Color(30, 30, 47));
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return area;
    }
    protected JPanel mangBuy(Product product, JPanel idepadPanel) {
        JPanel resPanel = new JPanel();
        addToCart.setBounds(1200, 600, 100, 100);
        addToCart.setBorderPainted(false);
        addToCart.setFocusPainted(false);
        addToCart.setContentAreaFilled(false);
        addToCart.setIcon(addToCartIconImg);
        idepadPanel.add(addToCart);

        addToCart.addActionListener(e1 -> {
            JFrame catrQ = new JFrame();
            catrQ.setLayout(null);
            catrQ.setBounds(1200, 200, 300, 300);
            catrQ.setVisible(true);
            JPanel cartQPanel = new JPanel();
            cartQPanel.setLayout(null);
            cartQPanel.setBounds(0, 0, 300, 300);
            cartQPanel.setBackground(new Color(30, 30, 46));

            JTextArea quantityText = new JTextArea("Enter the quantity that you need :");
            quantityText.setForeground(Color.WHITE);
            quantityText.setBounds(60, 5, 300, 20);
            quantityText.setBackground(new Color(30, 30, 46));
            quantityText.setEditable(false);
            JTextField getQuantity = new JTextField();
            getQuantity.setBounds(70, 29, 100, 20);
            cartQPanel.add(getQuantity);

            JButton submit = new JButton("OK");
            submit.setBounds(70, 60, 100, 30);
            cartQPanel.add(submit);

            submit.addActionListener(e2 -> {

                int quantity = 0;
                quantity = Integer.parseInt(getQuantity.getText().trim());
                System.out.println("Quantity entered: " + quantity);
                cart.addToTheCart(product, quantity);

                cart.toDisplay(cartPanel);
                //System.out.println(cart.toString());
            });


            cartQPanel.add(quantityText);
            cartQPanel.add(getQuantity);

            catrQ.add(cartQPanel);
        });


        return resPanel;
    }
    protected ImageIcon makeAnImage150x150(String path) {
        ImageIcon startIcon = new ImageIcon(getClass().getResource(path));
        Image img = startIcon.getImage();
        Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
    protected ImageIcon makeAnImage100x100(String path) {
        ImageIcon startIcon = new ImageIcon(getClass().getResource(path));
        Image img = startIcon.getImage();
        Image scaledImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
    protected void saveProducts() {
        data.addProduct(lenovoIdeaPadSlim3);
        data.addProduct(AsusVivobook15);
        data.addProduct(AppleMacBookPro14);
        data.addProduct(AsusTUFGamingF15_2023);
        data.addProduct(samsungS25Ultra);
        data.addProduct(iPhone16Pro);
    }
    protected void display(Product product, String path) {
        JFrame frame = new JFrame(product.getNameOfProduct());
        frame.setVisible(true);
        frame.setBounds(0, 0, 2500, 2500);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 30, 46));
        panel.setBounds(0, 0, 2500, 2500);

        JLabel label = new JLabel(makeAnImage150x150(path));
        label.setLayout(null);
        label.setBounds(1200, 250, 150, 150);
        panel.add(label);
        frame.add(panel);


        JTextArea description = createDescription(product.getDescription());
        JTextArea diteals = new JTextArea("Price " + product.getPrice() + " $" +
                " Or by installments " + product.getPrice() / 10 + " $ Every month for 10 months " +
                "\n////////////////////////////////////////////////////\n" +
                "//////////////////////////////////////////////////////////////////////////////\n" +
                "//////////////////////////////////////////////////////////////////////////////\n");


        description.setFont(new Font("Arial", Font.PLAIN, 15));
        description.setForeground(Color.WHITE);
        description.setBounds(1200, 410, 400, 250);

        diteals.setFont(new Font("Arial", Font.PLAIN, 15));
        diteals.setForeground(Color.WHITE);
        diteals.setBackground(new Color(30, 30, 46));
        diteals.setBounds(10, 300, 500, 500);
        diteals.setEditable(false);

        // buttons
        buttons(frame, frame, panel, product);

        // addToCart
        frame.add(mangBuy(product, panel));
        panel.add(diteals);
        panel.add(description);
    }
    protected void addToScreen(Product product, String path, JFrame frame, JPanel panel, int x, int y) {
        // JPanel resPanel = new JPanel();
        JLabel label = new JLabel();

        JButton button = new JButton();

        //button.setIcon(makeAnImage150x150(path));
        button.setBounds(x, y, 150, 150);

//        button.setBorderPainted(false);
//        button.setFocusPainted(false);
//        button.setContentAreaFilled(false);
        button.setIcon(makeAnImage150x150(path));

        panel.add(button);

        label.setBounds(x, y, 150, 150);

        JTextArea namePrice = new JTextArea(product.getNameOfProduct() + "\n             " + product.getPrice() + " $");
        namePrice.setFont(new Font("Arial", Font.PLAIN, 15));
        namePrice.setForeground(Color.WHITE);
        namePrice.setBackground(new Color(30, 30, 46));
        namePrice.setBounds(x, y + 160, 200, 50);
        namePrice.setEditable(false);

        panel.add(namePrice);
        frame.add(label);
        frame.add(panel);


        button.addActionListener(e -> {
            display(product, path);
            frame.dispose();

        });

    }
    protected void menu(JFrame frame, JButton menuButton) {
        // buttons

        menuButton.setBackground(Color.blue);
        menuButton.setVisible(true);
        ImageIcon menuIcon = new ImageIcon(getClass().getResource("/menu-burger - Copy (2).png"));
        Image buttonImage = menuIcon.getImage();
        Image scaledButton = buttonImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        menuButton.setIcon(new ImageIcon(scaledButton));
        menuButton.setBounds(1470, 20, 60, 60);
        menuButton.setVisible(true);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        menuButton.addActionListener(e -> {
            menuPanel.setVisible(true);
            frame.add(menuPanel);

            // menuPanel.setBounds(1330, 100, 210, 670);
            menuPanel.setBounds(1330, 80, 210, 700);
            menuPanel.setBackground(Color.WHITE);


            // phones
            JButton phone = new JButton();
            ImageIcon phoneIcon = new ImageIcon(getClass().getResource("/iphone.png"));
            Image phoneS = phoneIcon.getImage();
            Image scaledPhone = phoneS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon phoneImg = new ImageIcon(scaledPhone);
            phone.setIcon(phoneImg);
            menuPanel.add(phone);
            phone.setBounds(60, 20, 100, 100);
            phone.addActionListener(e1 -> {
                frame.dispose();
                phones();
            });

            // laptop
            JButton laptop = new JButton();
            ImageIcon laptopIcon = new ImageIcon(getClass().getResource("/laptop-screen.png"));
            Image laptopS = laptopIcon.getImage();
            Image scaledLaptop = laptopS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon laptopImg = new ImageIcon(scaledLaptop);
            laptop.setIcon(laptopImg);
            menuPanel.add(laptop);
            laptop.setBounds(60, 140, 100, 100);
            laptop.addActionListener(e1 -> {
                frame.dispose();
                laptops();
            });

            //pc
            JButton pc = new JButton();
            ImageIcon pcIcon = new ImageIcon(getClass().getResource("/pc.png"));
            Image pcS = pcIcon.getImage();
            Image scaledPc = pcS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon pcImg = new ImageIcon(scaledPc);
            pc.setIcon(pcImg);
            menuPanel.add(pc);
            pc.setBounds(60, 260, 100, 100);

            // headPhones
            JButton headPhones = new JButton();
            ImageIcon headIcon = new ImageIcon(getClass().getResource("/headphones.png"));
            Image headS = headIcon.getImage();
            Image scaledHeadPhones = headS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon headPhonesImg = new ImageIcon(scaledHeadPhones);
            headPhones.setIcon(headPhonesImg);
            menuPanel.add(headPhones);
            headPhones.setBounds(60, 380, 100, 100);

            // op
            JButton op = new JButton();
            ImageIcon opIcon = new ImageIcon(getClass().getResource("/op.png"));
            Image opS = opIcon.getImage();
            Image scaledOp = opS.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon opImg = new ImageIcon(scaledOp);
            op.setIcon(opImg);
            menuPanel.add(op);
            op.setBounds(60, 500, 100, 100);


            // LogOut
            JButton logOut = new JButton("logOut");
            logOut.setLayout(null);
            logOut.setBackground(Color.BLACK);
            logOut.setForeground(Color.RED);
            logOut.setBounds(10, 650, 180, 40);
            menuPanel.add(logOut);
            logOut.addActionListener(e1 -> {
                start();
            });

        });
        // menuPanel.add()
        frame.add(menuButton);
    }

    /*
     */

    //++++++++++++-----------**************xxxxxxxxxxxxx//++++++++++------------**************xxxxxxxxxxxxxxxxx++++++++++++-----------**************xxxxxxxxxxxxx
    //++++++++++++-----------**************xxxxxxxxxxxxx//++++++++++------------**************xxxxxxxxxxxxxxxxx++++++++++++-----------**************xxxxxxxxxxxxx

    Product lenovoIdeaPadSlim3 = new Product(000000, "Lenovo IdeaPad Slim 3", 663,
            "Lenovo 15.6\" FHD (1920x1080)\n" +
                    "Intel® Core™ i5-12450H\n" +
                    "8GB RAM\n" +
                    "256GB SSD\n" +
                    "663 $", "Laptop", "/img.png");

    Product AsusVivobook15 = new Product(000001, "Asus Vivobook 15", 940,
            "ASUS laptop with a 15.6''  screen,\n" +
                    "FHD resolution (1920x1080),\n" +
                    " AMD Ryzen™ 7 7730U processor,\n" +
                    " 16GB internal memory,\n" +
                    " 1TB SSD drive,\n" +
                    " and includes an operating system.\n" +
                    "940 $", "Laptop", "/asusVivobook.jpg");

    Product AppleMacBookPro14 = new Product(000002, "Apple MacBook Pro 14", 2037,
            "MacBook Pro computer with Standard " +
                    "\nGlass screen finish from Apple, with a 14''" +
                    "\nscreen, 10-core Apple M4 processor,\n " +
                    "10-core graphics accelerator,\n" +
                    " 512GB SSD storage drive,\n" +
                    "16GB internal RAM, Arabic/English keyboard\n" +
                    "and includes macOS operating system.\n" +
                    "2037 $", "Laptop", "/Apple MacBook Pro 14.jpg");
    Product AsusTUFGamingF15_2023 = new Product(000003, "Asus TUF Gaming F15", 1886, "ASUS gaming laptop with a 15.6'' screen,\n" +
            " FHD resolution (1920x1080), \n" +
            "Intel® Core™ i7-12700H processor,\n" +
            " NVIDIA® GeForce RTX™ 4070 8GB\n" +
            " graphics accelerator,\n" +
            " 16GB internal memory, 512GB SSD drive\n" +
            ", and no operating system.\n" +
            "1886 $", "Laptop", "/asusTUF.jpg");

    //----------------------------------------------------------------------------------------------------------------
    // Samsung Galaxy S25 Ultra
    Product samsungS25Ultra = new Product(000010, "Samsung Galaxy S25 Ultra", 1340, "The Galaxy S25 Ultra is here! An advanced\n" +
            " mobile phone from Samsung with\n" +
            " a 6.9'' screen, a rear/front\n" +
            " camera array, and support\n" +
            " for the fifth-generation 5G network.\n" +
            "1340 $", "Phone", "/samsungS25Ultra150p.jpg");
//----------------------------------------------------------------------------------------------------------------

    // iPhone 16 Pro
    Product iPhone16Pro = new Product(000020, "iPhone 16 Pro", 1381, "The powerful iPhone 16 Pro from Apple,\n" +
            " has a 6.3-inch Super Retina XDR screen,\n" +
            " with a facial recognition sensor a powerful A18 Pro main processor," +
            "\n three 48+48+12-megapixel rear cameras, a 12-megapixel selfie camera," +
            "\nwireless charging capability, and support for the fifth-generation 5G network. 1381 $", "Phone", "/iphone16pro.jpg");
    //----------------------------------------------------------------------------------------------------------------
    Product general = new Product(999999, "general", 9999999, "general", "general", "/iphone16pro.jpg");
    //----------------------------------------------------------------------------------------------------------------

}

