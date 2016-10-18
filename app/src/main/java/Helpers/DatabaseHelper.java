package Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.app.oscar.pruebadescargafichero.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import POJO.Combination;

/**
 * Created by Oscar on 18/10/2016.
 * Esta clase es utilizada para administrar la creación y actualización de la base de datos.
 * Esta clase usualmente proporciona las clase DAO(Patrón de diseño Data Acces Objet).
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME= "combinaciones.db";
    private static final int DATABASE_VERSION = 1;


    //Objeto DAO que se utilizarán para acceder a la tabla Contacto.
    private Dao<Combination,Integer> combinationDAO = null;
    private RuntimeExceptionDao<Combination,Integer> combinationRuntimeDAO = null;

    public DatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        //TODO: Al finalizar el helper crear un fichero de configuración ORMLite
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {

        try {
            Log.i(DatabaseHelper.class.getSimpleName(),"onCreate");
            TableUtils.createTable(connectionSource,Combination.class);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(DatabaseHelper.class.getSimpleName(),"Imposible crear la Db",e);
            throw new RuntimeException(e);
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int i, int i1) {

        try {
            Log.i(DatabaseHelper.class.getSimpleName(),"onUpdate");
            TableUtils.dropTable(connectionSource,Combination.class,true);

            //Depués de eliminar las tablas anteriores, creamos nuevamente la Bd.
            onCreate(db,connectionSource);

        } catch (SQLException e) {
            e.printStackTrace();
            Log.e(DatabaseHelper.class.getSimpleName(),"Imposible actualizar la Db",e);
            throw new RuntimeException(e);
        }


    }

    public Dao<Combination, Integer> getCombinationDAO() throws SQLException {
        if(combinationDAO == null) combinationDAO = getDao(Combination.class);
        return combinationDAO;
    }

    public RuntimeExceptionDao<Combination, Integer> getCombinationRuntimeDAO() {
        if(combinationRuntimeDAO == null) combinationRuntimeDAO = getRuntimeExceptionDao(Combination.class);
        return combinationRuntimeDAO;
    }

    @Override
    public void close() {
        super.close();
        combinationDAO = null;
        combinationRuntimeDAO = null;
    }
}
