package proj.vx.doc.qdox.tag;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by admin on 2020/1/15 9:25:05.
 */
public class PrimitiveType1 {
    //java 原始类型 8种
    //void, byte, short, int, long; float, double, char(character), boolean;
    public enum BaseType {
        VOID(Void.TYPE),
        BYTE(Byte.TYPE),
        SHORT(Short.TYPE),
        INT(Integer.TYPE),
        LONG(Long.TYPE),
        FLOAT(Float.TYPE),
        DOUBLE(Double.TYPE),
        CHAR(Character.TYPE),
        BOOLEAN(Boolean.TYPE);
    
        private final Class<?> clazz;
        BaseType(Class<?> clazz) {
            this.clazz = clazz;
        }
    }
    
    //开发过程中常用的一些 JDK 类型（都是非primitive的类型）
    public enum KeyType {
        // base class
        VOID(Void.class),
        BYTE(Byte.class),
        SHORT(Short.class),
        INT(Integer.class),
        LONG(Long.class),
        FLOAT(Float.class),
        DOUBLE(Double.class),
        CHAR(Character.class),
        BOOLEAN(Boolean.class),
        // key class
        STRING(String.class),
        URI(java.net.URI.class),
        URL(java.net.URL.class),
        UUID(java.util.UUID.class),
        BIGINTEGER(BigInteger.class),
        BIGDECIMAL(BigDecimal.class),
        NUMBER(Number.class),
        DATA_STUB(DateStub.class),//???
        DATE_TIME(Date.class),
        LOCALDATE(LocalDate.class),
        LOCALTIME(LocalTime.class),
        LOCALDATE_TIME(LocalDateTime.class),
        FILE(File.class),
        OBJECT(Object.class);
        
        
        private final Class<?> clazz;
        KeyType(Class<?> clazz) {
            this.clazz = clazz;
        }
    }
    /*Set<Class<?>> baseType = new HashSet(){{
        add(byte.class);
        add(Long.TYPE);
        add(Long.TYPE);
        add(Long.TYPE);
        add(Long.TYPE);
        
    }}*/
    
    private static class DateStub {
        private DateStub() {
        }
    }
}
