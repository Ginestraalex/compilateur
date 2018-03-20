package yal.arbre.fonction;

import yal.arbre.BlocDInstructions;
import yal.arbre.instruction.EntreeFonction;
import yal.arbre.instruction.Instruction;
import yal.arbre.instruction.SymboleFonction;
import yal.arbre.tds.TableSymbole;
import yal.exceptions.AnalyseSemantiqueException;

public class FonctionSP extends Instruction{
	
	private SymboleFonction sym;
    private String name;
    private BlocDInstructions bloc;

    public FonctionSP(String nom, BlocDInstructions bloc) {
        super(bloc.getNoLigne());
        // TODO Auto-generated constructor stub
        this.name = nom;
        this.bloc = bloc;
    }

    public void verifier() {
    		SymboleFonction symbole= (SymboleFonction) TableSymbole.getInstance().identifier(new EntreeFonction(name, 0));
		TableSymbole.getInstance().entreeBloc();
		bloc.verifier();
		if(symbole==null) {
			throw new AnalyseSemantiqueException("Ligne"+getNoLigne()+ ": Fonction\""+name+"\"non déclaré", noLigne);
		}
		TableSymbole.getInstance().sortieBloc();
		sym=symbole;
    }


    public String toMIPS() {
        StringBuilder spb = new StringBuilder();
        spb.append("# Fonction "+name+"\n");
        spb.append(name+":\n\n");

        spb.append("# Empilement de l'adresse de retour\n");
        spb.append("sw $ra, ($sp)\n");
        spb.append("addi $sp, $sp, -4\n\n");

        spb.append("# Mettre base locale dans la pile\n");
        spb.append("sw $s7, ($sp)\n");
        spb.append("addi $sp, $sp, -4\n\n");

        spb.append("# Ajout du numero de bloc\n");
        spb.append("li $v0, "+ TableSymbole.getInstance().getNumRegion()+"\n");
        spb.append("sw $v0, ($sp)\n");
        spb.append("addi $sp, $sp, -4\n\n");

        spb.append("# Déplacement de la base\n");
        spb.append("move $s7, $sp\n\n");

        spb.append("# Instruction de la fonction\n");
        spb.append(bloc.toMIPS());

        return spb.toString();
    }
    
    public String toString() {
    		return null;
    }

}


