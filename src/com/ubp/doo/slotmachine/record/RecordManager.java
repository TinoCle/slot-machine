package com.ubp.doo.slotmachine.record;

import java.util.List;

public class RecordManager implements java.io.Serializable {
    List<Record> records;
    RecordPersistance recordSaver;

    public void saveRecord(int betAmount, List<String> reelsResult, String gameResult){
        Record record = new Record(betAmount, reelsResult, gameResult);
        records.add(record);
        recordSaver.Serialize(records);
    }

    public List<Record> showRecord(){
        return this.records;
    }

    public void showRecords(){
        if (this.showRecord() != null) {
            //Leo la size primero para que salte la excepción antes que nada
            int x = records.size();
            System.out.println("Record nº\tBetAmount\tResult\tReels\n");
            for (int i = 0; i < x; i++) {
                System.out.println(i+"\t"+records.get(i).getBetAmount()+"\t"+records.get(i).getGameResult()+"\t"+records.get(i).getReelResults()+"\n");
            }
        } else {
            System.out.println("No existen records para leer.");
        }
    }
}
