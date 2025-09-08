import java.io.*;
import java.util.*;

public class PersonList {
    private LinkedList<Person> list = new LinkedList<>();

    // store(<input stream>)
    public void store(InputStream in) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // skip blank lines
                String[] parts = line.split("\\s+");
                if (parts.length < 3) continue; // skip malformed lines
                String first = parts[0];
                String last = parts[1];
                String id = parts[2];
                list.add(new Person(first, last, id));
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // display(<output stream>)
    public void display(PrintStream out) {
        for (Person p : list) {
            out.println(p.toString());
        }
    }

    // find(string sid)
    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) return i;
        }
        return -1;
    }

    public int size() { return list.size(); }
    public Person get(int idx) { return list.get(idx); }
}
