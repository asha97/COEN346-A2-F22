import java.io.BufferedWriter;
import java.io.*;
import java.util.ArrayList;

public class main {

    public static void main (String[] args) throws IOException
    {

        //Output file is created and a writer is initialized.
        String filepath = new File("").getAbsolutePath();
        File fout = new File(filepath+"\\output.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

        //Input file is red
        FileInput input = new FileInput(filepath+"/input.txt");
        input.inputArrayRead();


        Scheduler scheduler = new Scheduler(input.getUsers(),input.getTimeQuantum(),writer);

        Thread t = new Thread(scheduler);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        writer.close();

    }
}