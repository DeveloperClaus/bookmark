package demo.models;


import act.aaa.model.UserBase;
import act.db.jpa.JPADao;
import act.job.OnAppStart;
import demo.aaa.AAAHelper;
import org.osgl.util.S;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User extends UserBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public User(String email, char[] password) {
        this.email = S.requireNotBlank(email);
        this.setPassword(password);
        this.grantRoleByNames(AAAHelper.ROLE_USER);
    }

    public static class Dao extends JPADao<Integer, User> {
        public boolean exists(String email) {
            return countBy("email", email) > 0;
        }

        public User findByEmail(String email) {
            return findOneBy("email", email);
        }

        @OnAppStart
        public void ensureTestUserAccount() {
            User user = findByEmail("testFlowUser");
            if (null == user) {
                user = new User("testFlowUser", "testpassword".toCharArray());
                user.grantPermissionByNames("defaultFlowPermission");
                save(user);
            }
        }

    }
}
