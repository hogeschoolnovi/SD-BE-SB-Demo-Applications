package nl.novi.studentcourse.model;

import java.io.File;
import java.util.Scanner;

public class Info {

    private static final String FILENAME = "src/main/resources/info.json";

    public static String getInfo() {
        try {
            File file = new File(FILENAME);
            Scanner sc = new Scanner(file);

            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine()).append(System.lineSeparator());
            }
            return sb.toString();
        }
        catch (Exception ex) {
            return ex.toString(); // System.getProperty("user.dir");
        }
    }

}
