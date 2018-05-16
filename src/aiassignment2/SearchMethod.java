/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiassignment2;

import java.util.ArrayList;

/**
 *
 * @author Carl
 */
public abstract class SearchMethod {
    public String code;
    
    public abstract String methodOutput(boolean result);
    public abstract boolean methodEntails(ArrayList<String> agenda, ArrayList<String> clauses, ArrayList<Integer> count, String query);
    public abstract boolean premiseContains(String clause, String ask);
    
}