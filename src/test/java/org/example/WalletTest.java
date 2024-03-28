package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    private Wallet wallet1;
    private Wallet wallet2;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Running Wallet tests...");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("All Wallet tests completed.");
    }

    @BeforeEach
    void setUp() {
        wallet1 = new Wallet(1000.0, "USD");
        wallet2 = new Wallet(500.0, "USD");
    }

    @AfterEach
    void tearDown() {
        wallet1 = null;
        wallet2 = null;
    }

    @Test
    void getBalance() {
        assertEquals(1000.0, wallet1.getBalance());
        assertEquals(500.0, wallet2.getBalance());
    }

    @Test
    void getCurrency() {
        assertEquals("USD", wallet1.getCurrency());
        assertEquals("USD", wallet2.getCurrency());
    }

    @Test
    void depositAmount() {
        wallet1.depositAmount(500.0);
        assertEquals(1500.0, wallet1.getBalance());
    }

    @Test
    void depositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> wallet1.depositAmount(-100.0));
    }

    @Test
    void withdrawAmount() {
        assertTrue(wallet1.withdrawAmount(500.0));
        assertEquals(500.0, wallet1.getBalance());
    }

    @Test
    void withdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> wallet1.withdrawAmount(-100.0));
    }

    @Test
    void withdrawInsufficientFunds() {
        assertFalse(wallet2.withdrawAmount(1000.0));
        assertEquals(500.0, wallet2.getBalance());
    }

    @Test
    void transferFunds() {
        wallet1.transferFunds(wallet2, 250.0);
        assertEquals(750.0, wallet1.getBalance());
        assertEquals(750.0, wallet2.getBalance());
    }

    @Test
    void transferInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> wallet2.transferFunds(wallet1, 1000.0));
    }

    @Test
    void transferDifferentCurrencies() {
        Wallet walletEUR = new Wallet(1000.0, "EUR");
        assertThrows(IllegalArgumentException.class, () -> wallet1.transferFunds(walletEUR, 500.0));
    }
}