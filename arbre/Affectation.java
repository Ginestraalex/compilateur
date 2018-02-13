package yal.arbre;

import yal.arbre.expression.Expression;
import yal.exceptions.AnalyseSyntaxiqueException;

public class Affectation extends Instruction{
	private Expression e;
	private EntreeVar idf;

	public Affectation(int no,Expression exp,String i) {
		super(no);
		// TODO Auto-generated constructor stub
		e=exp;
		idf=new EntreeVar(i);
	}
	
	public void verifier() {
		e.verifier();
		if(!TableSymbole.getInstance().contains(idf)) {
			throw new AnalyseSyntaxiqueException("Variable"+idf.getIdf()+"n'est pas déclarée");
		}
	}
	
	public String toMIPS(){
		int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder spb=new StringBuilder();
		spb.append("#Affectation"+idf.getIdf()+" \n"+e.toMIPS());
		spb.append("\n sw $v0,"+deplacement+"($s7) \n");
		return spb.toString();
	}
	
	
	
	

}
