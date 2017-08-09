import java.util.Scanner;

public class MainMenue 
{

	public static void main(String[] args)
	{
		Scanner inp=new Scanner(System.in);
		Scanner inp2=new Scanner(System.in);
		//key=hbddcdhbm

		while(true)
		{
			System.out.println("Choose From Operations :-");
			System.out.println("1-Encryption.");
			System.out.println("2-Decryption.");
			int choose=inp2.nextInt();
			switch(choose)
			{
			case 1:
			{
				String plainMessage,key;
				char[]cipherMessageChars;
				System.out.println("Enter Your Message 'only 3 characters' ");
				plainMessage=inp.nextLine();
				System.out.println("Enter Your Key 'only 9 characters' ");
				key=inp.nextLine();
				cipherMessageChars=HillEncryption.encrypt(plainMessage, key);
				StringBuilder cipherMessage=new StringBuilder();
				for(int i=0;i<cipherMessageChars.length;i++)
				{
					cipherMessage.append(cipherMessageChars[i]);
				}
				System.out.print("Your Cipher Text is : "+cipherMessage.toString());
				break;
			}
			case 2:
			{
				String cipherMessage,key;
				char[]plainMessageChars;
				System.out.println("Enter Your Cipher Message 'only 3 characters' ");
				cipherMessage=inp.nextLine();
				System.out.println("Enter Your Key 'only 9 characters' ");
				key=inp.nextLine();
				plainMessageChars=HillDecryption.decrypt(cipherMessage,key);
				StringBuilder plainMessage=new StringBuilder();
				for(int i=0;i<plainMessageChars.length;i++)
				{
					plainMessage.append(plainMessageChars[i]);
				}
				System.out.print("Your Plain Text is : "+plainMessage.toString());
				break;
			}
			default:
			{
				System.out.println("Please,Select a Valid Chooise !");
			}
			}
			break;
		}
	}
}
