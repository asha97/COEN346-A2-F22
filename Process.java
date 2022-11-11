//this is the class that is going to be storing all of the informations about the process
import javax.swing.*;
import java.io.*;

public class Process implements Runnable{

    //information of the processes (going to be extracted from the input.txt file later)
    int allocatedTime; //Allocated time
    int serviceTime; //burst time
    int arrivalTime; //arrival time
    int processID; //id of the process
    int currentTime;
    boolean ready;
    String user_name;
    String state; //started or resumed or finished or paused
    //Writer for output
    public BufferedWriter outputWriter;


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


    public void run()
    {
        try {
            if (state == "idle") {
                state = "started";
            } else if (state == "paused") {
                state = "resumed";
            }

            System.out.println("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
            outputWriter.write("Time " + Integer.toString(currentTime) + ", User " + user_name + ", Process " + Integer.toString(processID) + ", has " + state);
            outputWriter.newLine();

            while (serviceTime > 0 && allocatedTime > 0) {
                currentTime += 1;
                serviceTime -= 1;
                allocatedTime -= 1;
            }

            if (serviceTime == 0) {
                state = "ended";
                System.out.println("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.write("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.newLine();
            } else {
                state = "paused";
                System.out.println("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.write("Time " + currentTime + ", User " + user_name + ", Process " + processID + ", has " + state);
                outputWriter.newLine();
            }
        }
        catch (IOException intercept){
            intercept.printStackTrace();
        }
    }


    public void setAllocatedTime(int time){
        this.allocatedTime = time;
    }

    public int getAllocatedTime() {
        return allocatedTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }


    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public BufferedWriter getOutputWriter() {
        return outputWriter;
    }

    public void setOutputWriter(BufferedWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public String getstate() {
        return state;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public void setState(String state) {
        this.state = state;
    }
}