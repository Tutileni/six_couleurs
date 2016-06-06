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
	public static JButton b1,b2,b3,b4,b5,b6,b7;
	public static	String couleur_string,nouvelle_col;
	public static boolean[] etat=new boolean[7];
	public static Cellule [][] grille_save= Grille.initGrille(19);
	public static int var_d=0;
	public static JFrame f;
	public static Joueur a,b,c,d;
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
					System.out.println("Choisissez la taille du carré");
					int taille=19;
							//sc.nextInt();
					int pour=100;
					int type=0;
					int joueur=2;
					int rang=-1;
					int nbrOrdiJoueur=0;
					String reseau="a";
					String host="a";
					String ordi="a";
					String[] leschamps=Fenetre.getDonnees();
					Cellule [][] grille= Grille.initGrille(taille);
					Main.a = new Joueur(1,grille[0][taille-1].getcolor(),leschamps[6],0.0);
					
					Main.b = new Joueur (2,grille[taille-1][0].getcolor(),leschamps[7],0.0);
							
					Main.c = new Joueur(3,null,leschamps[8],0.0);
					
					Main.d = new Joueur(4,null,leschamps[9],0.0);
					Joueur[] J={Main.a,Main.b,Main.c,Main.d};
					Fenetre o = new Fenetre(J);
			
			        f = new JFrame(o.getClass().getSimpleName());
			        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			        f.setLocationByPlatform(true);
			
			        f.setContentPane(o.getUI());
			        f.pack();
			        f.setMinimumSize(f.getSize());
			        f.setSize( 100 , 100 ) ;
			        f.setVisible(true);
					
					
					
					
					
					Joueur [] stockJoueur= new Joueur [4];
					stockJoueur[0]=a;
				    stockJoueur[1]=b;
				    stockJoueur[2]=c;
				    stockJoueur[3]=d;
					grille[0][taille-1].changeId(a.getid());
					grille[taille-1][0].changeId(b.getid());
					Fenetre.print(taille,grille);
					etat[6]=false;
					
			        System.out.println("Voulez vous jouer en réseau? O/N");
					
			        while(!reseau.equals("O")&&!reseau.equals("N"))
					{
			        	reseau=leschamps[0];
			        			//sc.nextLine();
			        	//reseau=reseau.toUpperCase();
			        	
						
					}
			        
			        if(reseau.equals("N"))
			        {
						        	System.out.println("Combien de joueur? 2/3/4?");
									do
									{
										joueur = Integer.parseInt(leschamps[2]);
										//joueur=sc.nextInt();
									}while(joueur<2||joueur>4);
									
									System.out.println("Voulez vous jouer contre l'ordinateur? O/N");
									while(!ordi.equals("O")&&!ordi.equals("N"))
									{
										ordi=leschamps[1];
										ordi=ordi.toUpperCase();
										
									}
									
									if(ordi.equals("O"))
									{
										System.out.println("Quelle difficulté? 0/1/2");
										while(rang<0||rang>2)
										{
											rang=Integer.parseInt(leschamps[4]);
													//sc.nextInt();
										}
										System.out.println("Nombre d'ordinateur joueurs");
										while(nbrOrdiJoueur<=0||nbrOrdiJoueur>joueur-1)
										{
											nbrOrdiJoueur=Integer.parseInt(leschamps[3]);
													//sc.nextInt();
										}
									}else{}
									
									if(joueur==3)
									{
										grille[0][0].changeId(c.getid());
										c.changeCouleur(grille[0][0].getcolor());
									}else{
										if(joueur==4)
										{
											grille[0][0].changeId(c.getid());
											c.changeCouleur(grille[0][0].getcolor());
											grille[taille-1][taille-1].changeId(d.getid());
											d.changeCouleur(grille[taille-1][taille-1].getcolor());
										}else{
											
										}
									}	
									System.out.println("Choisissez le type de jeu. 0 pour un carré et 1 pour un losange");
									do{
										//type=sc.nextInt();
										type=Integer.parseInt(leschamps[5]);
									}while(type<0&&type>1);
			        }
			        else
			        {
			        	System.out.println("Êtes vous l'host?");
			        	while(!host.equals("O")&&!host.equals("N"))
						{
							//host=
									//sc.nextLine();	
							host=host.toUpperCase();
						}
			        }
					
					
					
					Scanner scan = new Scanner(System.in);
					pour=pour/joueur;
					while(a.getPourc()<pour&&b.getPourc()<pour&&c.getPourc()<pour&&d.getPourc()<pour) 
					{
						if(reseau.equals("N")||!host.equals("N"))
						{
							
							if(ordi.equals("O"))
							{
								Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
								Grille.affConsole(grille,type);
								
								a=changCoulJ(a,b,c,d,a,o,grille);
								
								grille=Grille.changCoulG(grille,a,b,c,d);
								Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
								b=changCoulia(a,b,c,d,b,rang,o,grille);
								if(grille[0][0].getPlayerId()==c.getid())
								{
									c=changCoulia(a,b,c,d,c,rang,o,grille);
									if(grille[taille-1][taille-1].getPlayerId()==d.getid())
									{
										d=changCoulia(a,b,c,d,d,rang,o,grille);
									}else{}
								}
								else{}
								grille=Grille.changCoulG(grille,a,b,c,d);
								Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
							}else{
								if(reseau.equals("O")&&host.equals("O"))
								{
									int regle;
									System.out.println("Voulez vous jouer avec le brouillard? 0/1");
									do
									{
										regle=sc.nextInt();
									}while(regle<0&&regle>1);
							
									//stockJoueur=Serveur.serveur(grille, a, b, c, d, type,regle);
									
									a=stockJoueur[0];
									b=stockJoueur[1];
									c=stockJoueur[2];
									d=stockJoueur[3];
									
								}else{
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
									Grille.affConsole(grille,type);
									
									a=changCoulJ(a,b,c,d,a,o,grille);
									
									grille=Grille.changCoulG(grille,a,b,c,d);
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
									b=changCoulJ(a,b,c,d,b,o,grille);
									if(grille[0][0].getPlayerId()==c.getid())
									{
										c=changCoulJ(a,b,c,d,c,o,grille);
										if(grille[taille-1][taille-1].getPlayerId()==d.getid())
										{
											d=changCoulJ(a,b,c,d,d,o,grille);
										}else{}
									}
									else{}
									grille=Grille.changCoulG(grille,a,b,c,d);
									Fenetre.print(taille,Grille.changCoulG(grille,a,b,c,d));
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
							
							
							
			
							
							
						}else{
							try {
								if(a.getPourc()<pour&&b.getPourc()<pour)
							    {
									//stockJoueur=Client.client();
									a=stockJoueur[0];
									b=stockJoueur[1];
									
							    }
							} catch (Exception e) {
								//System.out.println(" Probleme client !");
							}
						}
						
					}
					
					winner(a,b,c,d,pour);
					scan.close();
					sc.close();
					
					
		
				
		
		
	}
	
	public static Joueur changCoulJ(Joueur a, Joueur b, Joueur c, Joueur d,Joueur x,Fenetre o,Cellule [][] grille)
	{	
		int co;
		String [] couleur= {"R","O","J","V","B","I"};
		//Scanner scan=new Scanner(System.in);
	
		/*System.out.println("Au tour du joueur "+x.getid());
		
		System.out.println("Le joueur "+x.getid()+" possède la couleur "+x.getcolor()+" et est à "+x.getPourc());
		
		System.out.print("Quelle couleur choisissez vous? ");*/
		/*if(var_d==0 ){
			o=new Fenetre(a, b, c, d,x);
			var_d++;
		}*/
		/*****************************************************************************************************************************************/
		
		//Message
		
		
		a_copy=a;b_copy=b;c_copy=c;d_copy=d;x_copy=x;
		grille_save=grille;
			System.out.println(x.getname());	
		String Couleur;
		Joueur[] J={a,b,c,d};
		switch(x.getcolor())
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
  		
		switch(x.getcolor())
        {
		        case "R" : b1.setBackground(Color.black);etat[0]=false;break;
		        case "O" : b2.setBackground(Color.black);etat[1]=false; break;
		        case "J" : b3.setBackground(Color.black);etat[2]=false; break;
		        
		        case "B" : b4.setBackground(Color.black);etat[3]=false; break;
		        case "I" : b5.setBackground(Color.black);etat[4]=false; break;
		        case "V" :b6.setBackground(Color.black);etat[5]=false;break;
        }
		nouvelle_col=x.getcolor();
		
		//o=new Fenetre(a, b, c, d,x);
		
		
		//o.Message(x.getname(),x.getcolor());
		for(co=0;co<couleur.length;co++)
		{
			if(!couleur[co].equalsIgnoreCase(a.getcolor())&&!couleur[co].equalsIgnoreCase(b.getcolor())
					&&!couleur[co].equalsIgnoreCase(c.getcolor()) && !couleur[co].equalsIgnoreCase(d.getcolor())
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
		nouvelle_col=x.getcolor();
		
		/*while(((nouvelle_col.equalsIgnoreCase(a.getcolor()) || nouvelle_col.equalsIgnoreCase(b.getcolor()) || nouvelle_col.equalsIgnoreCase(c.getcolor())|| nouvelle_col==null || nouvelle_col.equalsIgnoreCase(d.getcolor())) ))
		{		//couleur1=Fenetre.couleur_string;
				//System.out.println(couleur1);
			nouvelle_col=scan.next();
	}*/
		
		//x.changeCouleur(nouvelle_col.toUpperCase());
		
		while(((nouvelle_col.equalsIgnoreCase(a.getcolor()) || nouvelle_col.equalsIgnoreCase(b.getcolor()) || nouvelle_col.equalsIgnoreCase(c.getcolor())|| nouvelle_col==null || nouvelle_col.equalsIgnoreCase(d.getcolor())) ))
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
		x.changPour(pourcent);
		return pourcent;
		
	}
	
	public static Joueur changCoulia(Joueur a, Joueur b, Joueur c, Joueur d,Joueur x,int rang,Fenetre o,Cellule [][] grille)
	{
		int co;
		int co1=0;
		String [] couleur= {"R","O","J","V","B","I"};
		String [] couleur1 = new String [6];
		int [] comptCouleur = new int [6];
		int compteur=0;
		
		
		
		
		
		int i=0;
		for(i=0;i<couleur1.length;i++)
		{
			couleur1[i]=null;
		}
		for(i=0;i<comptCouleur.length;i++)
		{
			comptCouleur[i]=0;
		}
		for(co=0;co<couleur.length;co++)
		{
			if(!couleur[co].equalsIgnoreCase(a.getcolor())&&!couleur[co].equalsIgnoreCase(b.getcolor())
					&&!couleur[co].equalsIgnoreCase(c.getcolor()) && !couleur[co].equalsIgnoreCase(d.getcolor()))
			{
				
				couleur1[co1]=couleur[co];
				
				co1++;
			}else{}
		}
		if(rang==0)
		{
			compteur=(int)(Math.random()*4);
		}else{
			if(rang==1)
			{
				
				int x1;
				int y;
				
				for(co=0;co<couleur.length;co++)
				{
					if(!couleur[co].equalsIgnoreCase(a.getcolor())&&!couleur[co].equalsIgnoreCase(b.getcolor())
							&&!couleur[co].equalsIgnoreCase(c.getcolor()) && !couleur[co].equalsIgnoreCase(d.getcolor()))
					{
						System.out.print(couleur[co]+" / ");
					}else{}
				}
				System.out.println();
				
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
				for(i=0;i<comptCouleur.length;i++)
				{
					comptCouleur[i]=0;
				}
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
			if(comptCouleur[i]>comptCouleur[compteur])
			{
				compteur=i;
			}else{}
		}
		
		x.changeCouleur(couleur1[compteur].toUpperCase());
		
		a_copy=a;b_copy=b;c_copy=c;d_copy=d;x_copy=x;
		grille_save=grille;
			System.out.println(x.getname());	
		String Couleur;
		Joueur[] J={a,b,c,d};
		switch(x.getcolor())
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
  		
		switch(x.getcolor())
        {
		        case "R" : b1.setBackground(Color.black);etat[0]=false;break;
		        case "O" : b2.setBackground(Color.black);etat[1]=false; break;
		        case "J" : b3.setBackground(Color.black);etat[2]=false; break;
		        
		        case "B" : b4.setBackground(Color.black);etat[3]=false; break;
		        case "I" : b5.setBackground(Color.black);etat[4]=false; break;
		        case "V" :b6.setBackground(Color.black);etat[5]=false;break;
        }
		nouvelle_col=x.getcolor();
		
		//o=new Fenetre(a, b, c, d,x);
		
		
		//o.Message(x.getname(),x.getcolor());
		for(co=0;co<couleur.length;co++)
		{
			if(!couleur[co].equalsIgnoreCase(a.getcolor())&&!couleur[co].equalsIgnoreCase(b.getcolor())
					&&!couleur[co].equalsIgnoreCase(c.getcolor()) && !couleur[co].equalsIgnoreCase(d.getcolor())
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
		nouvelle_col=x.getcolor();
		
		/*while(((nouvelle_col.equalsIgnoreCase(a.getcolor()) || nouvelle_col.equalsIgnoreCase(b.getcolor()) || nouvelle_col.equalsIgnoreCase(c.getcolor())|| nouvelle_col==null || nouvelle_col.equalsIgnoreCase(d.getcolor())) ))
		{		//couleur1=Fenetre.couleur_string;
				//System.out.println(couleur1);
			nouvelle_col=scan.next();
	}*/
		
		//x.changeCouleur(nouvelle_col.toUpperCase());
		
		while(((nouvelle_col.equalsIgnoreCase(a.getcolor()) || nouvelle_col.equalsIgnoreCase(b.getcolor()) || nouvelle_col.equalsIgnoreCase(c.getcolor())|| nouvelle_col==null || nouvelle_col.equalsIgnoreCase(d.getcolor())) ))
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
		
		
		return x;
	}
	
	public static void winner (Joueur a,Joueur b, Joueur c, Joueur d,int pour)
	{
		if(a.getPourc()>pour)Fenetre.Message(a.getname(),"F");
		else if(b.getPourc()>pour)Fenetre.Message(b.getname(),"F");
		else if(c.getPourc()>pour)Fenetre.Message(c.getname(),"F");
		else if(d.getPourc()>pour)Fenetre.Message(d.getname(),"F");
		
		
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
        b7.addActionListener(new ActionListener( ){     
			
			@Override
			public void actionPerformed(ActionEvent e) {    
				
				
					Fenetre.ecrire(grille_save,a_copy,b_copy,c_copy,d_copy,x_copy );
					System.out.println("Grille sauvée");
					//Cellule [][] g;
					/*Fenetre.lire(grille_save);
					System.out.println(grille_save[0][0].getcolor());
					System.out.println(grille_save[0][0].getPlayerId());
					for(int j=0;j<grille_save.length;j++)
					{
						for(int i=0;i<grille_save.length;i++)
						{
							System.out.print(" | "+grille_save[i][j].getcolor()+" "+grille_save[i][j].getPlayerId()+" | ");
						}
						System.out.println();
					}*/
				
			}      
			}); 
    }
    	
	
	
}
