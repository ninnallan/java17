import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ShoppingCartPanel extends JPanel {
    private Cart cart;
    private ShoppingCartApp app;
    private DefaultTableModel tableModel;

    public ShoppingCartPanel(Cart cart, ShoppingCartApp app) {
        this.cart = cart;
        this.app = app;
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Shopping Cart", SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Item Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable cartTable = new JTable(tableModel);
        this.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Proceed to Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cart.getItems().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cart is empty. Add items to proceed.");
                } else {
                    app.showPanel("PurchasePanel");
                }
            }
        });

        this.add(checkoutButton, BorderLayout.SOUTH);

        updateCartItems();
    }

    public void updateCartItems() {
        tableModel.setRowCount(0);
        for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            tableModel.addRow(new Object[]{item.getName(), quantity, item.getPrice() * quantity});
        }

        JLabel totalLabel = new JLabel("Total: $" + cart.getTotalPrice(), SwingConstants.CENTER);
        this.add(totalLabel, BorderLayout.NORTH);
    }
}