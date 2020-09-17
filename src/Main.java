import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a number");
		String inputedNum = input.nextLine();
		
		System.out.println("Your binary number in decimal is: " + Main.decimalToHex(Main.binaryToDecimal(inputedNum)));
		
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
