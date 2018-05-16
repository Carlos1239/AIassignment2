/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiassignment2;
import java.io.*;
import java.util.*;


public class AIAssignment2 {

    /**
     */
    public static AIAssignment2 iengine;
    public static String query;
    public static ArrayList<String> facts;
    public static ArrayList<String> clauses;
    public static ArrayList<String> agenda;
    public static final int METHOD_COUNT = 1;
    public static SearchMethod[] aMethods;

    public static void main(String[] args) {
        
        //InitMethods();
        facts = new ArrayList<>();
        clauses = new ArrayList<>();
        agenda = new ArrayList<>();
        
        if(args.length <2){
            System.out.println("Usage:iengine <method> <filename>");
            System.exit(1);
        }
        try{
            readProblemFile(args[1]);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        String method = args[1];
	SearchMethod thisMethod = null;
		
//        //determine which method the user wants to use to solve the puzzles
//            for(int i = 0; i < METHOD_COUNT; i++)
//            {
//                    //do they want this one?
//                    if(aMethods[i].code.compareTo(method) == 0)
//                    {
//                            //yes, use this method.
//                            thisMethod = aMethods[i];
//                    }
//            }
//
//            //Has the method been implemented?
//            if(thisMethod == null)
//            {
//                    //No, give an error
//                    System.out.println("Search method identified by " + method + " not implemented. Methods are case sensitive.");
//                    System.exit(1);
//            }
//           
        if(facts!=null){
            System.out.print(facts);
        }
        
        if(clauses!=null){
            System.out.print(clauses);
        }
        
        if(agenda!=null){
            System.out.print(agenda);
        }


        
    }
    
    private static void InitMethods(){
        aMethods[0]= new FC();
        //TT
        //FC
        //BC
    }
    
    private static void readProblemFile(String fileName) // this allow only one puzzle to be specified in a problem file 
	{
		String[] sentencesArray;
		try
		{
			//create file reading objects
			FileReader reader = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(reader);
			AIAssignment2 result;
                        
                        String line = buff.readLine();
                        if(line.equalsIgnoreCase("Tell")){
                            line = buff.readLine();
                            sentencesArray = line.split(";");
                            for (int i=0; i<sentencesArray.length;i++){
                                if(!sentencesArray[i].contains("=>"))
                                    facts.add(sentencesArray[i]);
                                else{
                                    clauses.add(sentencesArray[i]);
                                }
                            }
                            
                        }
                        
                        line = buff.readLine();
                        if(line.equalsIgnoreCase("Ask")){
                            line = buff.readLine();
                            agenda.add(line);
                        }
                        
                        
			
			
			
		}
		catch(FileNotFoundException ex)
		{
			//The file didn't exist, show an error
			System.out.println("Error: File \"" + fileName + "\" not found.");
			System.out.println("Please check the path to the file.");
			System.exit(1);
		}
		catch(IOException ex)
		{
			//There was an IO error, show and error message
			System.out.println("Error in reading \"" + fileName + "\". Try closing it and programs that may be accessing it.");
			System.out.println("If you're accessing this file over a network, try making a local copy.");
			System.exit(1);
		}
		
		//this code should be unreachable. This statement is simply to satisfy Eclipse.
		
	}
}