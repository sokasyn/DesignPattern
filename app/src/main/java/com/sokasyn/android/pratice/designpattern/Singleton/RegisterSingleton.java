package com.sokasyn.android.pratice.designpattern.Singleton;

import java.util.HashMap;

/**
 * Created by Samson on 16/7/22.
 *
 * 登记式单例模式
 * 经典的饿汉/懒汉单例模式,能创建全局唯一的实例，
 * 但是某些情况,我们可能需要特定条件下的单例,即根据某些条件,创建该条件下的单例。
 * 一般是在不同配置(即根据不同的入参）下创建实例。
 * 试想,在有入参的时候，还采用饿汉/懒汉式,那么第一次创建实例的时候,instance已经不为null,
 * 那么不管之后怎么配置，都只会返回第一次创建的那个“单例",那么该配置也就形同虚设
 * 解决的办法就是采用登记式,通过一个Map来保存
 */
public class RegisterSingleton {

    private String name;

    // 用HasMap来存放属于key条件下的单例
    private static HashMap<String,RegisterSingleton> singletonMap =
            new HashMap<String, RegisterSingleton>();

    private RegisterSingleton(String name){
        this.name = name;
    }

    public synchronized static RegisterSingleton getInstance(String name){
        // 先检查map中时候已经存了实例,如果存了,直接返回，否则创建,并存于map中
        RegisterSingleton instance = singletonMap.get(name);
        if(instance == null){
            instance = new RegisterSingleton(name);
            singletonMap.put(name,instance);
        }
        return instance;
    }

    public String getName() {
        return name;
    }
}
