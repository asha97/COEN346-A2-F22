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

    public void readInput()
    {
        //reader opened
        String filepath = new File("").getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filepath+input_path));

        //first reads the time quantum
        int timeQuantum;

        //since reader reads in strings, need to convert it to integer, stores the time quantum
        timeQuantum = Integer.parseInt(reader.readLine());

        /* we want to count the number of users and store their processes in separate arrays/arraylist */
        System.out.println ("read.");
        //increment the counter when character detected, will use to split time quantum
        int countUsers;
        //read of character
        char userLetter;
        //store the characters from A to Z
        char[] arrayOfChar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        //store number of processes of each user
        int numProcesses;

        //read through each line and check if there is a character

        for (int i = 0 ; i < arrayOfChar.length; i++ ) {
            //if read line is equal to any character in the arrayOfChar
            if (reader.readLine() == arrayOfChar[i]) {
                //incrementation of count to get number of users
                countUsers++;

                //store the number of processes read from file
                numProcesses = reader.readInt();

                //store the processes in the arrayList


                //now we want to read the number of processes and store it
            }
        }
    }



/*


    //Method that takes the text input file path as an argument and return the content into an ArrayList of integers.
    public int[] inputArrayRead(){

        //An ArrayList is created instead of an array since we don't know the size of th input file.
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            //Reader is opened
            String filepath = new File("").getAbsolutePath();
            BufferedReader reader = new BufferedReader(new FileReader(filepath+input_path));

            //Lines (strings) are read line-by-line, converted to integers, and added to the ArrayList.
            String line = reader.readLine();
            while (line != null) {
                list.add(Integer.parseInt(line));
                line = reader.readLine();
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
        }
        return array;
    }

}


 */