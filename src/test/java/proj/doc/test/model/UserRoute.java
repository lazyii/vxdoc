package proj.doc.test.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2020/1/9 9:10:32  className 填充name ，comment填充description
 * - name: pet
 *   description: Everything about your Pets
 * @route /aaaaaaa
 */
public interface UserRoute {
    

    /**
     * controller-desc api接口的描述,用来填充 summary/description 两个字段
     *
     *
     * @tag (不必要，默认使用className)
     * @route /sdjflksjdjlk.do {@link http.GET,http.POST}
     * @param users 用户
     * @param userArrayList {@link http.GET,http.POST} {@link http.DESC sdsdfsdfdsfdsf}
     * @param str {@link http.DESC lsjdlfkjldkjflk}
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
