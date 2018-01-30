package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {
	
    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		this.gauche.verifier();
		this.droite.verifier();
		if(!gauche.getType().equals("int")||!droite.getType().equals("int")) {
			throw new AnalyseSemantiqueException("Les expressions doivent être de type entier",gauche.getNoLigne());
		}
	}
	
	public String toMIPS() {
		StringBuilder str = new StringBuilder();
		str.append(super.toMIPS()+"\n #Inferieur \n");
		str.append("slt $v0,$t8,$v0\n");
	    	
	    	return str.toString();
	}
    
}
