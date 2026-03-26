package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    private List<RegisteredUsers> registeredUsers = new ArrayList<>();
    public void userManagementOptions(){
        System.out.println("Welcome to E-Ryder Admininstrator Panel. What do you want to do?\n" +
                "1. Add a new user\n" +
                "2. Delete a user\n" +
                "3. View all users\n" +
                "4. View a specific user\n" +
                "5. Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1: addNewUsers();
                break;
            case 2: viewRegisteredUsers();
                break;
            case 3: removeRegisteredUsers();
                break;
           case 4: updateRegisteredUsers();
                break;
           case 5:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
    private void addNewUsers() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many users the admin would like to add? ");
        int numberOfUsers = sc.nextInt();
        sc.nextLine();

        for (int userCount = 0; userCount < numberOfUsers; userCount++) {
            System.out.println("\n Entering details for User " + (userCount + 1));

            System.out.print("Enter full name: ");
            String fullName = sc.nextLine();

            System.out.print("Enter email address: ");
            String emailAddress = sc.nextLine();

            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dateOfBirth = sc.nextLine();

            System.out.print("Enter card number: ");
            long cardNumber = Long.parseLong(sc.nextLine());

            System.out.print("Enter card provider: ");
            String cardProvider = sc.nextLine();

            System.out.print("Enter card expiry date (MM-YY): ");
            String cardExpiryDate = sc.nextLine();

            System.out.print("Enter CVV: ");
            int cvv = Integer.parseInt(sc.nextLine());

            System.out.print("Enter user type (Regular User/VIP User): ");
            String userType = sc.nextLine();

            String[] lastThreeTrips = new String[3];

            for (int tripIndex = 0; tripIndex < 3; tripIndex++) {
                System.out.println("\nTrip " + (tripIndex + 1) + " Details");

                System.out.print("Enter date of trip (YYYY-MM-DD): ");
                String tripDate = sc.nextLine();

                System.out.print("Enter source: ");
                String source = sc.nextLine();

                System.out.print("Enter destination: ");
                String destination = sc.nextLine();

                System.out.print("Enter fare paid: ");
                double fare = Double.parseDouble(sc.nextLine());

                System.out.print("Enter feedback (or leave blank for NULL): ");
                String feedback = sc.nextLine();
                if (feedback.isEmpty()) {
                    feedback = "NULL";
                }

                StringBuilder tripDetails = new StringBuilder();
                tripDetails.append("Date: ").append(tripDate)
                        .append(", Source: ").append(source)
                        .append(", Destination: ").append(destination)
                        .append(", Fare: ").append(fare)
                        .append(", Feedback: ").append(feedback);

                lastThreeTrips[tripIndex] = tripDetails.toString();
            }

            RegisteredUsers newUser = new RegisteredUsers(
                    fullName,
                    emailAddress,
                    dateOfBirth,
                    cardNumber,
                    cardProvider,
                    cardExpiryDate,
                    cvv,
                    userType,
                    lastThreeTrips
            );
            registeredUsers.add(newUser);

            System.out.println("\nUser " + (userCount + 1) + " added successfully!");
        }

        System.out.println("\nAll " + numberOfUsers + " user(s) have been added to the system.");
        sc.close();
    }
    private void viewRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users found.");
        } else {
            for (RegisteredUsers user : registeredUsers) {
                System.out.println("Full Name: " + user.getFullName());
                System.out.println("Email Address: " + user.getEmailAddress());
                System.out.println("Date of Birth: " + user.getDateOfBirth());
                System.out.println("Card Number: " + user.getCardNumber());
                System.out.println("Card Provider: " + user.getCardProvider());
                System.out.println("Card Expiry Date: " + user.getCardExpiryDate());
                System.out.println("CVV: " + user.getCvv());
                System.out.println("User Type: " + user.getUserType());
                
                String[] trips = user.getLastThreeTrips();
                System.out.println("Last Three Trips:");
                for (int i = 0; i < trips.length; i++) {
                    System.out.println("  Trip " + (i + 1) + ": " + trips[i]);
                }
                System.out.println();
            }
        }
    }

    private void removeRegisteredUsers() {
        Scanner sc = new Scanner(System.in);

        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users to remove");
            sc.close();
            return;
        }
        System.out.print("The email addresses of users who must be removed\n");
        String emailToRemove = sc.nextLine();
        
        boolean found = false;

        java.util.Iterator<RegisteredUsers> iterator = registeredUsers.iterator();
        
        while (iterator.hasNext()) {
            RegisteredUsers user = iterator.next();

            if (user.getEmailAddress().equals(emailToRemove)) {
                iterator.remove();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("”No user found with this email address");
        }
        
        sc.close();
    }
    private void updateRegisteredUsers(){
        Scanner sc = new Scanner(System.in);

        if(registeredUsers.isEmpty()){
            System.out.println("No registered users to remove");
        }

        System.out.print("Enter the email address of the user you want to update: ");
        String emailToUpdate = sc.nextLine();
        
        boolean found = false;
        RegisteredUsers userToUpdate = null;

        for(RegisteredUsers user : registeredUsers){
            if(user.getEmailAddress().equals(emailToUpdate)){
                userToUpdate = user;
                found = true;
                break;
            }
        }

        if(!found){
            System.out.println("No user found with this email address");
            sc.close();
            return;
        }

        System.out.print("Enter new full name (Press ENTER for no change): ");
        String newName = sc.nextLine();
        if(!newName.isEmpty()){
            userToUpdate.setFullName(newName);
        }

        System.out.print("Enter new email address (Press ENTER for no change): ");
        String newEmail = sc.nextLine();
        if(!newEmail.isEmpty()){
            userToUpdate.setEmailAddress(newEmail);
        }

        System.out.print("Enter new date of birth (Press ENTER for no change): ");
        String newDob = sc.nextLine();
        if(!newDob.isEmpty()){
            userToUpdate.setDateOfBirth(newDob);
        }

        System.out.print("Enter new card number (Enter 0 for no change): ");
        String newCard = sc.nextLine();
        if(!newCard.equals("0")){
            long cardNum = Long.parseLong(newCard);
            userToUpdate.setCardNumber(cardNum);
        }

        System.out.print("Enter new card provider (Press ENTER for no change): ");
        String newProvider = sc.nextLine();
        if(!newProvider.isEmpty()){
            userToUpdate.setCardProvider(newProvider);
        }

        System.out.print("Enter new card expiry date (Press ENTER for no change): ");
        String newExpiry = sc.nextLine();
        if(!newExpiry.isEmpty()){
            userToUpdate.setCardExpiryDate(newExpiry);
        }

        System.out.print("Enter new CVV (Enter 0 for no change): ");
        String newCvv = sc.nextLine();
        if(!newCvv.equals("0")){
            int cvvNum = Integer.parseInt(newCvv);
            userToUpdate.setCvv(cvvNum);
        }

        System.out.print("Enter new user type (Press ENTER for no change): ");
        String newType = sc.nextLine();
        if(!newType.isEmpty()){
            userToUpdate.setUserType(newType);
        }
        
        System.out.println("User updated successfully!");
        sc.close();
    }


}
