package yal.arbre.fonction;

import yal.arbre.instruction.EntreeFonction;
import yal.arbre.instruction.Instruction;
import yal.arbre.instruction.SymboleFonction;
import yal.arbre.tds.TableSymbole;
import yal.exceptions.AnalyseSemantiqueException;

public class Appel extends Instruction{
	private String idf;
	private SymboleFonction sym;

	protected Appel(int no,String iDf) {
		super(no);
		// TODO Auto-generated constructor stub
		idf=iDf;
	}
	
	public void verifier() {
		SymboleFonction symbole=(SymboleFonction) TableSymbole.getInstance().identifier(new EntreeFonction(idf, 0));
		if (!(symbole.isFonc())) {
			throw new AnalyseSemantiqueException("Ligne"+getNoLigne()+":\""+idf+"\"n'est pas une fonction'",noLigne);
		}else if (symbole==null) {
			throw new AnalyseSemantiqueException("Ligne"+getNoLigne()+": Fonction\""+idf+"\"n'existe pas'",noLigne);
		}
		this.sym=symbole;
	}
	
	public String toMIPS() {
		StringBuilder spb = new StringBuilder();
		int nb=hashCode();
		
		spb.append("# Appel d'un fonction \n");
		spb.append("# Allocation place pour la valeur retour\n");
		spb.append("addi $sp, $sp, -4\n");
		
		spb.append("# Jump sur la fonction"+ idf +"\n");
		spb.append("jal "+nb+"\n");
		
		spb.append("#Dépiler retour dans v0 \n");
		spb.append("add $sp, $sp, 4 \n"); 
		spb.append("lw $v0, 0($sp) \n");
		spb.append("jr $ra \n");
		
		return spb.toString();
	}

}
