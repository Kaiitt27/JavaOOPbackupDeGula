package BankSys;
import java.util.Date;

public class Account {
    private String username;
    private String password;
    private String pinCode;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthdate;
    private String gender;
    private String address;
    private String fatherName;
    private String motherName;
    private String contactNo;
    private double balance;
    private long accountNo;

    public Account(String username, String password, String pinCode, String firstName, String middleName, String lastName, Date birthdate, String gender, String address, String fatherName, String motherName, String contactNo) {
        this.username = username;
        this.password = password;
        this.pinCode = pinCode;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.address = address;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.contactNo = contactNo;
        this.balance = 500; // Initial deposit
        this.accountNo = 2024100000 + AccountManager.getNextAccountNumber(); // Increment for each new account
    }

    // Getters and setters for all fields

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if (System.currentTimeMillis() - lastWithdrawalTime > 60000) { // 60 seconds timer
            if (this.balance >= amount) {
                this.balance -= amount;
                lastWithdrawalTime = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }


    private long lastWithdrawalTime = 0;

    // get/set
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthdate() {
        return (Date) birthdate.clone(); // Return a clone to prevent external modification
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public double getBalance() {
        return balance;
    }

    public long getAccountNo() {
        return accountNo;
    }

}