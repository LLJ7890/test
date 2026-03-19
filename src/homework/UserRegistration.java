package homework;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class UserRegistration {
    public static final double VIP_DISCOUNT_UNDER_18_BIRTHDAY = 25.0;
    public static final double VIP_DISCOUNT_UNDER_18 = 20.0;
    public static final double VIP_BASE_FEE = 100.0;
    
    private String fullName;
    private String emailAddress;
    private String dateOfBirth;
    private long cardNumber;
    private String cardProvider;
    private String cardExpiryDate;
    private double feeToCharge;
    private int cvv;
    private String userType;
    private boolean emailValid;
    private boolean minorAndBirthday;
    private boolean minor;
    private boolean ageValid;
    private boolean cardNumberValid;
    private boolean cardStillValid;
    private boolean validCVV;

    public void registration(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to the ERyder Registration. Here are your two options:");
        System.out.println("1. Register as a Regular User");
        System.out.println("2. Register as a VIP User");
        System.out.print("Please enter your choice (1 or 2): ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            userType = "Regular User";
        } else if (choice == 2) {
            userType = "VIP User";
        } else {
            System.out.println("Invalid choice. Please restart the registration process.");
            sc.close();
            return;
        }

        System.out.print("Please enter your full name: ");
        fullName = sc.nextLine();

        System.out.print("Please enter your email address: ");
        emailAddress = sc.nextLine();
        emailValid = analyseEmail(emailAddress);

        System.out.print("Please enter your date of birth in the format YYYY-MM-DD: ");
        dateOfBirth = sc.nextLine();
        LocalDate dob = LocalDate.parse(dateOfBirth);
        ageValid = analyseAge(dob);

        System.out.print("Please enter your card number (Visa, MasterCard, and American Express accepted): ");
        cardNumber = sc.nextLong();
        sc.nextLine();
        cardNumberValid = analyseCardNumber(cardNumber);

        System.out.print("Please enter your card expiry date (MM-YY): ");
        cardExpiryDate = sc.nextLine();
        cardStillValid = analyseCardExpiryDate(cardExpiryDate);

        System.out.print("Please enter your card CVV: ");
        cvv = sc.nextInt();
        validCVV = analyseCVV(cvv);
        
        sc.nextLine();
        finalCheckpoint();
        
        sc.close();
    }
    
    private boolean analyseEmail(String email) {
        if (email.contains("@") && email.contains(".")) {
            System.out.println("Email is valid");
            return true;
        } else {
            System.out.println("Invalid email address. Going back to the start of the registration");
            registration();
            return false;
        }
    }

    private boolean analyseAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dob, today);
        int age_difference = period.getYears();
        
        boolean isBirthday = (dob.getMonthValue() == today.getMonthValue()) && 
                            (dob.getDayOfMonth() == today.getDayOfMonth());
        
        if (userType.equals("VIP User")) {
            if (isBirthday && age_difference <= 18 && age_difference > 12) {
                System.out.println("Happy Birthday!\nYou get 25% discount on the VIP subscription fee for being born today and being under 18!");
                minorAndBirthday = true;
            } else if (!isBirthday && age_difference <= 18 && age_difference > 12) {
                System.out.println("You get 20% discount on the VIP subscription fee for being under 18!");
                minor = true;
            }
        }
        
        if (age_difference <= 12 || age_difference > 120) {
            System.out.println("Looks like you are either too young or already dead. Sorry, you can't be our user. Have a nice day");
            System.exit(0);
        }
        
        return true;
    }
    
    private boolean analyseCardNumber(long cardNumber) {
        String cardNumStr = String.valueOf(cardNumber);
        
        int firstTwoDigits = Integer.parseInt(cardNumStr.substring(0, 2));
        int firstFourDigits = Integer.parseInt(cardNumStr.substring(0, 4));
        
        if ((cardNumStr.length() == 13 || cardNumStr.length() == 15) && cardNumStr.startsWith("4")) {
            cardProvider = "VISA";
        } else if (cardNumStr.length() == 16 && 
                  ((firstTwoDigits >= 51 && firstTwoDigits <= 55) || 
                   (firstFourDigits >= 2221 && firstFourDigits <= 2720))) {
            cardProvider = "MasterCard";
        } else if (cardNumStr.length() == 15 && 
                  (cardNumStr.startsWith("34") || cardNumStr.startsWith("37"))) {
            cardProvider = "American Express";
        } else {
            System.out.println("Sorry, but we accept only VISA, MasterCard, or American Express cards. Please try again with a valid card.\nGoing back to the start of the registration.");
            registration();
            return false;
        }
        
        return true;
    }
    
    private boolean analyseCardExpiryDate(String cardExpiryDate) {
        int month = Integer.parseInt(cardExpiryDate.substring(0, 2));
        int year = Integer.parseInt(cardExpiryDate.substring(3, 5)) + 2000;
        
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        
        if (year > currentYear || (year == currentYear && month >= currentMonth)) {
            System.out.println("The card is still valid");
            return true;
        } else {
            System.out.println("Sorry, your card has expired. Please use a different card." +
                    "\nGoing back to the start fo the registration process...");
            registration();
            return false;
        }
    }
    
    private boolean analyseCVV(int cvv) {
        String cvvStr = String.valueOf(cvv);
        
        if ((cardProvider.equals("American Express") && cvvStr.length() == 4) ||
            (cardProvider.equals("VISA") && cvvStr.length() == 3) ||
            (cardProvider.equals("MasterCard") && cvvStr.length() == 3)) {
            System.out.println("Card CVV is valid.");
            return true;
        } else {
            System.out.println("Invalid CVV for the given card.\nGoing back to the start of the registration process.");
            registration();
            return false;
        }
    }
    
    private void finalCheckpoint() {
        if (emailValid && ageValid && cardNumberValid && cardStillValid && validCVV) {
            chargeFees();
        } else {
            System.out.println("Sorry, your registration was unsuccessful due to the following reason(s):");
            
            if (!emailValid) {
                System.out.println("Invalid email address");
            }
            if (!ageValid) {
                System.out.println("Invalid age");
            }
            if (!cardNumberValid) {
                System.out.println("Invalid card number");
            }
            if (!cardStillValid) {
                System.out.println("Card has expired");
            }
            if (!validCVV) {
                System.out.println("Invalid CVV");
            }
            
            System.out.println("Going back to the start of the registration process.");
            registration();
        }
    }
    
    private void chargeFees() {
        if (minorAndBirthday) {
            feeToCharge = VIP_BASE_FEE * (1 - 0.25);
        } else if (minor) {
            feeToCharge = VIP_BASE_FEE * (1 - 0.20);
        } else {
            feeToCharge = VIP_BASE_FEE;
        }
        
        String lastFourDigits = String.valueOf(cardNumber).substring(String.valueOf(cardNumber).length() - 4);
        System.out.println("Thank you for your payment.");
        System.out.println("A fee of " + feeToCharge + " has been charged to your card ending with " + lastFourDigits);
    }
    public String toString(){
        String cardNumberStr = String.valueOf(cardNumber);
        String censoredPart = cardNumberStr.substring(0, cardNumberStr.length() - 4).replaceAll(".","*");
        String lastFourDigits = cardNumberStr.substring(cardNumberStr.length() - 4);
        String censoredNumber = censoredPart + lastFourDigits;
        return "Registration successful! Here are your details:\n" +
                "User Type: " + userType + "\n" +
                "Full Name: " + fullName + "\n" +
                "Email Address: " + emailAddress + "\n" +
                "Date of Birth: " + dateOfBirth + "\n" +
                "Card Number: " + censoredNumber + "\n" +
                "Card Provider: " + cardProvider + "\n" +
                "Card Expiry Date: " + cardExpiryDate;


    }
}
