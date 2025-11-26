
import java.util.Vector;

public class Customer {

    private final String name;
    private final Vector _rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }
}
