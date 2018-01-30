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
	    	str.append("Si"+compteurSi+":\n");
	    	str.append("# a != b \n");
	    	str.append("sub $v0, $v0, $t8\n");
	    	str.append("beqz $v0, alors"+compteurSi+"\n"); //branch on greater than zero
	    	str.append("alors"+compteurSi+":\n");
	    	//contenu du si
	    	str.append("li $v0,1 \n");
	    	str.append("j fin"+compteurSi+"\n");
	    	str.append("sinon"+compteurSi+":\n");
	    	//Contenu du sinon
	    	str.append("li $v0,0 \n");
	    	str.append("fin"+compteurSi+":\n");
	    	compteurSi++;
	    	
	    	return str.toString();
	}

  
}
