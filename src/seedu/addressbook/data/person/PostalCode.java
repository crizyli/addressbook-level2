package seedu.addressbook.data.person;

/**
 * Represents a Person's address's block in the address book.
 */
public class PostalCode {

    public final String value;

    /**
     *
     */
    public PostalCode(String postalCode) {
        String trimmedPostalCode = postalCode.trim();
        this.value = trimmedPostalCode;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this.value.equals(((PostalCode) other).value)); // state check
    }
}
