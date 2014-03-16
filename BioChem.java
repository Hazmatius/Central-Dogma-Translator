import java.util.*;

public class BioChem
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Amine.buildAmines();
        String title = "Hello, welcome to Central Dogma Translator by Baranski.\n. ,-*-.   ,-*-. ,-*-.   ,-*-. ,-*-.   ,-*-. ,-*-.   ,-*\n X | | \\ / | | X | | \\ / | | X | | \\ / | | X | | \\ / | \n/ \\| | |X| | |/ \\| | |X| | |/ \\| | |X| | |/ \\| | |X| | \n   `-!-' `-!-*   `-!-' `-!-'   `-!-' `-!-*   `-!-' `-!-\n";
        System.out.println(title);
        System.out.println("TYPE options: Anti-sense DNA, Sense DNA, RNA, Protein");
        System.out.print("Input TYPE: ");
        String itype = in.nextLine();
        if(!(itype.equals("Anti-sense DNA") || itype.equals("Sense DNA") || itype.equals("RNA") || itype.equals("Protein"))){
            System.out.println("    Input not recognized. SOMETHING BAD MIGHT HAPPEN.");
        }
        System.out.print("Output TYPE: ");
        String otype = in.nextLine();
        if(!(otype.equals("Anti-sense DNA") || otype.equals("Sense DNA") || otype.equals("RNA") || otype.equals("Protein"))){
            System.out.println("    Input not recognized. SOMETHING BAD MIGHT HAPPEN.");
        }
        String format = "";
        if(otype.equals("Protein")){
            System.out.print("Output format (name, abreviation, symbol): ");
            format = in.nextLine();
            if(!(format.equals("name") || format.equals("abreviation") || format.equals("symbol"))){
                System.out.println("    Input not recognized. SOMETHING BAD MIGHT HAPPEN.");
            }
        }
        System.out.print("INPUT: ");
        String data = in.nextLine();
        
        //inputType
        //outputType
        data = data.replace("3' ", "3");
        data = data.replace("5' ", "5");
        data = data.replace("3'", "3");
        data = data.replace("5'", "5");
        
        System.out.println("");
        
        if(itype.equals("Anti-sense DNA")){
            if(otype.equals("Sense DNA")){
                data = Scribe.flipDNA(data);
            }
            else if(otype.equals("RNA")){
                data = Scribe.flipDNA(data);
                data = Scribe.DNAtoRNA(data);
                data = Scribe.flipRNA(data);
            }
            else if(otype.equals("Protein")){
                data = Scribe.flipDNA(data);
                data = Scribe.DNAtoRNA(data);
                data = Scribe.flipRNA(data);
                data = Scribe.order(data);
                if(format.equals("name")){
                    data = Amine.printProteinName(Translator.translate(data));
                }
                else if(format.equals("abreviation")){
                    data = Amine.printProteinAbrev(Translator.translate(data));
                }
                else if(format.equals("symbol")){
                    data = Amine.printProteinSymb(Translator.translate(data));
                }
            }
        }
        else if(itype.equals("Sense DNA")){
            if(otype.equals("Anti-sense DNA")){
                data = Scribe.flipDNA(data);
            }
            else if(otype.equals("RNA")){
                data = Scribe.DNAtoRNA(data);
                data = Scribe.flipRNA(data);
            }
            else if(otype.equals("Protein")){
                data = Scribe.DNAtoRNA(data);
                data = Scribe.flipRNA(data);
                data = Scribe.order(data);
                if(format.equals("name")){
                    data = Amine.printProteinName(Translator.translate(data));
                }
                else if(format.equals("abreviation")){
                    data = Amine.printProteinAbrev(Translator.translate(data));
                }
                else if(format.equals("symbol")){
                    data = Amine.printProteinSymb(Translator.translate(data));
                }
            }
        }
        else if(itype.equals("RNA")){
            if(otype.equals("Anti-sense DNA")){
                data = Scribe.flipRNA(data);
                data = Scribe.RNAtoDNA(data);
                data = Scribe.flipDNA(data);
            }
            else if(otype.equals("Sense DNA")){
                data = Scribe.RNAtoDNA(data);
                data = Scribe.flipDNA(data);
            }
            else if(otype.equals("Protein")){
                data = Scribe.order(data);
                if(format.equals("name")){
                    data = Amine.printProteinName(Translator.translate(data));
                }
                else if(format.equals("abreviation")){
                    data = Amine.printProteinAbrev(Translator.translate(data));
                }
                else if(format.equals("symbol")){
                    data = Amine.printProteinSymb(Translator.translate(data));
                }
            }
        }
        else if(itype.equals("Protein")){
            System.out.println("Why would you do that?");
            data = "";
        }
        
        if(!otype.equals("Protein")){
            data = Scribe.order(data);
            int pairs = data.length()-2;
            int codons = pairs/3;
            data = data.replace("5", "5' ");
            data = data.replace("3", " 3'");
            System.out.println("Base Pairs: " + pairs);
            System.out.println("Codons: " + codons);
        }
        System.out.println(data);
    }
}