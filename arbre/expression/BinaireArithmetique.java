package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public void verifier() {
    		this.gauche.verifier();
    		this.droite.verifier();
    		if(!gauche.getType().equals("int") || !droite.getType().equals("int")){
    			throw new AnalyseSemantiqueException("les expressions doivent être des entiers",gauche.getNoLigne());
    		}
    }
    
    public String getType() {
    	return "int";
    }
    
}
