//this is where we are going to be scheduling the processes

//make a function that is going to be adding processes to a list/array

//make a list/array that is going to be representing the ready queue that could be scheduled
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.lang.Runnable;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler implements Runnable{

    //list of all the users
    public ArrayList<User> users;
    //time quantum
    public int timeQuantum;
    //get current time
    public int currTime;
    //Writer
    BufferedWriter outputWriter;

    public Scheduler(int q,BufferedWriter writer)
    {
        users = new ArrayList<User>();
        timeQuantum = q;
        currTime = 1; //start time
        outputWriter = writer;

    }

    private void allocateTime(){
        //Check how many users have at least one process ready to run
        int readyUsers = 0;
        for(int user=0;user<users.size();user++){
            if(users.get(user).isReady(currTime)){
                readyUsers += 1;
            }
        }
        int time = timeQuantum / readyUsers;
        for (int i = 0; i < users.size(); i++) {
            User current = users.get(i);
            current.setAllocatedTime(time);
            current.allocateTimeToProcesses(currTime);
            users.set(i, current);
        }
    }

    public void run() {
        while (isNotDone()) {
            //Allocates the allowed running time to all process that are ready
            this.allocateTime();
            for (int user = 0; user < users.size(); user++) {
                for (int process = 0; process < users.get(user).getUser_processes().size(); process++) {
                    //Runs the process if it is ready
                    if (users.get(user).getUser_processes().get(process).isReady()&&users.get(user).getUser_processes().get(process).allocatedTime!=0) {
                        Process runningProcess = users.get(user).getUser_processes().get(process);
                        runningProcess.setCurrentTime(currTime);
                        runningProcess.setOutputWriter(outputWriter);
                        //Process runs for amount of allocated time or until
                        Thread t = new Thread(runningProcess);
                        t.start();
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //Updates the current time inside the scheduler
                        currTime = runningProcess.getCurrentTime();
                        //Updates the user with the running process or removes it if it has ended
                        if (runningProcess.getstate() == "ended") {
                            User current_user = users.get(user);
                            current_user.user_processes.remove(runningProcess);
                            users.set(user,current_user);
                        }
                        else{
                            User current_user = users.get(user);
                            current_user.user_processes.set(process,runningProcess);
                            users.set(user,current_user);
                        }
                    }
                }
            }
        }
    }

    public boolean isNotDone(){
        for(int user=0;user<users.size();user++){
            if(!users.get(user).isEmpty()){
                return true;
            }
        }
        return false;
    }

    public void addUser(User u){
        users.add(u);
    }
}