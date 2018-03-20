package yal.arbre.fonction;

import yal.arbre.BlocDInstructions;
import yal.arbre.expression.Expression;
import yal.arbre.instruction.Conditionelle;
import yal.exceptions.AnalyseSemantiqueException;

public class SiAlorsSinon extends Conditionelle {
	private Expression e;
	private BlocDInstructions cAlors;
	private BlocDInstructions cSinon;

	public SiAlorsSinon(Expression exp,BlocDInstructions alors,BlocDInstructions sinon,int no) {
		super(no);
		// TODO Auto-generated constructor stub
		e=exp;
		cAlors=new BlocDInstructions(noLigne+1);
		cSinon=new BlocDInstructions(noLigne+1);
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
		res.append("#Conditionelle avec sinon\n");
		res.append("Si"+nb+": \n");
		res.append(e.toMIPS());
		res.append("beqz $v0, sinon"+nb+"\n");
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
