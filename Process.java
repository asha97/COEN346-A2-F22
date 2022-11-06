//this is the class that is going to be storing all of the informations about the process


public class Process {

    //information of the processes (going to be extracted from the input.txt file later)
    int burstTime; //burst time
    int arrivalTime; //arrival time
    int processID; //id of the process
    String user; //if user A or B
    String state; //started or resumed or finished or paused


    //constructor
    public Process(int pID, String u , int at, int bt)
    {
        burstTime = bt;
        arrivalTime = at;
        processID = pID;
        user = u;
    }


    public void run()
    {
       //indicate the process has started
        System.out.println("Process " + user + "," + processID + " started");

        //the process is going to be running..
        //must make a loop to allow the process to run as long as its burst time is not over


        for (int i = burstTime; i >= 0 ; i--)
        {
            thread.sleep(200);
            burstTime --;
            System.out.println("Process " + user + "," + processID +" paused");
        }

        System.out.println("Process " + user + "," + processID +" resumed");


    }

}