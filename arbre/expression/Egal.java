package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Egal extends Comparaison {
	
    public Egal(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " == ";
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		this.gauche.verifier();
		this.droite.verifier();
		//reste à verifier que droite et gauche sont du meme type
	}
	
	public String toMIPS() {
		StringBuilder str = new StringBuilder();
	    	str.append(super.toMIPS());
	    	str.append("si"+compteurSi+":");
	    	str.append("# a == b \n");
	    	str.append("sub $v0, $v0, $t8\n");
	    	str.append("beqz $v0, alors"+compteurSi+"\n"); //branch on greater than zero
	    	str.append("alors"+compteurSi+":\n");
	    	//contenu du si
	    	str.append("j finsi"+compteurSi+":\n");
	    	str.append("sinon"+compteurSi+":\n");
	    	//Contenu du sinon
	    	str.append("j finsi"+compteurSi+"\n");
	    	str.append("finsi"+compteurSi+":\n");
	    	compteurSi++;
	    	
	    	return str.toString();
	}
  
}
