package java_project;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Save {

	public static void ecrire() throws FileNotFoundException, IOException{
			File file= new File("./fichier.txt");
			if(!file.exists()){
				
				try{
					file.createNewFile();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			try(PrintWriter print = new PrintWriter(new FileOutputStream(file,true))){
				print.print("message");
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	public static void lire() throws FileNotFoundException, IOException{
		File file= new File("./fichier.txt");
		if(!file.exists()){
			
			try{
				file.createNewFile();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		try(FileInputStream fos = new FileInputStream(file)){
			Scanner sc= new Scanner(fos);
			while(sc.hasNextLine()){
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
