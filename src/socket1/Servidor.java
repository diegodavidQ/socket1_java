package socket1;



import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.net.*;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
		
		}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			//escucha en el puerto 9999 abierto
			ServerSocket servidor = new ServerSocket(9999); 
			
			while(true){
				//acepta cualquier conexion
				Socket misocket = servidor.accept(); 
				//crear un flujo de datos de entrada
				DataInputStream flujo_entrada = new DataInputStream(misocket.getInputStream());
				
				String mensaje_texto = flujo_entrada.readUTF();
				
				areatexto.append("\n"+ mensaje_texto);
				
				misocket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private	JTextArea areatexto;
}



