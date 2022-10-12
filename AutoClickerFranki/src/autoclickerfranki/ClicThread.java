/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclickerfranki;

import java.time.LocalDateTime;

/**
 *
 * @author ioman
 */
public class ClicThread implements Runnable{
    private Clicker c;
    
    public ClicThread( Clicker c){
        this.c = c;
    }

    @Override
    public void run() {
        try{
            while(c.getWorking()){  
                Thread.sleep(500);
                c.refresh();
                Thread.sleep(500);
                    if(c.findKey()){
                        System.out.println(LocalDateTime.now() + " : LLave encontrada\n");
                        c.activate();
                        Thread.sleep(5000);
                        c.activate();
                        Thread.sleep(5000);
                        c.activate();
                        Thread.sleep(5000);
                        if(!c.findKey2()){
                            c.activate();
                            Thread.sleep(5000);
                        }
                        if(c.findKey2()){
                            c.setTotal(c.getTotal() + 1);
                            System.out.println("Total llaves : " + c.getTotal());
                            Thread.sleep(5000);
                        }
                    }
            }
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    
}
