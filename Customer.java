
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : rentals) {
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(String.valueOf(rental.getCharge()))
                    .append("\n");
        }

        result.append("Amount owed is ").append(String.valueOf(getTotalCharge())).append("\n");
        result.append("You earned ").append(String.valueOf(getTotalFrequentRenterPoints()))
                .append(" frequent renter points");

        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder();

        result.append("<H1>Rentals for <EM>").append(getName()).append("</EM></H1><P>\n");

        for (Rental rental : rentals) {
            result.append(rental.getMovie().getTitle())
                    .append(": ")
                    .append(String.valueOf(rental.getCharge()))
                    .append("<BR>\n");
        }

        result.append("<P>You owe <EM>").append(String.valueOf(getTotalCharge())).append("</EM><P>\n");
        result.append("On this rental you earned <EM>")
                .append(String.valueOf(getTotalFrequentRenterPoints()))
                .append("</EM> frequent renter points<P>");

        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        for (Rental rental : rentals) {
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}
