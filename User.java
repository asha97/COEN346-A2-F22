import java.util.ArrayList;

public class User {
    private String name;
    private int allocatedTime;
    private ArrayList<Process> user_processes;

    User(String name){
        this.name = name;
        this.allocatedTime = 0;
    }

    public User() {

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
        int time = allocatedTime/ user_processes.size();
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

    public boolean isEmpty(){
        if(user_processes.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }


}
