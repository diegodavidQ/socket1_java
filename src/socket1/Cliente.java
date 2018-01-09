package socket1;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
	
		JLabel texto=new JLabel("CLIENTE");
		
		add(texto);
	
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		EnviaTexto mievento = new EnviaTexto();
		miboton.addActionListener(mievento);
		add(miboton);	
		
	}
	
	
private class EnviaTexto implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(campo1.getText());
		
		//crear el socket
		try {
			Socket misocket = new Socket("192.168.0.107",9999);
			
			//flujo de datos de salida
			DataOutputStream flujo_salida = new DataOutputStream(misocket.getOutputStream());
			
			flujo_salida.writeUTF(campo1.getText());
			
			flujo_salida.close();
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
		
		
		
	private JTextField campo1;
	
	private JButton miboton;
	
}