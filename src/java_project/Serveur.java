package java_project;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
	public static Joueur [] serveur(Cellule  [][]grille,Joueur a,Joueur b,Joueur c,Joueur d,int type,int regle)  throws IOException, ClassNotFoundException {	
		
		Joueur [] stockJoueur= new Joueur [4];
		ServerSocket ss = new ServerSocket(9530);
		System.out.println("En attente de connexion");
		int pour=50;
		
		Socket s = ss.accept();

		
		
		System.out.println("Le serveur a accepté la connexion de "+s);
		
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		out.flush();
		ObjectInputStream in = new ObjectInputStream(s.getInputStream());
		
		out.writeInt(regle);
		out.flush();
		while(a.getPourc()<pour&&b.getPourc()<pour)
		{
			out.flush();
			grille=Grille.changCoulG(grille, a, b, c, d);
			if(regle==0)
			{
				Grille.affConsole(grille, 0);
			}else{
				Grille.brouillard(grille, a);
			}
			
			a=Main.changCoulJ(a, b, c, d, a);
			grille=Grille.changCoulG(grille, a, b, c, d);
			
			
			
			
			
			
			out.writeObject(grille);
			out.flush();
			
			out.writeObject(a);
			out.flush();
			
			out.writeObject(b);
			out.flush();
			
			out.writeObject(c);
			out.flush();
			
			out.writeObject(d);
			out.flush();
			
			/*System.out.println("Information émises");
			
			System.out.println("Réception de b");*/
			System.out.println("En attente du joueur "+b.getid());
			b=(Joueur) in.readObject();
			Main.pourcentage(a,grille);
			Main.pourcentage(b,grille);
			
			out.reset();
		}
		
		in.close();
        out.close();
        ss.close();
		
        stockJoueur[0]=a;
	    stockJoueur[1]=b;
	    stockJoueur[2]=c;
	    stockJoueur[3]=d;
	    
		return stockJoueur;
	}
}
