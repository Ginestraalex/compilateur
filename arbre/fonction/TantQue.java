package yal.arbre.fonction;

import java.util.ArrayList;

import yal.arbre.BlocDInstructions;
import yal.arbre.expression.Expression;
import yal.arbre.instruction.Boucle;
import yal.exceptions.AnalyseSemantiqueException;
import yal.exceptions.AnalyseSyntaxiqueException;

public class TantQue extends Boucle{
	private Expression e;
	private BlocDInstructions bi;

	public TantQue(Expression exp,BlocDInstructions i,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		bi=i;
		e=exp;
	}
	
	public void verifier() {
		if(!e.getType().equals("booleen")) {
			throw new AnalyseSemantiqueException("L'expression doit être de type booléen", e.getNoLigne());
		}
		e.verifier();
		bi.verifier();
	}
	
	public String toMIPS() {
		int nb=hashCode();
		//int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder res= new StringBuilder();
		res.append("#Debut de boucle tant que");
		//res.append("lw $v0,"+deplacement+"($s7) \n");
		res.append("boucle"+nb+": \n"+e.toMIPS());
		res.append("beqz $v0, Fintantque"+nb+": \n");
		res.append("#Code cible de la boucle");
		//Code cible
		res.append(bi.toMIPS());
		res.append("j boucle"+nb+": \n");
		res.append("fintantque"+nb+": \n");
		
		return res.toString();
	}

}
