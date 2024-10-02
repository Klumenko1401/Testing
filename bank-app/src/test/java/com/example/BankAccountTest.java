package com.example;

//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    //Тест для створення рахунку
    @Test
    public void testCreateAccountWithInitialBalance() {
        // fail("Test not implemented");
        BankAccount account = new BankAccount(100);
        assertEquals(100, account.getBalance());
    }

    //Тест для зняття коштів
    @Test
    public void testWithdraw() {
    BankAccount account = new BankAccount(100);
    account.withdraw(50);
    assertEquals(50, account.getBalance());
    }

    //Тест для поповнення
    @Test
    public void testDeposit() {
    BankAccount account = new BankAccount(100);
    account.deposit(50);
    assertEquals(150, account.getBalance());
    }

    //Тест для перевірки недостатніх коштів
    @Test
    public void testWithdrawInsufficientFunds() {
    BankAccount account = new BankAccount(100);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        account.withdraw(150);
    });
    assertEquals("Insufficient funds", exception.getMessage());
}

    //Тест для негативного балансу
    @Test
    public void testCreateAccountWithNegativeBalance() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        new BankAccount(-100);
    });
    assertEquals("Initial balance cannot be negative", exception.getMessage());
}

// Тест на багаторазові транзакції
@Test
public void testMultipleTransactions() {
    BankAccount account = new BankAccount(100);
    account.deposit(50);  // +50, balance = 150
    account.withdraw(30); // -30, balance = 120
    account.deposit(70);  // +70, balance = 190
    account.withdraw(90); // -90, balance = 100
    assertEquals(100, account.getBalance());
}

//Тест на дуже велику кількість транзакцій
@Test
public void testHighVolumeOfTransactions() {
    BankAccount account = new BankAccount(0);
    for (int i = 0; i < 1000; i++) {
        account.deposit(1); // 1000 поповнень на 1 одиницю
    }
    for (int i = 0; i < 500; i++) {
        account.withdraw(1); // 500 зняттів на 1 одиницю
    }
    assertEquals(500, account.getBalance());
}



}
