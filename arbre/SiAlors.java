package yal.arbre;

import yal.arbre.expression.Expression;

public class SiAlors extends Conditionelle {
	private Expression e;
	private CodeCible cc;

	protected SiAlors(Expression exp,String i,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		cc=new CodeCible(no);
		e=exp;
	}
	
	public void verifier() {
		e.verifier();
	}
	
	public String ToMIPS() {
		int nb=hashCode();
		//int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder res= new StringBuilder();
		res.append("#Conditionelle avec sinon\n");
		res.append("si"+nb+": \n");
		//Evaluer l'expression
		//res.append("lw $v0,"+deplacement+"($s7) \n");
		res.append("bgez $v0, finsi"+nb+"\n");
		res.append("alors"+nb+":\n");
		//Code cible pour la partie alors
		res.append(cc.toMIPS());
		
		
		res.append("finsi"+nb+":\n");
		
		return res.toString();
	}

}
