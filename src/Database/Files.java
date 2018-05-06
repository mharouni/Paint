/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author MaramH
 */
public interface Files {
    
    public void save(String s) throws IOException;
    public void load(String s) throws ParseException, IOException;
    
}
