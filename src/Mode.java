
public class Mode {
	
	public static int FindMode(int[] a)
	{
		//this.a = a; 
		int count = 0; 
		int mode = 0; 
		for (int i =1; i < a.length; i++)
		{
			if (a[i] == a[i-1])
			{
				count = 2;
				mode = a[i]; 
				//added
				if (i+1 < a.length)
				{
				if (a[i+1] == mode)
				{
					count ++; 
				}
				}
			}
		}
		for (int i = 1; i < a.length; i ++)
		{
			if ( a[i] == a[i-1])
			{
				int tempcount = 2; 
				//added
				if (i+1 < a.length)
				{
					if (a[i] == a[i+1])
				{
					tempcount++;
					if (tempcount > count)
					{
						mode = a[i]; 
					}
				}
				}
			}
		}
		return mode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		int[] a = {2,5,6,7,7,10,11,11,13,15,15,15,19,19,19,19,20,20}; 
		
		System.out.println(FindMode(a));

	}

}
