package se.util.core.teachers;

public class Teacher{


    private final String name;
    private final String url;
    private final String codeRef;


    public  Teacher(){

        name=null;
        url = null;
        codeRef=null;

    }

    public Teacher(String name, String url, String codeRef) {
        this.name = name;
        this.url = url;
        this.codeRef = codeRef;
    }
}