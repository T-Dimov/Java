package inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InputOutput
{

	public static void main(String[] args)
	{
		try(ShljokawicaReader sr = new ShljokawicaReader(new InputStreamReader(System.in)))
		{
			BufferedWriter f = new BufferedWriter(
					new FileWriter("conv.txt"));
			String str = "";
			int c = 0;
			while (!str.equals("край") && c != -1)
			{
				c = sr.read();
				f.write(c);
				if (Character.isLetter(c))
				{
					str += new String(Character.toChars(c));
				}
				else
				{
					str = "";
				}
			}
			f.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try(WordCounter in = new WordCounter(new BufferedReader(new FileReader("conv.txt"))))
		{
			TreeMap<Integer, Integer> histogram = new TreeMap<Integer, Integer>();
			String str = "";
			int c = 0;
			do
			{
				c = in.read();
				if (c != 0 && c != -1)
				{
					str += new String(Character.toChars(c));
					if (Character.isLetter(c))
					{
						Integer v = histogram.get(c);
						if (v == null)
						{
							v = 0;
						}
						histogram.put(c, v + 1);
					}
				}
			} while(c != -1);
			
			int wc = str.split("\\s+").length;
			System.out.println("Брой думи във въведения текст: " + wc);
			System.out.println("Първите 7 най-често срещани букви във въведения текст:");
			sortAndPrintMap(histogram);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void sortAndPrintMap(TreeMap<Integer, Integer> map)
	{
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>( map.entrySet());
        Collections.sort
        ( 
    		list, new Comparator<Map.Entry<Integer, Integer>>()
	        {
	            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
	            {
	                int comp =  o1.getValue().compareTo(o2.getValue());
	                if (comp == 0)
	                {
	                	comp = o1.getKey().compareTo(o2.getKey());
	                }
	                return comp * -1;
	            }
	        }
        );
        for (int i = 0; i < 7 && i < list.size(); ++i)
        {
        	Map.Entry<Integer, Integer> elem = list.get(i);
        	System.out.println(new String(Character.toChars(elem.getKey())) + ": " + elem.getValue());
        }
	}
}
