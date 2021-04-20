import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class sayQuotes {
    long cool=7200000;
    int size;
    String  file = "quotes.txt";
    List<String> quotes=new ArrayList<String>();
    void load() throws FileNotFoundException, IOException {
        FileReader fr=new FileReader("C:\\Users\\LUCKY\\IdeaProjects\\sxc\\src\\quotess.txt");
        BufferedReader br=new BufferedReader(fr);
        String l,l1;
        while((l=br.readLine())!=null)
        {
            l1= br.readLine();
            quotes.add(l + ((!l1.equals(""))? "  ~" + l1:""));
        }
        size=quotes.size();
    }

    void display() throws IOException {
        Ginko g = new Ginko();
        Random r=new Random();
        String current;
        int i=0;
          /* quotes.forEach((a,b)-> {
            //g.sendMessage(b + ((!a.equals(""))? "  ~" + a:""));
              System.out.println(b + ((!a.equals(""))? "  ~" + a:""));
            try {
                Thread.sleep(cool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });  */
        while(true)
        {
            current=quotes.get(r.nextInt(size-1));
            System.out.println(++i+"\t"+current);
            g.sendMessage(current);
            try {
                Thread.sleep(cool);
            }
            catch(InterruptedException e)
            {
                System.out.println("fuck");
            }
        }


    }

    public static void main(String args[]) throws IOException {
        sayQuotes q=new sayQuotes();
        q.load();
        q.display();
    }
}
