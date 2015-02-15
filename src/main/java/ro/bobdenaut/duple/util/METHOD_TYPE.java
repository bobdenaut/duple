package ro.bobdenaut.duple.util;

/**
 * Created by Voicu.Liviu on 2/15/2015.
 */
public enum METHOD_TYPE {
    SET("set", "^set[A-Z].*"), GET("get", "^get[A-Z].*"), IS("is", "^is[A-Z].*"), HAS("has", "^has[A-Z].*");

    private final String methodType;
    private final String patern;

    METHOD_TYPE(String methodType, String patern) {
        this.methodType = methodType;
        this.patern = patern;
    }

    public String getMethodType() {
        return this.methodType;
    }

    public String getPatern() {
        return patern;
    }
}
