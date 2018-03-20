package yal.arbre.tds;

public abstract class Entree {
	private String idf;
	
	public Entree(String i) {
		idf=i;	
	}
	
	public String getIdf() {
		return idf;
	}
	
	public boolean equals(Object obj) {
		Entree test=(Entree) obj;
		if((obj==null) || !(idf.equals(test.idf)) || (getClass() != obj.getClass()) ) {
			return false;
		}
		return true;
	}
	
	public int hashCode() {
		return idf.hashCode();
	}
	
	
}
