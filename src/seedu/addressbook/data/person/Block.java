package seedu.addressbook.data.person;


/**
 * Represents a Person's address's block in the address book.
 */
public class Block {

    public final String value;

    /**
     *
     */
    public Block(String block) {
        String trimmedBlock = block.trim();
        this.value = trimmedBlock;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }
}
