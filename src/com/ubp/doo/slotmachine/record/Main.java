package com.ubp.doo.slotmachine.record;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RecordManager recordManager = new RecordManager();
        //Leo los records de entrada, me va a decir que no hay nada
        //recordManager.showRecords();
        //Creo un record y lo guardo
        List<String> resultados = new ArrayList<>();
        resultados.add("Fruta");
        resultados.add("Fruta");
        resultados.add("Fruta");
        recordManager.saveRecord(5,100, resultados,"Ganaste un 0km");
        //Ahora si me tiene que mostrar lo que guarde
        recordManager.showRecords();
    }
}
