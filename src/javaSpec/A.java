package javaSpec;

public class A {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class B extends A{

    public B (){
        setName("testName");
        System.out.println(getName());
    }
}

class C{

    public String getName(){
        return "testName666";
    }
    public String getName(String name){
        return name;
    }
}