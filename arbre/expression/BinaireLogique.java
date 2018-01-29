package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireLogique extends Binaire {

    protected BinaireLogique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public void verifier() {
	    	this.gauche.verifier();
	    	this.droite.verifier();
	    	if(!gauche.getType().equals("bool")|| !droite.getType().equals("bool")){
				throw new AnalyseSemantiqueException("Les expressions deoivent être de type booléen", gauche.getNoLigne());
	    }
    }

    public String getType() {
    		return "bool";
    }
}
