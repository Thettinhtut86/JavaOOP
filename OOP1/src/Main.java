import Model.Electronic;
import Model.Grocery;
import Model.Product;
import Service.ProductService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n=== Inventory Management ===");
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Grocery");
            System.out.println("3. View Inventory");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Search Product");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Electronics Product Adding Page!");

                    int eId = readInt(scanner, "Enter Your Product ID: ", "Invalid Product ID. Please enter a valid number.");
                    scanner.nextLine();

                    String eName = readNonEmptyString(scanner, "Enter Your Product Name: ", "Product name cannot be empty.");

                    double ePrice = readDouble(scanner, "Enter Your Product Price: ","Invalid price. Please enter a valid number.");

                    int eQuantity =  readInt(scanner, "Enter Product quantity: ", "Invalid quantity. Please enter a valid number.");

                    int  warranty = readInt(scanner, "Enter Warranty Period (months): ", "Invalid warranty period. Please enter a valid number.");
                    productService.addProduct(new Electronic(eId,eName,ePrice,eQuantity,warranty));
                    break;

                case 2:
                    System.out.println("Grocery Product Adding Page!");

                    int gId =readInt(scanner, "Enter Your Product ID: ", "Invalid Product ID. Please enter a valid number.");
                    scanner.nextLine();

                    String gName = readNonEmptyString(scanner, "Enter Your Product Name: ", "Product name cannot be empty.");

                    double gPrice = readDouble(scanner, "Enter Your Product Price: ","Invalid price. Please enter a valid number.");

                    int gQuantity = readInt(scanner, "Enter Product quantity: ", "Invalid quantity. Please enter a valid number.");

                    String epDate = readNonEmptyString(scanner,"Enter Product Expiration Date","Invalid Date. Please enter valid Date.");
                    productService.addProduct(new Grocery(gId,gName,gPrice,gQuantity,epDate));
                    break;
                case 3:
                    productService.displayInentory();
                    break;
                case 4:
                    System.out.println("Product Update Page!");

                    System.out.print("Enter the ID of the product to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    Product existProduct = productService.searchProductById(updateId);

                    if (existProduct == null) {
                        System.out.println("Product not found with ID: " + updateId);
                        System.out.println("Returning to the main menu...");
                        break;
                    }

                    System.out.print("Enter Product new Name: ");
                    String udName = scanner.nextLine();
                    System.out.print("Enter Product new Price: ");
                    double udPrice = scanner.nextDouble();
                    System.out.print("Enter Product new Quantity: ");
                    int udQuantity = scanner.nextInt();
                    scanner.nextLine();

                    Product udProduct ;
                    if (existProduct instanceof Electronic){
                        System.out.print("Enter New Warranty Period(months): ");
                        int udwarranty = scanner.nextInt();
                        udProduct = new Electronic(updateId,udName,udPrice,udQuantity,udwarranty);
                    }else if (existProduct instanceof Grocery) {
                        System.out.print("Enter new expiration date (YYYY-MM-DD): ");
                        String udExpirationDate = scanner.nextLine();
                        udProduct = new Grocery(updateId, udName, udPrice, udQuantity, udExpirationDate);
                    } else {
                        System.out.println("Unknown product type.");
                        return;
                    }
                    productService.updateProduct(updateId, udProduct);
                case 5:
                    System.out.println("Product Deleting Page!");
                    System.out.print("Enter the Id of Product to delete: ");
                    int id = scanner.nextInt();
                productService.deleteProduct(id);

                case 6:
                    System.out.print("Enter the name of the product to search: ");
                    String searchName = scanner.nextLine();
                    Product foundProduct = productService.searchProductByName(searchName);
                    if (foundProduct != null) {
                        foundProduct.displayDetails();
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    private static int readInt(Scanner scanner, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                if (value >= 0){
                    return value;
                }else {
                    System.out.println("Please enter a valid number.More than 0");
                }
            } catch (Exception e) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    private static double readDouble(Scanner scanner, String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                if (value >= 0){
                    return value;
                }else {
                    System.out.println("Please enter a valid number.More than 0");
                }
            } catch (Exception e) {
                System.out.println(errorMessage);
                scanner.nextLine();
            }
        }
    }
    private static String readNonEmptyString(Scanner scanner, String prompt, String errorMessage){
        while(true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()){
                return input;
            }
            System.out.println(errorMessage);
        }
    }


}