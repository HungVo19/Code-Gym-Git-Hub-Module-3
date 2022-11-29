package service.impl;

import model.Category;
import model.Product;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        INDEX = products.get(products.size() - 1).getId();
    }

    public CategoryServiceImpl getCategoryService() {
        return categoryService;
    }

    @Override
    public ArrayList<Product> findByNameContaining(String name) {
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                searchedProducts.add(p);
            }
        }
        return searchedProducts;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
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
        products.remove(findById(id));
    }
}
