package proj.doc.test.model;

import java.util.List;

/**
 * Created by admin on 2020/1/9 9:10:32.
 * @see String
 *
 * @apiInfo title description
 * aa: sdfsdf
 * bb: dsfds
 *
 * @route /test/user
 */
public interface UserRoute {
    
    /**
     * @param sdf  参数sdf
     * @operationId getUserInfoaa
     * @query userId 用户id
     * @body {@link User}
     * @response {@link }
     */
    User sdfds(List<User> users);
    
}
