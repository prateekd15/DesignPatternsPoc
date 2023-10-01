package org.example.pattern.creational;

final class SingletonInstance {

    private SingletonInstance(){}

    private static final class SingletonInstanceHolder {
        public static final SingletonInstance singletonInstance = new SingletonInstance();
    }

    public static SingletonInstance getSingletonInstance() {
        return SingletonInstanceHolder.singletonInstance;
    }
}
public class SingletonPattern {

    public static void main(String[] args) {
        SingletonInstance singletonInstance = SingletonInstance.getSingletonInstance();
        System.out.println("Created a singleton instance");
        SingletonInstance anotherSingletonInstance = SingletonInstance.getSingletonInstance();
        System.out.println("Both the instances of SingletonInstance class are equal: " + (singletonInstance == anotherSingletonInstance));
    }
}
