package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Binaire extends Expression {
    
    protected Expression gauche ;
    protected Expression droite ;

    protected Binaire(Expression gauche, Expression droite) {
        super(gauche.getNoLigne());
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public abstract String operateur() ;

    @Override
    public String toString() {
        return "(" + gauche + operateur() + droite + ")" ;
    }
    
    public String toMIPS() {
        StringBuilder res = new StringBuilder();
		res.append("# opération \n");
		res.append(operateur()+"\n");
		
		//Calculer partie gauche
		res.append("#Opérande gauche \n");
		res.append(gauche.toMIPS()+"\n");
		
		//Empiler gauche 
		res.append("sw $v0,($sp) \n");
		res.append("addi $sp,$sp,-4 \n");
		
		//Calcul partie droite
		res.append("#Opérande droite \n");
		res.append(droite.toMIPS()+"\n");
		
		//Depiler gauche
		res.append("addi $sp,$sp,4 \n");
		res.append("lw $t8,($sp) \n");
		return res.toString();
    }

}
