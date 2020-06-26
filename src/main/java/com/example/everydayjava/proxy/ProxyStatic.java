package com.example.everydayjava.proxy;

public class ProxyStatic {
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

    static class SubjectImplProxy implements Subject{
        private Subject target;

        public SubjectImplProxy(Subject target){
            this.target = target;
        }



        @Override
        public void sayHi() {
            System.out.print("say:");
            target.sayHi();
        }

        @Override
        public void sayHello() {
            System.out.print("say:");
            target.sayHello();
        }
    }

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject subjectProxy = new SubjectImplProxy(subject);
        subjectProxy.sayHi();
        subjectProxy.sayHello();
    }
}
