package java_project;
import java.util.Scanner;
import java.lang.Math;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.* ;
import javax.swing.border.TitledBorder;

import java.io.IOException;

public class Main{
	public static JButton b1,b2,b3,b4,b5,b6,b7,b8;
	public static	String couleur_string,nouvelle_col;
	public static boolean[] etat=new boolean[7];
	public static Cellule [][] grille_save= Grille.initGrille(19);
	public static int var_d=0;
	public static JFrame f;
	public static Joueur a,b,c,d,x;
	public static Joueur a_copy,b_copy,c_copy,d_copy,x_copy;
	public Joueur[] J={a,b,c,d};
	
	public Main(){
		button(new Fenetre(J));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		
		game();
	}
	
	
	
	public static void game() throws ClassNotFoundException, IOException
	{	
					etat[6]=false;
					Scanner sc=new Scanner(System.in);
					String graphic="a";
					System.out.println("Choisissez si vous voulez jouer en partie graphique. O/N");
					while(!graphic.equals("O")&&!graphic.equals("N"))
					{
			        	graphic=sc.nextLine();
			        	graphic=graphic.toUpperCase();
						
					}
					int taille;
					if(graphic.equals("N"))
					{	
						System.out.println("Choisissez la taille du carré (Entre 1 et100)");
					
						do
						{
							taille=sc.nextInt();
						}while(taille<1&&taille>100);
							
					}else{
						taille=19;
					}
											
					int pourcent=100;
					int type=0;
					int joueur=2;
					int rang=-1;
					int nbrOrdiJoueur=0;
					String reseau="a";
					String host="a";
					String ordi="a";
					String name;
					String[] leschamps=null;
					if(graphic.equals("O"))
					{
						leschamps=Fenetre.getDonnees();
						
					}else{}
					
					Cellule [][] grille= Grille.initGrille(taille);
					if(graphic.equals("N"))
					{
						sc.nextLine(); 
						System.out.println("Choisir le pseudo du joueur a");
						name=sc.nextLine();
						
						Main.a = new Joueur(1,grille[0][taille-1].getColor(),name,0.0);
						System.out.println("Choisir le pseudo du joueur b");
						name=sc.nextLine();
						Main.b = new Joueur (2,grille[taille-1][0].getColor(),name,0.0);
						
						Main.c = new Joueur(3,null,null,0.0);
						
						Main.d = new Joueur(4,null,null,0.0);
					}else{
						Main.a = new Joueur(1,grille[0][taille-1].getColor(),leschamps[6],0.0);
						
						Main.b = new Joueur (2,grille[taille-1][0].getColor(),leschamps[7],0.0);
								
						Main.c = new Joueur(3,null,leschamps[8],0.0);
						
						Main.d = new Joueur(4,null,leschamps[9],0.0);
					}
					
					Joueur[] J={Main.a,Main.b,Main.c,Main.d};
					
					Fenetre o=null;
					if(graphic.equals("O"))
					{
						 o = new Fenetre(J);
					
				        f = new JFrame(o.getClass().getSimpleName());
				        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				        f.setLocationByPlatform(true);
				
				        f.setContentPane(o.getUI());
				        f.pack();
				    
				        f.setMinimumSize(f.getSize());
				        f.setSize( 100 , 100 ) ;
				        f.setVisible(true);
					}else{}
					
					Joueur [] stockJoueur= new Joueur [4];
					stockJoueur[0]=a;
				    stockJoueur[1]=b;
				    stockJoueur[2]=c;
				    stockJoueur[3]=d;
					grille[0][taille-1].changeId(a.getid());
					grille[taille-1][0].changeId(b.getid());
					
					if(graphic.equals("O"))
					{
						Fenetre.print(taille,grille);
						etat[6]=false;
					}else{}
					
					while(!reseau.equals("O")&&!reseau.equals("N"))
					{
			        	 
							
			        	if(graphic.equals("O"))
						{
			        		reseau=leschamps[0];
						}
			        	else{
			        		System.out.println("Voulez vous jouer en réseau? O/N");
			        			reseau=sc.nextLine();
			        			reseau=reseau.toUpperCase();
			        	}
						
					}
			        
			        if(reseau.equals("N"))
			        {
						        	do
									{
										if(graphic.equals("O"))
										{
											joueur = Integer.parseInt(leschamps[2]);
										}else{
											System.out.println("Combien de joueur? 2/3/4?");
											
											joueur=sc.nextInt();
										}
									}while(joueur<2||joueur>4);
									
									System.out.println("Voulez vous jouer contre l'ordinateur? O/N");
									while(!ordi.equals("O")&&!ordi.equals("N"))
									{
										if(graphic.equals("O"))
										{
											ordi=leschamps[1];
										}else{
											ordi=sc.nextLine();
										}
										ordi=ordi.toUpperCase();
										
									}
									
									if(ordi.equals("O"))
									{
										System.out.println("Quelle difficulté? 0/1/2");
										while(rang<0||rang>2)
										{
											if(graphic.equals("O"))
											{
												rang=Integer.parseInt(leschamps[4]);
											}else{
												rang=sc.nextInt();
											}
										}
										System.out.println("Nombre d'ordinateur joueurs");
										while(nbrOrdiJoueur<=0||nbrOrdiJoueur>joueur-1)
										{
											if(graphic.equals("O"))
											{
												nbrOrdiJoueur=Integer.parseInt(leschamps[3]);
											}else{
												nbrOrdiJoueur=sc.nextInt();
											}
										}
									}else{}
									
									if(joueur==3)
									{
										grille[0][0].changeId(c.getid());
										c.changeCouleur(grille[0][0].getColor());
									}else{
										if(joueur==4)
										{
											grille[0][0].changeId(c.getid());
											c.changeCouleur(grille[0][0].getColor());
											grille[taille-1][taille-1].changeId(d.getid());
											d.changeCouleur(grille[taille-1][taille-1].getColor());
											sc.nextLine();
											System.out.println("Choisir le pseudo du joueur c");
											name=sc.nextLine();
											c.changName(name);
											System.out.println("Choisir le pseudo du joueur d");
											name=sc.nextLine();
											d.changName(name);
										}else{
											
										}
									}	
									System.out.println("Choisissez le type de jeu. 0 pour un carré");
									do{
										if(!graphic.equals("O"))
										{
											type=sc.nextInt();
										}else{
											type=Integer.parseInt(leschamps[5]);
										}
										
									}while(type<0&&type>1);
			        }
			        else
			        {
			        	System.out.println("Êtes vous l'host?");
			        	while(!host.equals("O")&&!host.equals("N"))
						{
			        		if(!graphic.equals("O"))
							{
								host=sc.nextLine();	
								host=host.toUpperCase();
							}else{}
						}
			        }
					
					
					
					Scanner scan = new Scanner(System.in);
					pourcent=pourcent/joueur;
					while(a.getPourcent()<pourcent&&b.getPourcent()<pourcent&&c.getPourcent()<pourcent&&d.getPourcent()<pourcent) 
					{
						if(reseau.equals("N")||!host.equals("N"))
						{
							
							if(ordi.equals("O"))
							{
								if(graphic.equals("O"))
								{
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
								}else{
									Grille.affConsole(grille,type);
								}
								
								a=changCoulJ(a,b,c,d,a,o,grille,graphic);
								
								grille=Grille.changCoulG(grille,a,b,c,d);
								
								if(graphic.equals("O"))
								{
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
								}else{}
								
								b=changCoulia(a,b,c,d,b,rang,o,grille,joueur);
								if(grille[0][0].getPlayerId()==c.getid())
								{
									c=changCoulia(a,b,c,d,c,rang,o,grille,joueur);
									if(grille[taille-1][taille-1].getPlayerId()==d.getid())
									{
										d=changCoulia(a,b,c,d,d,rang,o,grille,joueur);
									}else{}
								}
								else{}
								grille=Grille.changCoulG(grille,a,b,c,d);
								if(graphic.equals("O"))
								{
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
								}else{}
							}else{
								if(reseau.equals("O")&&host.equals("O"))
								{
									int regle;
									if(!graphic.equals("O"))
									{
										System.out.println("Voulez vous jouer avec le brouillard? 0/1");
									do
									{
										regle=sc.nextInt();
									}while(regle<0&&regle>1);
							
									stockJoueur=Serveur.serveur(grille, a, b, c, d, regle);
									
									a=stockJoueur[0];
									b=stockJoueur[1];
									c=stockJoueur[2];
									d=stockJoueur[3];
									
								}else{
									if(graphic.equals("O"))
									{
										Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
									}else{
										Grille.affConsole(grille,type);
									}
									a=changCoulJ(a,b,c,d,a,o,grille,graphic);
									
									grille=Grille.changCoulG(grille,a,b,c,d);
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
									b=changCoulJ(a,b,c,d,b,o,grille,graphic);
									if(grille[0][0].getPlayerId()==c.getid())
									{
										c=changCoulJ(a,b,c,d,c,o,grille,graphic);
										if(grille[taille-1][taille-1].getPlayerId()==d.getid())
										{
											d=changCoulJ(a,b,c,d,d,o,grille,graphic);
										}else{}
									}
									else{}
									
									grille=Grille.changCoulG(grille,a,b,c,d);
									if(graphic.equals("O"))
									{
										Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
									}else{}
									pourcentage(a,grille);
									pourcentage(b,grille);
									
									if(grille[0][0].getPlayerId()==c.getid())
									{
										pourcentage(c,grille);
										if(grille[taille-1][taille-1].getPlayerId()==d.getid())
										{
											pourcentage(d,grille);
										}else{}
									}
									else{}
								}
								
							}
							
							
							}
			
							
							
						}else{
							try {
								if(a.getPourcent()<pourcent&&b.getPourcent()<pourcent)
							    {
									stockJoueur=Client.client();
									a=stockJoueur[0];
									b=stockJoueur[1];
									
							    }
							} catch (Exception e) {
								//System.out.println(" Probleme client !");
							}
						}
						
					}
					
					winner(a,b,c,d,pourcent,graphic);
					scan.close();
					sc.close();
					
					
		
				
		
		
	}
	
	public static Joueur changCoulJ(Joueur a, Joueur b, Joueur c, Joueur d,Joueur x,Fenetre o,Cellule [][] grille,String graphic)
	{	
		if(graphic.equalsIgnoreCase("O"))
		{
			int co;
		
			String [] couleur= {"R","O","J","V","B","I"};
			
			a_copy=a;b_copy=b;c_copy=c;d_copy=d;x_copy=x;
			grille_save=grille;
				//System.out.println(x.getname());	
			String Couleur;
			Joueur[] J={a,b,c,d};
			switch(x.getColor())
	        {
	                case "R" : Couleur="Rouge";
	                
	        		Fenetre.Label(J);
	        		Fenetre.Message(x.getname(), Couleur);
	                break;
	                case "O" :Couleur="Orange"; 
	                
	        		Fenetre.Label(J);
	        		Fenetre.Message(x.getname(), Couleur);
	                break;
	                case "J" : Couleur="Jaune"; 
	               
	        		Fenetre.Label(J);
	        		Fenetre.Message(x.getname(), Couleur);
	                break;
	                
	                case "B" : Couleur="Blue"; 
	                
	        		Fenetre.Label(J);
	        		Fenetre.Message(x.getname(), Couleur);break;
	                case "I" : Couleur="Gris"; 
	                
	        		Fenetre.Label(J);
	        		Fenetre.Message(x.getname(), Couleur);
	                break;
	                case "V" : Couleur="Vert";
	                
	        		Fenetre.Label(J);
	        		Fenetre.Message(x.getname(), Couleur);
	        		break;
	        }
			
			//}
			
	        //Fin
	  		/***************************************************************************************************************/
	  		
			switch(x.getColor())
	        {
			        case "R" : b1.setBackground(Color.black);etat[0]=false;break;
			        case "O" : b2.setBackground(Color.black);etat[1]=false; break;
			        case "J" : b3.setBackground(Color.black);etat[2]=false; break;
			        
			        case "B" : b4.setBackground(Color.black);etat[3]=false; break;
			        case "I" : b5.setBackground(Color.black);etat[4]=false; break;
			        case "V" :b6.setBackground(Color.black);etat[5]=false;break;
	        }
			nouvelle_col=x.getColor();
			
			//o=new Fenetre(a, b, c, d,x);
			
			
			//o.Message(x.getname(),x.getcolor());
			for(co=0;co<couleur.length;co++)
			{
				if(!couleur[co].equalsIgnoreCase(a.getColor())&&!couleur[co].equalsIgnoreCase(b.getColor())
						&&!couleur[co].equalsIgnoreCase(c.getColor()) && !couleur[co].equalsIgnoreCase(d.getColor())
						&&couleur[co]!=null)
				{
					System.out.print(couleur[co]+" / ");
					switch(couleur[co])
			        {
			                case "R" : b1.setBackground(Color.red);etat[0]=true;break;
			                case "O" :b2.setBackground(Color.orange);etat[1]=true; break;
			                case "J" : b3.setBackground(Color.yellow);etat[2]=true; break;
			                case "B" : b4.setBackground(Color.blue);etat[3]=true; break;
			                case "I" : b5.setBackground(Color.gray);etat[4]=true; break;
			                case "V" :b6.setBackground(Color.green);etat[5]=true; break;
			        }
				}else{
					switch(couleur[co])
			        {
			                case "R" : b1.setBackground(Color.black);etat[0]=false;break;
			                case "O" : b2.setBackground(Color.black);etat[1]=false; break;
			                case "J" : b3.setBackground(Color.black);etat[2]=false; break;
			                
			                case "B" : b4.setBackground(Color.black);etat[3]=false; break;
			                case "I" : b5.setBackground(Color.black);etat[4]=false; break;
			                case "V" :b6.setBackground(Color.black);etat[5]=false;break;
			        }
				}
			}
			nouvelle_col=x.getColor();
			
			while(((nouvelle_col.equalsIgnoreCase(a.getColor()) || nouvelle_col.equalsIgnoreCase(b.getColor()) || nouvelle_col.equalsIgnoreCase(c.getColor())|| nouvelle_col==null || nouvelle_col.equalsIgnoreCase(d.getColor())) ))
			{
				
				
				b1.addActionListener(new ActionListener( ){     
			
					@Override
					public void actionPerformed(ActionEvent e) {    
						if(etat[0]){
							b1.setBackground(Color.black);
								etat[0]=false;
								String nouvelle_col1="R"; 
								x.changeCouleur(nouvelle_col1.toUpperCase());
								
						}else{b1.setBackground(Color.black);etat[0]=false;}
				}      
				}); 
				
				b2.addActionListener(new ActionListener( ) {     
					@Override
					public void actionPerformed(ActionEvent e) {   
						if(etat[1]){
							
							b2.setBackground(Color.black);
							etat[1]=false;
							String nouvelle_col2="O";
							x.changeCouleur(nouvelle_col2.toUpperCase());}else{b2.setBackground(Color.black);etat[1]=false;}
					}      
				});
				b3.addActionListener(new ActionListener( ) { 
				   		@Override
						public void actionPerformed(ActionEvent e) {    
				   			if(etat[2]){
				   				
									b3.setBackground(Color.black);
									etat[2]=false;
									String nouvelle_col3="J";
									x.changeCouleur(nouvelle_col3.toUpperCase());}else{b3.setBackground(Color.black);etat[2]=false;}
						}      
						});
						
			b4.addActionListener(new ActionListener( ) {     
				@Override
				public void actionPerformed(ActionEvent e) {    
					if(etat[3]){
						b4.setBackground(Color.black);
								etat[3]=false;
								String nouvelle_col4="B";
								x.changeCouleur(nouvelle_col4.toUpperCase());}else{b4.setBackground(Color.black);etat[3]=false;}
							}      
							}); 
			b5.addActionListener(new ActionListener( ) {     
				@Override
				public void actionPerformed(ActionEvent e) {    
					if(etat[4]){
						b5.setBackground(Color.black);
									etat[4]=false;
									String nouvelle_col5="I";
									x.changeCouleur(nouvelle_col5.toUpperCase());}else{b5.setBackground(Color.black);etat[4]=false;}
								}      
			}); 
			b6.addActionListener(new ActionListener( ) {     
				@Override
				public void actionPerformed(ActionEvent e) {    
					if(etat[5]){
						b6.setBackground(Color.black);
										etat[5]=false;
										String nouvelle_col6="V";
					x.changeCouleur(nouvelle_col6.toUpperCase());}
					else{b6.setBackground(Color.black);etat[5]=false;}
									}      
				});
			}
		}else{
			int co;
			String [] couleur= {"R","O","J","V","B","I"};
			Scanner scan=new Scanner(System.in);
			pourcentage(x,grille);
			System.out.println("Au tour du joueur "+x.getid());
			
			System.out.println("Le joueur "+x.getid()+" possède la couleur "+x.getColor()+" et est à "+x.getPourcent());
			
			System.out.print("Quelle couleur choisissez vous? ");
			
			for(co=0;co<couleur.length;co++)
			{
				if(!couleur[co].equalsIgnoreCase(a.getColor())&&!couleur[co].equalsIgnoreCase(b.getColor())
						&&!couleur[co].equalsIgnoreCase(c.getColor()) && !couleur[co].equalsIgnoreCase(d.getColor())
						&&couleur[co]!=null)
				{
					System.out.print(couleur[co]+" / ");
				}else{}
			}
			
			String couleur1=x.getColor();
			
			while((couleur1.equalsIgnoreCase(a.getColor())||couleur1.equalsIgnoreCase(b.getColor())||
					couleur1.equalsIgnoreCase(c.getColor())||
					couleur1.equalsIgnoreCase(d.getColor())))
			{
					couleur1=scan.nextLine();
			}
			
			x.changeCouleur(couleur1.toUpperCase());
			
			
		}
		
	
	
		return x;
	}
	
	public static double pourcentage(Joueur x, Cellule [][] grille)
	{
		int compteur=0;
		double pourcent;
		for(int i=0;i<grille.length;i++)
		{
			for(int j=0;j<grille.length;j++)
			{
				if(grille[i][j].getPlayerId()==x.getid())
				{
					compteur++;
					
				}else{}
			}
			
		}
		pourcent=(compteur*100)/(grille.length*grille.length);
		x.changPourcent(pourcent);
		return pourcent;
		
	}
	
	public static Joueur changCoulia(Joueur a, Joueur b, Joueur c, Joueur d,Joueur x,int rang,Fenetre o,Cellule [][] grille,int nbrJoueur)
	{
	
		int coulCompteur;
		int coulCompteur1=0;
		String [] couleur= {"R","O","J","V","B","I"};
		String [] couleur1 = new String [nbrJoueur];
		int [] comptCouleur = new int [nbrJoueur];
		int compteur=0;
		pourcentage(x,grille);
		int i;
		for(i=0;i<couleur1.length;i++)
		{
			couleur1[i]=null;
		}
		
		for(i=0;i<comptCouleur.length;i++)
		{
			comptCouleur[i]=0;
		}
		
		for(coulCompteur=0;coulCompteur<couleur.length;coulCompteur++)
		{
			if(!couleur[coulCompteur].equalsIgnoreCase(a.getColor())&&!couleur[coulCompteur].equalsIgnoreCase(b.getColor())
					&&!couleur[coulCompteur].equalsIgnoreCase(c.getColor()) && !couleur[coulCompteur].equalsIgnoreCase(d.getColor()))
			{
				
				if(coulCompteur1<nbrJoueur)couleur1[coulCompteur1]=couleur[coulCompteur];
				coulCompteur1++;
				
				
			}else{}
		}
		if(rang==0)
		{
			compteur=(int)(Math.random()*nbrJoueur);
		}else{
			if(rang==1)
			{
				
				int x1;
				int y;
				
				for(i=0;i<couleur1.length;i++)
				{
					for(x1=0;x1<grille.length;x1++)
					{
						for(y=0;y<grille.length;y++)
						{
							if(grille[x1][y].getPlayerId()==x.getid())
							{
								comptCouleur[i]=comptCouleur[i]+Grille.proximiteCompteur(x1, y, x, grille, couleur1[i], 0);
							}						
									
						}
					}
				}
													
			}else{
				
				int x1;
				int y;
				
				for(i=0;i<couleur1.length;i++)
				{
					for(x1=0;x1<grille.length;x1++)
					{
						for(y=0;y<grille.length;y++)
						{
							if(grille[x1][y].getPlayerId()==a.getid())
								{
									comptCouleur[i]=comptCouleur[i]+Grille.proximiteCompteur(x1, y, a, grille, couleur1[i], 0);
								}						
									
						}
					}
				}
				
			}
			
		}
		
		
		
			
			
		
		
		for(i=0;i<couleur.length;i++)
		{	
			if(i<nbrJoueur){
				if(comptCouleur[i]>comptCouleur[compteur])
				{
					compteur=i;
				}else{}
			}
		}
		
		x.changeCouleur(couleur1[compteur].toUpperCase());
		
		return x;
		
		
		
		
	}
	
	public static void winner (Joueur a,Joueur b, Joueur c, Joueur d,int pourcent,String graphic)
	{
		if(graphic.equals("O"))
		{
			if(a.getPourcent()>pourcent)Fenetre.Message(a.getname(),"F");
			else if(b.getPourcent()>pourcent)Fenetre.Message(b.getname(),"F");
			else if(c.getPourcent()>pourcent)Fenetre.Message(c.getname(),"F");
			else if(d.getPourcent()>pourcent)Fenetre.Message(d.getname(),"F");
		}
		else{
			String win = null;
			if(a.getPourcent()>pourcent)
			{
				win="a";
			}else{
				if(b.getPourcent()>pourcent)
				{
					win="b";
				}else{
					if(c.getPourcent()>pourcent)
					{
						win="c";
					}else{
						if(d.getPourcent()>pourcent)
						{
							win="d";
						}else{}
					}
				}
			}
			System.out.println("La partie est finie, le joueur "+win+" a gagné");
		}
		
		
		
		
		
		
	}
	public static void button(Fenetre o)
    {
    	JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel.setBorder(new TitledBorder("Choix"));
        Fenetre.menuPanel.add(buttonPanel, BorderLayout.LINE_START);
        
        // création des boutons
         b1 = new JButton("Rouge"); 
        		b2 = new JButton("Orange");
        		b3 = new JButton("Jaune");
        		b4 = new JButton("Blue");
        		b5 = new JButton("Gris");
        		b6 = new JButton("Vert");
        		b7 = new JButton("Sauvegarder la partie");
        		b8 = new JButton("Recuperer la partie");
        // ajout des boutons à la fenêtre
        buttonPanel.add(b1).setBackground(Color.red);
        buttonPanel.add(b2).setBackground(Color.orange);
        buttonPanel.add(b3).setBackground(Color.yellow);
        buttonPanel.add(b4).setBackground(Color.blue);
        buttonPanel.add(b5).setBackground(Color.gray);
        buttonPanel.add(b6).setBackground(Color.green);
       
        
        // positionnement et dimensionnement manuel des boutons
       
        
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        buttonPanel.add(b6);
        Fenetre.buttonPanel_2.add(b7);
        Fenetre.buttonPanel_2.add(b8);
        	b7.addActionListener(new ActionListener( ){     
			
			@Override
			public void actionPerformed(ActionEvent e) {    
				Fenetre.ecrire(grille_save,a_copy,b_copy,c_copy,d_copy,x_copy );
			}      
			});
        	b8.addActionListener(new ActionListener( ){     
			
			@Override
			public void actionPerformed(ActionEvent e) {    
				Fenetre.print(19,Grille.changCoulG(Fenetre.lire(grille_save),a,b,c,d));
				changCoulJ(a,b,c,d,x,o,Fenetre.lire(grille_save),"O");
			}      
			}); 
    }
    	
	
	
}
