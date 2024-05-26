package BankSys;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static long nextAccountNumber = 0;
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        accounts.put(account.getUsername(), account);
        saveAccountToFile(account);
    }

    public Account getAccount(String username) {
        return accounts.get(username);
    }

    private void saveAccountToFile(Account account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("NewAccount.txt", true))) {
            // Write account details to the file
            writer.write(account.getUsername() + ","
                        + account.getPassword() + ","
                        + account.getPinCode() + ","
                        + account.getFirstName() + ","
                        + account.getMiddleName() + ","
                        + account.getLastName() + ","
                        + account.getBirthdate() + "," // Assuming getBirthdate() returns a String
                        + account.getGender() + ","
                        + account.getAddress() + ","
                        + account.getFatherName() + ","
                        + account.getMotherName() + ","
                        + account.getContactNo() + ","
                        + account.getBalance() + ","
                        + account.getAccountNo());
            writer.newLine(); // Add a new line after each account
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately in a production environment
        }
    }

    public static long getNextAccountNumber() {
        // Check if the file exists
        Path filePath = Paths.get("NewAccount.txt");
        if (Files.exists(filePath)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
                String line;
                long lastAccountNumber = 0;
                // Read the file line by line
                while ((line = reader.readLine()) != null) {
                    // Split the line by comma and extract the account number
                    String[] parts = line.split(",");
                    if (parts.length > 0) {
                        try {
                            lastAccountNumber = Long.parseLong(parts[parts.length - 1]);
                        } catch (NumberFormatException e) {
                            // Handle the case where the account number is not a valid long
                            e.printStackTrace();
                        }
                    }
                }
                // Set the next account number to the last account number incremented by 1
                nextAccountNumber = lastAccountNumber + 1;
            } catch (IOException e) {
                e.printStackTrace(); // Handle exceptions appropriately in a production environment
            }
        } else {
            // If the file does not exist, set the next account number to 1
            nextAccountNumber = 1;
        }
        return nextAccountNumber;
    }
}