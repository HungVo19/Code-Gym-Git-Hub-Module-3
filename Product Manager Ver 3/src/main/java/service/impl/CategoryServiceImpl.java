package service.impl;

import model.Category;
import service.ICategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private static ArrayList<Category> categories;
    private static Long INDEX;

    static {
        categories = new ArrayList<>();
        categories.add(new Category(1L, "iPhone"));
        categories.add(new Category(2L, "iPad"));
        categories.add(new Category(3L, "Macbook"));
        INDEX = categories.get(categories.size()-1).getId();
    }

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public Category findById(Long id) {
        for (Category c : categories) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
