import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemListPanel extends JPanel {
    private Cart cart;
    private ShoppingCartApp app;

    public ItemListPanel(Cart cart, ShoppingCartApp app) {
        this.cart = cart;
        this.app = app;
        this.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Item List", SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridLayout(0, 1));


        Item[] items = {
                new Item("Item 1", 10.00),
                new Item("Item 2", 18.50),
                new Item("Item 3", 20.00),
        };

        for (Item item : items) {
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel nameLabel = new JLabel(item.getName() + " - $" + item.getPrice());
            Integer[] quantities = {0, 1, 2, 3, 4, 5};
            JComboBox<Integer> quantityComboBox = new JComboBox<>(quantities);
            JButton addButton = new JButton("Add to Cart");

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int quantity = (Integer) quantityComboBox.getSelectedItem();
                    if (quantity > 0) {
                        cart.addItem(item, quantity);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a valid quantity");
                    }
                }
            });

            itemPanel.add(nameLabel);
            itemPanel.add(quantityComboBox);
            itemPanel.add(addButton);
            itemsPanel.add(itemPanel);
        }

        this.add(new JScrollPane(itemsPanel), BorderLayout.CENTER);

        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.showPanel("ShoppingCartPanel");
            }
        });

        this.add(viewCartButton, BorderLayout.SOUTH);
    }
}