
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//This class is designed to import the content of an input text file where integers are stored line-by-line
public class FileInput {


    String input_path; //Path to the input file
    ArrayList<User> users;
    int timeQuantum;

    //Constructor
    public FileInput(String path){
        users = new ArrayList<User>();
        timeQuantum = 0;
        input_path = path;
    }

    //Method that takes the text input file path as an argument and return the content into an ArrayList of integers.
    public void inputArrayRead(){

        //An ArrayList is created instead of an array since we don't know the size of th input file.
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            //Reader is opened
            String filepath = new File("").getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(input_path));

            //Read the time quantum on the first line of the input file
            timeQuantum = Integer.parseInt(reader.readLine());

            String line = reader.readLine();
            while (line != null) {

                //Splitting the elements on the line being read
                String[] splittingRead = line.split(" ");

                //First element: User
                User user = new User(splittingRead[0]);

                //next element: number of processes of the particular user.
                int numberOfProcesses = Integer.parseInt(splittingRead[1]);

                //we are going to be reading the processes of the user here
                for (int i = 0; i < numberOfProcesses ; i++)
                {
                    //reading the line of the process with burst time and arrival time
                    line = reader.readLine();
                    splittingRead = line.split(" ");
                    int arrivalT = Integer.parseInt(splittingRead[0]);
                    int burstT = Integer.parseInt(splittingRead[1]);
                    //adding the process into an arraylist
                    Process p = new Process(i, user.getName(), arrivalT, burstT);
                    user.addProcess(p);
                }
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

    public ArrayList<User> getUsers() {
        return users;
    }

    public int getTimeQuantum() {
        return timeQuantum;
    }
}