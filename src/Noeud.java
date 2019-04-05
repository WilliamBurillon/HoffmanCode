class Noeud <E> implements Cloneable{
   private String lettre;
   private Noeud<E> gauche, droit;
   private int val;
   
   public Noeud (){ 
      lettre = null;
      val=0;
      gauche = null;
      droit = null;
   }
   
   // methode pour les feuilles avec la lettre qu'elles représente
   public Noeud (String lettre,int val){
	   this.lettre=lettre;
	   this.val=val;
	   
	   gauche = null;
	   droit = null;
}

   //méthode pour les noeuds sans lettre
   public Noeud ( int val, Noeud<E> g,
                  Noeud<E> d){
      this.val = val;
      this.lettre=null;
      gauche = g;
      droit = d;
   }
  /* 
   public Object clone() throws CloneNotSupportedException{
      // copie en profondeur d’un noeud
      Noeud<E> g = null;
      if( gauche != null ) g = (Noeud<E>)gauche.clone();
      Noeud<E> d = null;
      if( droit != null ) d = (Noeud<E>)droit.clone();
      return new Noeud<E>(element, g, d);
   }
   */

public String getLettre() {
	return lettre;
}

public void setLettre(String lettre) {
	this.lettre = lettre;
}

public Noeud<E> getGauche() {
	return gauche;
}

public void setGauche(Noeud<E> gauche) {
	this.gauche = gauche;
}

public Noeud<E> getDroit() {
	return droit;
}

public void setDroit(Noeud<E> droit) {
	this.droit = droit;
}

public int getVal() {
	return val;
}

public void setVal(int val) {
	this.val = val;
}

public boolean isLeaf() {
	boolean res = false;
	if (this.gauche == null && this.droit==null){
		res = true;
	}
	return res;
}

public boolean isFound(String lettre) {
	boolean res = false;
	if (this.isLeaf() && this.lettre == lettre){
		res= true;
	}
	return res;
}


public void deepPath(String path, String l ) {
	//System.out.println(this.lettre);
	//System.out.println(path);
	
	if (this.isFound(l)) {
		break;
	}
	
	else {
		
		if (this.gauche != null ) {
			System.out.println("a un gauche");
			this.gauche.deepPath(path+"0" , l);
		}
		else if (this.gauche == null && this.droit!= null)
			{
			System.out.println("a pas de gauche");
			this.droit.deepPath(path + "1", l);
		}
		else {
			break; 
		}
		
	}
}
}
