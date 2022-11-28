package service.impl;

import model.Category;
import model.Product;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private static ArrayList<Product> products;
    private static CategoryServiceImpl categoryService;
    private static Long INDEX;

    static {
        products = new ArrayList<>();
        categoryService = new CategoryServiceImpl();
        products.add(new Product(1L, "iPhone 14", 799D, 99, categoryService.findAll().get(0)));
        products.add(new Product(2L, "Macbook Air M1", 899D, 99, categoryService.findAll().get(2)));
        products.add(new Product(3L, "iPad Pro", 599D, 99, categoryService.findAll().get(1)));
        INDEX = products.get(products.size()-1).getId();
    }

    public CategoryServiceImpl getCategoryService() {
        return categoryService;
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            product.setId(++INDEX);
        }
        products.add(product);
    }

    @Override
    public void deleteById(Long id) {

    }
}
