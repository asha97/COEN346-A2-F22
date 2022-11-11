import java.util.ArrayList;

public class User {
    private String name; //User name/identifier
    private int allocatedTime; //Allocated time to that user during a cycle
    public ArrayList<Process> user_processes; //Arraylist containing the processes specific to that user

    //Constructor
    User(String name){
        this.user_processes = new ArrayList<Process>();
        this.name = name;
        this.allocatedTime = 0;
    }


    //This method is used to allocate time to the processes that are ready to be executed
    //after the user was allocated time by the scheduler.
    public void allocateTimeToProcesses(int currentTime){
        //Checks how many process are ready.
        int readyProcesses = 0;
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime <= currentTime){
                readyProcesses+=1;
            }
        }

        //If no process is ready, returns
        if(readyProcesses==0){
            return;
        }
        //Calculate the amount of time allocated to each ready process
        int time = allocatedTime/readyProcesses;

        //Allocate the correct amount of time to all ready processes and set their ready flag.
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime <= currentTime){
                Process current = user_processes.get(i);
                current.setAllocatedTime(time);
                current.setReady(true);
                user_processes.set(i,current);
            }
        }

    }

    //To assign a process to the user
    public void addProcess(Process p){
        user_processes.add(p);
    }

    //Getter
    public ArrayList<Process> getUser_processes() {
        return user_processes;
    }

    //Setter
    public void setUser_processes(ArrayList<Process> user_processes) {
        this.user_processes = user_processes;
    }

    //Determines if the user is ready(if it has at least one ready process
    public boolean isReady(int currentTime){
        //Iterates trough all process of that user and returns true if it finds oen that is ready
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime <= currentTime){
                return true;
            }
        }
        //returns false if no ready process was found
        return false;
    }

    //Returns true if user has no more processes
    public boolean isEmpty(){
        return user_processes.isEmpty();
    }

    //getter
    public String getName() {
        return name;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    //getter
    public int getAllocatedTime() {
        return allocatedTime;
    }

    //setter
    public void setAllocatedTime(int allocatedTime) {
        this.allocatedTime = allocatedTime;
    }
}