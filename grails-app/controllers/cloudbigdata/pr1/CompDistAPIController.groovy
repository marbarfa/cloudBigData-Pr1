package cloudbigdata.pr1

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import grails.converters.JSON

class CompDistAPIController {

    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

    def index() {
        def strBusqueda = params.busqueda;
    }

    def getMasPosts() {
        def strBusqueda = params.busqueda;


        def res;
        try {
            Class.forName(driverName);
            Connection con = DriverManager.getConnection("jdbc:hive://localhost:10000/default", "", "");
            Statement stmt = con.createStatement();
            String tableName = "comments";
            res = stmt
                    .executeQuery(
                    "select sub.user_id, sub.p from " +
                    " (select user_id, count(1) as p " +
                    "  from comments " +
                    "  where text like '%${strBusqueda}%' " +
                    "  group by postid, user_id) sub " +
                    "order by sub.p " +
                    "desc limit 1")

            if (res.next()) {
                def usr = res.getString(1)
                def posts = res.getString(2)
                render(['busqueda': strBusqueda, 'user': usr, 'cantidad_posts': posts] as JSON)
            }
        } catch (Throwable t) {
            System.out.println("Error ${t.getStackTrace()}")
            render(['busqueda': strBusqueda, 'error': t.getStackTrace()] as JSON)
        }
    }
}




