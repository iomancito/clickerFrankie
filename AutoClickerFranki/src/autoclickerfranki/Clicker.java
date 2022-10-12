/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclickerfranki;

/**
 *
 * @author ioman
 */


import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextArea;
import org.sikuli.script.Match;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;



public class Clicker {
    private int total = 0;
    private Screen s;
    private Region r1;
    private Region r2;
    private boolean enS1 = false;
    private boolean enS2 = false;
    private boolean working = false;
    private JTextArea log;
    
    public Clicker(){
       this.s = new Screen(0);
    }
    
    public Clicker(JTextArea l){
        this.s = new Screen(0);
        this.log = l;
    }
    
    public void setR1(){
        this.r1 = new Region(s.selectRegion());
        this.enS1 = true;
    }
    
    public void setR2(){
        this.r2 = new Region(s.selectRegion());
        this.enS2 = true;
    }
    
    public boolean findKey(){
        try{
            String key = "resources/key.png";            
            Iterator<Match> f = this.r1.findAll(key);
            int a = 0;
            while(f.hasNext()){
                a++;
                f.next();
            }
            if(a>=2) return true;
            else return false;
        }catch(Exception e){
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean findKey2(){
        try{
            String key2 = "resources/key2.png";
            Match f = this.r2.find(key2);
            if(f != null) return true;
            else return false;
        }catch(Exception e){
            //e.printStackTrace();
            return false;
        }
    }
    
    public void oneClick(){
        try{
            String oneClick = "resources/oneClick.png";
            this.r1.click(this.r1.find(oneClick));
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    public void refresh(){
        try{
            String refresh = "resources/refresh.png";
            this.r1.click(this.r1.find(refresh));
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    
    public void activate(){
        try{
            String activate = "resources/activate.png";
            this.r1.click(this.r1.find(activate));
        }catch(Exception e){
            //e.printStackTrace();
        }
    }
    
    public boolean r1Status(){
        return this.enS1;
    }
    
    public boolean r2Status(){
        return this.enS2;
    }
    
    public boolean getWorking(){
        return this.working;
    }
    
    public void setWorking(boolean b){
        this.working = b;
    }

    public void logAppend(String str){
        this.log.append(str); 
    }
    
    public void setTotal(int i){
        this.total = i;
    }
    
    public int getTotal(){
        return this.total;
    }
}
