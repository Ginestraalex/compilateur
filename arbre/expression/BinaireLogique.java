package yal.arbre.expression;

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
    	//reste à vérifier que droite et gauche sont de type bool sinon exception
    }
}
