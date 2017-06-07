package serializable.readResolve;

import java.io.*;

/**
 * Created by Andrew  on 2017/5/16.
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        Elvis elvis = Elvis.INSTANCE;
        FileOutputStream fos = new FileOutputStream(new File("C:\\test\\elvis.class"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(elvis);

        oos.close();

        ElvisStealer elvisStealer = new ElvisStealer();
        FileOutputStream fos2 = new FileOutputStream(new File("C:\\test\\elvisStealer.class"));
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(elvisStealer);

        oos2.close();
    }
}
