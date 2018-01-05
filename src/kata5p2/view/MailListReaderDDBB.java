package kata5p2.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderDDBB {
    
    public static List<Mail> read(String fileName) throws ClassNotFoundException, SQLException {
        List<Mail> mailList = new ArrayList<>();
        
        Class.forName("org.sqlite.JDBC");
        Connection connect = DriverManager.getConnection("jdbc:sqlite:" + fileName);
        
        Statement st = connect.createStatement();
        
        String query = "SELECT * FROM mail";
        
        ResultSet result = st.executeQuery(query);
        
        while (result.next()) {
            mailList.add(new Mail(result.getString(2)));
        }
        
        st.close();
        result.close();
        connect.close();
        
        return mailList;
    }
}