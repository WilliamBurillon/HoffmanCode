import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// The name of the file to open.
	
        
        LectureData reader = new LectureData("freq.dat");
        ArrayList<String[]> dataList = reader.arrayListValue();
        
        LectureData reader2 = new LectureData("example.txt");
        ArrayList<String[]> test =reader2.dicoText();
        
     // Creation des feuilles
                
        ArrayList<Noeud> nodeList = new ArrayList<Noeud>();
        for (int i =0; i< test.size();i++) {
        	
        	Noeud leNode = new Noeud(test.get(i)[0],Integer.parseInt( test.get(i)[1]));
        	nodeList.add(leNode);	
        }
        System.out.println(nodeList.size());
        System.out.println(test.size());
        
        /* ------------- Tests ---------------------------
        System.out.println(nodeList.size());
        for (int i =0; i<nodeList.size();i++) {
        	System.out.println(nodeList.get(i).getLettre());
        	System.out.println(nodeList.get(i).getVal());
        }
        
  /*      ArrayList<Noeud> nodeListExec = new ArrayList<Noeud>();
        // copie les même noeud et pas une copie de noeud 
        
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
       
       
      // marche sauf pour E 
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
           System.out.println(test.get(i)[0] + " : "+  hF.getForet().get(0).deepPath("", test.get(i)[0]));
        
    	   
    	   
       }
       
       /*LectureData reader2 = new LectureData("example.txt");
       ArrayList<String[]> test =reader2.dicoText();
       System.out.println(test.size());
       
       for (int i =0; i < test.size();i++) {
    	   System.out.println(test.get(i)[0]+" : " + test.get(i)[1]);
    	   
       }
   */
}
}