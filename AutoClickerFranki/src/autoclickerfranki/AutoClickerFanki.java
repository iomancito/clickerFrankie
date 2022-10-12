/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclickerfranki;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ioman
 */
public class AutoClickerFanki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long tiempoInicio = 0;
        Clicker c = new Clicker();
        Thread t = null;
        boolean bucle = true;
        Scanner sc = new Scanner(System.in);
        help();
        
        while(bucle){
            String cmd = pideComando(sc).toLowerCase();
            if (cmd.compareTo("exit") == 0) bucle = false;
            else if(cmd.compareTo("r1") == 0){
                System.out.println("Selecciona el area de la ruleta.");
                c.setR1();
            }
            else if(cmd.compareTo("r2") == 0) {
                System.out.println("Selecciona el area de los premios.");
                c.setR2();
            }
            else if(c.r1Status() && c.r2Status() && cmd.compareTo("start") == 0){
                System.out.println("Iniciando...");
                tiempoInicio = System.currentTimeMillis();
                c.setTotal(0);
                ClicThread ct = new ClicThread(c);
                c.setWorking(true);
                t = new Thread(ct);
                t.start();
            }
            else if(c.getWorking() && cmd.compareTo("stop") == 0){
                System.out.println("Deteniendo...");
                System.out.println("Total llaves : " + c.getTotal());
                System.out.println("En " + TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - tiempoInicio) + "minutos.");
                c.setWorking(false);
                if (t.isAlive()) t.interrupt();
            }else if(cmd.compareTo("help") == 0) help();
            else if(cmd.compareTo("helpita") == 0) helpIta();
            else if (cmd.compareTo("file") == 0) System.out.println("You don't need this program, cloth stones raining you.");
        }
        

        
    }
    
    public static String pideComando(Scanner sc){
        return sc.next();
    }
    
    public static void help(){
        System.out.println("r1      selecciona el area para la ruleta.");
        System.out.println("r2      selecciona el area para los premios.");
        System.out.println("start   inicia la ejecución");
        System.out.println("stop    detiene la ejecución");
        System.out.println("exit    sale del programa");
        System.out.println("helpIta aiuto in italiano");
        System.out.println("help    esta ayuda");
        System.out.println("File    si eres Filemon\n");
    }
    
    public static void helpIta(){
        System.out.println("r1      seleziona l'area per la roulette.");
        System.out.println("r2      seleziona l'area per i premi.");
        System.out.println("start   inizia l'esecuzione");
        System.out.println("stop    fermare l'esecuzione");
        System.out.println("exit    lascia il programma");
        System.out.println("helpIta aiuto in italiano");
        System.out.println("help    aiuto in spagnolo");
        System.out.println("File    se sei Filemon\n");
    }
    
}
