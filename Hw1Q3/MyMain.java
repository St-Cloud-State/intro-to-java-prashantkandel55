import java.io.*;

public class MyMain {
    public static void main(String[] args) throws Exception {
        PersonList plist = new PersonList();

        // Load from people.txt (try local first, then fallback to ../Hw1Q2/people.txt)
        File data = new File("people.txt");
        if (!data.exists()) {
            data = new File("../Hw1Q2/people.txt");
        }
        if (!data.exists()) {
            throw new FileNotFoundException("people.txt not found in Hw1Q3/ or ../Hw1Q2/");
        }
        try (InputStream in = new FileInputStream(data)) {
            plist.store(in);
        }

        // Display
        System.out.println("All people:");
        plist.display(System.out);

        // Find a few
        String[] testIds = {"1001", "1003", "9999"};
        for (String sid : testIds) {
            int idx = plist.find(sid);
            System.out.println("find(" + sid + ") => " + idx);
        }
    }
}
