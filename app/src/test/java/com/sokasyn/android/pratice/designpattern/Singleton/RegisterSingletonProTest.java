package com.sokasyn.android.pratice.designpattern.Singleton;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Samson on 16/7/22.
 */
public class RegisterSingletonProTest {

    @Test
    public void testCreateWithName() throws Exception {

    }

    @Test
    public void testCreateWithNameAndType() throws Exception {

    }

    @Test
    public void testCreateAllArg() throws Exception {

    }

    @Test
    public void testCreateWithConfig() throws Exception {

        RegisterSingletonPro.Config config = new RegisterSingletonPro.Config();
        config.setName("Sokasyn");
        RegisterSingletonPro instance = RegisterSingletonPro.create(config);

        debug("config:" + config);
        debug("instance:" + instance);
        debug("instance version:" + instance.getConfig().getVersion());

        RegisterSingletonPro.Config config1 = new RegisterSingletonPro.Config();
        config1.setName("Sokasyn");
        config1.setVersion(200);
        RegisterSingletonPro instance1 = RegisterSingletonPro.create(config1);
        debug("new config1:" + config1);

        debug("instance1.config:" + instance1.getConfig());
        debug("instance1:" + instance1);
        debug("instance1 version:" + instance1.getConfig().getVersion());
    }

    private void debug(String string){
        System.out.println(string);
    }
}