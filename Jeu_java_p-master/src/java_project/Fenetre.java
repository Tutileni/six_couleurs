package java_project;
import java.awt.* ;

import java.awt.event.ActionEvent;

import javax.swing.* ;
import  javax.swing.JOptionPane;
import  javax.swing.JOptionPane;
import  javax.swing.JOptionPane;
import java.awt.event.*;
import  javax.swing.JOptionPane;
import  javax.swing.JOptionPane;
import  javax.swing.JOptionPane;
import  javax.swing.JOptionPane;
import  javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.io.File;
public class Fenetre 
{
	private JComponent ui = null;
    private static int cellSize ;
    private static int nbCols ;
    private static int nbRows ;
    public static JPanel menuPanel,buttonPanel_1, buttonPanel_2;
    //public static String joueur,couleur;
    public static JLabel aff,aff1;
    public static JLabel[] JLabelScore=new JLabel[5];
    public static String[] couleur1=new String[4];
    
    private static Color[][] colors ;

    private static JFrame frame ;
    private static CellPanel panel ;
    
    Fenetre(Joueur[] J) {
        initUI(35,19,19,this,J);
    }
    /*Fenetre(Joueur a, Joueur b, Joueur c, Joueur d,Joueur x) {
    	Joueur[] J={a,b,c,d};
    	Fenetre.Label(J);
    	Fenetre.Message(x.getname(), x.getcolor());
    }*/
    
   
    public void initUI(int cellSize , int nbRows , int nbCols,Fenetre o, Joueur[] J) {
    	
    	Fenetre.cellSize = cellSize ;
    	Fenetre.nbCols = nbCols ;
    	Fenetre.nbRows = nbRows ;
    	colors = new Color[ nbRows ][ nbCols ] ;
    	panel = new CellPanel() ;
        
    	
    	for( int i = 0 ; i < nbRows ; i++ )
        {
            for( int j = 0 ; j < nbCols ; j++ )
            {
                colors[j][i] = Color.BLACK ;
            }
        }
    	
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new TitledBorder("GRILLE"));

        JPanel Cell_Grille = new JPanel(new GridLayout());
        Cell_Grille.setBackground(Color.WHITE);
        //Cell_Grille.add(new JLabel(new ImageIcon(new BufferedImage(400, 300, BufferedImage.TYPE_INT_ARGB))));
        ui.add(Cell_Grille );

        menuPanel = new JPanel(new BorderLayout());
        menuPanel.setBorder(new TitledBorder("Menu"));
        
        menuPanel.setSize(1500, 1500);
        
        //Message
        buttonPanel_1 = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel_1.setBorder(new TitledBorder("Tours"));
        

    	aff = new JLabel();
    	aff1 = new JLabel();
    	//aff.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
    	//aff.setOpaque(true);
    	//aff.setBackground(Color.WHITE);
    	aff.setForeground(Color.BLUE);
    	aff.setBounds(800, 340, 240, 40);
    	aff1.setForeground(Color.BLUE);
    	aff1.setBounds(800, 380, 240, 40);
    	
          
    	buttonPanel_1.add(aff);
    	buttonPanel_1.add(aff1);
        menuPanel.add(buttonPanel_1, BorderLayout.PAGE_START);
        //Label
        buttonPanel_2 = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonPanel_2.setBorder(new TitledBorder("Score"));
        
        for(int i=0;i<J.length;i++){
        JLabelScore[i] = new JLabel(J[i].getname()+", Score : "+J[i].getPourcent()+"%");
        buttonPanel_2.add(JLabelScore[i]);}
        Main.button(this);
        
        menuPanel.add(buttonPanel_2, BorderLayout.CENTER);
        
        ui.add(menuPanel, BorderLayout.LINE_END);
       
        
        
        Cell_Grille.add( panel ) ;
    }
    public JComponent getUI() {
        return ui;
    }
    
    public static String[] getDonnees(){
    	
		    String[] leschamps=new String[11];
		    
		    JLabel  Choix1  = new  JLabel("Voulez vous jouer en réseau? O/N");
		    //reponse1
		    JTextField Champ1 = new  JTextField();
		    
		    
		    JLabel  lab = new  JLabel("Entrez  vos les coordonnées ?");
		    Object[] tab = new  Object []{ Choix1  ,  Champ1 ,lab};
		    int rep = JOptionPane.showOptionDialog(null,tab,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
		    
		    if(rep== JOptionPane.OK_OPTION){
		    	
				    if("N".equalsIgnoreCase(Champ1.getText())){
				    	
				    	JLabel  Choix2  = new  JLabel("Voulez vous jouer contre l'ordinateur ? O/N :");
				    	JTextField Champ2 = new  JTextField();
				    	JLabel  lab1 = new  JLabel("Entrez  vos les coordonnées ?");
					    Object[] tab1 = new  Object []{ Choix2  ,  Champ2 ,lab1};
					    int rep1 = JOptionPane.showOptionDialog(null,tab1,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
					    
				    	//reponse2
				    	if(rep1== JOptionPane.OK_OPTION){
				    		
				    	
				    		if("O".equalsIgnoreCase(Champ2.getText())){
				    			
						    			JLabel  Choix3  = new  JLabel("Combien de joueur? 2/3/4?");
								    	JTextField Champ3 = new  JTextField();
								    	JLabel  lab3 = new  JLabel("Entrez  vos les coordonnées ?");
									    Object[] tab3 = new  Object []{ Choix3  ,  Champ3 ,lab3};
									    int rep2 = JOptionPane.showOptionDialog(null,tab3,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
									    
							    		//reponse3
							    		if(rep2==JOptionPane.OK_OPTION){
							    		
							    		JLabel  ChoixOrdi  = new  JLabel("Nombre d'ordinateur joueurs");	
							    		JLabel  Choixdif  = new  JLabel("Quelle difficulté? 0/1/2");
							    		JLabel  Choixtype = new  JLabel("Choisissez le type de jeu. 0 pour un carré et 1 pour un losange :");
			  							
								    	JTextField ChampOrdi = new  JTextField();
								    	JTextField Champdif = new  JTextField();
								    	JTextField Champtype = new  JTextField();
								    	JLabel  l = new  JLabel("Entrez  vos les coordonnées ?");
									    Object[] t = new  Object []{ ChoixOrdi  ,  ChampOrdi ,Choixdif, Champdif, Choixtype,Champtype,l};
									    int ordi_ok = JOptionPane.showOptionDialog(null,t,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
									    	
												if(ordi_ok==JOptionPane.OK_OPTION){
													      String Cas = Champ3.getText () + " | " + ChampOrdi.getText ();
											  			  switch (Cas) {
												  						case "2 | 1": {
												  							
												  							
																    		
												  							
														  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
														  							JLabel  Choix8  = new  JLabel("IA");
														  							JTextField Champ7 = new  JTextField();
														  							JTextField Champ8 = new  JTextField();
														  							
														  							
														  							JLabel  lab4 = new  JLabel("Saisie des noms");
														  						    Object[] tab4 = new  Object []{  Choix7 ,Champ7,Choix8 ,Champ8,lab4};
														  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
														  						    if (rep3 == JOptionPane.OK_OPTION)
														  							  {
														  							  	leschamps[0]=Champ1.getText ();
														  						    	leschamps[1]=Champ2.getText ();
														  						    	leschamps[2]=Champ3.getText ();
														  						    	leschamps[3]=ChampOrdi.getText ();
														  						    	leschamps[4]=Champdif.getText ();
														  						    	leschamps[5]=Champtype.getText ();
														  						    	leschamps[6]=Champ7.getText ();
														  						    	leschamps[7]=Champ8.getText ();
														  						    }
														  						    break;
											  						}
											  						case "3 | 2":{
											  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
											  							JLabel  Choix8  = new  JLabel("IA");
											  							JLabel  Choix9  = new  JLabel("IA");
											  							
											  							JTextField Champ9 = new  JTextField();
											  							JTextField Champ7 = new  JTextField();
											  							JTextField Champ8 = new  JTextField();
											  							
											  							JLabel  lab4 = new  JLabel("Saisie des noms");
											  						    Object[] tab4 = new  Object []{ Choix7 , Champ7,Choix8 , Champ8,Choix9 , Champ9,lab4};	
											  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
											  						    
											  						    if (rep3 == JOptionPane.OK_OPTION)
											  							  {
											  						    	leschamps[0]=Champ1.getText ();
											  						    	leschamps[1]=Champ2.getText ();
											  						    	leschamps[2]=Champ3.getText ();
											  						    	leschamps[3]=ChampOrdi.getText ();
											  						    	leschamps[4]=Champdif.getText ();
											  						    	leschamps[5]=Champtype.getText ();
											  						    	leschamps[6]=Champ7.getText ();
											  						    	leschamps[7]=Champ8.getText ();
											  						    	leschamps[8]=Champ9.getText ();
											  							  }break;
											  						}
											  						case "3 | 1":{
											  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
											  							JLabel  Choix8  = new  JLabel("Nom du Joueur 2");
											  							JLabel  Choix9  = new  JLabel("IA");
											  							
											  							JTextField Champ7 = new  JTextField();
											  							JTextField Champ8 = new  JTextField();
											  							JTextField Champ9 = new  JTextField();
											  							
											  							
											  							JLabel  lab4 = new  JLabel("Saisie des noms");
											  						    Object[] tab4 = new  Object []{ Choix7 , Champ7,Choix8 , Champ8,Choix9 , Champ9,lab4};	
											  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
											  						    
											  						    if (rep3 == JOptionPane.OK_OPTION)
											  							  {
											  						    	leschamps[0]=Champ1.getText ();
											  						    	leschamps[1]=Champ2.getText ();
											  						    	leschamps[2]=Champ3.getText ();
											  						    	leschamps[3]=ChampOrdi.getText ();
											  						    	leschamps[4]=Champdif.getText ();
											  						    	leschamps[5]=Champtype.getText ();
											  						    	leschamps[6]=Champ7.getText ();
											  						    	leschamps[7]=Champ8.getText ();
											  						    	leschamps[8]=Champ9.getText ();
											  						    		
											  							  }break;
											  						}
											  						case "3 | 3":{
											  							JLabel  Choix7  = new  JLabel("IA1");
											  							JLabel  Choix8  = new  JLabel("IA2");
											  							JLabel  Choix9  = new  JLabel("IA3");
											  							JTextField Champ7 = new  JTextField();
											  							JTextField Champ8 = new  JTextField();
											  							JTextField Champ9 = new  JTextField();
											  							
											  							JLabel  lab4 = new  JLabel("Saisie des noms");
											  						    Object[] tab4 = new  Object []{ Choix7 , Champ7,Choix8 , Champ8,Choix9 , Champ9,lab4};	
											  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
											  						    
											  						    if (rep3 == JOptionPane.OK_OPTION)
											  							  {
											  						    	leschamps[0]=Champ1.getText ();
											  						    	leschamps[1]=Champ2.getText ();
											  						    	leschamps[2]=Champ3.getText ();
											  						    	leschamps[3]=ChampOrdi.getText ();
											  						    	leschamps[4]=Champdif.getText ();
											  						    	leschamps[5]=Champtype.getText ();
											  						    	leschamps[6]=Champ7.getText ();
											  						    	leschamps[7]=Champ8.getText ();
											  						    	leschamps[8]=Champ9.getText ();
											  						    		
											  							  }break;
											  						}
											  						case "4 | 3": {
											  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
											  							JLabel  Choix8  = new  JLabel("IA1");
											  							JLabel  Choix9  = new  JLabel("IA2");
											  							JLabel  Choix10  = new  JLabel("IA3");
											  							JTextField Champ7 = new  JTextField();
											  							JTextField Champ8 = new  JTextField();
											  							JTextField Champ9 = new  JTextField();
											  							JTextField Champ10 = new  JTextField();
											  							
											  							JLabel  lab4 = new  JLabel("Saisie des noms");
											  						    Object[] tab4 = new  Object []{ Choix7  ,  Champ7 , Choix8 , Champ8,Choix9 , Champ9,Choix10 , Champ10,lab4};
											  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  des données",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
											  						    
											  						    if (rep3 == JOptionPane.OK_OPTION)
											  							  {
											  						    	leschamps[0]=Champ1.getText ();
											  						    	leschamps[1]=Champ2.getText ();
											  						    	leschamps[2]=Champ3.getText ();
											  						    	leschamps[3]=ChampOrdi.getText ();
											  						    	leschamps[4]=Champdif.getText ();
											  						    	leschamps[5]=Champtype.getText ();
											  						    	leschamps[6]=Champ7.getText ();
											  						    	leschamps[7]=Champ8.getText ();
											  						    	leschamps[8]=Champ9.getText ();
											  						    	leschamps[9]=Champ10.getText ();
											  						    	
											  							  }break;
											  						}
											  						case "4 | 1": {
											  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
											  							JLabel  Choix8  = new  JLabel("Nom du Joueur 2");
											  							JLabel  Choix9  = new  JLabel("Nom du Joueur 3");
											  							JLabel  Choix10  = new  JLabel("IA");
											  							JTextField Champ7 = new  JTextField();
											  							JTextField Champ8 = new  JTextField();
											  							JTextField Champ9 = new  JTextField();
											  							JTextField Champ10 = new  JTextField();
											  							
											  							JLabel  lab4 = new  JLabel("Saisie des noms");
											  						    Object[] tab4 = new  Object []{  Choix7  ,  Champ7 , Choix8 , Champ8,Choix9 , Champ9,Choix10 , Champ10,lab4};
											  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  des données",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
											  						    
											  						    if (rep3 == JOptionPane.OK_OPTION)
											  							  {
											  						    	leschamps[0]=Champ1.getText ();
											  						    	leschamps[1]=Champ2.getText ();
											  						    	leschamps[2]=Champ3.getText ();
											  						    	leschamps[3]=ChampOrdi.getText ();
											  						    	leschamps[4]=Champdif.getText ();
											  						    	leschamps[5]=Champtype.getText ();
											  						    	leschamps[6]=Champ7.getText ();
											  						    	leschamps[7]=Champ8.getText ();
											  						    	leschamps[8]=Champ9.getText ();
											  						    	leschamps[9]=Champ10.getText ();
											  						    	
											  							  }break;
											  						}
											  						case "4 | 2": {
											  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
											  							JLabel  Choix8  = new  JLabel("Nom du Joueur 2");
											  							JLabel  Choix9  = new  JLabel("IA1");
											  							JLabel  Choix10  = new  JLabel("IA2");
											  							JTextField Champ7 = new  JTextField();
											  							JTextField Champ8 = new  JTextField();
											  							JTextField Champ9 = new  JTextField();
											  							JTextField Champ10 = new  JTextField();
											  							
											  							JLabel  lab4 = new  JLabel("Saisie des noms");
											  							 Object[] tab4 = new  Object []{  Choix7  ,  Champ7 , Choix8 , Champ8,Choix9 , Champ9,Choix10 , Champ10,lab4};
												  						 int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  des données",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
												  						    
											  						    if (rep3 == JOptionPane.OK_OPTION)
											  							  {
											  						    	leschamps[0]=Champ1.getText ();
											  						    	leschamps[1]=Champ2.getText ();
											  						    	leschamps[2]=Champ3.getText ();
											  						    	leschamps[3]=ChampOrdi.getText ();
											  						    	leschamps[4]=Champdif.getText ();
											  						    	leschamps[5]=Champtype.getText ();
											  						    	leschamps[6]=Champ7.getText ();
											  						    	leschamps[7]=Champ8.getText ();
											  						    	leschamps[8]=Champ9.getText ();
											  						    	leschamps[9]=Champ10.getText ();
											  						    	
											  						    	
											  							  }break;
											  						}
											  						
											  						default: {
											  						    System.out.println("Erreur de saisie");
											  						}
											  			    }}
											  			  
												}}
				    		else{
					    		
			  					
								JLabel  Choix3  = new  JLabel("Combien de joueur? 2/3/4?");
						    	JTextField Champ3 = new  JTextField();
						    	JLabel  Choixtype = new  JLabel("Choisissez le type de jeu. 0 pour un carré et 1 pour un losange :");
						    	JTextField Champtype = new  JTextField();
						    	JLabel  lab8 = new  JLabel("Entrez  vos les coordonnées ?");
							    Object[] tab8 = new  Object []{ Choix3  ,  Champ3 ,Choixtype  ,  Champtype, lab8};
							    int rep8 = JOptionPane.showOptionDialog(null,tab8,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
							    
											if (rep8== JOptionPane.OK_OPTION){
												
												
											  switch (Champ3.getText ()) {
														case "2": {

								  							JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
								  							JLabel  Choix8  = new  JLabel("Nom du Joueur 2");
								  							JTextField Champ7 = new  JTextField();
								  							JTextField Champ8 = new  JTextField();
								  							
								  							
								  							JLabel  lab4 = new  JLabel("Saisie des noms");
								  						    Object[] tab4 = new  Object []{  Choix7 ,Champ7,Choix8 ,Champ8,lab4};
								  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
								  						    if (rep3 == JOptionPane.OK_OPTION)
								  							  {
								  							  	leschamps[0]=Champ1.getText ();
								  						    	leschamps[1]=Champ2.getText ();
								  						    	leschamps[2]=Champ3.getText ();
								  						    	
								  						    	leschamps[5]=Champtype.getText ();
								  						    	leschamps[6]=Champ7.getText ();
								  						    	leschamps[7]=Champ8.getText ();
								  						    }
														    break;
														}
														case "3":{
															JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
								  							JLabel  Choix8  = new  JLabel("Nom du Joueur 2");
								  							JLabel  Choix9  = new  JLabel("Nom du Joueur 3");
								  							
								  							JTextField Champ9 = new  JTextField();
								  							JTextField Champ7 = new  JTextField();
								  							JTextField Champ8 = new  JTextField();
								  							
								  							JLabel  lab4 = new  JLabel("Saisie des noms");
								  						    Object[] tab4 = new  Object []{ Choix7 , Champ7,Choix8 , Champ8,Choix9 , Champ9,lab4};	
								  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
								  						    
								  						    if (rep3 == JOptionPane.OK_OPTION)
								  							  {
								  						    	leschamps[0]=Champ1.getText ();
								  						    	leschamps[1]=Champ2.getText ();
								  						    	leschamps[2]=Champ3.getText ();
								  						    	
								  						    	leschamps[5]=Champtype.getText ();
								  						    	leschamps[6]=Champ7.getText ();
								  						    	
								  						    	leschamps[7]=Champ8.getText ();
								  						    	leschamps[8]=Champ9.getText ();
								  							  }break;
														}
														case "4": {
															JLabel  Choix7  = new  JLabel("Nom du Joueur 1");
								  							JLabel  Choix8  = new  JLabel("Nom du Joueur 2");
								  							JLabel  Choix9  = new  JLabel("Nom du Joueur 3");
								  							JLabel  Choix10  = new  JLabel("Nom du Joueur 3");
								  							JTextField Champ7 = new  JTextField();
								  							JTextField Champ8 = new  JTextField();
								  							JTextField Champ9 = new  JTextField();
								  							JTextField Champ10 = new  JTextField();
								  							
								  							JLabel  lab4 = new  JLabel("Saisie des noms");
								  						    Object[] tab4 = new  Object []{  Choix7  ,  Champ7 , Choix8 , Champ8,Choix9 , Champ9,Choix10 , Champ10,lab4};
								  						    int rep3 = JOptionPane.showOptionDialog(null,tab4,"Saisie  des données",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
								  						    
								  						    if (rep3 == JOptionPane.OK_OPTION)
								  							  {
								  						    	leschamps[0]=Champ1.getText ();
								  						    	leschamps[1]=Champ2.getText ();
								  						    	leschamps[2]=Champ3.getText ();
								  						    	
								  						    	leschamps[5]=Champtype.getText ();
								  						    	leschamps[6]=Champ7.getText ();
								  						    	leschamps[7]=Champ8.getText ();
								  						    	leschamps[8]=Champ9.getText ();
								  						    	leschamps[9]=Champ10.getText ();
								  						    	
								  						    	
								  							  }break;
														}
														
														default: {
														    System.out.println("Erreur de saisie");
														}
											    }}}
				}}}
		    	else{
				    	
				    	 	JLabel  Choix8  = new  JLabel("Êtes vous l'host?O/N");
				    	 
					    	JTextField Champ8 = new  JTextField();
					    	
						    Object[] tab8 = new  Object []{ Choix8  ,  Champ8};
						    int rep8 = JOptionPane.showOptionDialog(null,tab8,"Saisie  desdonnées",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
						    
							if (rep8== JOptionPane.OK_OPTION){
						    	 if("O".equalsIgnoreCase(Champ8.getText()))
						    	 {
						    		 JLabel  Choix9  = new  JLabel("Voulez vous jouer avec le brouillard? 0/1");
						    		 JTextField Champ9 = new  JTextField();
						    		 
									    Object[] tab9 = new  Object []{ Choix9  ,  Champ9 };
									    int rep4 = JOptionPane.showOptionDialog(null,tab9,"Saisie  des données",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
									    if (rep4== JOptionPane.OK_OPTION){
								    		 leschamps[7]=Champ8.getText ();
								    		 leschamps[8]=Champ9.getText ();
								    	}
						    	 }
						    	 else{
						    		 JLabel  Choix9  = new  JLabel("Voulez vous jouer avec le brouillard? 0/1");
						    		 JTextField Champ9 = new  JTextField();
						    		 
									    Object[] tab9 = new  Object []{ Choix9  ,  Champ9 };
									    int rep9 = JOptionPane.showOptionDialog(null,tab9,"Saisie  des données",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE ,null ,null ,null);
									    if (rep9== JOptionPane.OK_OPTION){
								    		 leschamps[7]=Champ8.getText ();
								    		 leschamps[8]=Champ9.getText ();
								    	}
						    	 }
						   }
				    }
		    
		   return leschamps;
    }
   
    public static void Label(Joueur[] J){
    	for(int i=0;i<J.length;i++)Fenetre.JLabelScore[i].setText(J[i].getname()+", Score : "+J[i].getPourcent()+"%");
    }
   
    public static void Message(String joueur, String couleur)
    {
    	if(couleur!="F"){
    	switch(couleur)
        {
                case "R" : couleur="Rouge"; break;
                case "O" :couleur="Orange"; break;
                case "J" : couleur="Jaune"; break;
                
                case "B" : couleur="Blue"; break;
                case "I" : couleur="Gris"; break;
                case "V" : couleur="Vert"; break;
        }
    	Fenetre.aff.setText("Au tour du joueur "+joueur);
    	Fenetre.aff1.setText(joueur+" possède la couleur"+" "+couleur+". Quelle couleur choisissez vous ?");
    	}else{
    	
		
    	Fenetre.aff.setText("La partie est finie, le joueur "+joueur+" a gagné");
    	Fenetre.aff1.setText("Felicitation à "+joueur);
    	}
    }
    
    public static void print(int taille, Cellule [][] grille)
    {
		
			for(int i=0;i<taille;i++)
			{
				for(int j=0;j<taille;j++)
				{
					String  var= grille[j][i].getColor();
					
					 
		                switch(var)
		                {
		                        case "R" : setCellColor(i,j,Color.red); break;
		                        case "O" :setCellColor(i,j,Color.orange); break;
		                        case "J" : setCellColor(i,j,Color.yellow); break;
		                        
		                        case "B" : setCellColor(i,j,Color.blue); break;
		                        case "I" : setCellColor(i,j,Color.gray); break;
		                        default : setCellColor(i,j,Color.green);
		                }
					//F.setCellColor(i,j,Color.var);
				}
			}
    }	
    public static void setCellColor( int r , int c , Color newColor ) 
    {
        if( r < -nbRows || r > 2*nbRows ) throw new RuntimeException( "r = " + r ) ;
        if( c < -nbCols || c > 2*nbCols ) throw new RuntimeException( "c = " + c ) ;

        r = ( r + nbRows ) % nbRows ;
        c = ( c + nbCols ) % nbCols ;
        
        Color prevColor = colors[r][c] ;
        colors[r][c] = newColor ;
        if( !prevColor.equals( newColor ) )
        {
        	
            panel.drawCell( r , c ) ;
            //panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
        }
    }
    
    public static Color getCellColor( int r , int c ) 
    {
        if( r < -nbRows || r > 2*nbRows ) throw new RuntimeException( "r = " + r ) ;
        if( c < -nbCols || c > 2*nbCols ) throw new RuntimeException( "c = " + c ) ;

        r = ( r + nbRows ) % nbRows ;
        c = ( c + nbCols ) % nbCols ;
        
        return colors[r][c] ;
    }
    
    public static void pause( double seconds ) 
    {
        try
        {
            Thread.sleep( (int)( seconds * 1000 ) ) ;
        }
        catch( Exception e ) {} 
    }

    public static void stop()
    {
        frame.dispose();
    }
    
    private static class CellPanel extends JPanel
    {
    	
    	    
        void drawCell( int r , int c )
        {
            Graphics g = getGraphics() ;

            g.setColor( colors[ r ][ c ] );

            g.fillRect( c * cellSize , r * cellSize ,
                        cellSize , cellSize );
        }

        public void paintComponent( Graphics g )
        {
            if( colors == null )
                return ;

            g.setColor( Color.BLACK ) ;
            g.fillRect( 0 , 0 , nbCols * cellSize , nbRows * cellSize ) ;

            int x = 0 ;
            int y = 0 ;
            
            for( int r = 0 ; r < nbRows ; r++ )
            {
                for( int c = 0 ; c < nbCols ; c++ )
                {
                    if( !colors[r][c].equals( Color.BLACK ) ) 
                    {
                        g.setColor( colors[r][c] ) ;
                        g.fillRect( x , y , cellSize , cellSize ) ;
                    }
                    x += cellSize ;
                }
                y += cellSize;
                x = 0;
            }
        }
    } 
    

		
public static void ecrire(Cellule [][] grille,Joueur a, Joueur b, Joueur c, Joueur d,Joueur x){
		File file= new File("../Jeu_java_p/src/java_project/fic1.txt");
		File file2= new File("../Jeu_java_p/src/java_project/fic2.txt");
		File file3= new File("../Jeu_java_p/src/java_project/fic3.txt");
		if(!file.exists() && !file2.exists() && !file3.exists()){
			
			try{
				file.createNewFile();
				file2.createNewFile();
				file3.createNewFile();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		try(PrintWriter print = new PrintWriter(new FileOutputStream(file))){
			for(int j=0;j<grille.length;j++)
			{	//print.print("|");
				for(int i=0;i<grille.length;i++)
				{
					print.println(grille[i][j].getColor());
					
				}//print.println("|");
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(PrintWriter print2 = new PrintWriter(new FileOutputStream(file2))){
			for(int j=0;j<grille.length;j++)
			{	//print.print("|");
				for(int i=0;i<grille.length;i++)
				{
					print2.println(grille[i][j].getPlayerId());
					
				}//print.println("|");
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		try(PrintWriter print3 = new PrintWriter(new FileOutputStream(file3))){
			print3.println(a.toString());
			print3.println(b.toString());
			print3.println(c.toString());
			print3.println(d.toString());
			print3.println(x.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
}
public static Cellule [][] lire(Cellule [][] grille){
	File file= new File("../Jeu_java_p/src/java_project/fic1.txt");
	File file2= new File("../Jeu_java_p/src/java_project/fic2.txt");
	File file3= new File("../Jeu_java_p/src/java_project/fic3.txt");
	//Cellule [][] grille= Grille.initGrille(19);
	
	if(!file.exists() && !file2.exists() && !file3.exists()){
		
		try{
			file.createNewFile();
			file2.createNewFile();
			file3.createNewFile();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	try(FileInputStream fos = new FileInputStream(file)){
		
		Scanner sc= new Scanner(fos);
		while(sc.hasNextLine()){
			
			for(int j=0;j<grille.length;j++)
			{	
				for(int i=0;i<grille.length;i++)
				{	grille[i][j].changeCouleur(String.valueOf(sc.nextLine()));
					
				}
				
			}
			
		}sc.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	
	
	try(FileInputStream fos2 = new FileInputStream(file2)){
		
		Scanner sc= new Scanner(fos2);
		while(sc.hasNextLine()){
			
			for(int j=0;j<grille.length;j++)
			{	
				for(int i=0;i<grille.length;i++)
				{	
					grille[i][j].changeId(Integer.parseInt(String.valueOf(sc.nextLine())));
				
				}
				
			}
			
		}sc.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	
	try(FileInputStream fos3 = new FileInputStream(file3)){
		int i=0;
		Scanner sc= new Scanner(fos3);
		while(sc.hasNextLine()){
			
					String[] split=String.valueOf(sc.nextLine()).split(" ");
					
					
						switch(split[0])
				        {	
				                case "1" : 
				                	if(i==0){
				                		 Main.a.changPourcent(Double.parseDouble(split[3]));
										 Main.a.changeCouleur(split[1]);
				                		//Main.a=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));i++;
				                		}
				                	else{
				                		 Main.x.changPourcent(Double.parseDouble(split[3]));
										 Main.x.changeCouleur(split[1]);	
				                		//Main.x=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));
				                		}
				                break;
				                case "2" : 
				                	if(i==0){
				                		 Main.b.changPourcent(Double.parseDouble(split[3]));
										 Main.b.changeCouleur(split[1]);
				                		 //Main.b=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));i++;
										 }
			                		else{
			                			 Main.x.changPourcent(Double.parseDouble(split[3]));
										 Main.x.changeCouleur(split[1]);
			                			//Main.x=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));
			                			} 
				                break;
				                case "3" : 
				                	if(i==0){
				                		 Main.c.changPourcent(Double.parseDouble(split[3]));
										 Main.c.changeCouleur(split[1]);
				                		//Main.c=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));i++;
				                		}
			                		else{
			                			 Main.x.changPourcent(Double.parseDouble(split[3]));
										 Main.x.changeCouleur(split[1]);	
			                			//Main.x=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));
			                			} 
					                break;
				                case "4" : 
				                	if(i==0){
				                		 Main.d.changPourcent(Double.parseDouble(split[3]));
										 Main.d.changeCouleur(split[1]);
				                		//Main.d=new Joueur(Integer.parseInt(split[0]),split[1],split[2],Double.parseDouble(split[3]));i++;
				                		}
			                		else{
			                			 Main.x.changPourcent(Double.parseDouble(split[3]));
										 Main.x.changeCouleur(split[1]);
			                				//new Joueur(Integer.parseInt(split[0]),split[1],split[2],;
			                		} 
					                break;
				        }
					
				
			
		}sc.close();
	}catch(IOException e){
		e.printStackTrace();
	}
	
	
	return grille;
}
    	
    
    		
    
    
    	
    	
}







