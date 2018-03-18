import java.util.Objects;

/**
 *  this class models a person
 *
 * @author Ali ArjomandBigdeli
 * @since 3.17.2018
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     *
     * @param firstName first name of person
     * @param lastName last name of person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //ADD METHODS IF YOU NEED

    /**
     *
     * @param o Object type
     * @return boolean that specifies whether two objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName);
    }
}
