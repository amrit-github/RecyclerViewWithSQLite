package com.example.amrit.recyclerviewwithdatabase;

import android.provider.BaseColumns;

public class ModelContract {

    private ModelContract(){
    }

    public static final class ModelEntry implements BaseColumns{
        public static final String TABLE_NAME = "dataTable";
        public static final String HELLO_COLUMN = "helloColumn";
        public static final String NUMBER_COLUMN = "numberColumn";
    }
}
