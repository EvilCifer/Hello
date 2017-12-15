package se_01;

import java.util.List;
import java.util.Arrays;

public class Project {
	
	private String[][] sequence;
	
	public Project(String[][] sequence){
		this.sequence = sequence;
	}
	
	public boolean isWellSorted(String[] sequence){
		List<String> list = Arrays.asList(sequence);
		for(int i = 0; i < this.sequence.length; ++i){
			if(list.indexOf(this.sequence[i][0]) >= list.indexOf(this.sequence[i][1])){
				return false;
			}
		}
		return true;
	}
}
