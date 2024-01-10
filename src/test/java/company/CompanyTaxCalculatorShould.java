package company;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CompanyTaxCalculatorShould {

    private static final double ANNUAL_TURNOVER = 1000;

    @Test
    void calculate_tax_for_companies() {
        assertTaxToPay(new SelfEmployed(), 250.0);
        assertTaxToPay(new SAS(), 330.0);
        assertTaxToPay(new SARL(), 100.0);
    }

    private static void assertTaxToPay(Company company, double expectedTaxToPay) {
        double taxToPay = company.calculateTax(ANNUAL_TURNOVER);

        assertThat(taxToPay).isEqualTo(expectedTaxToPay);
    }
}
