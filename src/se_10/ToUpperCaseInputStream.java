package se_10;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ToUpperCaseInputStream extends FilterInputStream{

	protected ToUpperCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() {
		try {
			for(int i; (i = in.read()) != -1;) {
				return (i >= 97 && i <= 122) ? (i - 32) : i;
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
		return -1;
	}
}
