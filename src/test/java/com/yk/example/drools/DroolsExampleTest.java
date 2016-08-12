package com.yk.example.drools;

import com.yk.example.drools.clock.Clock;
import com.yk.example.drools.helloworld.Message;
import com.yk.example.drools.helloworld.State;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by yukui on 2016/8/12.
 */
public class DroolsExampleTest {

    public static KieServices kieServices;
    public static KieContainer kieContainer;


    static {
        kieServices = KieServices.Factory.get();
        kieContainer = kieServices.getKieClasspathContainer();
    }

    @Test
    public void clockTest() {
        KieSession kieSession = kieContainer.newKieSession("session-clock");
        kieSession.insert(new Clock());
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void messageTest() {
        KieSession kieSession = kieContainer.newKieSession("HelloWorldKS");
        kieSession.addEventListener(new DebugAgendaEventListener());
        kieSession.addEventListener(new DebugRuleRuntimeEventListener());
        final Message message = new Message();
        message.setMessage("hello world");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

    @Test
    public void stateTest() {
        KieSession kieSession = kieContainer.newKieSession("StateExampleKS");
        final State a = new State("A");
        final State b = new State("B");
        final State c = new State("C");
        final State d = new State("D");
        kieSession.insert(a);
        kieSession.insert(b);
        kieSession.insert(c);
        kieSession.insert(d);
        kieSession.fireAllRules();
        kieSession.dispose();
    }
}