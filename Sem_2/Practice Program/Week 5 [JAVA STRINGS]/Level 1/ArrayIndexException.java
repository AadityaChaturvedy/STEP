public class ArrayIndexException{

	public static String IndexException(String[] charArray)
	{
		return charArray[100];
	}

	public static void main(String[] args)
	{
		String[] charArray = {"a","b"};

		try{
			System.out.println(IndexException(charArray));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
		}

		try{
			System.out.println(IndexException(charArray));
		}catch(RuntimeException e){
			System.out.println("Runtime Exception: " + e.getMessage());
		}
	}
}