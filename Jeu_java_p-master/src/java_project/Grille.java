package java_project;
import java.lang.Math;


public class Grille {

	public static String [] couleur= {"R","O","J","V","B","I"};
	public static Cellule[][] initGrille(int taille)
	{
		Cellule [][] nouvelleG= new Cellule [taille][taille];
		int i;
		int j;
		int compteur=0;
		int rand;
		Cellule [] c = new Cellule [taille*taille];
		
		
		for(i=0;i<taille;i++)
		{
			for(j=0;j<taille;j++)
			{
				
				rand=(int)(Math.random()*6);
				c[compteur] = new Cellule(couleur[rand],0,i,j);
				nouvelleG[i][j]=c[compteur];
				compteur++;
				
			}
		}
		
		initCoulSom(nouvelleG);
					
		initCouleurGrille(0, taille-1, nouvelleG, 1, taille-1);
		initCouleurGrille(0, taille-1, nouvelleG, 0, taille-2);
		initCouleurGrille(taille-1, 0, nouvelleG, taille-2, 0);
		initCouleurGrille(taille-1, 0, nouvelleG, taille-1, 1);
		initCouleurGrille(0, 0, nouvelleG, 0, 1);
		initCouleurGrille(0, 0, nouvelleG, 1, 0);
		initCouleurGrille(taille-1, taille-1, nouvelleG, taille-2, taille-1);
		initCouleurGrille(taille-1, taille-1, nouvelleG, taille-1, taille-2);
		
		return nouvelleG;
	}
	
	public static void initCoulSom(Cellule[][] nouvelleG)
	{
		int i=0;
		String [] couleur1 = new String [6];
		int taille=nouvelleG.length;
		int rand;
		
		for(int compt=0;compt < 4;compt++)
		{
			switch (compt){
					case 0: 
						for(int co=0;co<couleur.length;co++)
						{	
							if(!couleur[co].equalsIgnoreCase(nouvelleG[0][taille-1].getColor()))
							{
								couleur1[i]=couleur[co];
								i++;
							}else{}
						}
						
						
						rand=(int)(Math.random()*4);
						nouvelleG[taille-1][0].changeCouleur(couleur1[rand]);
						i=0;
						break;
							
							
					case 1:
						for(int co=0;co<couleur.length;co++)
						{	
							if(!couleur[co].equalsIgnoreCase(nouvelleG[0][taille-1].getColor())
							&&!couleur[co].equalsIgnoreCase(nouvelleG[taille-1][0].getColor()))
							{
								couleur1[i]=couleur[co];
								i++;
							}else{}
							
							
						}			
						
						rand=(int)(Math.random()*3);
						nouvelleG[0][0].changeCouleur(couleur1[rand]);
						i=0;
						break;
							
					case 3: for(int co=0;co<couleur.length;co++)
					{	
						if(!couleur[co].equalsIgnoreCase(nouvelleG[0][0].getColor())
							&&!couleur[co].equalsIgnoreCase(nouvelleG[taille-1][0].getColor())
							&&!couleur[co].equalsIgnoreCase(nouvelleG[0][taille-1].getColor()))
						{
							couleur1[i]=couleur[co];
							i++;
						}
						else{}
						
					}	
					
					rand=(int)(Math.random()*2);
					nouvelleG[taille-1][taille-1].changeCouleur(couleur1[rand]);
					i=0;
					break;
				}
					
			}
	}
	
	public static void initCouleurGrille(int x, int y, Cellule [][] grille, int x1, int y1)
	{
		int rand;
		while(grille[x1][y1].getColor().equalsIgnoreCase(grille[x][y].getColor()))
		{
			rand=(int)(Math.random()*6);
			grille[x1][y1].changeCouleur(couleur[rand]);
		}
	}
	
	public static Cellule[][] changCoulG(Cellule [][] grille,Joueur a, Joueur b,Joueur c, Joueur d)
	{
		
		int x;
		int y;
		
			for(x=0;x<grille.length;x++)
			{
				for(y=0;y<grille.length;y++)
				{
					
						
						if(grille[x][y].getPlayerId()==a.getid())
						{
							grille[x][y].changeCouleur(a.getColor());							
							proximite(x, y, a, grille);
						}else{									
							if(grille[x][y].getPlayerId()==b.getid())
							{
								
								grille[x][y].changeCouleur(b.getColor());
								proximite(x, y, b, grille);		
								
							}else{
								if(grille[x][y].getPlayerId()==c.getid())
								{
									
									grille[x][y].changeCouleur(c.getColor());
									proximite(x, y, c, grille);		
									
								}else{
									if(grille[x][y].getPlayerId()==d.getid())
									{
										
										grille[x][y].changeCouleur(d.getColor());
										proximite(x, y, d, grille);		
										
									}else{
										
									}
								}
							}
					
					}
				}
			}
			return grille;
		
	}
	
	public static void proximite(int i, int j, Joueur x, Cellule [][] grille)
	{
		int largeur;
		int longueur;
		
		largeur=i-1;
		longueur=j;
		
		if(largeur >= 0 && largeur < grille.length && longueur >= 0 && longueur < grille.length && grille[largeur][longueur].getColor().equalsIgnoreCase(x.getColor())) 
		{
			
			grille[largeur][longueur].changeId(x.getid());
			proximite(largeur,longueur,x,grille);
			
		}else{}
		
		largeur=i+1;
		
		if(largeur >= 0 && largeur < grille.length && longueur >= 0 && longueur < grille.length && grille[largeur][longueur].getPlayerId()==0
				&& grille[largeur][longueur].getColor().equalsIgnoreCase(x.getColor())) 
		{
			grille[largeur][longueur].changeId(x.getid());
			proximite(largeur,longueur,x,grille);
			
		}else{}
		
		largeur=i;
		longueur=j-1;
		
		if(largeur >= 0 && largeur < grille.length && longueur >= 0 && longueur < grille.length 
				&& grille[largeur][longueur].getPlayerId()==0 
				&& grille[largeur][longueur].getColor().equalsIgnoreCase(x.getColor())) 
		{
			grille[largeur][longueur].changeId(x.getid());
			proximite(largeur,longueur,x,grille);
			
		}else{}
		
		longueur=j+1;
		
		if(largeur >= 0 && largeur < grille.length && longueur >= 0 
				&& longueur < grille.length && grille[largeur][longueur].getPlayerId()==0
				&& grille[largeur][longueur].getColor().equalsIgnoreCase(x.getColor())) 
		{
			grille[largeur][longueur].changeId(x.getid());
			proximite(largeur,longueur,x,grille);
			
		}else{}
	}
	
	public static int proximiteCompteur(int i, int j, Joueur x, Cellule [][] grille,String couleur,int compteur1)
	{

		int colonne;
		int ligne;
		
	
		colonne=i;
		ligne=j-1;
		if(colonne>=0 && colonne<grille.length && ligne>=0 && ligne<grille.length)
		{
			if( grille[colonne][ligne].getPlayerId()==0
				&& grille[colonne][ligne].getColor().equalsIgnoreCase(couleur))
			{
				grille[colonne][ligne].changeId(10);
				compteur1=proximiteCompteur(colonne, ligne, x, grille, couleur, compteur1);
				compteur1++;
				
			}else{}
		}else{}
		
		colonne=i-1;
		ligne=j;
		if(colonne>=0 && colonne<grille.length && ligne>=0 && ligne<grille.length)
		{
			if(grille[colonne][ligne].getPlayerId()==0
					&& grille[colonne][ligne].getColor().equalsIgnoreCase(couleur))
			{
				grille[colonne][ligne].changeId(10);
				compteur1=proximiteCompteur(colonne, ligne, x, grille, couleur, compteur1);
				compteur1++;
			}else{}
		}else{}
		colonne=i;
		ligne=j+1;
		if(colonne>=0 && colonne<grille.length && ligne>=0 && ligne<grille.length)
		{
			if(grille[colonne][ligne].getPlayerId()==0
				&& grille[colonne][ligne].getColor().equalsIgnoreCase(couleur))
			{
				grille[colonne][ligne].changeId(10);
				
				compteur1=proximiteCompteur(colonne, ligne, x, grille, couleur, compteur1);
				compteur1++;
			}else{}
		}
		colonne=i+1;
		ligne=j;
		if(colonne>=0 && colonne<grille.length && ligne>=0 && ligne<grille.length)
		{
			if(grille[colonne][ligne].getPlayerId()==0
				&& grille[colonne][ligne].getColor().equalsIgnoreCase(couleur))
			{
				grille[colonne][ligne].changeId(10);
				compteur1=proximiteCompteur(colonne, ligne, x, grille, couleur, compteur1);
				compteur1++;
			}else{}
		}else{}
		
		for(int x1=0;x1<grille.length;x1++)
		{
			for(int y1=0;y1<grille.length;y1++)
			{
				if(grille[x1][y1].getPlayerId()==10)
				{
					grille[x1][y1].changeId(0);
				}
			}
		}
		return compteur1;
	}
	
	public static void affConsole(Cellule [][] grille,int type)
	{
		
		System.out.println("\n\n\n\n\n\n\n\n") ;
		
		if(type==0)
		{
			for(int j=0;j<grille.length;j++)
				{
					for(int i=0;i<grille.length;i++)
					{
						System.out.print(" | "+grille[i][j].getColor()+" "+grille[i][j].getPlayerId()+" | ");
					}
					System.out.println();
				}
		}else{
			if(type==1)
			{
				for(int j=0;j<grille.length;j++)
				{
					for(int i=0;i<grille.length;i++)
					{
						System.out.print(" | "+grille[i][j].getColor()+" "+grille[i][j].getPlayerId()+" | ");
					}
					System.out.println();
				}
				
				
			}else{
				
			}
			
			
		}
		
	
	
	
	
	
		
	}

	public static void brouillard(Cellule [][] grille,Joueur x)
	{
		System.out.println("\n\n\n\n\n\n\n\n") ;
		
		
			for(int j=0;j<grille.length;j++)
				{
					for(int i=0;i<grille.length;i++)
					{
						if(grille[i][j].getPlayerId()==x.getid())
						{
							System.out.print(" | "+grille[i][j].getColor()+" "+grille[i][j].getPlayerId()+" | ");
						}else{
							System.out.print(" |     | "	);
						}
					}
					System.out.println();
				}
	}

}
