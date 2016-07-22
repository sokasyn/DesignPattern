package com.sokasyn.android.pratice.designpattern.Singleton;

/**
 * Created by Samson on 16/7/22.
 */
public class HungrySingleton {

    // 用单例模版创建的饿汉单例
    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

    private HungrySingleton() {
    }
}
