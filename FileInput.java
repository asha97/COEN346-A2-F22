
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//This class is designed to import the content of an input text file where integers are stored line-by-line
public class FileInput {


    String input_path; //Path to the input file

    //Constructor
    public FileInput(String path){
        input_path = path;
    }

    //Method that takes the text input file path as an argument and return the content into an ArrayList of integers.
    public int[] inputArrayRead(){

        //An ArrayList is created instead of an array since we don't know the size of th input file.
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            //Reader is opened
            String filepath = new File("").getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(filepath+input_path));

            //Read the time quantum on the first line of the input file
            int timeQuantum = Integer.parseInt(reader.readLine());

            //Creating object scheduler
            Scheduler scheduler = new Scheduler(timeQuantum);

            String line = reader.readLine();
            while (line != null) {

                //Splitting the elements on the line being read
                String[] splittingRead = line.split(" ");

                //First element: User
                User user = splittingRead[0];
                scheduler.addUser(user);

                //next element: number of processes of the particular user.
                int numberOfProcesses = Integer.parseInt(splittingRead[1]);

                //we are going to be reading the processes of the user here
                for (int i = 0; i < numberOfProcesses ; i++)
                {
                    //reading the line of the process with burst time and arrival time
                    int arrivalT = reader.read();
                    int burstT = reader.read();
                    //adding the process into an arraylist
                    scheduler.addProcess(i, user, arrivalT, burstT);
                }
            }
            //Reader is closed
            reader.close();
        }
        //Prints the stack trace up to the error that was caught.
        catch(IOException e){
            e.printStackTrace();
        }
        //ArrayList is converted to an int[] array and returned by the method.
        int[] array = new int[list.size()];

        for(int i=0;i<list.size();i++){
            array[i] = list.get(i).intValue();
            System.out.println(array[i]);
        }

        return array;
    }

}

