/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

class LinesProcInt {


    public static int processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        HashMap<String, String> softwareLatestVersionMap = new HashMap<String, String>();
        HashMap<String, Integer> softwareInstallationMap = new HashMap<String, Integer>();
        //double olderVersionSoftware;
        int returnValue = 0;
        //int serverCountWithOldSoftware;
        for(String s: array){
                StringTokenizer st = new StringTokenizer(s, ",");
                String[] arr = new String[4];
                int i=0;
                while(st.hasMoreTokens()){
                    arr[i++] = st.nextToken();
                }
                if(softwareLatestVersionMap.get(arr[2])!=null){
                    if(Double.valueOf(arr[3]) > Double.valueOf(softwareLatestVersionMap.get(arr[2]))){
                        softwareLatestVersionMap.put(arr[2],arr[3]);
                        softwareInstallationMap.put(arr[2]+arr[3], 1);
                    }
                    else{
                        if(softwareInstallationMap.get(arr[2]+arr[3])!=null){
                            returnValue++;
                        }
                        else{
                            softwareInstallationMap.put(arr[2]+arr[3], 1);
                        }
                    }
                }else{
                    softwareLatestVersionMap.put(arr[2],arr[3]);
                    softwareInstallationMap.put(arr[2]+arr[3], 1);

                }

        }

        return returnValue;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\jmishra\\IdeaProjects\\AdvancedDataStructures\\src\\input.txt")));
            while(in.hasNextLine()) {
                String line = in.nextLine().trim();
                if (!line.isEmpty()) // Ignore blank lines
                    inputData.add(line);
            }
            int retVal = processData(inputData);
            System.out.println("ReturnValue: "+retVal);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            output.println("" + retVal);
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
