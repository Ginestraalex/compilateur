package yal.arbre;

import java.util.ArrayList;

import yal.arbre.expression.Expression;
import yal.exceptions.AnalyseSyntaxiqueException;

public class TantQue extends Instruction {
	private Expression e;
	private CodeCible cc;

	protected TantQue(Expression exp,String i,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		cc=new CodeCible(no);
		e=exp;
	}
	
	public void verifier() {
		e.verifier();
	}
	
	public String toMIPS() {
		int nb=hashCode();
		//int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder res= new StringBuilder();
		res.append("#Debut de boucle tant que");
		//res.append("lw $v0,"+deplacement+"($s7) \n");
		res.append("boucle"+nb+": \n");
		res.append("bgez $v0, fintantque"+nb+": \n");
		res.append("#Code cible de la boucle");
		//Code cible
		res.append(cc.toMIPS());
		res.append("j boucle"+nb+": \n");
		res.append("fintantque"+nb+": \n");
		
		return res.toString();
	}

}
