package com.example.md3;

import android.app.Application;
import android.content.Context;

import com.example.md3.datas.SearchHistory;
import com.orm.androrm.DatabaseAdapter;
import com.orm.androrm.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 德祥 on 2015/6/30.
 *
 * 程序入口，在这里做数据库初始化工作
 *
 */
public class MD3Application extends Application {
    private static MD3Application sAppContext;

    public void onCreate() {
        super.onCreate();
        sAppContext = this;
        initializeDatabase();
    }

    public static Context getContext() {
        return sAppContext;
    }

    /**
     * 初始化数据库
     */
    private void initializeDatabase() {
        List<Class<? extends Model>> models = new ArrayList<>(0);
        models.add(SearchHistory.class);
        String dbName = this.getResources().getString(R.string.database_name);
        DatabaseAdapter.setDatabaseName(dbName);
        DatabaseAdapter adapter = new DatabaseAdapter(sAppContext);
        adapter.setModels(models);
    }
}
