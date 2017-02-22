/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swap;

/**
 *
 * @author Amaro
 */
public class Swp {
    private boolean value=false;
    
    public boolean swap(boolean newValue){
        boolean temp=value;
        value=newValue;
        return temp;
    }
}
