package proj.doc.test.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by admin on 2020/1/9 9:13:59.
 *
 * @model User
 */
public class User {
    
    /**
     * 用户id
     */
    String userId;
    
    /**
     * 用户名
     */
    String userName;
    
    /**
     * 真实姓名
     */
    String realName;
    
    /**
     * 昵称
     */
    String nickName;
    
    /**
     * dds
     */
    List<String> dds;
    
    /**
     * ddt
     */
    String[] ddt;
    
    /**
     * addresses
     */
    List<Address> addresses;
    
    /**
     * uas
     */
    List<Map<User, Map<Address, Address>>> uas;
    
    /**
     * list set string
     */
    List<Set<String>> lss;
    
    /**
     * uamap
     */
    Map<User, Address> uamap;
    /**
     * 班级
     */
    Address            address;
    
    
}
