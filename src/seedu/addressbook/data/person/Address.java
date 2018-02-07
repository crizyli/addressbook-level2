package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Address should be 4 strings seperated by commas, representing block" +
            "(number and character only), street(number and character only), unit (number and character and #), and postal code" +
            "(fixed 6 numbers)";
    public static final String ADDRESS_VALIDATION_REGEX = "[0-9a-zA-Z]+,\\s[0-9a-zA-Z\\s]+,\\s[0-9#a-zA-Z]+,\\s(\\d{6})";

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }

        String[] addressElements = trimmedAddress.split(",");

        this.block = new Block(addressElements[0].trim());
        this.street = new Street(addressElements[1].trim());
        this.unit = new Unit(addressElements[2].trim());
        this.postalCode = new PostalCode(addressElements[3].trim());

        this.value = block.toString() + ", "
                        + street.toString() + ", "
                        + unit.toString() + ", "
                        + postalCode.toString();
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
