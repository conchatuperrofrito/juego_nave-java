/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codideep.app.process;

import com.codideep.app.object.Ship;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KAAF0
 */
public class ShipProcess extends Thread {

    Ship ship = null;

    public ShipProcess() {
    }

    public ShipProcess(Ship ship) {
        this.ship = ship;
    }

    @Override
    public void run() {
        while (true) {
            switch (Ship.move) {
                case "static":
                    break;

                case "left":
                    ship.moveLeft();

                    break;

                case "right":
                    ship.moveRight();

                    break;
            }

            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(ShipProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
