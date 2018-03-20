package yal.arbre;

import java.util.ArrayList;

import yal.arbre.tds.TableSymbole;

public class Programme extends ArbreAbstrait {
	
	protected ArrayList<BlocDInstructions> ins;
	private int taille;

	public Programme(int no) {
		super(no);
		ins=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	public void ajouter(BlocDInstructions a) {
        ins.add(a);
    }
	
	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		for(BlocDInstructions bi:ins) {
			bi.verifier();
		}
		taille = TableSymbole.getInstance().getTaille();
	}

	
	@Override
	public String toMIPS() {
		// TODO Auto-generated method stub
		StringBuilder res= new StringBuilder();
		res.append(".data \n\n");
		res.append(".text \n");
		res.append("main: \n");
		res.append(" # initialisation de la base des variables \n");
		res.append("move $s7,$sp \n");
		res.append("addi $sp,$sp,-"+taille+"\n");
		res.append("li $t8,0 \n");
		for (int i=0;i<taille;i+=4) {
        res.append("sw $t8, -"+i);
        	res.append("($s7)\n");
        }
		for(ArbreAbstrait arb:ins) {
			res.append("\n"+arb.toMIPS());
		}
		res.append("\n end :\n" + 
				"         move $v1, $v0      # copie de v0 dans v1 pour permettre les tests de plic0\n" + 
				"         li $v0, 10               # retour au système\n" + 
				"         syscall");
		return res.toString();
		}

}
