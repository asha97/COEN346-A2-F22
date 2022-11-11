import java.util.ArrayList;

public class User {
    private String name;
    private int allocatedTime;
    public ArrayList<Process> user_processes;

    User(String name){
        this.user_processes = new ArrayList<Process>();
        this.name = name;
        this.allocatedTime = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAllocatedTime() {
        return allocatedTime;
    }

    public void setAllocatedTime(int allocatedTime) {
        this.allocatedTime = allocatedTime;
    }

    public void allocateTimeToProcesses(int currentTime){
        //Checks how many process are ready
        int readyProcesses = 0;
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime <= currentTime){
                readyProcesses+=1;
            }
        }

        //Calculate the amount of time allocated to each ready process
        if(readyProcesses==0){
            return;
        }
        int time = allocatedTime/readyProcesses;
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime <= currentTime){
                Process current = user_processes.get(i);
                current.setAllocatedTime(time);
                current.setReady(true);
                user_processes.set(i,current);
            }
        }

    }

    public void addProcess(Process p){
        user_processes.add(p);
    }

    public ArrayList<Process> getUser_processes() {
        return user_processes;
    }

    public void setUser_processes(ArrayList<Process> user_processes) {
        this.user_processes = user_processes;
    }

    public boolean isReady(int currentTime){
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime <= currentTime){
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty(){
        return user_processes.isEmpty();
    }
}