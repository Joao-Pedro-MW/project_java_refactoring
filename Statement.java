
import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = headerString(aCustomer);

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += rentalString(each);
        }

        result += footerStringCharge(aCustomer);
        result += footerStringPoints(aCustomer);
        return result;
    }

    public abstract String headerString(Customer aCustomer);

    public abstract String rentalString(Rental aRental);

    public abstract String footerStringCharge(Customer aCustomer);

    public abstract String footerStringPoints(Customer aCustomer);
}
