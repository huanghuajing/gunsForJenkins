package cn.stylefeng.guns.base.auth.context;

import cn.stylefeng.roses.core.util.SpringContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




/**
 * 当前登录用户信息获取的接口
 *
 * @author fengshuonan
 * @Date 2019/7/18 22:27
 */
public class LoginContextHolder {

    public static LoginContext getContext() {
        return SpringContextHolder.getBean(LoginContext.class);
    }


    public static void main(String[] args) {
//        String s1 = new String("1");
//        s1.intern();
//        String s2 = "1";
//        String s3 = "1";
//        String s4 = new String("1");
//        System.out.println(s1 == s2);
//        System.out.println(s3 == s2);
//        System.out.println(s1 == s4);
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();


    }

}
