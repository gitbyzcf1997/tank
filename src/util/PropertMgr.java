package util;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther:ZhenCF
 * @Date: 2022-01-26-9:40
 * @Description: util
 * @version: 1.0
 */

/**
 * 配置文件中 的属性管理
 */
public class PropertMgr {

    //使用匿名内部类进行单例（懒加载）
    private static class PropertHolader{
        private static final PropertMgr INSTANCE =new PropertMgr();
    }
    private static Properties props=new Properties();
    static {
        try {
            props.load(PropertMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertMgr() {
    }

    public static PropertMgr getInstance() {
        return PropertHolader.INSTANCE;
    }

    public static String getString(String key){
        if(props==null)return null;
        return (String) props.get(key);
    }
    public static int getInt(String key){
        if(props==null)return -1;
        return Integer.parseInt((String)props.get(key));
    }

    public static void main(String[] args) {
        System.out.println(PropertMgr.getString("initialization"));
    }
}
