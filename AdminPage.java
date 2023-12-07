import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {

    public AdminPage() {
        setTitle("Admin Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        JLabel titleLabel = new JLabel("Admin Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(titleLabel);

        // Options Panel
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton manageUsersButton = new JButton("Manage Users");
        JButton manageProductsButton = new JButton("Manage Products");
        JButton viewLogsButton = new JButton("View Logs");
        

        manageUsersButton.addActionListener(e -> showInventory("Users Inventory"));
        manageProductsButton.addActionListener(e -> showInventory("Products Inventory"));
        viewLogsButton.addActionListener(e -> showInventory("Logs Inventory"));
        

        optionsPanel.add(manageUsersButton);
        optionsPanel.add(manageProductsButton);
        optionsPanel.add(viewLogsButton);
       

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(optionsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private void showInventory(String inventoryType) {
        // Simulating inventory details display with a message dialog
        String inventoryDetails = "Inventory Details for: " + inventoryType;
        if (inventoryType.equals("Users Inventory")) {
            inventoryDetails += "\n- Total Users: 100";
            inventoryDetails += "\n- Active Users: 80";
            inventoryDetails += "\n- Inactive Users: 20";
        } else if (inventoryType.equals("Products Inventory")) {
            inventoryDetails += "\n- Total Products: 50";
            inventoryDetails += "\n- Available Products: 40";
            inventoryDetails += "\n- Out of Stock: 10";
        } else if (inventoryType.equals("Logs Inventory")) {
            inventoryDetails += "\n- Log Entries: 500";
            inventoryDetails += "\n- Error Logs: 20";
            inventoryDetails += "\n- Information Logs: 480";
        } 

        JOptionPane.showMessageDialog(this, inventoryDetails, "Inventory Details", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminPage());
    }
}

