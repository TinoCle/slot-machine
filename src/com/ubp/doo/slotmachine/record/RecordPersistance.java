package com.ubp.doo.slotmachine.record;

import java.io.*;
import java.util.List;

public class RecordPersistance {
    private String fileName;

    public RecordPersistance() {
        fileName = "/records.dat";
    }

    public void Serialize(List<Record> records) {
        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(records);
            out.close();
            fileOut.close();
            //System.out.println("Serialized data is saved in "+System.getProperty("user.dir") + fileName);
        }
        catch (Exception ex){
             System.out.println(ex);
        }
    }
    public List<Record> Deserialize() throws IOException, ClassNotFoundException {
        try{
            FileInputStream fileIn= new FileInputStream(System.getProperty("user.dir") + fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Record> records = (List<Record>) in.readObject();
            in.close();
            fileIn.close();
            return records;
        }
        catch (FileNotFoundException e){
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        }
    }
}