package com.AlfExample.alfExample.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class AlfServiceImplementationTests {
    AlfServiceImplementation alfServiceImplementation = new AlfServiceImplementation();
    @Test
    public void testIfAListContainsAString(){
        String[] array = {"1", "fizz", "3"};
        Assert.assertEquals(1, alfServiceImplementation.checkIfContainsString("fizz", Arrays.asList(array)));
    }

    @Test
    public void testIfTheResultContainsStrings(){
    String text = "The list is: [1, 2, alfresco, 4, buzz]";
        Assert.assertTrue(alfServiceImplementation.printFizzBuzz(5).contains(text));
    }

}
