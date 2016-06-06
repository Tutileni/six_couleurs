package java_project;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static Joueur[] client()
			 throws IOException, ClassNotFoundException {
		Cellule [][] grille=null;
		
		Joueur [] stockJoueur= new Joueur [4];
		
		Joueur a = new Joueur(1,null);
		
		Joueur b = new Joueur (2,null);
				
		Joueur c = new Joueur(3, null);
		
		Joueur d = new Joueur(4, null);
		int taille;
		int regle=0;
		int pour=50;
		Socket socket=null;
		
		/*long debut= System.currentTimeMillis();
		long intervalle=0;
		long actuelTime=System.currentTimeMillis();
		
			while(!socket.isConnected()&&intervalle<60000)
			{
				socket = new Socket("localhost",9520);	
				actuelTime=System.currentTimeMillis();
				intervalle=actuelTime-debut;
			}*/
		try{
			socket = new Socket("192.168.1.14",9530);
			System.out.println("Demande de connexion");
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			
		    ObjectInputStream in = new ObjectInputStream (socket.getInputStream());
		    regle = (int) in.readInt();
		    
		    while(a.getPourc()<pour&&b.getPourc()<pour)
		    {
		    	if(a.getPourc()<pour&&b.getPourc()<pour)
			    { 
			    	grille=(Cellule [][]) in.readObject();
					
			    	 
				   
					a=(Joueur) in.readObject();
					
				 
				   b=(Joueur) in.readObject();
					
				    
				   c=(Joueur) in.readObject();
					
				    
				   d=(Joueur) in.readObject();
			    }else{}
				
			 
			    
			    if(a.getPourc()<pour&&b.getPourc()<pour)
			    {
			    	if(regle==0)
			    	{
			    		Grille.affConsole(grille, 0);
			    	}else{
			    		Grille.brouillard(grille, b);
			    	}
			    	b=Main.changCoulJ(a, b, c, d, b);
			    	 Main.pourcentage(a,grille);
			    	System.out.println("En attente du joueur "+a.getid());
			    }else{}
			    Main.pourcentage(a,grille);
				Main.pourcentage(b,grille);
			   
			    
			    out.writeObject(b);
			    out.flush();  
			    out.reset();
			    
		    }
		    stockJoueur[0]=a;
		    stockJoueur[1]=b;
		    stockJoueur[2]=c;
		    stockJoueur[3]=d;
		    
		   
		    in.close();
	        out.close();
		}
		catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		socket.close();
		return stockJoueur;
	}
}
