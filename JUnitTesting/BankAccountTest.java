package JUnitTesting;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    static void beforeClass(){
        System.out.println("This Executes Before Any Test Cases. Successful Test Count = " + count++);
    }

    @org.junit.jupiter.api.BeforeEach
    void setup(){
        bankAccount = new BankAccount("Onur Elhakan" ,768.63, BankAccount.CHECKING);
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = bankAccount.deposit(200, true);
        assertEquals(968.63, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        bankAccount.withdraw(600, true);
        assertEquals(168.63, bankAccount.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_atm(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                bankAccount.withdraw(600, false));
        assertEquals("Visit our branches to withdraw more than 500 pln.", exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        bankAccount.deposit(200, true);
        assertEquals(968.63, bankAccount.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        bankAccount.withdraw(200, true);
        assertEquals(568.63, bankAccount.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true(){
        assertTrue(bankAccount.isChecking());
    }

    @org.junit.jupiter.api.Test
    void isChecking_false(){
        assertFalse(!bankAccount.isChecking());
    }

    @org.junit.jupiter.api.AfterAll
    static void afterClass(){
        System.out.println("This Executes After All Methods. Successful Test Count = "+ count++);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown(){
        System.out.println("Successful Test Count = "+ count++);
    }
}