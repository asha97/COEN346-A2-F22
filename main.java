import java.io.BufferedWriter;
import java.io.*;

public class main {

    public static void main (String[] args) throws IOException
    {

        //Output file is created and a writer is initialized.
        String filepath = new File("").getAbsolutePath();
        File fout = new File(filepath+"\\output.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));


        //Test processes
        Process P1 = new Process(1,"A",4,3);
        Process P2 = new Process(2,"A",1,5);
        Process P3 = new Process(3,"B",5,6);
        Process P4 = new Process(4,"B",10,10);

        //Test User
        User A = new User("A");
        User B = new User("B");

        A.addProcess(P1);
        A.addProcess(P2);
        B.addProcess(P3);
        B.addProcess(P4);

        Scheduler scheduler = new Scheduler(4,writer);
        scheduler.addUser(A);
        scheduler.addUser(B);

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