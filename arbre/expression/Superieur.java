package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
    }

    @Override
    public String toMIPS(){
    	StringBuilder str = new StringBuilder();
    	str.append(super.toMIPS());
    	str.append("# a > b \n");
    	str.append("sub $v0, $t8, $v0\n");
    	//str.append("bgez $v0, ")
    	//TODO a finir
    	return str.toString();
    }
    
	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}
    
}
