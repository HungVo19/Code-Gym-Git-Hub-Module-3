package Model;

import java.util.ArrayList;

public class ProductManager {
    private final ArrayList<Product> products;


    public ProductManager(){
        products = new ArrayList<>();
        products.add(new Product("iPhone 14",799D,99));
        products.add(new Product("iPhone 14 Pro",999D,99));
        products.add(new Product("MacBook Air M1",999D,100));
        products.add(new Product("iPad Pro",799D,99));
        products.add(new Product("Apple Watch SE",249D,99));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int findIndexByID(int id) {
        int index = -1;
        for (int i = 0; i <products.size(); i++) {
            if (products.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }
}
