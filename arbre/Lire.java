package yal.arbre;

public class Lire extends Instruction {
	private EntreeVar idf;

	public Lire(String chaine,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		idf=new EntreeVar(chaine);
	}

	public void verifier() {
	}
	
	public String toMIPS() {
		int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder res= new StringBuilder();
		res.append("#Lecture d'un entier \n");
		res.append("li $v0,5 \n");
		res.append("syscall\n");
		res.append("lw $v0,"+deplacement+"($s7) \n");
		
		return res.toString();
		
	}
	
}
