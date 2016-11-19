package inputOutput;

import java.io.IOException;
import java.io.Reader;

class ShljokawicaReader extends Reader
{
	private Reader in;
	
	public ShljokawicaReader(Reader in)
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
	
	private int convert(int c)
	{
		switch(c)
		{
		case 0x0061://a
			return 0x0430;//а
		case 0x0062://b
			return 0x0431;//б
		case 0x0063://c
			return 0x0446;//ц
		case 0x0064://d
			return 0x0434;//д
		case 0x0065://e
			return 0x0435;//е
		case 0x0066://f
			return 0x0444;//ф
		case 0x0067://g
			return 0x0433;//г
		case 0x0068://h
			return 0x0445;//х
		case 0x0069://i
			return 0x0438;//и
		case 0x006A://j
			return 0x0439;//й
		case 0x006B://k
			return 0x043A;//к
		case 0x006C://l
			return 0x043B;//л
		case 0x006D://m
			return 0x043C;//м
		case 0x006E://n
			return 0x043D;//н
		case 0x006F://o
			return 0x043E;//о
		case 0x0070://p
			return 0x043F;//п
		case 0x0071://q
			return 0x044F;//я
		case 0x0072://r
			return 0x0440;//р
		case 0x0073://s
			return 0x0441;//с
		case 0x0074://t
			return 0x0442;//т
		case 0x0075://u
			return 0x0443;//у
		case 0x0076://v
			return 0x0436;//ж
		case 0x0077://w
			return 0x0432;//в
		case 0x0078://x
			return 0x044C;//ь
		case 0x0079://y
			return 0x044A;//ъ
		case 0x007A://z
			return 0x0437;//з
		case 0x0060://`
			return 0x044F;//я
		case 0x005B://[
			return 0x0448;//ш
		case 0x005C://\
			return 0x044E;//ю
		case 0x005D://]
			return 0x0449;//щ
		default:
			return c;
		}
	}
}
