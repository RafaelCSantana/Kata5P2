package kata5p2.main;

import java.sql.SQLException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReaderDDBB;

public class Kata5P2 {

    private String fileName;
    private Histogram<String> histogram;
    private List<Mail> mailList;
    private HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Kata5P2 kata5 = new Kata5P2();
        kata5.execute();
    }
    
    public void input() throws ClassNotFoundException, SQLException {
        fileName = "C:\\Users\\Home\\Documents\\NetBeansProjects\\Kata5P2\\KATA.sDB";
        mailList = MailListReaderDDBB.read(fileName);
    }
    
    public void process() {
         histogram = MailHistogramBuilder.build(mailList);
    }
    
    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    public void execute() throws ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
}