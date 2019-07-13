package Utilities;

import com.mysql.cj.jdbc.PreparedStatement;

import java.sql.*;
import java.util.*;

public class MySQLJDBC {
    private static Connection connection;

    private static Statement statement;

    private static ResultSet resultSet;


    public static void establishConnection() throws SQLException {

        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/medet2DBx5bqh?serverTimezone="+ TimeZone.getDefault().getID(),
                "medet2DBx5bqh","dh9KWht3FQ");

    }

    public static PreparedStatement prepareStatement(String querry) throws SQLException {


        return (PreparedStatement) connection.prepareStatement(querry);
    }

    public static List<Map<String,Object>> runSQLQuery(String query) throws SQLException{

        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        resultSet=statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        int columnCount = resultSetMetaData.getColumnCount();

        List<Map<String,Object>> dbData=new ArrayList<>();

        while(resultSet.next()){
            Map<String,Object> rowMap=new HashMap<>();
            for(int i=1;i<=columnCount; i++){
                rowMap.put(resultSetMetaData.getColumnName(i),
                        resultSet.getObject(resultSetMetaData.getColumnName(i)));
            }
            dbData.add(rowMap);
        }
        return dbData;
    }

    public static boolean runInsertQuery(String query) throws SQLException{

        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        return statement.execute(query);

//        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

//        int columnCount = resultSetMetaData.getColumnCount();

       // List<Map<String,Object>> dbData=new ArrayList<>();

//        while(resultSet.next()){
//            Map<String,Object> rowMap=new HashMap<>();
//            for(int i=1;i<=columnCount; i++){
//                rowMap.put(resultSetMetaData.getColumnName(i),
//                        resultSet.getObject(resultSetMetaData.getColumnName(i)));
//            }
//            dbData.add(rowMap);
//        }

    }

    public static void closeConnections() throws SQLException{
        if(connection!=null){
            connection.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }

    }

    public static int rowCount(String query) throws SQLException{

        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        resultSet=statement.executeQuery(query);
        ResultSet resultSet1=resultSet;

        resultSet1.last();

        int numberOfRow= resultSet1.getRow();

        return numberOfRow;
    }

    }




