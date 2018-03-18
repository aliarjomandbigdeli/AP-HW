import java.util.Queue;

/**
 *  this class implement for running code that models a queue
 *
 * @author Ali ArjomandBigdeli
 * @since 3.17.2018
 */
public class Main {
    public static void main(String[] args) {
        SimplePersonQueue spq = new SimplePersonQueue();

        if (spq instanceof Queue) {
            System.out.println("LinkedPersonQueue is an Queue");
        }

        if (spq.peek() == null) {
            System.out.println("Queue is empty");
        }

        spq.add(new Person("Seyed", "Ahmadpanah"));
        spq.add(new Person("Parham", "Alvani"));

        if (spq.element().equals(new Person("Parham", "Alvani"))) {
            System.out.println("Parham is on the head of queue");
        }

        spq.peek();
        spq.peek();

        if (spq.size() == 0) {
            System.out.println("Queue is empty");
        }

        //USE OTHER METHODS OF THE SimplePersonQueue CLASS TO TEST ALL UNITS OF YOUR CODE...

        System.out.println("");
        if (spq.element().equals(new Person("Seyed", "Ahmadpanah"))) {
            System.out.println("Seyed is on the head of queue");
        }
        System.out.println("size: "+spq.size());

        Person person = new Person("Ali", "Arjomand");

        spq.add(person);
        if (spq.contains(person))
            System.out.println("contained");
        else
            System.out.println("not contained");

        System.out.println("size: "+spq.size());

        spq.remove(person);
        if (spq.contains(person))
            System.out.println("contained");
        else
            System.out.println("not contained");

        spq.clear();
        System.out.println("size: "+spq.size());
        if (spq.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue isn't empty");
        }

        if (spq.poll() == null) {
            System.out.println("Queue is empty");
        }
    }
}
