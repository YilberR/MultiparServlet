package co.edu.unbosque.multipartservlet.multiparservlet;

import java.util.ArrayList;

public class CSV {
    ArrayList<String> array;
    public CSV(){
        array= new ArrayList<>();
        array.add("admin@outlook.com");
        array.add("admin");
        array.add("funcionario");
        array.add("prop@outlook.com");
        array.add("prop");
        array.add("propietario");

    }

    public ArrayList<String> getArray() {
        return array;
    }

    public void setArray(ArrayList<String> array) {
        this.array = array;
    }
}

