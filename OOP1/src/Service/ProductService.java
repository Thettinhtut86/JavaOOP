package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductService {
    private final List<Product> inventory = new ArrayList<>();

    public void addProduct(Product product){
        inventory.add(product);
        System.out.println("Product added:"+ product.getName());
    }
    public boolean updateProduct(int id,Product up){
        Optional<Product> productOpt = inventory.stream()
                .filter(product -> product.getId() == id).findFirst();

        if (productOpt.isPresent()){
            int index = inventory.indexOf(productOpt.get());
            inventory.set(index,up);
            System.out.println("Product updated: " + up.getName());
            return true;
        }
        System.out.println("Product is not found");
        return false;

    }
    public boolean deleteProduct(int id){
        boolean removed =  inventory.removeIf(product -> product.getId() == id);
        if (removed){
            System.out.println("Product is deleted");
        }else {
            System.out.println("Product "+inventory.get(id).getName()+" is not found");
        }
        return removed;
    }


    public Product searchProductByName(String name){
        return inventory.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Product searchProductById(int id){
        return inventory.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void displayInentory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is Empty");
        } else {
            inventory.forEach(Product::displayDetails );
        }
    }


}
