/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest { 
    @Test void appHasAGreeting() {
        App classUnderTest = new App(); 
        System.out.println("MESSAGE: Hello world!!!");
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
