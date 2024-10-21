import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> stock;

    public Inventory() {
        stock = new HashMap<>();
    }

    public void addProduct(String productName, int quantity) {
            stock.put(productName, quantity);
    }

    public void incrementStock(String productName, int quantity) {
        int currentQuantity = stock.get(productName);
        stock.put(productName, currentQuantity + quantity);
    }

    public void removeProduct(String productName) {
        stock.remove(productName);
    }

    public void decrementStock(String productName, int quantity) {
        int currentQuantity = stock.get(productName);
        if(currentQuantity > 0)
            stock.put(productName, currentQuantity - quantity);
    }

    public int checkStock(String productName) {
        return stock.getOrDefault(productName, 0);
    }

    @Override
    public String toString() {

        String inventory = "";
        for (String product : stock.keySet()) {
            inventory += product + ": " + stock.get(product) + "\n";
        }
        return inventory;
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct("Gibson les paul", 5);
        inventory.addProduct("Fender Stratocaster", 3);
        inventory.addProduct("Fender Telecaster", 2);

        System.out.println(inventory.toString());

        inventory.incrementStock("Gibson les paul", 1);
        inventory.decrementStock("Fender Stratocaster", 1);
        System.out.println(inventory.toString());

        inventory.addProduct("Gibson les paul", 10);    // o produto não é duplicado, mas sim atualizado

        inventory.removeProduct("Fender Stratocaster");
        inventory.removeProduct("Fender Telecaster"); 

        System.out.println(inventory.toString());
    }
}
