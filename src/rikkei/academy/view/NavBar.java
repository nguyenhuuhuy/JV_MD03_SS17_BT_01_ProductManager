package rikkei.academy.view;

import rikkei.academy.config.Config;

public class NavBar {
    public NavBar() {
        System.out.println("******************************** CATEGORY MANAGE *********************************");
        System.out.println("1. Show List Category.");
        System.out.println("2. Create Category.");
        System.out.println("3. Update category.");
        System.out.println("4. Delete category.");
        int chooseManu = Config.scanner().nextInt();
        switch (chooseManu) {
            case 1:
                new CategoryView().ShowListCategory();
                break;
            case 2:
                new CategoryView().fromCreateCategory();
                break;
            case 3:
                new CategoryView().updateCategory();
                break;
            case 4:
                new CategoryView().deleteCategory();
                break;
        }
    }

    public static void main(String[] args) {
new NavBar();
    }
}
