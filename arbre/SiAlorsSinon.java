package yal.arbre;

import yal.arbre.expression.Expression;

public class SiAlorsSinon extends Conditionelle {
	private EntreeVar idf;
	private Expression e;
	private CodeCible cAlors;
	private CodeCible cSinon;

	protected SiAlorsSinon(Expression exp,String alors,String sinon,String i,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		idf=new EntreeVar(i);
		e=exp;
	}
	
	public void verifier() {
		e.verifier();
	}
	
	public String ToMIPS() {
		int nb=hashCode();
		int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder res= new StringBuilder();
		res.append("#Conditionelle avec sinon\n");
		res.append("si"+nb+": \n");
		res.append("lw $v0,"+deplacement+"($s7) \n");
		res.append("bgez $v0, sinon"+nb+"\n");
		res.append("alors"+nb+":\n");
		//Code cible pour la partie alors
		res.append(cAlors.toMIPS());
		
		
		res.append("j finsi"+nb+"\n");
		res.append("sinon"+nb+":\n");
		//Code cible pour la partie sinon
		res.append(cSinon.toMIPS());
		
		
		res.append("fsi"+nb+":\n");
		return res.toString();
	}

}
