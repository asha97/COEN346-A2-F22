//this is the class that is going to be storing all of the informations about the process


public class Process {

    //information of the processes (going to be extracted from the input.txt file later)
    int burstTime; //burst time
    int arrivalTime; //arrival time
    int processID; //id of the process
    String user; //if user A or B
    String state; //started or resumed or finished or paused


    //constructor
    public Process(int bt, int at, int pID, String u , String s) {
        burstTime = bt;
        arrivalTime = at;
        processID = pID;
        user = u;
        state = s;
    }

}