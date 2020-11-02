package fr.mds.langageobjet.niv1.poo.tp14.models;

import java.util.List;
import java.util.Random;

public class Joueur {
	public int id;
	public List<Navire> navires;
	public List<Case> cases;
	private int map_x;
	private int map_y;
	
	private final int NBR_CORVETTE = 1;
	private final int NBR_CROISEUR = 2;
	private final int NBR_DESTROYER = 2;
	private final int NBR_PORTE_AVION = 1;
	
	public Joueur(int id, List<Navire> navires, List<Case> cases) {
		this.id = id;
		this.navires = navires;
		this.cases = cases;
		
		
		this.setId(id);
		this.setMap_x(map_x);
		this.setMap_y(map_y);

//		Création du corvette
		for (int i = 0; i < NBR_CORVETTE; i++) {
			Corvette corvette = new Corvette();
			placeBateau(corvette);
			this.navires.add(corvette);
		}
//		Création du croiseur
		for (int i = 0; i < NBR_CROISEUR; i++) {
			Croiseur croiseur = new Croiseur();
			placeBateau(croiseur);
			this.navires.add(croiseur);
		}
//		Création du destroyeur
		for (int i = 0; i < NBR_DESTROYER; i++) {
			Destroyer destroyeur = new Destroyer();
			placeBateau(destroyeur);
			this.navires.add(destroyeur);
		}
//		Création du porte avion 
		for (int i = 0; i < NBR_PORTE_AVION; i++) {
			PorteAvion PorteAvion = new PorteAvion();
			placeBateau(PorteAvion);
			this.navires.add(PorteAvion);
		}
	} 
	
	 public void placeBateau(Navire navires) {
		    // Création d'un objet pour faire de l'aléatoire.
		    Random rand = new Random();
		    
		   map_x = this.getMap_x();
		   map_y = this.getMap_y();

		    // Tirage aléatoire de x et y;
		    int x = rand.nextInt(map_x) % map_x;
		    int y = rand.nextInt(map_y) % map_y;
		    int direction = rand.nextInt(2) % 2;

		    // Bateau placable aux coordonnées.
		    if (estPlacable(navires, x, y, direction)) {
		      placeBateauDansCarte(navires, x, y, direction);
		    } else {
		      placeBateau(navires);
		    }
		  }
	 
	 public boolean estPlacable(Navire navire, int x, int y, int direction) {
		    boolean result = true;
		    map_x = this.getMap_x();
			  map_y = this.getMap_y();

		    switch (direction) {
		    case 0:
		      // Verticale.
		      for (int i = 0; i < navire.getTaille(); i++) {
		        // Si hors de la carte.
		        if (x + i >= map_x) {
		          result = false;
		        } else
		        // Si la case contient déjà un bateau.
		        //if (maps[joueur][x + i][y] != 0) { // Je ne comprends pas comment adapté le code ici ! PB de logique
		        //result = false;
		        //}
		      }
		      break;

		    case 1:
		      // Horizontale.
		      for (int i = 0; i < navire.getTaille(); i++) {
		        // Si hors de la carte.
		        if (y + i >= map_y) {
		          result = false;
		        } else
		        // Si la case contient déjà un bateau.
//		        if (maps[joueur][x][y + i] != 0) { // Je ne comprends pas comment adapté le code ici ! PB de logique
//		          result = false;
//		        }
		      }
		      break;
		    }

		    return result;
		  }
	 
	 /**
	   * Place réellement le bateau sur la carte du joueur.
	   * @param joueur l'indice du joueur dans le tableau
	   * @param navire le tableau représentant le type de navire
	   * @param x coordonnée X
	   * @param y coordonnée Y
	   * @param direction verticale ou horizontale
	   */
	  public static void placeBateauDansCarte(Navire navire, int x, int y, int direction) {
	    switch (direction) {
	    case 0:
	      // Verticale.
	      for (int i = 0; i < navire.getTaille(); i++) {
	        maps[joueur][x + i][y] = navire.getId(); //Logique pour passer du tableau 3dim à l'utilisation class. Même pb que plus haut
	      }
	      break;

	    case 1:
	      // Horizontale.
	      for (int i = 0; i < navire.getTaille(); i++) {
	        maps[joueur][x][y + i] = navire.getId();
	      }
	      break;
	    }
	  }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Navire> getNavires() {
		return navires;
	}

	public void setNavires(List<Navire> navires) {
		this.navires = navires;
	}

	public List<Case> getCases() {
		return cases;
	}

	public void setCases(List<Case> cases) {
		this.cases = cases;
	}

	public int getMap_x() {
		return map_x;
	}

	public void setMap_x(int map_x) {
		this.map_x = map_x;
	}

	public int getMap_y() {
		return map_y;
	}

	public void setMap_y(int map_y) {
		this.map_y = map_y;
	};
	
}

