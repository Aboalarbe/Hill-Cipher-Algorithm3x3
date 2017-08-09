public class HillUtilies 
{
	public static final char[]arr=new char[]
			{   'A','B','C','D','E',
		'F','G','H','I','J','K',
		'L','M','N','O','P',
		'Q','R','S','T','U',
		'V','W','X','Y','Z'  };

	public static char[] encrypt(String message,String key)
	{
		int[]orignalMessage=findIndexsOfMessage(message);
		int[][]orignalKey=findIndexsOfKey(key);
		int charIndex[]=multiplacation(orignalMessage, orignalKey);
		char result[]=new char[charIndex.length];
		for(int i=0;i<result.length;i++)
		{
			result[i]=findCharOfIndex(charIndex[i]);
		}
		return result;
	}
	
	public static char[] decrypt(String cipherMessage,String key)
	{
		int[]cipherTxt=findIndexsOfMessage(cipherMessage);
		int[][]decryptionKey=keyOfDecryption(key);
		int[]charIndex=multiplacation(cipherTxt, decryptionKey);
		char result[]=new char[charIndex.length];
		for(int i=0;i<result.length;i++)
		{
			result[i]=findCharOfIndex(charIndex[i]);
		}
		return result;
	}
	
	public static int[] findIndexsOfMessage(String message) 
	{
		String orignalMessage=message.toUpperCase();
		char orignalChars[]=orignalMessage.toCharArray();
		int[] index = new int[orignalMessage.length()] ;
		for(int i=0;i<orignalChars.length;i++)
		{
			index[i]= findIndexOfChar(orignalChars[i]);
		}
		return index;
	}

	public static int[][] findIndexsOfKey(String key) 
	{
		String orignalKey=key.toUpperCase();
		char orignalChars[]=orignalKey.toCharArray();
		int[] index = new int[orignalKey.length()] ;
		for(int i=0;i<orignalChars.length;i++)
		{
			index[i]= findIndexOfChar(orignalChars[i]);
		}
		int keyIndex[][]=new int[][]
			   {{index[0],index[1],index[2]},
				{index[3],index[4],index[5]},
				{index[6],index[7],index[8]}};

		return keyIndex;
	}

	public static int findIndexOfChar (char c)
	{
		int index=-1;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==c)
			{
				index=i;
				break;
			}
		}
		return index;
	}
	
	public static char findCharOfIndex (int n)
	{
		char ch='a';
		for(int i=0;i<arr.length;i++)
		{
			if(arr[n]==arr[i])
			{
				ch=arr[i];
				break;
			}
		}
		return ch;
	}
	public static int[] multiplacation(int message[],int key[][])
	{
		int result[]=new int[message.length];
		result[0]=((message[0]*key[0][0])+(message[1]*key[1][0])+(message[2]*key[2][0]));
		result[1]=((message[0]*key[0][1])+(message[1]*key[1][1])+(message[2]*key[2][1]));
		result[2]=((message[0]*key[0][2])+(message[1]*key[1][2])+(message[2]*key[2][2]));
		for(int i=0;i<result.length;i++)
		{
			result[i]%=26;
		}
		return result;
	}
	
	public static int valueOfMatrix(String key)
	{
		int[][]arr=findIndexsOfKey(key);
		int value1=arr[0][0]*(arr[1][1]*arr[2][2]-arr[1][2]*arr[2][1]);
		int value2=-arr[0][1]*(arr[1][0]*arr[2][2]-arr[1][2]*arr[2][0]);
		int value3=arr[0][2]*(arr[1][0]*arr[2][1]-arr[1][1]*arr[2][0]);
		int result=(value1+value2+value3)%26;;
		if(result>0)
		return result;
		else 
			return result+26;
	}
	
	public static int FindK(int n)
	{
		int k=-1;
		for(int i=0;i<26;i++)
		{
			if((n*i)%26==1)
			{
				k=i;
				break;
			}
		}
		return k;
	}
	
	public static int[][] transposeMatrix(String key)
	{
		int[][]arr=findIndexsOfKey(key);
		int[][]transopsedArr=new int[3][3];
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				transopsedArr[i][j]=arr[j][i];
			}
		}
		return transopsedArr;
	}
	
	public static int[][] keyOfDecryption(String key)
	{
		int arr[][]=transposeMatrix(key);
		int k=FindK(valueOfMatrix(key));
		int decryptionKey[][]=new int[3][3];
		decryptionKey[0][0]=(((arr[1][1]*arr[2][2]-arr[1][2]*arr[2][1])*k)%26);
		decryptionKey[0][1]=-(((arr[1][0]*arr[2][2]-arr[1][2]*arr[2][0])*k)%26);
		decryptionKey[0][2]=(((arr[1][0]*arr[2][1]-arr[1][1]*arr[2][0])*k)%26);
		decryptionKey[1][0]=-(((arr[0][1]*arr[2][2]-arr[0][2]*arr[2][1])*k)%26);
		decryptionKey[1][1]=(((arr[0][0]*arr[2][2]-arr[0][2]*arr[2][0])*k)%26);
		decryptionKey[1][2]=-(((arr[0][0]*arr[2][1]-arr[0][1]*arr[2][0])*k)%26);
		decryptionKey[2][0]=(((arr[0][1]*arr[1][2]-arr[0][2]*arr[1][1])*k)%26);
		decryptionKey[2][1]=-(((arr[0][0]*arr[1][2]-arr[0][2]*arr[1][0])*k)%26);
		decryptionKey[2][2]=(((arr[0][0]*arr[1][1]-arr[0][1]*arr[1][0])*k))%26;
		for(int i=0;i<decryptionKey.length;i++)
		{
			for(int j=0;j<decryptionKey.length;j++)
			if(decryptionKey[i][j]>=0)
			{
				decryptionKey[i][j]=decryptionKey[i][j];
			}
			else{
				decryptionKey[i][j]+=26;
			}
				
		}
		return decryptionKey;
	}
}
