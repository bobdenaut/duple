package ro.bobdenaut.duple.util;

/**
 * Created by Voicu.Liviu on 2/15/2015.
 */
public enum METHOD_TYPE {
    SET("set"), GET("get"), IS("is"), HAS("has");

    private final String methodType;

    METHOD_TYPE(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return this.methodType;
    }
}
