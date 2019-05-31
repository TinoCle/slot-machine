package com.ubp.doo.slotmachine.record;

import java.util.List;

public class RecordManager implements java.io.Serializable {
    List<Record> records;
    RecordPersistance recordSaver;

    public RecordManager() {
        //aca deberia leer de memoria persistente los records
        records = recordSaver.Deserialize();
    }

    public void saveRecord(int betAmount, List<String> reelsResult, String gameResult){
        Record record = new Record(betAmount, reelsResult, gameResult);
        records.add(record);
        recordSaver.Serialize(records);
        //aca se ejecutaria la sentencia que lo guarda en memoria persistente
    }

    public List<Record> showRecord(){
        return this.records;
    }

    public void showRecords(){
        System.out.println("Record nº\tBetAmount\tResult\tReels\n");
        for (int i = 0; i < records.size(); i++) {
            System.out.println(i+"\t"+records.get(i).getBetAmount()+"\t"+records.get(i).getGameResult()+"\t"+records.get(i).getReelResults()+"\n");
        }
    }

}
