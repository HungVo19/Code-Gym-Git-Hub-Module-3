package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductManager implements Serializable {
    private final ArrayList<Product> products;
    private final IOFile<Product> file;
    private final String filePath = "D:\\Code Gym\\Code-Gym-Git-Hub-Module-3\\Lecture_9\\JSTLandServletUpgradeVersion\\src\\main\\java\\Data\\ProductsList.txt";

    public ProductManager(){
        file = new IOFile<Product>();
        products = (ArrayList<Product>) file.readFromFile(filePath);
        resetStaticIndex();
    }

    public IOFile<Product> getFile() {
        return file;
    }

    public String getFilePath() {
        return filePath;
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

    private void resetStaticIndex() {
        if (!products.isEmpty()) {
            Product.INDEX = products.get(products.size() - 1).getId();
        }
    }
}
