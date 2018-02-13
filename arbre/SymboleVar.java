package yal.arbre;

import yal.arbre.expression.Expression;

import java_cup.runtime.Symbol;

public class SymboleVar extends Symbole{
	private Expression e;
	private int position;

	public SymboleVar() {
		position=TableSymbole.getInstance().getTaille();
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return e.getTypeExpression();
	}

	@Override
	public int getPos() {
		// TODO Auto-generated method stub
		return position;
	}



}
