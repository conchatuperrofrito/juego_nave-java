/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.process;

import com.codideep.app.object.Meteor;
import com.codideep.app.object.Ship;
import com.codideep.app.view.FrmGeneral;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author stifler
 */
public class ProcessMeteoro  extends JFrame  {

    private List<JLabel> raindrops;
    private ImageIcon raindropIcon;
    private Random random;
    
  public ProcessMeteoro() {
        // Configurar propiedades de la ventana
        Meteor meteoro = new Meteor();
       raindropIcon= meteoro.raindropIcon;
        List<JLabel> raindrops = new ArrayList<>();
        raindrops =meteoro.Compoenetraindrops;
        // Crear un generador de números aleatorios
        random = new Random();

        // Iniciar el efecto de lluvia
        startRainEffect();

        // Mostrar la ventana
      //  setVisible(true);
    }

    private void startRainEffect() {
        // Crear un temporizador para controlar la velocidad de caída de las gotas de lluvia
        int intervaloCaida = 50; // Intervalo en milisegundos entre cada caída de gota de lluvia
        new Thread(() -> {
            while (true) {
                createRaindrop();
                sleep(intervaloCaida);
            }
        }).start();
    }

    private void createRaindrop() {
        // Crear un nuevo JLabel con la imagen de la gota de lluvia
            JLabel raindrop = new JLabel(raindropIcon);
            
                    FrmGeneral frmGeneral = new FrmGeneral();


        // Establecer la posición inicial de la gota de lluvia en la parte superior de la ventana y una posición horizontal aleatoria
        int x = random.nextInt(getWidth());
        raindrop.setBounds(x, 0, raindropIcon.getIconWidth(), raindropIcon.getIconHeight());

        // Agregar la gota de lluvia al JFrame
        frmGeneral.add(raindrop);
        raindrops.add(raindrop);

        // Iniciar un hilo para controlar la caída de la gota de lluvia
        new Thread(() -> {
            while (raindrop.getY() < getHeight()) {
                // Mover la gota de lluvia hacia abajo
                int y = raindrop.getY() + 1;
                raindrop.setLocation(raindrop.getX(), y);
                sleep(10); // Intervalo de movimiento de la gota de lluvia (ajusta según tu preferencia)
            }

            // Eliminar la gota de lluvia del JFrame cuando llegue al fondo
            removeRaindrop(raindrop);
        }).start();
    }

    private void removeRaindrop(JLabel raindrop) {
        remove(raindrop);
        raindrops.remove(raindrop);
        repaint();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

 
 
}
