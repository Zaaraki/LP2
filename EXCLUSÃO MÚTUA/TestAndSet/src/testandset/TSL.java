    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testandset;

/**
 *
 * @author Amaro
 */
public class TSL {
    boolean locked = false;
    
    public boolean testAndSet(){
        boolean temp = locked;
        if(!locked) locked = true;
        return temp;
    }
    
    public void unlock(){
        locked=false;
    }
}
