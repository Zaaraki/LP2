/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylock1;

/**
 *
 * @author Amaro
 */
public interface Lock {
    public void requestCS();
    public void  releaseCS();
}


