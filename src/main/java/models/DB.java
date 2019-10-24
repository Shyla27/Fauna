package models;
import org.sql2o.*;

public class DB {
// { public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlifetracker", "mark", "87654321");
//}

  public static  String connectionString = "jdbc:postgresql://ec2-50-19-222-129.compute-1.amazonaws.com:5432/d4u68thdat4ll4";
    public static Sql2o sql2o = new Sql2o(connectionString, "zesfdioldbnxyt", "3be5d3004b9c8520819d19a3baba4b3334cec7f9dfd0950e7a371e56d8e297c7");
}