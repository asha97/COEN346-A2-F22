
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//This class is designed to import the content of an input text file where integers are stored line-by-line
public class FileInput {


    String input_path; //Path to the input file
    ArrayList<User> users; //Array list containing the users which contain the processes
    int timeQuantum; //Time quantum for the scheduler

    //Constructor
    public FileInput(String path){
        users = new ArrayList<User>();
        timeQuantum = 0;
        input_path = path;
    }

    //Method that takes the text input file path as an argument and return the content into an ArrayList of integers.
    public void inputArrayRead(){


        try {
            //Reader is opened
            String filepath = new File("").getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(input_path));

            //Read the time quantum on the first line of the input file
            timeQuantum = Integer.parseInt(reader.readLine());

            //First line is read
            String line = reader.readLine();
            //Read file until it's finished
            while (line != null) {

                //Splitting the elements on the line being read
                String[] splittingRead = line.split(" ");

                //First element: User name/identifier
                User user = new User(splittingRead[0]);

                //Next element: number of processes of the particular user.
                int numberOfProcesses = Integer.parseInt(splittingRead[1]);

                //we are going to be reading the processes of the user here.
                for (int i = 0; i < numberOfProcesses ; i++)
                {
                    //reading the line of the process with burst time and arrival time
                    line = reader.readLine();

                    //Splitting the elements on the line being read
                    splittingRead = line.split(" ");
                    //Ready/arrival time is recorded.
                    int arrivalT = Integer.parseInt(splittingRead[0]);
                    //Service/burst time is recorded.
                    int burstT = Integer.parseInt(splittingRead[1]);
                    //Process is created and added to the corresponding user
                    Process p = new Process(i, user.getName(), arrivalT, burstT);
                    user.addProcess(p);
                }
                //User is added to the user arraylist
                users.add(user);
                line = reader.readLine();
            }
            //Reader is closed
            reader.close();
        }
        //Prints the stack trace up to the error that was caught.
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //Getter
    public ArrayList<User> getUsers() {
        return users;
    }

    //Getter
    public int getTimeQuantum() {
        return timeQuantum;
    }
}