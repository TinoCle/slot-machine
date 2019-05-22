package com.ubp.doo.slotmachine.record;

import java.util.List;

public class RecordManager {
    List<Record> records;

    public RecordManager() {
        //aca deberia leer de memoria persistente los records
    }

    public void saveRecord(int betAmount, List<String> reelsResult, String gameResult){
        Record record = new Record(betAmount, reelsResult, gameResult);
        records.add(record);
        //aca se ejecutaria la sentencia que lo guarda en memoria persistente
    }

    public List<Record> showRecord(){
        return this.records;
    }

}
