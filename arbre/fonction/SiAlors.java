package yal.arbre.fonction;

import yal.arbre.BlocDInstructions;
import yal.arbre.expression.Expression;
import yal.arbre.instruction.Conditionelle;
import yal.exceptions.AnalyseSemantiqueException;

public class SiAlors extends Conditionelle {
	private Expression e;
	private BlocDInstructions bi;

	public SiAlors(Expression exp,BlocDInstructions li, int no) {
		super(no);
		// TODO Auto-generated constructor stub
		bi=li;
		e=exp;
	}
	
	public void verifier() {
		if(!e.getType().equals("booleen")) {
			throw new AnalyseSemantiqueException("L'expression doit être de type booléen", e.getNoLigne());
		}
		e.verifier();
	}
	
	public String ToMIPS() {
		int nb=hashCode();
		//int deplacement=TableSymbole.getInstance().identifier(idf).getPos();
		StringBuilder res= new StringBuilder();
		res.append("#Conditionelle sans sinon\n");
		res.append("Si"+nb+": \n");
		//Evaluer l'expression
		//res.append("lw $v0,"+deplacement+"($s7) \n");
		res.append(e.toMIPS());
		res.append("beqz $v0, finsi"+nb+"\n");
		res.append("alors"+nb+":\n");
		//Code cible pour la partie alors
		res.append(bi.toMIPS());
		
		
		res.append("finsi"+nb+":\n");
		
		return res.toString();
	}

}
