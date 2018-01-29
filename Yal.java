package yal ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import yal.analyse.AnalyseurLexical;
import yal.analyse.AnalyseurSyntaxique;
import yal.arbre.ArbreAbstrait;
import yal.exceptions.AnalyseException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Yal {
    
    public Yal(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            System.err.println("expression stockée dans l'arbre : \n" + arbre);
            
            
            arbre.verifier() ; 
            System.out.println(arbre.toMIPS());
            String str;
            str = arbre.toMIPS();
            write(fichier.substring(0,fichier.length()-4),str);
            System.out.println("Compilation valide");
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Yal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void write(String nom_fichier, String contenu){
    	try{
	    	File f=new File(nom_fichier+".mips");
	    	FileWriter fileW=new FileWriter(f);
	    	fileW.write(contenu);
	    	fileW.close();
    	}catch(Exception e){
    		System.err.println("Erreur: le fichier n'a pa été crée");
    	}
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar yal.jar <fichierSource.yal>") ;
            System.exit(1) ;
        }
        new Yal(args[0]) ;
    }
    
}
