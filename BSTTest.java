/*
 * Name: Meetkumar Patel
 * CS 2400 Fall 2018 Project 3
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BSTTest
{
	
	public static void main(String[] args) throws IOException
	{		
		//Create a binary search tree using the user's input of numbers.
		BST<Integer> intBST = new BST<> ();
		
		System.out.println("% CS 2400 Fall 2018 Java Project 3 \n");
		System.out.println("Please enter the initial sequence of values:");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine(); //read a line of user input
		
		String[] numbers = line.trim().split("\\s+"); //store the line of input into a String array
		
		//Parse the String array and store each element into an int array
		int[] intNumbers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) 
		{
			intNumbers[i] = Integer.parseInt(numbers[i]);
		}
	
		// Add all the user entered numbers into the BST built called intBST
		for(int value : intNumbers) 
		{
			intBST.add(value);
		}
		
		// Print the three traversals of BST of the user entered numbers
		
		System.out.println();
		System.out.print("Pre-order: ");
		intBST.preorderTraverse();
		System.out.println();
		
		System.out.print("In-order: ");
		intBST.inorderTraverse();
		System.out.println();
		
		System.out.print("Post-order: ");
		intBST.postorderTraverse();
		System.out.println("\n");
		
		System.out.println("Below are the commands for navigating the program: ");
		System.out.println("I	Insert a value");
		System.out.println("D	Delete a value");
		System.out.println("P	Find predecessor");
		System.out.println("S	Find successor");
		System.out.println("E	Exit the program");
		System.out.println("H	Display this message");
		
		Scanner sc = new Scanner(System.in);
		String input, command[], option;
		
		do
		{
			System.out.print("Command? ");		
	
			input = sc.nextLine(); // retrieves entire line data
			command = input.split("\\s+"); // split by spaces
			
			option = command[0].toUpperCase(); //get the first element as user option
			
			// get the remaining input as int entry for the BST
			int entry = 0;
			if(command.length > 1) 
			{
				entry = Integer.parseInt(command[1]);
			}
			
			switch (option)
			{
				case "I":
					if(intBST.add(entry) == null)
					{
						System.out.print("In-order: ");
						intBST.inorderTraverse();
						System.out.println();
					}
					else
						System.out.println(entry + " already exists, ignore.");
					
					break;
					
				case "D":
					if(intBST.remove(entry) != null)
					{
						System.out.print("In-order: ");
						intBST.inorderTraverse();
						System.out.println();
					}
					else
						System.out.println(entry + " doesn't exist!");
					
					break;
					
				case "P":
					System.out.println(intBST.getPredecessor(entry));
					break;
					
				case "S":
					System.out.println(intBST.getSuccessor(entry));
					break;
					
				case "E":
					System.out.println("Thank you for using my program!");
					System.out.println("%");
					break;
					
				case "H":
					System.out.println("I	Insert a value");
					System.out.println("D	Delete a value");
					System.out.println("P	Find predecessor");
					System.out.println("S	Find successor");
					System.out.println("E	Exit the program");
					System.out.println("H	Display this message");
					break;
					
				default:
					System.out.println(" Incorrect option! Please enter option below");
					System.out.println("I	Insert a value");
					System.out.println("D	Delete a value");
					System.out.println("P	Find predecessor");
					System.out.println("S	Find successor");
					System.out.println("E	Exit the program");
					System.out.println("H	Display this message");
			}//end switch
		
		}while(!option.equals("E")); //end do-while
		
		br.close();
		sc.close();		
		
	} //end main
	
	
	
} //end BSTTest
