import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Product {
    private final String name;
    private final double price;
    private final ImageIcon image;

    public Product(String name, double price, ImageIcon image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ImageIcon getImage() {
        return image;
    }
}

public class ShoppingCartPage extends JFrame {

    private final ArrayList<Product> products;
    private final DefaultListModel<String> cartModel;

    /**
     * 
     */
    public ShoppingCartPage() {
        this.products = new ArrayList<>();
        products.add(new Product("Product 1", 29.99, new ImageIcon("path/to/image1.jpg")));
        products.add(new Product("Product 2", 39.99, new ImageIcon("path/to/image2.jpg")));
        // Add more products as needed

        setTitle("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel productPanel = new JPanel(new GridLayout(products.size(), 2));
        for (Product product : products) {
            JButton addButton = new JButton("Add to Cart");
            addButton.addActionListener(new AddToCartListener(product));

            JLabel nameLabel = new JLabel(product.getName());
            JLabel imageLabel = new JLabel(product.getImage());
            
            productPanel.add(nameLabel);
            productPanel.add(imageLabel);
            productPanel.add(addButton);
        }

        cartModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartModel);
        JScrollPane cartScrollPane = new JScrollPane(cartList);

        mainPanel.add(productPanel, BorderLayout.CENTER);
        mainPanel.add(cartScrollPane, BorderLayout.EAST);

        add(mainPanel);
        setVisible(true);
    }

    private class AddToCartListener implements ActionListener {
        private final Product product;

        public AddToCartListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cartModel.addElement(product.getName() + " - $" + product.getPrice());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartPage());
    }
}

