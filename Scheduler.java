//this is where we are going to be scheduling the processes

//make a function that is going to be adding processes to a list/array

//make a list/array that is going to be representing the ready queue that could be scheduled
import java.util.ArrayList;
import java.lang.Runnable;



public class Scheduler extends Runnable{

    //list of all the users
    public ArrayList<String> users;
    //list of all the processes
    public ArrayList<Process> processes;
    //list of the ready queue
    public ArrayList<Process> processQueue;
    //time quantum
    public int timeQuantum;
    //get current time
    public int currTime;

    public Scheduler(int q)
    {
        users = new ArrayList<String>();
        processes = new ArrayList<Process>();
        processQueue = new ArrayList<Process>();
        timeQuantum = q;
        currTime = 1; //start of the time
    }

    public void addProcess(int pid, String user1, int arrTime, int burst)
    {
        //adding the process into an object of type process
        Process process1 = new Process(pid, user1, arrTime, burst);

        //adding the object into the list of processes
        processes.add(process1);

    }

    public void readyQueue()
    {

    }

    public void run()
    {

    }


}