package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

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
	    	str.append(super.toMIPS()+"\n #Superieur \n");
	    	str.append("Si"+compteurSi+":\n");
	    	str.append("# a > b \n");
	    	str.append("sub $v0, $v0, $t8\n");
	    	str.append("bltz $v0, alors"+compteurSi+"\n"); //branch on greater than zero
	    	str.append("alors"+compteurSi+":\n");
	    	//contenu du si
	    	str.append("li $v0,0 \n");
<<<<<<< HEAD
	    	str.append("j fin"+compteurSi+"\n");
	    	str.append("sinon"+compteurSi+":\n");
	    	//Contenu du sinon
	    	str.append("li $v0,1 \n");
	    	str.append("fin"+compteurSi+":\n");
=======
	    	str.append("j finsi"+compteurSi+"\n");
	    	str.append("sinon"+compteurSi+":\n");
	    	//Contenu du sinon
	    	str.append("li $v0,1 \n");
	    	str.append("j finsi"+compteurSi+"\n");
	    	str.append("finsi"+compteurSi+":\n");
>>>>>>> 3893abf43e925940ea6ebe46c62fe3339b81bef1
	    	compteurSi++;
	    	
	    	return str.toString();
    }
    
	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		this.gauche.verifier();
		this.droite.verifier();
		if(!gauche.getType().equals("int")||!droite.getType().equals("int")) {
			throw new AnalyseSemantiqueException("Les expressions doivent être de type entier",gauche.getNoLigne());
		}
	}
    
}
