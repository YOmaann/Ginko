import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

// import java.io.InputStream;

/* mehnat done by luckyfur
 *  huhuhuhuhuhu */


class Ginko
{
    String url="https://discord.com/api/webhooks/833992535126310972/CiYsvNxVha5B504Du3MwuUjXk8FkGGY4nCcBe6Y3Ns6Ik-EaUnVD7UmvmK9YRLPTuqtG";  // https://httpbin.org/anything --> use this to debug
    URL a;
    HttpURLConnection b;
    Ginko() throws IOException {
        a=new URL(url);
    }
void sendMessage(String send)   //use this function to write
{
    String tmp="{\"content\":\""+send+"\"}";
    int aa;
    try {
        byte[] tempBytes = tmp.getBytes("utf-8");
        b=(HttpURLConnection)a.openConnection();
        b.setDoOutput(true);
        b.setRequestProperty("Content-Type","application/json");
        b.setRequestMethod("POST");
        b.setRequestProperty("Accept","application/json");
        b.connect();
        OutputStream o=b.getOutputStream();
        o.write(tempBytes);
        InputStream i=b.getInputStream();            //uncomment to debug
        while((aa=i.read())>0)
        {
            System.out.print((char)aa);
        }
        b.disconnect();
    } catch (ProtocolException e) {
        System.out.println("ab ye kya bawasir h");
    } catch (UnsupportedEncodingException e) {
        System.out.println("ni hoga merese kuch");
    } catch (IOException e) {
        System.out.println("luss ho gya vro");
    }

}

void test()throws IOException   //a tatti interface to message
{
    String st;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    while(true)
    {
        System.out.println("input>>");
        st=br.readLine();
        if(st.equals("exit"))
            break;
        sendMessage(st);
    }
  }
}

/* Ginko ob=new Ginko();
   ob.sendMessage("insert string here");
 */

