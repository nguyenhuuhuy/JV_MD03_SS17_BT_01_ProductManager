package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.Category;

import java.util.List;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    List<Category> categoryList = categoryController.getListCategory();

    public void ShowListCategory() {
        for (Category element : categoryList) {
            System.out.println(element);
        }
        System.out.println("Nhập back để quay trở lại menu: ");
        String backManu = Config.scanner().nextLine();
        if (backManu.equalsIgnoreCase("back")) {
            new NavBar();
        }
    }

    public void fromCreateCategory() {
        while (true) {
            int id = 0;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập tên: ");
            String name = Config.scanner().nextLine();
            Category category = new Category(id, name);
            categoryController.createCategory(category);
            System.out.println("Thêm thành công !");
            System.out.println("Nhập back để quay trở lại menu: ");
            String backManu = Config.scanner().nextLine();
            if (backManu.equalsIgnoreCase("back")) {
                new NavBar();
                break;
            }
        }
    }

    public void updateCategory() {
        while (true) {
            System.out.println("Nhập id muốn sửa: ");
            int targetId = Config.scanner().nextInt();
            if (categoryController.detailCategory(targetId) == null) {
                System.out.println("id không hợp lệ");
            } else {
                System.out.println("Nhập tên muốn sửa: ");
                String newName = Config.scanner().nextLine();
                Category category = new Category(targetId, newName);
                categoryController.updateCategory(category);
                System.out.println("sửa thành công!");
                System.out.println("Nhập back để quay trở lại menu: ");
                String backManu = Config.scanner().nextLine();
                if (backManu.equalsIgnoreCase("back")) {
                    new NavBar();
                    break;
                }
            }
        }
    }

    public void deleteCategory() {
        while (true){
            System.out.println("Nhập sản phẩm muốn xóa theo id");
            int targetId = Config.scanner().nextInt();
            if (categoryController.detailCategory(targetId) == null) {
                System.out.println("id không hợp lệ.");
            } else {
                categoryController.deleteCategory(targetId);
                System.out.println("Nhập back để quay trở lại menu: ");
                String backManu = Config.scanner().nextLine();
                if (backManu.equalsIgnoreCase("back")) {
                    new NavBar();
                    break;
                }
            }
        }
    }
}
