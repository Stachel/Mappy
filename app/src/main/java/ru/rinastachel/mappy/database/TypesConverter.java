package ru.rinastachel.mappy.database;


import java.util.Date;

import androidx.room.TypeConverter;
import ru.rinastachel.mappy.database.entity.table.TaskTable;

public class TypesConverter {

    @TypeConverter
    public long fromDate(Date date) {
        if (date == null) {
            return 0;
        }
        return date.getTime();
    }

    @TypeConverter
    public Date toDate(long time) {
        if (time == 0) {
            return null;
        }
        return new Date(time);
    }

    @TypeConverter
    public String fromPriority(TaskTable.Priority priority) {
        if (priority == null) {
            return TaskTable.Priority.NORMAL.name();
        }
        return priority.name();
    }

    @TypeConverter
    public TaskTable.Priority toPriority(String name) {
        try {
            return TaskTable.Priority.valueOf(name);
        } catch (IllegalArgumentException e) {
        }

        return TaskTable.Priority.NORMAL;
    }
}
