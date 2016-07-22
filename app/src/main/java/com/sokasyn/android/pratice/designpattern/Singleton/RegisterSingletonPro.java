package com.sokasyn.android.pratice.designpattern.Singleton;

import java.util.HashMap;

/**
 * Created by Samson on 16/7/22.
 *
 * 如果在参数比较多的时候,通过重载getInstance方法,会显得代码重复，
 * 因为登记式单例,既然是通过Map存取的,那么一个key对应一个instance
 * 所以就算重载,其实也就那个作为key的参数对实例有影响,其余的只是对构造方法有影响
 * 这种情况,可以将参数封装成一个对象,使得 getInstance 和私有构造方法的参数一致,
 * 不过对于用户来讲,他关注的则是传入的参数及个数,所以对外提供的创建方法重载
 *
 */
public class RegisterSingletonPro {

    // 如果参数比较多了可以封装起来
//    private String name;
//    private String type;
//    private int version;

    private Config config;

    private static HashMap<String , RegisterSingletonPro> singletonMap =
            new HashMap<String, RegisterSingletonPro>();

    private RegisterSingletonPro(Config config){
        // 在私有构造方法中,可以做一些业务上的处理,如数据校验,比如key不能为空等
        if(config.getName() == null || config.getName().trim() == ""){
            throw new IllegalArgumentException("name 不能为空！");
        }
        this.config = config;
    }

    private synchronized static RegisterSingletonPro getInstance(Config config){
        RegisterSingletonPro instance = singletonMap.get(config.getName());
        if(instance == null){
            instance = new RegisterSingletonPro(config);
            singletonMap.put(config.getName(),instance);
        }
        return instance;
    }

    // create的重载方法系列,是对外公开的,这些入参其实就是业务逻辑，那我们可以把封装的Config隐藏起来
    // 把getInstance()设置为private
    public static RegisterSingletonPro create(String name){
        Config config = new Config();
        config.setName(name);
        return create(config);
    }

    public static RegisterSingletonPro create(String name,String type){
        Config config = new Config();
        config.setName(name);
        config.setType(type);
        return create(config);
    }

    public static RegisterSingletonPro create(String name,String type, int version){
        Config config = new Config();
        config.setName(name);
        config.setType(type);
        config.setVersion(version);
        return create(config);
    }

    public static RegisterSingletonPro create(Config config){
        return getInstance(config);
    }

    public Config getConfig() {
        return config;
    }

    public static class Config{

        // 可以设置默认值,因为提供的create方法中,可能某些值并未传入,如version,int类型默认值会是0
        private static final int VERSION = 1;

        private String name;
        private String type;
        private int version = VERSION;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

}
