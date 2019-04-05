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
		ArrayList<String[]> al = new ArrayList<String[]>();
        String fileName = "freq.dat";
        try {
		BufferedReader br = new BufferedReader(new FileReader("freq.dat"));
		String line;
		
		while ((line = br.readLine()) != null) {
		   // process the line.
			if (line.length()>1){
				String[] newLine= line.split(" ");
				al.add(newLine);
				
			}
			   
			
		}
		
			
		
		br.close();
        }
        catch (Exception e){
			System.out.println(e.toString());
			}
     // boucle pour lire le tableau de tableau de string
    	/*
        for (int i =0; i< al.size();i++) {
			System.out.println("a la ligne" + i);
			for(String j : al.get(i)) {
				
				System.out.println(j);        	
	        }
			
    	}
    	*/
        
		/*try{
			InputStream flux=new FileInputStream("freq.dat"); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				System.out.println(ligne);
			}
			buff.close(); 
			}	
			catch (Exception e){
			System.out.println(e.toString());
			}
	*/
     
        System.out.println(al.get(0)[1] instanceof String);
        ArrayList<Noeud> nodeList = new ArrayList<Noeud>();
        
// Creation des feuilles
      
         for (int i =0; i< al.size();i++) {
        	
        	Noeud leNode = new Noeud(al.get(i)[0],Integer.parseInt( al.get(i)[1]));
        	nodeList.add(leNode);
        		
        	
        }
        /* ------------- Tests ---------------------------
        System.out.println(nodeList.size());
        for (int i =0; i<nodeList.size();i++) {
        	System.out.println(nodeList.get(i).getLettre());
        	System.out.println(nodeList.get(i).getVal());
        }
        */
        int i = 0;
        HuffmanForest hF = new HuffmanForest(nodeList);
        while (hF.getForet().size()>1){
        	hF.remakeForest();
        System.out.println(hF.getForet().size());
        }
        
       System.out.println(hF.getForet().get(0).getGauche().isLeaf());
       
       String path = hF.getForet().get(0).deepPath("", "B");
       System.out.println(path);
       
        
	}
}
