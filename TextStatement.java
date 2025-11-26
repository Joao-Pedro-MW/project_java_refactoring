
public class TextStatement extends Statement {

    @Override
    public String headerString(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    @Override
    public String rentalString(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle() + "\t"
                + String.valueOf(aRental.getCharge()) + "\n";
    }

    @Override
    public String footerStringCharge(Customer aCustomer) {
        return "Amount owed is "
                + String.valueOf(aCustomer.getTotalCharge()) + "\n";
    }

    @Override
    public String footerStringPoints(Customer aCustomer) {
        return "You earned "
                + String.valueOf(aCustomer.getTotalFrequentRenterPoints())
                + " frequent renter points";
    }

    // Método value() idêntico ao de HtmlStatement
    public String value(Customer aCustomer) {
        return super.value(aCustomer);
    }
}
