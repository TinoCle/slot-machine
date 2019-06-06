package com.ubp.doo.slotmachine.record;

import java.util.ArrayList;
import java.util.List;

public class RecordManager implements java.io.Serializable {
    List<Record> records;
    RecordPersistance recordSaver;

    public RecordManager() {
        records = new ArrayList<>();
        recordSaver = new RecordPersistance();
        try {
            records = recordSaver.Deserialize();
        }
        catch (Exception e) {
            System.out.println("Error al cargar el archivo de records.");
        }
    }

    public void saveRecord(int betAmount, List<Integer> reelsResult, String gameResult){
        Record record = new Record(betAmount, reelsResult, gameResult);
        records.add(record);
        recordSaver.Serialize(records);
    }

    public List<Record> showRecord(){
        return this.records;
    }

    public void showRecords(){
        if (records.size() > 0) {
            System.out.println("Record nº\tBetAmount\tResult\tReels");
            for (int i = 0; i < records.size(); i++) {
                System.out.println(i+"\t\t\t"+records.get(i).getBetAmount()+"\t\t\t"+records.get(i).getGameResult()+"\t"+records.get(i).getReelResults());
            }
        } else {
            System.out.println("No hay records guardados.");
        }
    }
}
