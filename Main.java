package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> find_txt = new ArrayList<>();
        int sizeOf_find_txt = 0;
        Map<Integer, String> directory_txt = new IdentityHashMap<>();

        File myObj = new File("C:\\Users\\Damir\\Downloads\\directory.txt");
        Scanner scanner = new Scanner(myObj);
        while(scanner.hasNextLine()) {
            directory_txt.put(scanner.nextInt(), scanner.nextLine().trim());
        }

        myObj = new File("C:\\Users\\Damir\\Downloads\\find.txt");
        scanner = new Scanner(myObj);
        while(scanner.hasNextLine()) {
            find_txt.add(scanner.nextLine().trim());
            sizeOf_find_txt++;
        }

        scanner.close();

        System.out.println("Start searching...");

        long startingTime = System.currentTimeMillis();

        int answer = 0;

        for (String name :
                find_txt) {
            for (Map.Entry<Integer, String> entry :
                    directory_txt.entrySet()) {

                if (entry.getValue().equals(name)) {
                    answer++;
                    break;
                }
            }
        }

        long currentTime = System.currentTimeMillis();
        int minutes = (int) (currentTime - startingTime)/36000;
        int seconds = (int) (currentTime - startingTime)/1000;
        int milliseconds = (int) (currentTime - startingTime)%1000;

        System.out.printf("Found %d / %d entries. ", answer, sizeOf_find_txt);
        System.out.printf("Time taken: %d min. %d sec. %d ms.\n", minutes, seconds, milliseconds);
    }
}
