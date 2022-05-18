import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    Customer sampleCustomer;

    @Before
    public void generateSampleCustomer() {
        String username2 = "jrbmercado";
        Payment p2 = new Payment("AMEX", "344922649319381", "062025", "902");
        Vehicle car2 = new Vehicle("Honda", "CRV", "Grey", 2009, "6LIK274");
        sampleCustomer = new Customer("Justin", "Mercado", "450 Diamond St.", "", "San Jose", "CA", 95113,
                "justinreianmercado@gmail.com", username2, "Welcome1!", p2, car2);
    }

    @Test
    public void testValidPasswordShouldBeTrue() {
        assertTrue(sampleCustomer.validPassword("Welcome1!"));
    }

    @Test
    public void testValidPasswordShouldBeFalse() {
        assertFalse(sampleCustomer.validPassword("123"));
    }

    @Test
    public void addFundsFiveDollarsShouldBeEqual() {
        double prevBalance = sampleCustomer.getAccountBalance();
        sampleCustomer.addFunds(5);
        assertEquals(prevBalance, sampleCustomer.getAccountBalance() - 5, 0.001);
    }
}
