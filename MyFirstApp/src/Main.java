public class Main {

    public static void main(String[] args) {
//      GUI S = new GUI();
//      S.start();
        //  System.out.println();

//        //////////  /// Admin
//
//        Database data = new Database();
//        Queue queue = new Queue();

//        /User
//
//        User user = new User(123456789, "Ahmad Salman", "password");
//        // queue mangmint
//        //queue.enQueue(user);
//        // add to the data base
//        //  data.addUser(user);
//
//        // System.out.println(data.users.get(123456789) + "\n");
//        // System.out.println(user.toString());
//
//
//
//         /*get & set*\
//
////        System.out.println(user.getID());
////        System.out.println(user.getPassword());
////        System.out.println(user.getUserName());
////        // set
////        user.setID(987654321);
////        user.setPassword("pass");
////        user.setUserName("Ahmad");
////        System.out.println(user.getID());
////        System.out.println(user.getPassword());
////        System.out.println(user.getUserName());
//
//
//        ///  Queue
//       /* Queue q = new Queue();
//        System.out.println(q.isEmpty());
//        q.enQueue(user);
//        System.out.println(q.isEmpty());
//        System.out.println(q.peek().toString());
//        q.deQueue();
//        System.out.println(q.isEmpty());
//        System.out.println(q.getSize());
//    */
//
//        /// Product
//        Product product = new Product(123, "Laptop", 1500, "16gr, 1T...");
//        Product product1 = new Product(1234, "Pc", 1200, "Rtx 4060, 16gr.....");
//        data.addProduct(product);
//        //  product.toString();
//        //  System.out.println(data.products.get(123));
//        ///  Cart
//        Cart cart = new Cart();
////
//        cart.addToTheCart(product, 2);
//        // System.out.println(cart.toString());
//        //System.out.println("\n");
//
//        cart.addToTheCart(product1, 1);
//        //System.out.println(cart.toString());
//        //System.out.println("\n\n");
//
//        //cart.remooveProduct(1, product1);
//        //System.out.println("\n\n");
//        //System.out.println(cart.toString());
//
//        //cart.updateQuantity(product,3);
//        //System.out.println(cart.toString());
//        // System.out.println();
//        //cart.updateQuantity(product, 1);
//        //System.out.println(cart.toString());
//
//        //System.out.println(cart.isEmpty());
//
//        // cart.clearCart();
//        // System.out.println(cart.isEmpty());
//
//        ///  Order
//        //Order order = new Order(user,cart);
//        // System.out.println(order.toString());
//        //System.out.println(order.toString());
//        //cart.clearCart();
//
//        /// Admin
////        System.out.println("ll");
////        Admin admin = new Admin();
////        admin.addProduct(product);
////        admin.list();
//
//        Product lenovoIdeaPadSlim3 = new Product(000000, "Lenovo IdeaPad Slim 3", 2199,
//                "Lenovo 15.6\" FHD (1920x1080)\n" +
//                        "Intel® Core™ i5-12450H\n" +
//                        "8GB RAM\n" +
//                        "256GB SSD");
//
        GUI start = new GUI();
        start.start();
////

//        GUI store = new GUI();
//        store.store();

//        GUI phones = new GUI();
//        phones.phones();

//        GUI laptops = new GUI();
//        laptops.laptops();

    }



}



/*
* 🛒 مشروع: نظام متجر إلكتروني (E-Commerce System) مصغر
💡 الفكرة

برنامج جافا (Java) مع واجهة رسومية (Swing) يحاكي متجر إلكتروني بسيط.
المستخدم يقدر يتصفح المنتجات، يضيفها إلى سلة (Cart)، يحسب السعر الكلي ويعمل طلب (Order).
المدير (Admin) يقدر يضيف منتجات جديدة، يعدل عليها أو يحذفها.

🎯 الأهداف

تدريبك على OOP Design (Class لكل كائن: User, Product, Order).

استخدام GUI (Swing) لعرض المنتجات والسلة.

ربط الواجهة بالمنطق الداخلي (Business Logic).

تخزين البيانات (ملف نصي أو قاعدة بيانات SQLite).

👤 المستخدمين

Admin

تسجيل الدخول بحساب خاص.

إدارة المنتجات (إضافة، تعديل، حذف).

عرض جميع الطلبات.

Customer (مستخدم عادي)

تسجيل الدخول أو إنشاء حساب.

تصفح المنتجات.

إضافة منتجات للسلة (Cart).

إنهاء الشراء (Place Order).

⚙ المكونات (Classes أساسية)
////////////
User → (id, username, password, role)

Product → (id, name, description, price, stock)

Cart → (list of products, totalPrice)

Order → (id, user, list of products, totalPrice, date)

StoreManager → (CRUD على المنتجات + الطلبات)


///////////
 */



/*🖥 الواجهات الرسومية (GUI)

Login/Register Window

دخول مستخدم أو مدير.

Customer Window

قائمة المنتجات (JTable).

زر "Add to Cart".

سلة شراء (مع السعر الكلي).

زر "Place Order".

Admin Window

لوحة إدارة المنتجات (Add/Edit/Delete).

قائمة الطلبات المنجزة.

✨ ميزات إضافية ممكن تضيفها

حفظ المنتجات والطلبات في ملف نصي أو SQLite.

البحث عن منتج بالاسم أو السعر.

فرز المنتجات (حسب السعر أو الاسم).

إضافة صور للمنتجات باستخدام ImageIcon.

توليد تقرير (CSV/Excel).

🔑 هيك عندك فكرة مشروع واضحة، مش بس "تطبيق متجر"، وإنما mini-system صغير كامل فيه:

Users

Products

Orders

GUI + Persistence
* */