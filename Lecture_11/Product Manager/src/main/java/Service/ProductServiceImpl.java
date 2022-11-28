package Service;

import Model.Product;
import Model.ProductManager;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductManager productManager = new ProductManager();

    @Override
    public List<Product> findAll() {
        return productManager.getProducts();
    }

    @Override
    public void create(Product product) {
        productManager.getProducts().add(product);
    }

    @Override
    public Product findById(int id) {
        return productManager.getProducts().get(id);
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void delete(int id) {

    }
}
