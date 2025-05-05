package controller;

import entity.*;
import repository.*;
import service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize repositories
        UserRepository userRepository = new UserRepository();
        ResourceRepository resourceRepository = new ResourceRepository();
        BookingRepository bookingRepository = new BookingRepository();

        // Initialize services with required repositories
        UserService userService = new UserService(userRepository);
        ResourceService resourceService = new ResourceService(resourceRepository);
        BookingService bookingService = new BookingService(bookingRepository, resourceRepository);
        ReportService reportService = new ReportService(bookingRepository);

        System.out.println("=== Welcome to the Smart Resource Booking System ===");

        boolean running = true;

        while (running) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role (admin / manager / user): ");
                    String role = scanner.nextLine();

                    User newUser = new RegularUser(username, password, role); // Example, you can switch type based on role
                    userService.registerUser(newUser);
                    System.out.println("User registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String loginUser = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String loginPass = scanner.nextLine();

                    User user = userService.login(loginUser, loginPass);
                    if (user != null) {
                        System.out.println("Welcome, " + user.getName() + "! Role: " + user.getRole());

                        if (user instanceof Admin) {
                            adminMenu(scanner, userService, reportService);
                        } else if (user instanceof ResourceManager) {
                            managerMenu(scanner, resourceService);
                        } else {
                            regularUserMenu(scanner, resourceService, bookingService);
                        }
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void adminMenu(Scanner scanner, UserService userService, ReportService reportService) {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("1. Manage Users");
        System.out.println("2. View Reports");
        System.out.println("3. Logout");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Placeholder for user management logic
                System.out.println("Managing users...");
                break;
            case 2:
                reportService.generateSystemReport();
                break;
            case 3:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void managerMenu(Scanner scanner, ResourceService resourceService) {
        System.out.println("\n--- Resource Manager Menu ---");
        System.out.println("1. Add Resource");
        System.out.println("2. Update Resource");
        System.out.println("3. Delete Resource");
        System.out.println("4. View All Resources");
        System.out.println("5. Logout");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Resource ID: ");
                String id = scanner.nextLine();
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Type: ");
                String type = scanner.nextLine();
                System.out.print("Enter Cost per Hour: ");
                double cost = scanner.nextDouble();
                scanner.nextLine();

                Resource newResource = new Resource(id, name, type, cost);
                resourceService.addResource(newResource);
                System.out.println("Resource added.");
                break;

            case 2:
                System.out.print("Enter Resource ID to Update: ");
                String updateId = scanner.nextLine();
                Resource resToUpdate = resourceService.getResourceById(updateId);
                if (resToUpdate != null) {
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    resToUpdate.setName(newName);
                    resourceService.updateResource(resToUpdate);
                    System.out.println("Resource updated.");
                } else {
                    System.out.println("Resource not found.");
                }
                break;

            case 3:
                System.out.print("Enter Resource ID to Delete: ");
                String deleteId = scanner.nextLine();
                resourceService.deleteResource(deleteId);
                System.out.println("Resource deleted.");
                break;

            case 4:
                System.out.println("All Resources:");
                for (Resource r : resourceService.getAllResources()) {
                    System.out.println(r);
                }
                break;

            case 5:
                System.exit(0);
 }
}
  
}
