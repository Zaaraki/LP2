/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peterson;

/**
 *
 * @author Amaro
 */
public interface Lock {
    public void requestCS(int id);
    public void releaseCS(int id);
}
