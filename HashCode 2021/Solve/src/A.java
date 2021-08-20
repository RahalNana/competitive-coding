import java.io.File;
import java.util.*;

public class A 
{
	public static HashMap<String, Street> streets;
	public static ArrayList<Car> cars;
	
	public static class Street implements Comparable<Street>
	{
		String name;
		int start, end, time, carCount;
		
		public Street(int start, int end, String name, int time)
		{
			this.name = name;
			this.start = start;
			this.end = end;
			this.time = time;
			carCount = 0;
		}
		
		public Street(String... s)
		{
			this(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2], Integer.parseInt(s[3]));
		}
		
		public String toString()
		{
			return name+" "+start+" - "+end+" : "+time;
		}

		public int compareTo(Street s) 
		{
			return carCount - s.carCount;
		}
	}
	
	public static class Car implements Comparable<Car>
	{
		int id, length, travelTime;
		ArrayList<Street> streetList;
		
		public Car(int id, String s)
		{
			this.id = id;
			travelTime = 0;
			String data[] = s.split(" ");
			length = Integer.parseInt(data[0]);
			streetList = new ArrayList<Street>();
			for(int i=0; i<length; i++)
			{
				streetList.add(streets.get(data[i+1]));
				travelTime += streets.get(data[i+1]).time;
				streets.get(data[i+1]).carCount++;
			}
		}
		
		public String toString()
		{
			return id+" : "+streetList.get(0).name+" ---> "+streetList.get(length-1).name;
		}

		public int compareTo(Car c) 
		{
			return travelTime - c.travelTime;
		}

	}
	
	public static class Intersection
	{
		int id;
		ArrayList<String> streetName;
		ArrayList<Integer> time;
		
		public Intersection(int id)
		{
			this.id = id;
			streetName = new ArrayList<String>();
			time = new ArrayList<Integer>();
		}
		
		public void put(String str, int t)
		{
			streetName.add(str);
			if (time.size()>0)
				time.add(t-time.get(time.size()-1));
			else
				time.add(t);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		File input = new File("E:\\Competitions\\HashCode 2021\\f.txt");
		Scanner in = new Scanner(input);
		String[] data = in.nextLine().split(" ");
		int d = Integer.parseInt(data[0]);
		int i = Integer.parseInt(data[1]);
		int s = Integer.parseInt(data[2]);
		int v = Integer.parseInt(data[3]);
		int f = Integer.parseInt(data[4]);
		
		streets = new HashMap<String,Street>();
		for(int x=0; x<s; x++)
		{
			data = in.nextLine().split(" ");
			streets.put(data[2], new Street(data));
		}
		LinkedList<Street> streetList = new LinkedList<Street>(streets.values());
		
		
		cars = new ArrayList<Car>();
		for(int x=0; x<v; x++)
			cars.add(new Car(x, in.nextLine()));
		
		Collections.sort(streetList, Collections.reverseOrder());
		
		HashMap<Integer,Intersection> schInter = new HashMap<Integer,Intersection>();
		
		int time = 0, greenTime = Integer.MAX_VALUE;
		Street str;
		while(true)
		{
			str = streetList.pop();
			time += str.carCount;
			if (!schInter.containsKey(str.end))
				schInter.put(str.end, new Intersection(str.end));
			
			if (greenTime<str.time)
				time += str.time-greenTime;
			schInter.get(str.end).put(str.name, time);
			
			greenTime = str.carCount;
			if (time>d) break;
			Collections.sort(streetList, Collections.reverseOrder());
		}
		
		System.out.println(schInter.size());
		for(Integer x : schInter.keySet())
		{
			System.out.println(x);
			int size = schInter.get(x).streetName.size();
			System.out.println(size);
			for(int y=0; y<size; y++)
			{
				System.out.println(schInter.get(x).streetName.get(y)+" "+schInter.get(x).time.get(y));
			}
		}
	}
}
