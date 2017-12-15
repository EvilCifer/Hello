package se_01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
	public int count(String path){
		int counter = 0;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(path));
			try{
				String line = "";
				do{
					line = reader.readLine();
					if(line == null || line.equals("")) return counter;
					String[] split = line.split(" ");
					for(String value : split){
						++counter;
					}
				}while(true);
			}catch(IOException e){
				e.printStackTrace();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return counter;
	}
}