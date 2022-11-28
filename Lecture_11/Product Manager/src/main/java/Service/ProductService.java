package Service;

import Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void delete(int id);
}
