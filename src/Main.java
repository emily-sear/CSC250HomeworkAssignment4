import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		String inputedNum = input.nextLine();
		
		System.out.println("Your binary number in hexidecimal is: " + Main.decimalToHex(Main.binaryToDecimal(inputedNum)));
		System.out.println("Your binary number in hexidecimal is: " + Main.binaryToHex(inputedNum));
	}
	
	public static int binaryToDecimal(String binaryNumber)
	{
		int answer = 0;
		int exponentNum = binaryNumber.length() -1;
		
		for(int i = 0; i < binaryNumber.length() ; i++)
		{
			int holder = Integer.parseInt(binaryNumber.valueOf(binaryNumber.charAt(i)));
			//System.out.println(holder);
			
			holder = holder * (int)Math.pow(2,exponentNum);
			//System.out.println(holder);
			
			answer = answer + holder;
			//System.out.println(holder);
			exponentNum--;
		}
		return answer;
	}
	
	public static int binaryToDecimalClassExample(String bin)
	{
		//does the same thing as binaryToDecimal()
		int place = 1;
		int sum = 0;
		
		for(int i = bin.length() - 1; i >= 0; i--)
		{
			if(bin.charAt(i) == '1')
			{
				sum += place;
			}
			place *= 2;
		}
		
		return sum;
	}
	
	public static String padZeroForHex(String bin)
	{
		//only goes through the length of the string %4 amount of times... 
		//This allows you to have groups of 4 bits... you are able to group your binary num into groups of 4
		int zerosToAdd = 4 - (bin.length()%4);
		//System.out.println(zerosToAdd);
		for(int i = 0; i < zerosToAdd; i++)
		{
			bin = "0" + bin;
		}
		return bin;
	}
	
	static String nibbleToHextet(String nibble)
	{
		String[] nibbles = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000",
				"1001", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
		String map = "0123456789ABCDEF";
		
		for(int i = 0; i < nibbles.length; i++)
		{
			//equals() does this method contains the same characters as another String
			if(nibbles[i].equals(nibble))
			{
				return "" + map.charAt(i);
			}
		}
		return "-1";
	}
	
	public static String binaryToHex(String binaryNumber)
	{	
		String answer = "";
		String paddedBin = Main.padZeroForHex(binaryNumber);
		for(int i = 0; i < paddedBin.length(); i+=4)
		{
			answer = answer + Main.nibbleToHextet("" + binaryNumber.charAt(i) + binaryNumber.charAt(i+1) + binaryNumber.charAt(i+2) + binaryNumber.charAt(i+3));
		}
		return answer;
	}
	
	public static String decimalToHex(int decimal)
	{
		String answer = ""; 
		String map = "0123456789ABCDEF";
		
		while(decimal > 0)
		{
			answer = map.charAt(decimal%16) + answer;
			decimal = decimal/16;
		}
		return answer;
	}
}
