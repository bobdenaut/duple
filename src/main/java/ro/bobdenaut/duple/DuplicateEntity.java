package ro.bobdenaut.duple;

import ro.bobdenaut.duple.util.METHOD_TYPE;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Voicu.Liviu on 2/14/2015.
 */
public abstract class DuplicateEntity {

    /**
     *
     * @param src                           Source object from we copy the data
     * @param dest                          Destination object where we copy the data
     * @param createMissing                 If the destination object is not exactly the same and the source, we can create
     *                                      the missing field along with it's getters and setters, by setting this true
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void start(Object src, Object dest, boolean createMissing) throws InvocationTargetException, IllegalAccessException {
        List<Method> getMethodsSRC = getGetters(src.getClass());

        if(getMethodsSRC==null || (getMethodsSRC!=null && getMethodsSRC.size()==0)){
            System.out.println("Object " + src.getClass() + " doesn't have any method. Done!");
            return;
        }

        for(Method getMethod : getMethodsSRC){
            getMethod.setAccessible(true);
            Object getSrcValue = getMethod.invoke(src);
            String setMethodName = convertGet2Set(getMethod.getName());

            try {
                Method setMethod = dest.getClass().getMethod(setMethodName, getMethod.getReturnType());
                setMethod.invoke(dest, getSrcValue);
            } catch (NoSuchMethodException e) {
                System.out.println("Method " + setMethodName + " not found in class " + dest.getClass());
                System.out.println("createMissing param, is set to " + createMissing);
                if(createMissing){
                    addMissingField(dest);
                }
            }
        }
    }

    private static void addMissingField(Object dest) {

    }

    private static String convertGet2Set(String name) {
        if(name.startsWith(METHOD_TYPE.GET.getMethodType())){
            return METHOD_TYPE.SET.getMethodType() + name.substring(METHOD_TYPE.GET.getMethodType().length(),name.length());//we can have get
        }
        if(name.startsWith(METHOD_TYPE.HAS.getMethodType())){
            return METHOD_TYPE.SET.getMethodType() + name.substring(METHOD_TYPE.HAS.getMethodType().length(),name.length());//we can have get
        }
        return METHOD_TYPE.SET.getMethodType() + name.substring(METHOD_TYPE.IS.getMethodType().length(),name.length());//we can have is
    }

    private static List<Method> getGetters(Class klass){
        Method[] allMethods = klass.getDeclaredMethods();

        if(allMethods!=null){
            List<Method> getters = new ArrayList<Method>(0);
            for(Method method:allMethods){
                if(isGetter(method)){
                    getters.add(method);
                }
            }
            return getters;
        }
        return null;
    }

    private static List<Method> getSetters(Class klass){
        Method[] allMethods = klass.getMethods();

        if(allMethods!=null){
            List<Method> setters = new ArrayList<Method>(0);
            for(Method method:allMethods){
                if(isSetter(method)){
                    setters.add(method);
                }
            }
            return setters;
        }
        return null;
    }

    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith(METHOD_TYPE.GET.getMethodType())
                && !method.getName().startsWith(METHOD_TYPE.IS.getMethodType())
                && !method.getName().startsWith(METHOD_TYPE.HAS.getMethodType())) {
            return false;
        }
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }

    private static boolean isSetter(Method method) {
        if (!method.getName().startsWith(METHOD_TYPE.SET.getMethodType())) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }
}
