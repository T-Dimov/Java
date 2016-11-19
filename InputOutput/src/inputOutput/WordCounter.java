package inputOutput;

import java.io.IOException;
import java.io.Reader;

class WordCounter extends Reader
{
	private Reader in;
	
	public WordCounter(Reader in)
	{
		this.in = in;
	}
	
	@Override
	public int read() throws IOException
	{
		int c = in.read();
		return convert(c);
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		return in.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException
	{
		in.close();
	}
	
	private int convert(int ch)
	{
		if (Character.isWhitespace(ch))
			return 0x0020;
		if (Character.isLetter(ch))
			return ch;
		if (ch == -1)
			return -1;
		return 0;
	}
}
