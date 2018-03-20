package yal.arbre.instruction;

public class EcrireString extends Ecrire{
	private String caractere;

	public EcrireString(String chaine,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		caractere=chaine;
		caractere=caractere.substring(1,caractere.length()-1);
		caractere=caractere.replace("\"\"","\\\"");
		caractere=caractere.replace("\n","\\n");
		caractere="\""+caractere+"\"";
	}
	
	public void verifier() {
	}
	
	public String toMIPS() {
			int number=hashCode();
			StringBuilder spb=new StringBuilder();
			spb.append("#Ecriture chaine de caractere \n");
			spb.append("li $v0,4 \n");
			spb.append("la $a0,chaine_"+number);
			spb.append("\n syscall \n");
			return spb.toString();
	}

}
