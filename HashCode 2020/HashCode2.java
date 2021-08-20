package hashcode;

import java.io.*;
import java.util.*;

public class HashCode 
{
	public static class Book implements Comparable<Book>
	{
		public Integer id, score;
		
		public Book(int id, int score)
		{
			this.id = id;
			this.score = score;
		}

		public int compareTo(Book b) 
		{
			return score.compareTo(b.score);
		}
		
		public String toString()
		{
			return id+" : "+score;
		}
	}
	
	public static class Library implements Comparable<Library>
	{
		public Integer id, books, signup, rate;
		public long totalScore;
		public Double avgScore, avgDaily;
		public ArrayList<Book> bookList;
		
		public Library(int id, int books, int signup, int rate)
		{
			this.id = id;
			this.books = books;
			this.signup = signup;
			this.rate = rate;
		}
		
		public int compareTo(Library l)
		{
//			return avgDaily.compareTo(l.avgDaily);
			return signup.compareTo(l.signup);
		}
		
		public String toString()
		{
			return id+" : "+avgDaily;
		}
	}
	
	public static int min(int a, int b)
	{
		return a<b?a:(b<0?a:b);
	}
	
	static String tc = "f";
	
	public static void main(String[] args) throws Exception 
	{
		Scanner in = new Scanner(new File("E:\\Code\\HashCode 2020\\input_"+tc+".txt"));
		int b = in.nextInt();
		int l = in.nextInt();
		int d = in.nextInt();
		Book[] books = new Book[b];
		//Reads the scores of each book
		for(int x=0; x<b; x++)
		{
			int score = in.nextInt();
			books[x] = new Book(x,score);
		}
		
		ArrayList<Library> libraries = new ArrayList<Library>();
		//iterates over each library
		for(int x=0; x<l; x++)
		{
			int bks = in.nextInt();
			int signup = in.nextInt();
			int rate = in.nextInt();
			Library library = new Library(x, bks, signup, rate);
			libraries.add(library);
			

			long tot = 0;
			ArrayList<Book> libraryBooks = new ArrayList<Book>();
			//reads books in this library
			for(int y=0; y<bks; y++)
			{
				int bk = in.nextInt();
				libraryBooks.add(books[bk]);
				tot += books[bk].score;
			}
			Collections.sort(libraryBooks, Collections.reverseOrder());
			library.totalScore = tot;
			library.bookList = libraryBooks;
			library.avgScore = (double)(tot*1.0/bks);
			library.avgDaily = library.avgScore*rate;
			
//			for(Book bk : libraryBooks) System.out.println(bk);
//			System.out.println(library.avgDaily);
		}
		
		//sorts libraries by avg daily scoring capacity
		Collections.sort(libraries, Collections.reverseOrder());
		int elapsedDays = 0;
		int libCount = 0;
		for(Library lib : libraries)
		{
			elapsedDays += lib.signup;
			libCount += (elapsedDays<d?1:0);
		}
		FileWriter writer = new FileWriter("E:\\Code\\HashCode 2020\\output2_"+tc+".txt");
		writer.write(libCount+"");
        writer.write("\r\n");   // write new line
        
        //resets elapsed days
        elapsedDays = 0;
        int count = 0;
        for(Library lib : libraries)
        {
        	count++;
        	if(count>libCount) break;
        	elapsedDays += lib.signup;
        	int daysToShip = d - elapsedDays;
        	int booksSent = min(lib.books, daysToShip*lib.rate);
//        	System.out.println(daysToShip+" "+lib.rate+" "+daysToShip*lib.rate);
//        	System.out.println(booksSent);
        	writer.write(lib.id+" "+booksSent);
        	writer.write("\r\n");   // write new line
        	String bookList = "";
        	for(int x=0; x<booksSent; x++) 
        		bookList += (lib.bookList.get(x).id+" ");
        	writer.write(bookList);
        	writer.write("\r\n");   // write new line
        }
        
        writer.close();
	}

}
