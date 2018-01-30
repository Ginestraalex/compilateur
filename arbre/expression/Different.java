package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Different extends Comparaison {

    public Different(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " != ";
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		this.gauche.verifier();
		this.droite.verifier();
		if(!gauche.getType().equals(droite.getType())) {
			throw new AnalyseSemantiqueException("Les expressions doivent être du même type",gauche.getNoLigne());
		}
	}

	public String toMIPS() { 
	    	StringBuilder str = new StringBuilder();
		str.append(super.toMIPS()+"\n #Different \n");
		str.append("sne $v0,$t8,$v0\n");
	    	
	    	return str.toString();
	}

  
}
