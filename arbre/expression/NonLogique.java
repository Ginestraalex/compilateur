package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }
    
    @Override
    public String toMIPS(){
        StringBuilder res=new StringBuilder();
        res.append(super.toMIPS()+"#Non Logique \n");
        res.append("xori $v0,$v0,1 \n");
        return res.toString();
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		// verifier que l'expression est de type booléen
	}

}
