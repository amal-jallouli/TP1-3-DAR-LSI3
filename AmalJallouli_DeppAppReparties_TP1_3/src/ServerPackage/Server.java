package ServerPackage;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class Server {


    public static void main(String[] args) {
    	// La première étape :
    	
    	try (ServerSocket ss=new ServerSocket(1234)){
    		
    		System.out.println("Je suis un serveur en attente la connexion d'un client ");
        	// La deuxième étape :
    		while(true)
    		{
	    		Socket s = ss.accept();
	        	System.out.println("un client est connecté");
	        	
	        	DataInputStream is ;
	        	DataOutputStream os ;
	        	
	        	//le serveur recoit l'operateur envoyee par le client
	        	is = new DataInputStream(s.getInputStream());
	        	char op = is.readChar();
	        	
	        	//le serveur recoit l'entier envoye par le client
	        	is = new DataInputStream(s.getInputStream());
	            int nb = is.readInt();

	        	// Le serveur calcule le resultat
	            float res=0;
	        	switch(op)
	        	{
	        		case ('+'):res=nb+5;break;
	        		case ('-'):res=nb-5;break;
	        		case ('*'):res=nb*5;break;
		        	case ('/'):res=((float)nb)/5;break;
	        	}
	        	
	        	// Renvoyer au client le resultat apres le calcul
	        	os= new DataOutputStream(s.getOutputStream());
	            os.writeFloat(res);
	            
	        	//  Fermer socket
	        	s.close();
	        	
    		
    		}
    	}
    		
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
