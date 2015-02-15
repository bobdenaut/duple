package ro.bobdenaut.duple.bytecode;

import java.util.Map;

/**
 * Created by Voicu.Liviu on 2/15/2015.
 *
 * Class to manipulate bytecode with jboss library - Javassist
 */
public abstract class BytecodeManipulator {
    /**
     * The class that will add to, during runtime, the missing fields along with getters and setters
     * @param object2modify Object
     */
    public static void write(Object object2modify, Map<String, Class<?>> properties){

    }
}
