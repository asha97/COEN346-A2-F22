import java.util.ArrayList;

public class User {
    private String name;
    private int allocatedTime;
    public ArrayList<Process> user_processes;
    private int number_of_ready_processes;

    User(String name){
        this.name = name;
        this.allocatedTime = 0;
        this.number_of_ready_processes = 0;
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

    public void allocateTimeToProcesses(){
        int time = allocatedTime/ number_of_ready_processes;
        for(int i =0;i<user_processes.size();i++){
            Process current = user_processes.get(i);
            current.setAllocatedTime(time);
            user_processes.set(i, current);
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

    public boolean isReady(int index){
        this.number_of_ready_processes = 0;
        boolean hasReadyProcesses = false;
        for(int i =0;i<user_processes.size();i++){
            if(user_processes.get(i).arrivalTime<=index){
                hasReadyProcesses = true;
                this.number_of_ready_processes += 1;
            }
        }
        return hasReadyProcesses;
    }

    public boolean isEmpty(){
        return user_processes.isEmpty();
    }
}