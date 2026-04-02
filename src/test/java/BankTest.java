import com.iv.bank.Bank;
import com.iv.bank.BankImpl;
import com.iv.bank.PaymentServiceImpl;
import com.iv.bank.exception.AccountCreationException;
import com.iv.bank.exception.AccountRemovalException;
import com.iv.bank.exception.PaymentException;
import com.iv.bank.model.Account;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

// This test class will validate a solution
public class BankTest {

    private Bank initializeTest() {
        Bank bank = new BankImpl(new PaymentServiceImpl());
        bank.createAccount(new Account(UUID.randomUUID(), 10));
        bank.createAccount(new Account(UUID.randomUUID(), 20));
        bank.createAccount(new Account(UUID.randomUUID(), 30));
        return bank;
    }

    @Test
    public void initializationTest() {
        //given
        //when
        Bank bank = initializeTest();
        //then
        assertEquals(3, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 30));
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 20));
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 10));
    }

    @Test
    public void newAccountCreationTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        //when
        var uuid = UUID.randomUUID();
        bank.createAccount(new Account(uuid, 40));
        //then
        assertEquals(4, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 40));
    }

    @Test
    public void newAccountWithSameUUIDCreationTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        //when
        var uuid = UUID.randomUUID();
        bank.createAccount(new Account(uuid, 40));
        bank.createAccount(new Account(uuid, 60));
        //then
        assertThrows(AccountCreationException.class, () -> bank.createAccount(new Account(uuid, 60)));
        assertEquals(4, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 40));
        assertTrue(bank.getAccounts().stream().noneMatch(a -> a.getBalance() == 60));
    }

    @Test
    public void accountRemovalTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        var uuid = UUID.randomUUID();
        bank.createAccount(new Account(uuid, 40));
        assertEquals(4, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 40));
        //when
        bank.removeAccount(uuid);
        //then
        assertEquals(3, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().noneMatch(a -> a.getBalance() == 40));
    }

    @Test
    public void sameAccountRemovedTwiceTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        var uuid = UUID.randomUUID();
        bank.createAccount(new Account(uuid, 40));
        assertEquals(4, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().anyMatch(a -> a.getBalance() == 40));
        //when
        bank.removeAccount(uuid);
        assertThrows(AccountRemovalException.class, () -> bank.removeAccount(uuid));
        //then
        assertEquals(3, bank.getAccounts().size());
        assertTrue(bank.getAccounts().stream().noneMatch(a -> a.getBalance() == 40));
    }

    @Test
    public void checkBalanceTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        var account = new Account(UUID.randomUUID(), 40);
        bank.createAccount(account);
        //when
        bank.checkBalance(account);
        //then
        assertEquals(40, bank.checkBalance(account));
    }

    @Test
    public void checkPaymentTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        var account = new Account(UUID.randomUUID(), 100);
        bank.createAccount(account);
        //when
        bank.makePayment(account, -10);
        //then
        assertEquals(90, bank.checkBalance(account));
    }

    @Test
    public void checkPaymentWithNotEnoughBalanceTest() {
        //given
        Bank bank = initializeTest();
        assertEquals(3, bank.getAccounts().size());
        var account = new Account(UUID.randomUUID(), 5);
        bank.createAccount(account);
        //when
        //then
        assertThrows(PaymentException.class, () -> bank.makePayment(account, -10));
    }

    @Test
    public void checkConcurrentPaymentTest() {
        // TODO
        // make test that will check if multiple threads can make payments to the same account and balance is correct
    }

    @Test
    public void checkConcurrentAccountAdditionalAndRemovalTest() {
        // TODO
        // make test that will check if multiple threads can create and remove accounts at the same time
    }


}
