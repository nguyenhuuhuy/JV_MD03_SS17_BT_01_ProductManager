package rikkei.academy.controller;

import rikkei.academy.model.Category;
import rikkei.academy.service.CategoryService;

import java.util.List;

public class CategoryController {
    CategoryService categoryService = new CategoryService();

    public List<Category>  getListCategory(){
        return categoryService.findAll();
    }
    public void createCategory(Category category){
        categoryService.save(category);
    }
    public Category detailCategory(int id){
        return categoryService.findById(id);
    }
    public void updateCategory(Category category){
        categoryService.save(category);
    }

    public void deleteCategory(int id){
        categoryService.deleteById(id);
    }
}
