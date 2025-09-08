import java.io.*;
import java.util.*;

public class MyMain {
    // store(<input stream>, <linked list>)
    public static void store(InputStream in, LinkedList<Person> list) {
        try (Scanner sc = new Scanner(in)) {
            while (sc.hasNext()) {
                String first = sc.next();
                if (!sc.hasNext()) break;
                String last = sc.next();
                if (!sc.hasNext()) break;
                String id = sc.next();
                list.add(new Person(first, last, id));
            }
        }
    }

    // display(<output stream>, <linked list>)
    public static void display(PrintStream out, LinkedList<Person> list) {
        for (Person p : list) {
            out.println(p.toString());
        }
    }

    // find(string sid, <linked list>)
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        // Instantiate a linked list
        LinkedList<Person> people = new LinkedList<>();

        // Read from a data file in the same folder (people.txt)
        File data = new File("people.txt");
        try (InputStream in = new FileInputStream(data)) {
            store(in, people);
        }

        // Display all persons
        System.out.println("All people:");
        display(System.out, people);

        // Invoke find a few times
        String[] testIds = {"1001", "1003", "9999"};
        for (String sid : testIds) {
            int idx = find(sid, people);
            System.out.println("find(" + sid + ") => " + idx);
        }
    }
}
