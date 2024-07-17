import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> items;
    public Cart(){
        items = new HashMap<>();
    }

    public void addItem(Item item, int quantity){
        if (items.containsKey(item)){
            items.put(item, items.get(item)+quantity);
        }else{
            items.put(item, quantity);
        }
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public Map<Item, Integer> getItems(){
        return new HashMap<>(items);
    }

    public double getTotalPrice(){
        double total = 0.0;
        for(Map.Entry<Item,Integer> entry : items.entrySet()){
            total += entry.getValue() * entry.getKey().getPrice();
        }
        return total;
    }

    public void clear(){
        items.clear();
    }
}
