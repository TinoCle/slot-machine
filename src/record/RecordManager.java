package record;

import java.util.List;

public class RecordManager {
    List<Record> records;


    public void onRecordSaved(Record rec){
        record.add(rec);
    }

    public List<Record> showRecord(){
        return this.records;
    }

}
