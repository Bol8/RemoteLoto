package Configuration;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Oscar on 18/10/2016.
 */

public class DatabaseConfigUtil extends OrmLiteConfigUtil {


    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt");
    }

}
