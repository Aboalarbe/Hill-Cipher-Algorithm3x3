public class HillDecryption 
{
	public static char[] decrypt(String cipherMessage,String key)
	{
		int[]cipherTxt=HillUtilies.findIndexsOfMessage(cipherMessage);
		int[][]decryptionKey=HillUtilies.keyOfDecryption(key);
		int[]charIndex=HillUtilies.multiplacation(cipherTxt, decryptionKey);
		char result[]=new char[charIndex.length];
		for(int i=0;i<result.length;i++)
		{
			result[i]=HillUtilies.findCharOfIndex(charIndex[i]);
		}
		return result;
	}
}
