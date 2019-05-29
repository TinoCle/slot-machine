package com.ubp.doo.slotmachine.record;

import java.io.*;
import java.util.List;

public class RecordPersistance {
    public void Serialize(List<Record> records) {
        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir"));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(records);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in "+System.getProperty("user.dir"));
        }
        catch (Exception ex){
             System.out.println(ex.getMessage());
        }
    }
    public List<Record> Deserialize(){
        try{
            FileInputStream fileIn= new FileInputStream(System.getProperty("user.dir"));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Record> records = (List<Record>) in.readObject();
            in.close();
            fileIn.close();
            return records;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}