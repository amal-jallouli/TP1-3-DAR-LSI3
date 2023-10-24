package ClientPackage;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class Client {

    public static void main(String[] args) {
        try {
        	InetAddress adresseip = InetAddress.getLocalHost();  
            String AdresseIP = adresseip.getHostAddress();      //convertir l'adresse ip en chaine de caractère 
	    	// La première étape :
	    	
	    	try (Socket sc=new Socket(AdresseIP,1234)){
	    		
	    		System.out.println("Je suis un client pas encore connecté…");
	        	System.out.println("je suis un client connecté");
	        	
	        	Scanner s=new Scanner(System.in);
	        	DataOutputStream os;
	        	DataInputStream is ;
	        	String str ;
	        	// Lecture et envoi de l'operateur 
				do{
					System.out.print("donner op '+' , '-' , '*' , '/' : ");
					str = s.nextLine();
					
				}while(!(str.equals("+")) && !(str.equals("-")) && !(str.equals("*")) && !(str.equals("/")));
				
				char op = str.charAt(0);
                os= new DataOutputStream(sc.getOutputStream());
                os.writeChar(op);
	        	
                //Lecture de l'entier a saisir
                System.out.print("Taper un entier : ");
                int x=s.nextInt();

                //Envoi de l'entier au serveur
                os= new DataOutputStream(sc.getOutputStream());
                os.writeInt(x);
                
                // Recevoir et afficher le produit envoye par le serveur
                is= new DataInputStream(sc.getInputStream());
                float res = is.readFloat();
                System.out.println("la resultat est : "+res);
                
	        	// La dernière étape : Fermer socket
	        	sc.close();
	        	// Fermer Scanner
	        	s.close();
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    	}
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
