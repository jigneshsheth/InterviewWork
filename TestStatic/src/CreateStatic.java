import java.util.ArrayList;
import java.util.List;


public class CreateStatic {
	
	private static final List<String> mins = new ArrayList<String>();
	
	public static List<String> fillRandomMins()
	{
		for(int i = 0; i < 10; i++)
		{
			mins.add("Min " + i);
		}
		return mins;
	}

}
