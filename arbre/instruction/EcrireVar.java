package yal.arbre.instruction;

import yal.arbre.expression.Expression;

public class EcrireVar extends Ecrire{
	private Expression e;

	protected EcrireVar(int no) {
		super(no);
		// TODO Auto-generated constructor stub
	}
	
	public EcrireVar(Expression exp, int no){
		super(no);
		e=exp;
	}
	
	public void verifier() {
		e.verifier();
	}
	
	public String toMIPS() {
		int number = hashCode();
		StringBuilder spb = new StringBuilder();
		if(e.getType().equals("booleen")) {
			spb.append(e.toMIPS()+"\n #Ecriture booleen \n");
			spb.append("beqz $v0,alors_"+number);
			spb.append("\n la $a0,vrai \n");
			spb.append("j end_"+number);
			spb.append("\n alors_"+number);
			spb.append(":\n la $a0,faux \n");
			spb.append("end_"+number);
			spb.append(":\n li $v0,4 \n");
			spb.append("syscall \n");
		}else {
			spb.append(e.toMIPS()+"\n #Ecriture entier \n");
			spb.append("move $a0,$v0 \n");
			spb.append("li $v0,1 \n");
			spb.append("syscall \n");
		}
		return spb.toString();
	}

}
