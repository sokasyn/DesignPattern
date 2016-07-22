package com.sokasyn.android.pratice.designpattern.Singleton;

/**
 * Created by Samson on 16/7/22.
 */
public class LazySingleton {

    // 类加载的时候,不创建实例,只有在getInstance的时候才创建
    private static LazySingleton instance = null;

    // 私有构造方法,阻止外部创建实例
    private LazySingleton(){
    }

    // 用synchronized，线程安全
    public synchronized static LazySingleton getInstance(){
        if(instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }
}
