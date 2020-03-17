package proj.doc.test.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2020/1/9 9:10:32.
 * @see String
 *
 * @apiInfo
 * version = 1.0.0
 * title = title
 * description = 这个api描述
 * termsOfService = "http://swagger.io/terms/"
 * contact.name = swagger
 * contact.email = "swagger@qq.com"
 * contact.url = "https://swagger.io"
 * license.name = "Apache 2.0"
 * license.url = "http://www.apache.org/licenses/LICENSE-2.0.html"
 *
 * @route /aaaaaaa
 */
public interface UserRoute {
    

    /**
     * sdfdsf
     * @route /sdfdsf.do {post}
     * @param users
     * sdfsdfasdfsd
     * @param userArrayList header sdfsdf
     *                      sdfsdfsd
     *                      sdfsadfsad
     *                      asdfsadf
     *                      sadfdfd
     * @param str
     * @param it
     * @param itger
     * @param bigInteger
     * @param bigDecimal
     * @param lng
     * @param Lng
     * @param map
     * @return
     */
    User getUser(List<User> users, ArrayList<User> userArrayList,  String str, /*00*/int it, Integer itger, BigInteger bigInteger, BigDecimal bigDecimal, long lng, Long Lng, Map<String, Object> map);
    
}
