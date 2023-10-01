package org.example.pattern.creational;

abstract class Computer {
    protected String ram;
    protected String cpu;
    protected String storage;

    public Computer(String ram, String cpu, String storage) {
        this.ram = ram;
        this.cpu = cpu;
        this.storage = storage;
    }

    public String toString() {
        return "RAM: " + this.ram + " AND " +
                "CPU: " + this.cpu + " AND " +
                "Storage: " + this.storage;
    }
}


class GamingPc extends Computer {
    private String gpu;

    public GamingPc() {
        super("16GB", "Intel core i7 12700H", "1TB SSD");
        gpu = "Nvidia RTX 4060";
        System.out.println("Creating a Gaming PC");
    }

    public String toString() {
        return "Created a Gaming PC with " + super.toString() + " AND GPU: " + this.gpu;
    }

}

class Laptop extends Computer {
    private String display;

    public Laptop() {
        super("8GB", "Intel core i5 12450H", "512GB SSD");
        display = "144Hz 1080p AMOLED";
        System.out.println("Creating a Laptop");
    }

    public String toString() {
        return "Created a Laptop with " +super.toString() + " AND Display: " + this.display;
    }
}

class Server extends Computer {
    private String network;

    public Server() {
        super("32GB", "Intel Xeon", "4TB SSD");
        network = "1GBPS";
        System.out.println("Creating a Server");
    }

    public String toString() {
        return "Created a Server with " +super.toString() + " AND Network: " + this.network;
    }
}

interface AbstractFactory {
    public Computer getComputer();
}

class GamingPcAbstractFactory implements AbstractFactory {
    public GamingPc getComputer() {
        return new GamingPc();
    }
}

class LaptopAbstractFactory implements AbstractFactory {
    public Laptop getComputer() {
        return new Laptop();
    }
}

class ServerAbstractFactory implements AbstractFactory {
    public Server getComputer() {
        return new Server();
    }
}
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GamingPc gamingPc = new GamingPcAbstractFactory().getComputer();
        System.out.println(gamingPc.toString());

        Server server = new ServerAbstractFactory().getComputer();
        System.out.println(server.toString());

        Laptop laptop = new LaptopAbstractFactory().getComputer();
        System.out.println(laptop.toString());
    }
}
