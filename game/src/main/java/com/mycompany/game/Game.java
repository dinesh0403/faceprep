

package com.mycompany.game;

import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Game {
    
    public static void append(String fileName, String str){
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
 
            out.write(str);
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }
	public static void main(String args[])
	{
            int retry;
            int score=0;
            int compscore=0;
            int choice;
            int maximum=0;
            String result = "";
            Scanner in = new Scanner(System.in);
            System.out.println("ENTER YOUR NAME : ");
            String name = in.nextLine();
            String fileName = "C:\\Users\\Dinesh\\Desktop\\scores.txt";
            try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("0 0");
            bw.close();
        }
 
        // Catch block to handle exceptions
        catch (IOException e) {
 
            // Display message when error occurs
            System.out.println("Exception Occurred" + e);
        }
                
            do {
                
                
		System.out.println("ENTER YOUR CHOICE \n\n 0 - ROCK \n 1 - PAPER \n 2 - SCISSORS");
		
		choice=in.nextInt();
		String[] action= {"rock","paper","scissors"};
		Random random = new Random();  
		int a=random.nextInt(3);
		System.out.println("the computer choice : "+action[a]);
		
		if(a==choice) {
                    
			System.out.println("match drawn");
			score=score+10;
                        compscore+=10;
		}
                
		else if((a==0&&choice==1)||(a==1&&choice==2)||(a==2&&choice==0)) {
			System.out.println("you won");
			score = score + 20;
		}
                
                else {
			System.out.println("computer won");
                        compscore += 20;
		}	
		System.out.println("Do you want to continue? 1/0");
		retry=in.nextInt();
		
            } while(retry==1);
            
            System.out.println("Your Total Score = "+score);
            System.out.println("COmputer's Total Score  = "+compscore);
            if(score == compscore){
                System.out.println("Draw game");
            }    
            else if(score > compscore){
                System.out.println("You have won the game");
            }
            else{
                System.out.println("Computer has won the game");
            }
            
            result = "\n"+name+" "+score;
            
            append(fileName,result );
                 
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            ArrayList<String> arr = new ArrayList<>();
            ArrayList<String> arrName = new ArrayList<>();
            String line;
            while ((line = br.readLine())!= null) {
                String[] splited = line.split("\\s");
                arr.add(splited[1]);
                arrName.add(splited[0]);
            }
            br.close();
            maximum = Integer.parseInt(arr.get(0));
            int countName=0;
            for (int i = 1; i < arr.size(); i++) {
                if(maximum < Integer.parseInt(arr.get(i))){
                    maximum = Integer.parseInt(arr.get(i));
                    countName=i;
                }
            }
            System.out.println("HIGH SCORE: "+maximum);
            System.out.println("By "+arrName.get(countName));
            
        }
        catch (IOException e) {
            System.out.println("Exception Occurred" + e);
        }
            
            
           
                
	}

}