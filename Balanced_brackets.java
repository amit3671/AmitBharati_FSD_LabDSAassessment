package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Balanced_brackets {
	
	static public boolean Check_brackets(String line) {
		
		 Deque<Character> stack = new ArrayDeque<Character>();

     for (int i = 0; i < line.length(); i++) {
         char input = line.charAt(i);

         if (input == '(' || input == '[' || input == '{') {
             stack.push(input);
             continue;
         }

         if (stack.isEmpty())
             return false;
         char check_Brac;
         switch (input) {
         case ')':
        	 check_Brac = stack.pop();
             if (check_Brac == '{' || check_Brac == '[')
                 return false;
             break;

         case '}':
        	 check_Brac = stack.pop();
             if (check_Brac == '(' || check_Brac == '[')
                 return false;
             break;

         case ']':
        	 check_Brac = stack.pop();
             if (check_Brac == '(' || check_Brac == '{')
                 return false;
             break;
         }
     }
     return (stack.isEmpty());
	}
	
	public void status(String line) {
		
		if(Check_brackets(line) == true)
			System.out.println("The entered String has Balanced Brackets");
		
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
		
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    Balanced_brackets Bb = new Balanced_brackets();
    
    System.out.println("Enter the brackets");
    String Brac = sc.next();
    
    Balanced_brackets.Check_brackets(Brac);
    Bb.status(Brac);
        	
    }
    
	}
