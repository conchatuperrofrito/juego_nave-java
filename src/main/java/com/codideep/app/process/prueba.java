/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.process;

import com.codideep.app.object.Ship;
import com.codideep.app.view.FrmGeneral;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class prueba  {

    private List<JLabel> raindrops;
    private ImageIcon raindropIcon;
    private Random random;
    FrmGeneral frmGeneral = new FrmGeneral();

    public prueba() {

        //   FrmGeneral frmGeneral = new FrmGeneral();
        // Configurar propiedades de la ventana
        frmGeneral.setTitle("STIFLER MASTERrrrrrr");
        frmGeneral.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //  frmGeneral.setVisible(true);

        // Inicializar la lista de JLabels para las gotas de lluvia
        raindrops = new ArrayList<>();

        // Cargar la imagen de la gota de lluvia
        raindropIcon = new ImageIcon("D:\\java\\CHEAP_GAME_JAVA\\img\\1945907.png");

        // ImageIcon imagenIcono = new ImageIcon("D:\\java\\CHEAP_GAME_JAVA\\img\\1945907.png");
        Image imagen = raindropIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        raindropIcon.setImage(imagen);
        //  JLabel etiqueta = new JLabel(imagenIcono);

        // Crear un generador de números aleatorios
        random = new Random();

        // Iniciar el efecto de lluvia
        startRainEffect();
        Ship ship = new Ship();

        frmGeneral.add(ship.component).repaint();
        //  frmGeneral.repaint();
        new ShipProcess(ship).start();

        // Mostrar la ventana
        frmGeneral.setVisible(true);
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
        //   FrmGeneral frmGeneral = new FrmGeneral();

        // Establecer la posición inicial de la gota de lluvia en la parte superior de la ventana y una posición horizontal aleatoria
        int x = random.nextInt(frmGeneral.getWidth());
        raindrop.setBounds(x, 0, raindropIcon.getIconWidth(), raindropIcon.getIconHeight());

        // Agregar la gota de lluvia al JFrame
        frmGeneral.add(raindrop);
        raindrops.add(raindrop);

        // Iniciar un hilo para controlar la caída de la gota de lluvia
        new Thread(() -> {
            while (raindrop.getY() < frmGeneral.getHeight()) {
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
        frmGeneral.remove(raindrop);
        raindrops.remove(raindrop);
        frmGeneral.repaint();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
