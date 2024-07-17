import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class PurchasePanel extends JPanel {
    private Cart cart;
    private ShoppingCartApp app;
    private DefaultTableModel tableModel;

    public PurchasePanel(Cart cart, ShoppingCartApp app) {
        this.cart = cart;
        this.app = app;
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Purchase Summary", SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"Item Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable summaryTable = new JTable(tableModel);
        this.add(new JScrollPane(summaryTable), BorderLayout.CENTER);

        JButton confirmButton = new JButton("Buy Now");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Purchase confirmed!");
                cart.clear();
                app.showPanel("ItemListPanel");
            }
        });

        this.add(confirmButton, BorderLayout.SOUTH);

        updatePurchaseSummary();
    }

    public void updatePurchaseSummary() {
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