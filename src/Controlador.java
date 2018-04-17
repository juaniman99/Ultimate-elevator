//	Project By Juan Torres Gómez

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Controlador {

	private Modelo mod = new Modelo();
	
	public void Ir(int planta) {
		if(planta != mod.plantaActual) {
			mod.plantaToGo = planta;
			Ascensor.lblStatusDoor.setText("Puerta cerrada");
			Ascensor.panelFooter.setBackground(Color.ORANGE);
			timer.start();
		}
	}
	
	Timer timer = new Timer (50, new ActionListener () {
			
			
			public void actionPerformed(ActionEvent e)
			{
				if(mod.isSubiendo()) {	//Si est� subiendo, va moviendo el texto hacia ABAJO  y comprueba cuando sobrepasa la parte INFERIOR.					
					Desplazar(mod.velocidad, mod.velocidadCabin);	//Desplaza los elementos
					Comprobar(1);				
					
					if(mod.calcularDistancia() == 0 && Ascensor.label.getBounds().y >= 0) {	//Comprueba si la posición es la inicial (0) y ya está en esa misma planta.
						Done();
					}				
					
				}else {		//Si est� bajando, va moviendo el texto hacia arriba  y comprueba cuando sobrepasa la parte superior.
					////////////////////////////	Hace prácticamente lo mismo que lo anterior, pero en sentido inverso.	////////////////////////				
					Desplazar(-mod.velocidad, -mod.velocidadCabin);							
					Comprobar(0);
					
					if(mod.calcularDistancia() == 0 && Ascensor.label.getBounds().y  <= 0) {
						Done();
					}
				}				
				//System.out.println(Ascensor.label.getBounds().y + ", " + (Ascensor.panel.getBounds().y + Ascensor.panel.getBounds().height + ", " + mod.plantaMostrando + ", " + mod.calcularDistancia()));				
			}
	});
	
	private void Desplazar(int vel1, int vel2) {
		Ascensor.label.setBounds(Ascensor.label.getBounds().x, Ascensor.label.getBounds().y + vel1, Ascensor.label.getBounds().width, Ascensor.label.getBounds().height);			//Desplaza el texto de la planta hacia abajo.
		Ascensor.imgCabin.setBounds(Ascensor.imgCabin.getBounds().x, Ascensor.imgCabin.getBounds().y - vel2, Ascensor.imgCabin.getBounds().width, Ascensor.imgCabin.getBounds().height);		//Desplaza el icono de la cabina hacia arriba.	
		
		if(vel1 > 0)
			Ascensor.lblStatusMovement.setText("Subiendo...");
		else
			Ascensor.lblStatusMovement.setText("Bajando...");
	}
	private void Comprobar(int dir) {	//0 = arriba; 1 = abajo. Se encarga de comprobar cuando el texto ha sobrepasado el limite inferior o superior.
		if(dir == 1) {
			if(Ascensor.label.getBounds().y + mod.offset >=Ascensor.panel.getBounds().height + Ascensor.panel.getBounds().y) {	//Comprueba si ha sobrepasado los limites inferiores.
				Ascensor.label.setBounds(Ascensor.label.getBounds().x, Ascensor.panel.getBounds().y - Ascensor.label.getBounds().height, Ascensor.label.getBounds().width, Ascensor.label.getBounds().height);	//Si es así, mueve el texto arriba del todo.
				Ascensor.label.setText((Integer.parseInt(Ascensor.label.getText()) + 1) + "");		//Suma la planta actual.
				mod.plantaMostrando++;
			}			
		}
		if(dir == 0) {
			if(Ascensor.label.getBounds().y + Ascensor.label.getBounds().height<= Ascensor.panel.getBounds().y) {
				//System.out.println("tpp");
				Ascensor.label.setBounds(Ascensor.label.getBounds().x, Ascensor.panel.getBounds().y + Ascensor.label.getBounds().height-mod.offset, Ascensor.label.getBounds().width, Ascensor.label.getBounds().height);
				Ascensor.label.setText((Integer.parseInt(Ascensor.label.getText()) - 1) + "");
				mod.plantaMostrando--;
			}	
		}
	}
	
	private void Done() {	//Cuando se ha llegado al destino, detiene el Timer y resetea los decorativos.
		mod.plantaActual = mod.plantaMostrando;
		timer.stop();
		Ascensor.panelFooter.setBackground(new Color(51, 153, 0));
		Ascensor.lblStatusMovement.setText("En planta");
		Ascensor.lblStatusDoor.setText("Puerta abierta");
	}
}
