//this is the class that is going to be storing all of the informations about the process
import javax.swing.*;
import java.io.*;

//Process class which implements runnable so that it can be put inside a thread
public class Process implements Runnable{

    //information of the processes (going to be extracted from the input.txt file later)
    int allocatedTime; //Allocated time
    int serviceTime; //burst time
    int arrivalTime; //arrival time
    int processID; //id of the process
    int currentTime; //Keeps track of the current runnign time
    boolean ready; //ready flag
    String user_name; //Name of the user
    String state; //started or resumed or finished or paused
    public BufferedWriter outputWriter; //Writer for output


    //constructor
    public Process(int pID, String u , int at, int st)
    {
        allocatedTime = 0;
        serviceTime = st;
        arrivalTime = at;
        processID = pID;
        user_name= u;
        currentTime = 0;
        ready = false;
        state = "idle";
        outputWriter = null;
    }


    //Runs when thread is started.
    public void run()
    {
        try {
            //Changes the state of the process when thread starts. If thread wasn't started
            //yet (idle), it sets it to started, or else it sets it to resumed
            if (state == "idle") {
                state = "started";
            } else if (state == "paused") {
                state = "resumed";
            }

            //Write the status of the thread to the output file
            System.out.println("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
            outputWriter.write("Time " + Integer.toString(currentTime) + ", User " + user_name + ", Process " + Integer.toString(processID) + ", has " + state);
            outputWriter.newLine();

            //Thread run for the amount of allocated time and/or until it is completed
            while (serviceTime > 0 && allocatedTime > 0) {
                currentTime += 1;
                serviceTime -= 1;
                allocatedTime -= 1;
            }

            //Sets the state to ended if process is completed
            if (serviceTime == 0) {
                state = "ended";
                //Write the status of the thread to the output file
                System.out.println("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.write("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.newLine();
            } else {
                //Sets the state to paused if allocate time was used and process isn't completed
                state = "paused";
                //Write the status of the thread to the output file
                System.out.println("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.write("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.newLine();
            }
        }
        //Catches IO exception if any error occurs when writing to output file
        catch (IOException intercept){
            intercept.printStackTrace();
        }
    }


    //Setter
    public void setAllocatedTime(int time){
        this.allocatedTime = time;
    }

    //Getter
    public int getAllocatedTime() {
        return allocatedTime;
    }

    //Getter
    public int getServiceTime() {
        return serviceTime;
    }

    //Getter
    public int getCurrentTime() {
        return currentTime;
    }

    //Setter
    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    //Setter
    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    //Getter
    public int getArrivalTime() {
        return arrivalTime;
    }

    //Setter
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    //Getter
    public int getProcessID() {
        return processID;
    }

    //Setter
    public void setProcessID(int processID) {
        this.processID = processID;
    }

    //Getter
    public BufferedWriter getOutputWriter() {
        return outputWriter;
    }

    //Setter
    public void setOutputWriter(BufferedWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    //Getter
    public String getstate() {
        return state;
    }

    //Getter
    public boolean isReady() {
        return ready;
    }

    //Setter
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    //Setter
    public void setState(String state) {
        this.state = state;
    }
}