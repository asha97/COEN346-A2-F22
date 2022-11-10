public class main {

    public static void main (String[] args)
    {

        //Test processes
        Process P1 = new Process(1,"A",4,3);
        Process P2 = new Process(2,"A",1,5);
        Process P3 = new Process(3,"B",5,6);

        //Test User
        User A = new User("A");
        User B = new User("B");

        A.addProcess(P1);
        A.addProcess(P2);
        B.addProcess(P3);

        Scheduler scheduler = new Scheduler(4);
        scheduler.addUser(A);
        scheduler.addUser(B);

        Thread t = new Thread(scheduler);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}