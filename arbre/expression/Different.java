package yal.arbre.expression;

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
		//reste à verifier que droite et gauche sont pas du meme type
	}

	public String toMIPS() { 
		// à realiser quand etiquette seront gérer
		return "";
	}

  
}
