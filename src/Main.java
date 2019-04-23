import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner; 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// The name of the file to open.
	/*
        
        LectureData reader = new LectureData("freq.dat");
        ArrayList<String[]> dataList = reader.arrayListValue();
        
        // lis le fichier txt et retourne un tableau de tableau aves les freq
        LectureData reader2 = new LectureData("example.txt");
        ArrayList<String[]> test =reader2.dicoText();
        
     // Creation des feuilles
        // creation des feuilles suivants les lignes de tableau         
        ArrayList<Noeud> nodeList = new ArrayList<Noeud>();
        for (int i =0; i< test.size();i++) {
        	
        	Noeud leNode = new Noeud(test.get(i)[0],Integer.parseInt( test.get(i)[1]));
        	nodeList.add(leNode);	
        }
        
        /* ------------- Tests ---------------------------
        System.out.println(nodeList.size());
        for (int i =0; i<nodeList.size();i++) {
        	System.out.println(nodeList.get(i).getLettre());
        	System.out.println(nodeList.get(i).getVal());
        }
        
  /*      ArrayList<Noeud> nodeListExec = new ArrayList<Noeud>();
        // copie les même noeud et pas une copie de noeud 
        
        */
/*       ArrayList<Noeud> nodeListExec = new ArrayList<Noeud>();
       
      /* for (int j = 0 ; j<nodeList.size();j++) {
         	nodeListExec.add(nodeList.get(j).clone());
         }*/
      
   /*    HuffmanForest hF = new HuffmanForest(nodeListExec);
       
      /* while (hF.getForet().size()>1){
          	hF.remakeForest();
          System.out.println(hF.getForet().size());
          }
       System.out.println( hF.getForet().get(0).deepPath("", "n"));
       
       
       */
   /*    String newFile = "freq1.dat";
       LectureData newDat = new LectureData(newFile);
       
      // marche sauf pour E 
       //pour tous les elements du tableau de freq, on crée un arbre et on retourne son code de Huffman
       
       for (int i = 0; i<test.size();i++) {
    	   
    	   nodeListExec.clear();
    	   for (int j = 0 ; j<nodeList.size();j++) {
           	nodeListExec.add(nodeList.get(j).clone());
           }
    	   
    	   hF = new HuffmanForest(nodeListExec);
           while (hF.getForet().size()>1){
           	hF.remakeForest();
          // System.out.println(hF.getForet().size());
           }
           
          // ecrit dans le fichier le codage de huffman 
          // System.out.println(test.get(i)[0] + " : "+  hF.getForet().get(0).deepPath("", test.get(i)[0]));
           newDat.writeInFile(test.get(i)[0], hF.getForet().get(0).deepPath("", test.get(i)[0]));
    	   
    	   
       }
       
       LectureData reader1 = new LectureData("freq1.dat");
       ArrayList<String[]> dataList2 = reader1.arrayListValue2();
       
       for (int i = 0; i< dataList2.size();i++) {
    	   System.out.println(dataList2.get(i)[0]+ " : " + dataList2.get(i)[1]);
       }
       File f = new File("example.txt");
       Codage c = new Codage("res");
       c.code(f, dataList2);
       
       
       
       
       /*LectureData reader2 = new LectureData("example.txt");
       ArrayList<String[]> test =reader2.dicoText();
       System.out.println(test.size());
       
       for (int i =0; i < test.size();i++) {
    	   System.out.println(test.get(i)[0]+" : " + test.get(i)[1]);
    	   
       }
  	*/	
		byte data = 0b01010101;
		System.out.println(data);
		System.out.println((char)data);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez selectionner une option :");
		System.out.println("1 - Coder un fichier .txt. ");
		System.out.println("2 - Decoder un fichier .dat");
		System.out.print("Votre choix : ");
		int choix = sc.nextInt();
		sc.nextLine();
		
		switch (choix) {
		case 1 :
			
			System.out.println("Vous avez choisit de coder un fichier .txt");
			System.out.println("Veuillez rentrer le nom du fichier, sans l'extention .txt");
			System.out.println("Veillez à qu'il soit bien dans le repertoire du projet");
			System.out.println("Nom du fichier:");
			String name = sc.nextLine();
			System.out.println(name);
			CodageHuffman c = new CodageHuffman(name);
			c.leCodage();
			sc.close();
			break;
		case 2 : 
			System.out.println("Vous avez choisit de decoder un fichier .dat utilisant le codage de Huffman ");
			System.out.println("Veuillez rentrer le préfixe du fichier, cad la chaine de caractère avant le '_'");
			System.out.println("Example avec le fichier example_huffCode.dat --> Veuillez rentrer : example");
			String name1 = sc.nextLine();
			DecodageHuffman d = new DecodageHuffman(name1+"_dico.dat",name1+"_huffCode.dat");
			d.decode();
			sc.close();
			
			break;
		default :
			System.out.println("veuiller choisir entre 1 et 2 ");
			break;
			
			
		}
		
		
		//CodageHuffman c = new CodageHuffman("alice29");, 
		//c.leCodage();
		
		//System.out.println(a.contains({"a",.}));
//		DecodageHuffman d = new DecodageHuffman("alice29_dico.dat","alice29_huffCode.dat");
	//	d.decode();
		
	/*	try {
			BufferedReader br = new BufferedReader(new FileReader("example_dico.dat"));
			
			System.out.println(br.readLine().equals(""));
			System.out.println(br.readLine());
			br.close();
		}catch (Exception e){
			System.out.println(e.toString());
			}*/
		
		
}
}