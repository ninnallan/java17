import javax.swing.*;
import java.awt.*;

public class ShoppingCartApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private Cart cart;

    public ShoppingCartApp() {
        cart = new Cart();
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        ItemListPanel itemListPanel = new ItemListPanel(cart, this);
        ShoppingCartPanel shoppingCartPanel = new ShoppingCartPanel(cart, this);
        PurchasePanel purchasePanel = new PurchasePanel(cart, this);

        mainPanel.add(itemListPanel, "ItemListPanel");
        mainPanel.add(shoppingCartPanel, "ShoppingCartPanel");
        mainPanel.add(purchasePanel, "PurchasePanel");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.add(mainPanel);
        this.setVisible(true);

        cardLayout.show(mainPanel, "ItemListPanel");
    }

    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCartApp());
    }
}