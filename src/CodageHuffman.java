import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class CodageHuffman {
		private String fileName; 
		
		public CodageHuffman(String file) {
			this.fileName = file;
		}
		
		public void leCodage() {
			
		     LectureData reader2 = new LectureData(this.fileName + ".txt");
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
		        // copie les m�me noeud et pas une copie de noeud 
		        
		        */
		       ArrayList<Noeud> nodeListExec = new ArrayList<Noeud>();
		       
		      /* for (int j = 0 ; j<nodeList.size();j++) {
		         	nodeListExec.add(nodeList.get(j).clone());
		         }*/
		      
		       HuffmanForest hF = new HuffmanForest(nodeListExec);
		       
		      /* while (hF.getForet().size()>1){
		          	hF.remakeForest();
		          System.out.println(hF.getForet().size());
		          }
		       System.out.println( hF.getForet().get(0).deepPath("", "n"));
		       
		       
		       */
		       String newFile = this.fileName+"_dico.dat";
		       LectureData newDat = new LectureData(newFile);
		       
		      // marche sauf pour E 
		       //pour tous les elements du tableau de freq, on cr�e un arbre et on retourne son code de Huffman
		       
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
		       
		       LectureData reader1 = new LectureData(this.fileName+"_dico.dat");
		       ArrayList<String[]> dataList2 = reader1.arrayListValue2();
		       System.out.println("un test");
		       System.out.println(dataList2.get(0)[0].length());
		       System.out.println(dataList2.get(0)[1]);
		       System.out.println("test fini");
		       
		       File f = new File(this.fileName+".txt");
		       Codage c = new Codage(this.fileName+"_huffCode");
		       c.code(f, dataList2);
		       
		       System.out.println("Code relating to the file : " );
		       try {
					BufferedReader br = new BufferedReader(new FileReader(this.fileName+"_huffCode.dat"));
					String line;
					
					while ((line = br.readLine()) != null) {
					   // process the line.
						System.out.println(line);
						   
						
					}
					
					br.close();
			        }
			        catch (Exception e){
						System.out.println(e.toString());
						}
		       System.out.println("\n");
		       System.out.println("the relating dictionnary : " + "\n");
		       for (int i = 0; i< dataList2.size();i++) {
		    	   System.out.println(dataList2.get(i)[0]+ " : " + dataList2.get(i)[1]);
		       }
		       
		       
		       
		}
}
