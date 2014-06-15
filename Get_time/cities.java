import java.io.*;
public class cities
{
    public static void main(String[] args) throws IOException
	{
		int len = 0, i, j, k=0;
		char ch;
		BufferedReader bfr=new BufferedReader(new FileReader("cities.txt"));
		String s;
		PrintWriter fout = new PrintWriter(new FileWriter("mod.txt"));;
		while(  k<1298 )
		{
			s = bfr.readLine();
			len = s.length();
			for( i=1; i<len; i++ )
			{
				ch = s.charAt(i);
				if( (int)ch == 34 )
					break;
				fout.write(ch);
			}
			fout.write((int)'\t');
			fout.write((int)'\t');
			for( ; i<len; i++ )
			{
				ch = s.charAt(i);
				if( (int)ch == 34 || ch == ',' || ch == '(' )
					continue;
				if( ch == ')')
					break;
				fout.write(ch);
			}
			fout.write((int)'\t');
			for( i=len-1; i>=0; i-- )
			{
				ch = s.charAt(i);
				if(  ch == ',' )
				{
					for( j =i+2; j<len-1; j++ )
					{
						ch = s.charAt(j);
						fout.write(ch);
					}
					break;
				}
			}
			fout.println();
			k++;
		}
		fout.close();
		bfr.close();
	}
}