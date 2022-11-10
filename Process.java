//this is the class that is going to be storing all of the informations about the process



public class Process implements Runnable{


    //information of the processes (going to be extracted from the input.txt file later)
    int allocatedTime; //Allocated time
    int serviceTime; //burst time
    int arrivalTime; //arrival time
    int processID; //id of the process
    String state; //started or resumed or finished or paused

    //constructor
    public Process(int pID, User u , int at, int st, int alt)
    {
        allocatedTime = alt;
        serviceTime = st;
        arrivalTime = at;
        processID = pID;
        state = "idle";
    }

    //constructor for FileInput.java since we are not going to be using allocated time just yet
    public Process(int pID, User u , int at, int st)
    {
        serviceTime = st;
        arrivalTime = at;
        processID = pID;
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

        System.out.println("Process "+processID+" has "+state+".");

        while(serviceTime>0 && allocatedTime>0){
            serviceTime -= 1;
            allocatedTime -= 1;
        }


        if(serviceTime==0){
            state = "ended";
            System.out.println("Process "+processID+" has "+state+".");

        }
        else{
            state = "paused";
            System.out.println("Process "+processID+" has "+state+".");
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


    public String getstate() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}