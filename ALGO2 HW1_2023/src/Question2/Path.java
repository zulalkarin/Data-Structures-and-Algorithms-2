package Question2;
//-------------------------------------------------------------------------
//Title: Path Class
//Author: Çaðla Köse
//ID: 10480227330
//Section: 02
//Assignment: 1 
//Question: 2
//Description: This class create paths and hold the vetrex numbers in the paths. 
//----------------------------------------------------------------------------------

import java.util.Arrays;

public class Path implements Comparable<Path> {

	public String path;
	int vertexCount;

	public Path(String path) {
		char[] chars = path.toCharArray();
		Arrays.sort(chars);
		this.path = new String(chars);
		vertexCount= chars.length;
		
	}

	@Override
	public String toString() {
		String s = "";
		for (char c : path.toCharArray())
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
		Path other = (Path) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public int compareTo(Path o) {
		return this.path.compareTo(o.path);
	}
}
