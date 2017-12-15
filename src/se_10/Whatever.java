package se_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Whatever {

	private static XStream xstream = new XStream(new DomDriver());
	private String string;
	private String string2;
	
	public Whatever(String string, String string2){
		this.string = string;
		this.string2 = string2;
		configureXStream();
	}
	
	public String getString() {
		return string;
	}
	
	public String getString2() {
		return string2;
	}
	
	private void configureXStream() {
		xstream.alias("Whatever", Whatever.class);
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(new Class<?>[] {Whatever.class});
	}
	
	public static void main(String[] args) {
		Whatever what = new Whatever("What", "ever");
		String xml = xstream.toXML(what);
		try {
			FileWriter writer = new FileWriter("whatever.xml");
			writer.write(xml);
			writer.close();
		}catch(IOException e) {
			
		}
		
		Whatever ever = (Whatever) xstream.fromXML(new File("whatever.xml"));
		System.out.println(ever.string + "" + ever.string2);
	}
}
