package com.codideep.app.object;

import com.codideep.app.generic.ObjectAttribute;
import java.awt.Image;
import java.awt.PopupMenu;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Meteor extends ObjectAttribute {

    public ImageIcon raindropIcon;
    public Random random;
    public ImageIcon imageIconFrontMetteor = null;
 

    public Meteor() {

        this.Compoenetraindrops = new ArrayList<>();
        raindropIcon = new ImageIcon("D:\\java\\CHEAP_GAME_JAVA\\img\\1945907.png");
        raindropIcon = new ImageIcon(raindropIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        Random random = new Random();
        int min = 100;
        int max = 1000;
        int range = (max - min) / 20; // Número de múltiplos de 20 dentro del rango
        int randomNumber = random.nextInt(range + 1) * 20 + min;
        System.out.println("Número Rondón: " + randomNumber);
        JLabel raindrop = new JLabel(raindropIcon);  
        raindrop.setBounds(randomNumber, 0, raindropIcon.getIconWidth(), raindropIcon.getIconHeight());
        Compoenetraindrops.add(raindrop);
/*
        for (int i = 0; i < Compoenetraindrops.size(); i++) {
        JLabel raindropLabel = new JLabel();
        raindropLabel.setBounds(100, 100, 100, 100);
        raindropLabel.setIcon(raindropIcon);
        Compoenetraindrops.add(raindropLabel);
    }
*/
    }
    



}
