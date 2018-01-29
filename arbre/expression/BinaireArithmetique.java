package yal.arbre.expression;

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
    	// reste à verifier que droite et gauche sont de type int sinon exception
    }
    
}
