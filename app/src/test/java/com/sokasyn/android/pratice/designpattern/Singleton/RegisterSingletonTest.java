package com.sokasyn.android.pratice.designpattern.Singleton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Samson on 16/7/22.
 */
public class RegisterSingletonTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetInstance() throws Exception {
        String name = "sam";
        RegisterSingleton instance = RegisterSingleton.getInstance(name);
        debug(instance.getName());
    }

    private void debug(String string){
        System.out.println(string);
    }
}