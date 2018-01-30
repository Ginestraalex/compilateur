package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    
    
    public String getType() {
    		return "bool";
    }
    
    public void verifier() {
    		this.gauche.verifier();
    		this.droite.verifier();
    		if(!gauche.getType().equals(droite.getType())){
    			throw new AnalyseSemantiqueException("Les expressions doivent être du même type",gauche.getNoLigne());
    		}
    }

}
