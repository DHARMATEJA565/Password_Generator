import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator{

	static Scanner sc = new Scanner(System.in);
	static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	static final String NUMBERS = "0123456789";
	static final String SYMBOLS = "!@#$%^&*()_+=-<,>./?;[]{}\'";

	static void Generate(){

	
		String pool ="" ;
		String b=""; //password
		int rand =0;
		char randc='a';
		int c = 0; //count
		String s1 = new String("yes");

		System.out.println("*** WELCOME TO PASSWORD GENERATION ***");
		System.out.println("\n" +"PLease answer YES or NO for following questions. " +"\n");

		String  a[] = new String[4];

		System.out.println("Do you want to include UPPERCASE LETTERS (ABCD...)");
		a[0] =  sc.next();
		System.out.println("Do you want to include LOWERCASE LETTERS (abcd...)");
		a[1] =  sc.next();
		System.out.println("Do you want to include NUMBERS (1234....)");
		a[2] =  sc.next();
		System.out.println("Do you want to include SPECIAL CHARACTERS (#$@^%*....)");
		a[3] =  sc.next();      	

		if ((a[0].toLowerCase()).equals(s1) ){
				 pool = pool + UPPERCASE_LETTERS;
				//to append atleast one upper case letter
			         rand = new Random().nextInt(UPPERCASE_LETTERS.length());
			         randc =UPPERCASE_LETTERS.charAt(rand);
			         b = b+randc;
				 c++;
		}

		if ((a[3].toLowerCase()).equals(s1)) {

				 pool = pool + SYMBOLS;
				 //to append atleast one special character
			         rand = new Random().nextInt(SYMBOLS.length());
			         randc = SYMBOLS.charAt(rand);
			         b = b+randc;
 	              		 c++;
		}

		if ((a[2].toLowerCase()).equals(s1)) {
				 pool = pool + NUMBERS;
				 //to append atleast one number
			         rand = new Random().nextInt(NUMBERS.length());
			         randc = NUMBERS.charAt(rand);
			         b = b+randc;
				 c++;
		}
		if ((a[1].toLowerCase()).equals(s1)) {

				 pool = pool + LOWERCASE_LETTERS;
				 //to append atleast one lower case letter
			         rand = new Random().nextInt(LOWERCASE_LETTERS.length());
			         randc = LOWERCASE_LETTERS.charAt(rand);
			         b = b+randc;
				 c++;
		}
		int len = pool.length(); 

		if(len >0) {

			System.out.println("\n" +"Please enter your desired length for the password : ");
			int length = sc.nextInt();
			for(int i=0 ; i<length-c; ++i)
				{
					rand = new Random().nextInt(len);
					randc = pool.charAt(rand);
					b = b + randc;
				}
			if (length>=c) System.out.println ( " YOUR PASSWORD IS :  " + b);
			else System.out.println("Please enter valid length.");
		}else {
			System.out.println("Please choose atleast one character set.");
		}
}

	static void Strength_Check(){
		System.out.println("Enter your password: " );
		boolean upper = false;
        	boolean lower = false;
        	boolean number = false;
        	boolean symbol = false;
		String password = sc.next();
		int val = 0 ;
		
		for (int i = 0; i < password.length(); i++) {
            		char c = password.charAt(i);
			val = (int) c ;
            		if (val >=65 && val <=90) upper = true;
           		else if (val >=97 && val <=122) lower = true;
            		else if (val >=48 && val <=57) number = true;
            		else symbol = true;
        	}
		val = 0 ;
		
		if (upper) val++;
		if (lower) val ++;
		if (number) val++;
		if (symbol) val++;

		if( password.length() >=8 ) val ++;
		if(password.length()>=16) val ++;

		if (val == 6) {
            		System.out.println("This is a very good password :D");
        		} else if ( val >= 4) {
            			System.out.println("This is a good password :) but you can still do better");
       			 } else if (val >= 3) {
           			 System.out.println("This is a medium password :/ try making it better");
      			  } else {
            			System.out.println("This is a weak password :( find a new one");
      			  }

	}

	public static void main (String [] args) {

		int choice = 0;
		System.out.println("\n\n******** WELCOME TO DHARMA PASSWORD HUB **********" +"\n\n");
		while (true) {

			System.out.println("1. Password Generation \n2. Check Password Strength \n3. Info about Best Passwords \n4. QUIT " );
			System.out.println("Enter the your choice of command : ");
			choice = sc.nextInt();
			if ( choice == 4 ){ 
				System.out.println(" ***** THANK YOU FOR USING DHARMA PASSWORD HUB  *****"); 
				break;
			}
			switch (choice) {
				 case 1 : Generate();
			    	          break;
				 case 2 : Strength_Check();
					  break;

 			 	 case 3 : System.out.println("\n-> Use a minimum password length of 8 or more characters if permitted \n-> Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted \n-> Avoid using the same password twice \n-> For the strongest password it is better to use a minimum  of 16 characters");
        			  	  break;

				default : System.out.println("Please Enter Valid Number. ");

			}

			System.out.println("\n\n");
 
		}

	}
}