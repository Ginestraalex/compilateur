package yal.arbre.instruction;

import yal.arbre.expression.Expression;
import yal.arbre.tds.TableSymbole;

public class Retourne extends Instruction{
	private Expression exp;

	public Retourne(Expression e) {
		super(e.getNoLigne());
		// TODO Auto-generated constructor stub
		exp=e;
	}
	
	public void verifier() {
		exp.verifier();
	}
	
	public String toMIPS() {
		StringBuilder spb = new StringBuilder();
		spb.append("#Retourner \n");
		spb.append(exp.toMIPS() + "\n\n");
		
		spb.append("#Nettoyage espace numéro de région \n");
		spb.append("add $sp, $sp, " + TableSymbole.getInstance().getNumRegion() + "\n\n");
		
		spb.append("#Replacement de $s7 \n");
		spb.append("add $s7, $sp, 0\n\n");
		
				
		spb.append("#Empilement de l'adresse de retour\n");
		spb.append("lw $ra, 0($sp)\n");
		spb.append("add $sp, $sp, 4\n\n");
		
		spb.append("#Empilement  valeur de retour\n");
		spb.append("lw $sp, 0($v0)\n\n");		
		
		spb.append("#Jump\n");
		spb.append("jr $ra\n\n");		 

		return spb.toString();
	}

}
