package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
	}

	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder res= new StringBuilder();
		res.append("# affectation constante booleenne \n");
		//si faux mis à 0 sinon mis à 1
		if(cste.equals("faux")) {
			res.append("li $v0,0 \n");
		}else {
			res.append("li $v0,1 \n");
		}
		return res.toString();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "bool";
	}

}
