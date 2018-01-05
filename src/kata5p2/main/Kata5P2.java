package kata5p2.main;

import java.io.IOException;
import java.util.List;
import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailHistogramBuilder;
import kata5p2.view.MailListReader;

public class Kata5P2 {

    private String fileName;
    private Histogram<String> histogram;
    private List<Mail> mailList;
    private HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws IOException {
        Kata5P2 kata4 = new Kata5P2();
        kata4.execute();
    }
    
    public void input() throws IOException {
        fileName = "C:\\Users\\Home\\Downloads\\emails.txt";
        mailList = MailListReader.read(fileName);
    }
    
    public void process() {
         histogram = MailHistogramBuilder.build(mailList);
    }
    
    public void output() {
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    public void execute() throws IOException {
        input();
        process();
        output();
    }
}