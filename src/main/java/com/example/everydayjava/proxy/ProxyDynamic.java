package com.example.everydayjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDynamic {
    static interface Subject{
        void sayHi();
        void sayHello();
    }

    static class SubjectImpl implements Subject {

        @Override
        public void sayHi() {
            System.out.println("hi");
        }

        @Override
        public void sayHello() {
            System.out.println("hello");
        }
    }

    static class ProxyInvocationHandler implements InvocationHandler{
        private Subject target;
        public ProxyInvocationHandler(Subject target) {
            this.target=target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.print("say:");
            return method.invoke(target, args);
        }

    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject sujectProxy = (Subject) Proxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), new ProxyInvocationHandler(subject));

        sujectProxy.sayHi();
        sujectProxy.sayHello();
    }
}
