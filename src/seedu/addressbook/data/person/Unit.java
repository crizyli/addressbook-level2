package seedu.addressbook.data.person;


/**
 * Represents a Person's address's block in the address book.
 */
public class Unit {

    public final String value;

    /**
     *
     */
    public Unit(String unit) {
        String trimmedUnit = unit.trim();
        this.value = trimmedUnit;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }
}
