import java.util.List;


public class Driver {
	private static final List<String> localMins = CreateStatic.fillRandomMins();

	public static void main(String[] args) {
		printMins();
	
	}
	
	public static void printMins()
	{
		for(String x : localMins)
		{
			System.out.println(x);
		}
	}

}
