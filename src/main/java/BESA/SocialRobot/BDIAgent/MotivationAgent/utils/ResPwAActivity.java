package BESA.SocialRobot.BDIAgent.MotivationAgent.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mafegarces
 */
public enum ResPwAActivity {
    MUSICOTERAPIA("Entretenimiento"),
    MEMORAMA("Entretenimiento"),
    CUENTERIA("Entretenimiento"),
    EJERCICIO("Entretenimiento");
    private ResPwAActivity(String s){
        tipo=s;
    }
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
