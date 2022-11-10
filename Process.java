//this is the class that is going to be storing all of the informations about the process


public class Process implements Runnable{

    //information of the processes (going to be extracted from the input.txt file later)
    int allocatedTime; //Allocated time
    int serviceTime; //burst time
    int arrivalTime; //arrival time
    int processID; //id of the process
    int currentTime; //Current time when running thread
    String user_name; //Name of user that possess the process
    String state; //started or resumed or finished or paused


    //constructor
    public Process(int pID, String u, int at, int st)
    {
        currentTime = 0;
        allocatedTime = 0;
        serviceTime = st;
        arrivalTime = at;
        processID = pID;
        user_name = u;
        state = "idle";
    }


    public void run()
    {
        if(state == "idle"){
            state = "started";
        }
        else if(state == "paused") {
            state = "resumed";
        }

        System.out.println("Time "+currentTime+", User "+user_name+", Process "+processID+" has "+state);

        while(serviceTime>0 && allocatedTime>0){
            currentTime += 1;
            serviceTime -= 1;
            allocatedTime -= 1;
        }

        if(serviceTime==0){
            state = "ended";
            System.out.println("Time "+currentTime+", User "+user_name+", Process "+processID+" has "+state);
        }
        else{
            state = "paused";
            System.out.println("Time "+currentTime+", User "+user_name+", Process "+processID+" has "+state);
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

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public String getstate() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    //Overriding equals method for easy removing of processes inside user class
    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Process other = (Process) obj;

        if (this.processID != other.processID) {
            return false;
        }

        return true;
    }
}