import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

class Product {
    private final String name;
    private final double price;
    private final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class ShoppingCartConfirmation extends JFrame {

    private final ArrayList<Product> cartItems;

    public ShoppingCartConfirmation(ArrayList<Product> cartItems) {
        this.cartItems = cartItems;

        setTitle("Order Confirmation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new GridLayout(cartItems.size() + 1, 2, 10, 5));
        cartPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        cartPanel.add(new JLabel("Product Name"));
        cartPanel.add(new JLabel("Price"));

        for (Product item : cartItems) {
            cartPanel.add(new JLabel(item.getName()));
            cartPanel.add(new JLabel(String.valueOf(item.getPrice())));
        }

        mainPanel.add(cartPanel, BorderLayout.CENTER);

        JButton confirmButton = new JButton("Confirm Order");
        confirmButton.addActionListener(e -> {
            double totalPrice = calculateTotal();
            JOptionPane.showMessageDialog(this, "Order Confirmed! Total Amount: $" + totalPrice);
            dispose(); // Close the window after confirmation
        });

        mainPanel.add(confirmButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private double calculateTotal() {
        double total = 0;
        for (Product item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public static void main(String[] args) {
        ArrayList<Product> cartItems = new ArrayList<>();
        cartItems.add(new Product("Product 1", 29.99, 2));
        cartItems.add(new Product("Product 2", 39.99, 1));
        // Add more items to the cart as needed

        SwingUtilities.invokeLater(() -> new ShoppingCartConfirmation(cartItems));
    }
}

