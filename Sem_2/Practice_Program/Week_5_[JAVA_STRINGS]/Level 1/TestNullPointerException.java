public class TestNullPointerException{

	public static char ExceptionTest(String str)
	{
		return str.charAt(1);
	}

	public static void main(String[] args)
	{
		String text = null;

		try{
			System.out.println(ExceptionTest(text));
		}catch(NullPointerException e){
			System.out.println("NullPointerException => " + e.getMessage());
		}

		System.out.println(text.charAt(1));
	}
}