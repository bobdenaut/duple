package ro.bobdenaut.data;

/**
 * Created by Voicu.Liviu on 2/14/2015.
 */
public class EntitateDTO {
    private String objString;
    private Long objLong;
    private Object objObject;
    private int i;
    private float f;
    private long l;
    private Boolean objBoolean;
    private Somefield afield;

    public String getObjString() {
        return objString;
    }

    public void setObjString(String objString) {
        this.objString = objString;
    }

    public Long getObjLong() {
        return objLong;
    }

    public void setObjLong(Long objLong) {
        this.objLong = objLong;
    }

    public Object getObjObject() {
        return objObject;
    }

    public void setObjObject(Object objObject) {
        this.objObject = objObject;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public long getL() {
        return l;
    }

    public void setL(long l) {
        this.l = l;
    }

    public Boolean isObjBoolean() {
        return objBoolean;
    }

    public void setObjBoolean(Boolean objBoolean) {
        this.objBoolean = objBoolean;
    }

    public Somefield getAfield() {
        return afield;
    }

    public void setAfield(Somefield afield) {
        this.afield = afield;
    }
}
