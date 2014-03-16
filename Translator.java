import java.util.*;

public class Translator
{
    public static ArrayList<Amine> translate(String rna){
        rna=rna.replace("5", "");
        rna=rna.replace("3", "");
        ArrayList<Amine> amines = new ArrayList<Amine>();
        for(int i=0; i<(rna.length()/3); i++){
            String codon = rna.substring(i*3, i*3+3);
            Amine a = Amine.getAmine(codon);
            amines.add(a);
        }
        return amines;
    }
}