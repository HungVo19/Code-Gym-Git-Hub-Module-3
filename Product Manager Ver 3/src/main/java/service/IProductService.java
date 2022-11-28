package service;

import model.Product;

import java.util.List;

public interface IProductService extends ICoreCRUDService<Product,Long>{
    List<Product> findByNameContaining (String name);
}
