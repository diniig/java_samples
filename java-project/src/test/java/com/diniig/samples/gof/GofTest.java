package com.diniig.samples.gof;

import com.diniig.samples.gof.behavioral.AddExpression;
import com.diniig.samples.gof.behavioral.JDBCDriver;
import com.diniig.samples.gof.behavioral.JDBCDriverImpl;
import com.diniig.samples.gof.behavioral.NoCapitalCharFilter;
import com.diniig.samples.gof.behavioral.NumberExpression;
import com.diniig.samples.gof.behavioral.TextFilter;
import com.diniig.samples.gof.creational.CoffeOrderFormBuilder;
import com.diniig.samples.gof.creational.CreationalPattern;
import com.diniig.samples.gof.creational.Device;
import com.diniig.samples.gof.creational.DeviceFactory;
import com.diniig.samples.gof.creational.GUIFactory;
import com.diniig.samples.gof.creational.MobileDeviceFactory;
import com.diniig.samples.gof.creational.OrderForm;
import com.diniig.samples.gof.creational.PcDeviceFactory;
import com.diniig.samples.gof.structural.Action;
import com.diniig.samples.gof.structural.ActionImpl;
import com.diniig.samples.gof.structural.Adapter;
import com.diniig.samples.gof.structural.Animal;
import com.diniig.samples.gof.structural.CachedProxy;
import com.diniig.samples.gof.structural.CompositeAction;
import com.diniig.samples.gof.structural.Connection2RealObject;
import com.diniig.samples.gof.structural.FacadeForLibs;
import com.diniig.samples.gof.structural.LegacyCode;
import com.diniig.samples.gof.structural.Lib1;
import com.diniig.samples.gof.structural.Lib2;
import com.diniig.samples.gof.structural.Lib3;
import com.diniig.samples.gof.structural.LoggingProxy;
import com.diniig.samples.gof.structural.NPC;
import com.diniig.samples.gof.structural.RealObject;
import com.diniig.samples.gof.structural.RealObjectImpl;
import com.diniig.samples.gof.structural.Red;
import com.diniig.samples.gof.structural.Remote;
import com.diniig.samples.gof.structural.RemoteAccessToRealObjectProxy;
import com.diniig.samples.gof.structural.RemoteImpl;
import com.diniig.samples.gof.structural.RemoteWithMute;
import com.diniig.samples.gof.structural.RemoteWithMuteImpl;
import com.diniig.samples.gof.structural.SecureProxy;
import com.diniig.samples.gof.structural.Square;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class GofTest {

    @Test
    public void structuralPatternTest() {
        Adapter adapter = new Adapter(new LegacyCode());
        log.info(adapter.getText());

        // bridge
        Square square = new Square(new Red()); // Shape - Colored is bridge
        square.draw();

        CompositeAction compositeAction = new CompositeAction();
        Action action1 = new ActionImpl();
        Action action2 = new ActionImpl();
        compositeAction.add(action1);
        compositeAction.add(action2);
        compositeAction.run();

        Remote remote = new RemoteImpl();
        RemoteWithMute withMute = new RemoteWithMuteImpl(remote); // decorator

        // facade, using libs through a facade.
        Lib1 lib1 = new Lib1();
        Lib2 lib2 = new Lib2();
        Lib3 lib3 = new Lib3();

        FacadeForLibs facade = new FacadeForLibs(lib1, lib2, lib3);

        facade.doWithLib1();
        facade.doWithLib2();
        facade.doWithLib3();

        // fluweight - легковес
        NPC crocodile = new NPC("crocodile", 0x12e); // Non-player character
        NPC elefant = new NPC("elefant", 0x15e); // one instance. brings static data. can be reused

        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int[] coordinates = new int[] { 1, i + 2, 3 };
            animals.add(new Animal(crocodile, coordinates));

            coordinates = new int[] { 1, i + 2, i + 3 };
            animals.add(new Animal(elefant, coordinates));
        }
        for (Animal animal : animals) {
            animal.draw();
        }

        RealObject real = new RealObjectImpl();
        RealObject secureProxy = new SecureProxy(real);
        RealObject loggingProxy = new LoggingProxy(real);
        RealObject cachedProxy = new CachedProxy(real);

        RealObject remoteAccessProxy = new RemoteAccessToRealObjectProxy(new Connection2RealObject());
    }

    @Test
    public void creationalPatternTest() {
        CreationalPattern pattern = CreationalPattern.INSTANCE; // singlenote

        GUIFactory pageElementsFactory = pattern.getGUIFactory();
        DeviceFactory mobileDeviceFactory = new MobileDeviceFactory();

        OrderForm form = new CoffeOrderFormBuilder()
                .addPageElementsFactory(pageElementsFactory) // abstract factory goes inside builder
                .addDeviceFactory(mobileDeviceFactory) // abstract factory goes inside builder
                .build();
        form.renderForm();

        Device device1 = new PcDeviceFactory().createDevice(); // factory method - создание через иерархию
        Device device2 = device1.clone(); // prototype - делегирование оригинальному классу
    }

    @Test
    public void behavioralTest() {
        TextFilter f = new NoCapitalCharFilter(new NoCapitalCharFilter(null));
        assertEquals("helloworld", f.doFilter("Hello World"));

        Runnable command = new Runnable() {

            @Override
            public void run() {
                log.info("hello from command");
            }

        };
        command.run();

        NumberExpression inter1 = new NumberExpression(1);
        NumberExpression inter2 = new NumberExpression(2);
        AddExpression res = new AddExpression(inter1, inter2);
        log.info("interpret res {}", res);

        List<Integer> list = List.of(1, 2, 34, 5);
        list.iterator().next();

        ExecutorService mediator = Executors.newCachedThreadPool();
        mediator.execute(command);

        JDBCDriver mediator2 =  new JDBCDriverImpl();
        mediator2.doQuery("select *");


        TextEditor originator = new TextEditor(); 
        originator.add("text");
        originator.add("one more");

        TextStore momento = originator.save();
        String text = momento.getText();
        originator.restore(momento);


        MyObserver ob1 = new MyObserverImpl();
        MyObserver ob2 = new MyObserverImpl();
        MyObserver ob3 = new MyObserverImpl();

        Processor pr = new ProcessorImpl();


        State state1 = new SuspendedState();
        ObjectWithState obj = new ObjectWithState(state1);
        obj.suspend();
        obj.getPrintStrategy().print("hello"); // "sorry i am sleep"
        obj.resume();
        obj.getPrintStrategy().print("hello"); // "hello"



        Library lib = new Library();
    }
}
