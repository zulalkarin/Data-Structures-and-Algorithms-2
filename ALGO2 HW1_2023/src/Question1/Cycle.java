package Question1;
import java.util.Arrays;
//-------------------------------------------------------------------------
//Title: Cycle Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 1
//Description:  This class create cycles and hold the city counts in the cycles. 
//----------------------------------------------------------------------------------


public class Cycle implements Comparable<Cycle> {

	public String path;
	int cityCount;

	public Cycle(String path) {
		char[] chars = path.toCharArray();
		Arrays.sort(chars);
		this.path = new String(chars);
		cityCount = chars.length;
	}
	

	@Override
	public String toString() {
		String s = "";
		for(char c : path.toCharArray())
			s += "-" + c;
		return s.substring(1);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cycle other = (Cycle) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cycle o) {
		if(this.path.length() == o.path.length())
			return this.path.compareTo(o.path);
		return Integer.compare(this.path.length(), o.path.length());
	}


	public int getCityCount() {
		return cityCount;
	}


	public void setCityCount(int cityCount) {
		this.cityCount = cityCount;
	}
	
	
}
