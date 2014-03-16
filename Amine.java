import java.util.*;

public class Amine
{
    private String name;
    private String abrev;
    private String symb;
    private ArrayList<String> rnas = new ArrayList<String>();
    
    public static ArrayList<Amine> amines = new ArrayList<Amine>();
    
    public static void buildAmines(){
        amines.add(new Amine("Phenylalanine", "Phe", "F", new String[]{"UUU", "UUC"}));
        amines.add(new Amine("Leucine", "Leu", "L", new String[]{"UUA", "UUG", "CUU", "CUC", "CUA", "CUG"}));
        amines.add(new Amine("Isoleucine", "Ile", "I", new String[]{"AUU", "AUC", "AUA"}));
        amines.add(new Amine("Methionine", "Met", "M", new String[]{"AUG"}));
        amines.add(new Amine("Valine", "Val", "V", new String[]{"GUU", "GUC", "GUA", "GUG"}));
        amines.add(new Amine("Serine", "Ser", "S", new String[]{"UCU", "UCC", "UCA", "UCG", "AGU", "AGC"}));
        amines.add(new Amine("Proline", "Pro", "P", new String[]{"CCU", "CCC", "CCA", "CCG"}));
        amines.add(new Amine("Threonine", "Thr", "T", new String[]{"ACU", "ACC", "ACA", "ACG"}));
        amines.add(new Amine("Alanine", "Ala", "A", new String[]{"GCU", "GCC", "GCA", "GCG"}));
        amines.add(new Amine("Tyrosine", "Tyr", "Y", new String[]{"UAU", "UAC"}));
        amines.add(new Amine("Histidine", "His", "H", new String[]{"CAU", "CAC"}));
        amines.add(new Amine("Glutamine", "Gln", "Q", new String[]{"CAA", "CAG"}));
        amines.add(new Amine("Asparagine", "Asn", "N", new String[]{"AAU", "AAC"}));
        amines.add(new Amine("Lysine", "Lys", "K", new String[]{"AAA", "AAG"}));
        amines.add(new Amine("Aspartic acid", "Asp", "D", new String[]{"GAU", "GAC"}));
        amines.add(new Amine("Glutamic acid", "Glu", "E", new String[]{"GAA", "GAG"}));
        amines.add(new Amine("Cysteine", "Cys", "C", new String[]{"UGU", "UGC"}));
        amines.add(new Amine("Tryptophan", "Trp", "W", new String[]{"UGG"}));
        amines.add(new Amine("Arginine", "Arg", "R", new String[]{"CGU", "CGC", "CGA", "CGG", "AGA", "AGG"}));
        amines.add(new Amine("Glycine", "Gly", "G", new String[]{"GGU", "GGC", "GGA", "GGG"}));
        amines.add(new Amine("Stop", "STOP", "STOP", new String[]{"UAA", "UAG", "UGA"}));
    }
    public Amine(String name, String abrev, String symb, String[] rs){
        this.name=name;
        this.abrev=abrev;
        this.symb=symb;
        this.rnas.addAll(Arrays.asList(rs));
    }
    public boolean matches(String rna){
        boolean match = false;
        for(String s : rnas){
            match = match || s.equals(rna);
        }
        return match;
    }
    public static Amine getAmine(String rna){
        Amine aminoAcid = null;
        for(Amine a : amines){
            if(a.matches(rna)){
                aminoAcid=a;
            }
        }
        return aminoAcid;
    }
    public String getName(){
        return name;
    }
    public String getAbrev(){
        return abrev;
    }
    public String getSymb(){
        return symb;
    }
    public static String printProteinName(ArrayList<Amine> chain){
        String output = "";
        if(chain.size()>1){
            for(int i=0; i<chain.size()-1; i++){
                output+=(chain.get(i).getName()+"-");
            }
        }
        output+=chain.get(chain.size()-1).getName();
        return output;
    }
    public static String printProteinAbrev(ArrayList<Amine> chain){
        String output = "";
        if(chain.size()>1){
            for(int i=0; i<chain.size()-1; i++){
                output+=(chain.get(i).getAbrev()+"-");
            }
        }
        output+=chain.get(chain.size()-1).getAbrev();
        return output;
    }
    public static String printProteinSymb(ArrayList<Amine> chain){
        String output = "";
        if(chain.size()>1){
            for(int i=0; i<chain.size()-1; i++){
                output+=(chain.get(i).getSymb()+"-");
            }
        }
        output+=chain.get(chain.size()-1).getSymb();
        return output;
    }
}