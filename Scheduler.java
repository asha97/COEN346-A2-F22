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

    //Constructor
    public Scheduler(ArrayList<User> inputArray, int q,BufferedWriter writer)
    {
        users = inputArray;
        timeQuantum = q;
        currTime = 1; //start time
        outputWriter = writer;

    }

    //Allocates the time quantum between the user which have at least one ready process
    private void allocateTime(){
        //Check how many users have at least one process ready to run
        int readyUsers = 0;
        for(int user=0;user<users.size();user++){
            if(users.get(user).isReady(currTime)){
                readyUsers += 1;
            }
        }

        //Divides the time quantum between the number of user that have at least one ready process at that time.
        int time = timeQuantum / readyUsers;

        //Allocates the allowed amount of time to all users. Note that even users with no ready processes get time,
        //but this isn't a problem since their processes still won't be executed (see run() method)
        for (int i = 0; i < users.size(); i++) {
            User current = users.get(i);
            //Allocates the user the allowed amount of time
            current.setAllocatedTime(time);
            //Allocates time to processes that are ready
            current.allocateTimeToProcesses(currTime);
            users.set(i, current);
        }
    }

    public void run() {
        //Runs until all processes are done
        while (isNotDone()) {
            //Allocates the allowed running time to all process that are ready
            this.allocateTime();
            //Iterates through all processes possessed by all users
            for (int user = 0; user < users.size(); user++) {
                for (int process = 0; process < users.get(user).getUser_processes().size(); process++) {
                    //Runs the process if it is ready at the beginning of the cycle
                    if (users.get(user).getUser_processes().get(process).isReady()&&users.get(user).getUser_processes().get(process).allocatedTime!=0) {
                        Process runningProcess = users.get(user).getUser_processes().get(process);
                        runningProcess.setCurrentTime(currTime);
                        runningProcess.setOutputWriter(outputWriter);
                        //Process runs for amount of allocated time or until it finishes
                        Thread t = new Thread(runningProcess);
                        t.start();
                        try {
                            t.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //Updates the current time inside the scheduler after the process is doen running
                        currTime = runningProcess.getCurrentTime();
                        //Updates the user with the running process if it has paused
                        if (runningProcess.getstate() == "ended") {
                            User current_user = users.get(user);
                            current_user.user_processes.remove(runningProcess);
                            users.set(user,current_user);
                        }
                        else{
                            //Removes process from its user if it ended
                            User current_user = users.get(user);
                            current_user.user_processes.set(process,runningProcess);
                            users.set(user,current_user);
                        }
                    }
                }
            }
        }
    }

    //Verify if all processes are completed
    public boolean isNotDone(){
        for(int user=0;user<users.size();user++){
            //Returns true if user still has processes that aren't completed
            if(!users.get(user).isEmpty()){
                return true;
            }
        }
        //Returns false if all processes for all users are completed
        return false;
    }

    //Add a user to the scheduler
    public void addUser(User u){
        users.add(u);
    }
}