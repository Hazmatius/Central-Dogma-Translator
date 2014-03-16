public class Scribe
{
    public static String flipDNA(String dna){
        String newDNA = "";
        for(int i=0; i<dna.length(); i++){
            char n=dna.charAt(i);
            if(n=='5'){newDNA+='3';}
            if(n=='3'){newDNA+='5';}
            
            if(n=='A'){newDNA+='T';}
            if(n=='T'){newDNA+='A';}
            if(n=='C'){newDNA+='G';}
            if(n=='G'){newDNA+='C';}
        }
        return newDNA;
    }
    
    public static String flipRNA(String rna){
        String newRNA = "";
        for(int i=0; i<rna.length(); i++){
            char n=rna.charAt(i);
            if(n=='5'){newRNA+='3';}
            if(n=='3'){newRNA+='5';}
            
            if(n=='A'){newRNA+='U';}
            if(n=='U'){newRNA+='A';}
            if(n=='C'){newRNA+='G';}
            if(n=='G'){newRNA+='C';}
        }
        return newRNA;
    }
    
    public static String DNAtoRNA(String dna){
        return dna.replace("T", "U");
    }
    
    public static String RNAtoDNA(String rna){
        return rna.replace("U", "T");
    }
    
    public static String order(String nacid){
        String newAcid = nacid;
        if(nacid.charAt(0)=='3'){
            newAcid = new StringBuffer(newAcid).reverse().toString();
        }
        return newAcid;
    }
}