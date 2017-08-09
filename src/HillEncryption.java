public class HillEncryption
{
	public static char[] encrypt(String message,String key)
	{
		int[]orignalMessage=HillUtilies.findIndexsOfMessage(message);
		int[][]orignalKey=HillUtilies.findIndexsOfKey(key);
		int charIndex[]=HillUtilies.multiplacation(orignalMessage, orignalKey);
		char result[]=new char[charIndex.length];
		for(int i=0;i<result.length;i++)
		{
			result[i]=HillUtilies.findCharOfIndex(charIndex[i]);
		}
		return result;
	}	
}
