package yal.arbre;

import yal.arbre.expression.Expression;

import yal.exceptions.AnalyseSyntaxiqueException;

public class IDF extends Expression{

private EntreeVar identificateur;
	
	public IDF(String idf, int n) {
		super(n);
		this.identificateur = new EntreeVar(idf);
		this.type = "int"; //Tous nos variables sont des entiers
	}

	public void verifier() {
		// Vérifie que la variable est déclarée
		if (!TableSymbole.getInstance().contains(identificateur)) {
			throw new AnalyseSyntaxiqueException(" Variable " + identificateur.getIdf() + " non déclarée.");
		}
	}

	public String toMIPS() {
		StringBuilder spb = new StringBuilder();
		int deplacement = TableSymbole.getInstance().identifier(identificateur).getPos();
		spb.append("# charger variable dans $v0 \n");
		spb.append("lw $v0,"+deplacement+"($s7) \n");
		return spb.toString();
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
