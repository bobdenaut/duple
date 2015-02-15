package ro.bobdenaut.duple;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ro.bobdenaut.data.Entitate;
import ro.bobdenaut.data.EntitateDTO;
import ro.bobdenaut.data.Somefield;

import java.lang.reflect.InvocationTargetException;

public class DuplicateEntityTest extends TestCase {
    private Entitate entitate = null;
    private EntitateDTO entitateDTO = null;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        entitate = new Entitate();
        entitate.setObjString("a string object!!!");
        entitate.setObjLong((long) 11);
        entitate.setObjObject(new Object());
        entitate.setI(12);
        entitate.setF(2.22f);
        entitate.setL(22l);
        entitate.setObjBoolean(Boolean.TRUE);
        entitate.setOtherBoolean(Boolean.FALSE);
        Somefield field = new Somefield();
        field.setField("somefield class!!!");
        entitate.setAfield(field);

        entitateDTO = new EntitateDTO();
    }

    @After
    public void tearDown() throws Exception {
        assertNotNull(entitateDTO);

//        System.out.println(entitateDTO.getObjString());
        System.out.println(entitateDTO.getObjLong());
        System.out.println(entitateDTO.getObjObject());
        System.out.println(entitateDTO.getI());
        System.out.println(entitateDTO.getF());
        System.out.println(entitateDTO.getL());
        System.out.println(entitateDTO.isObjBoolean());
        System.out.println(entitateDTO.hasOtherBoolean());
        System.out.println(entitateDTO.getAfield()!=null?entitateDTO.getAfield().getField():null);
    }

    @Test
    public void testStart() throws Exception {
        assertNotNull(entitate);
        assertNotNull(entitateDTO);
        try {
            DuplicateEntity.start(entitate, entitateDTO, true);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}