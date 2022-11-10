//this is where we are going to be scheduling the processes

//make a function that is going to be adding processes to a list/array

//make a list/array that is going to be representing the ready queue that could be scheduled
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

    //process list
    public ArrayList<Process> processList;

    public Scheduler(int q)
    {
        users = new ArrayList<User>();
        processList = new ArrayList<Process>();
        timeQuantum = q;
        currTime = 1; //start of the time
    }

    private void allocateTime(){
        //Check which user have at least one process ready to run
        int size = 0;
        for(int user=0;user<users.size();user++){
            if(users.get(user).isEmpty()){
                continue;
            }
            else{
                size += 1;
            }
        }

        int time = timeQuantum/size;
        for(int i =0;i<users.size();i++){
            User current = users.get(i);
            current.setAllocatedTime(time);
            current.allocateTimeToProcesses();
            users.set(i, current);
            processList.addAll(current.getUser_processes());
        }
    }

    public void run()
    {




    }




}