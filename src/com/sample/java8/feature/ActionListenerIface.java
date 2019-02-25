package com.sample.java8.feature;

import java.awt.event.ActionEvent;
import java.util.EventListener;

public interface ActionListenerIface extends EventListenerIface  
{
    void method1();
    
    public void actionPerformed(ActionEvent e);
    
    void method1(String str);
}
