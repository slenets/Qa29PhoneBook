package apiContact.utils;

import apiContact.dto.Contact;
import apiContact.dto.UserData;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUtil {

    @DataProvider
    public Iterator<Object[]> invalidEmailPasswordProvider400() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/testdata/userdata.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] data = line.split(",");
                UserData user = UserData.builder()
                        .email(data[0]).password(data[1]).build();
                list.add(new Object[]{user});

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> validNonRegisteredCredentials401(){
        List<Object[]> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/testdata/valid_non_registered_credentials.txt"));
            String line = br.readLine();
            while(line != null){
                String[] strings = line.split(",");
                UserData data = UserData.builder()
                        .email(strings[0])
                        .password(strings[1]).build();
                list.add(new Object[]{data});
                line = br.readLine();
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return list.iterator();
    }

    @DataProvider()
    public Object[][] emailPassword400() {
        return new Object[][]{
                {"aaa.a", "Asaa123$"},
                {"aa@a.aa", "aaas123$"},
                {"a@aa.aa", "AAAA123$"},
                {"a@aa.aa", "AAa123$"},
                {"a@aa.aa", "AAAAssddw$"},
                {"a@aa.aa", "AAAAssddw1"},
                {"sfg@sdg.ase", ""}};
    }

    @DataProvider()
    public Object[][] validNonExistentEmailPassword() {
        return new Object[][]{
                {"ssd@ga.com", "assaA452$"},
                {"a1@b1.ru", "Assw000$$$"},
                {"sfg@sdg.ase", "AAbb3'$'"}};
    }

    @DataProvider
    private Iterator<Object[]> contactDataWithEmptyField() {
        List<Object[]> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/testdata/contactData.txt"));
            String line = br.readLine();
            while (line != null) {
                String[] strings = line.split(",");
                Contact contact = Contact.builder()
                        .id(0)
                        .name(strings[0])
                        .lastName(strings[1])
                        .email(strings[2])
                        .phone(strings[3])
                        .address(strings[4])
                        .description(strings[5]).build();
                list.add(new Object[]{contact});
                line = br.readLine();
                //br.flush() deletes the contents of the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.iterator();
    }

    @DataProvider
    private Iterator<Object[]> contactIdProvider(){
        List<Object[]> list = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/test/java/testdata/contactId.txt"));
            String line = br.readLine();
            while (line != null){
                String[] strings = line.split(",");
                Integer id = Integer.parseInt(strings[0]);
                list.add(new Object[]{id});
                line = br.readLine();
            }
            br.close();
        }catch(IOException e){
            String s = e.getMessage();
            //Write own message using log4j logger
        }
        return list.iterator();
    }

    public static void writeContactIdToFile(Integer id) {
        BufferedWriter bw = null;
        String file = "src/test/java/testdata/contactId.txt";
        String idStr = String.valueOf(id);
        try {
            bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(String.valueOf(idStr));
            bw.newLine();
            System.out.println("File written Successfully");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //To do -> write a reader for contactid.txt to delete all contacts by id test
    // BufferedWriter flush()
    public static void deleteContactIdsFromFile(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/test/java/testdata/contactId.txt"));
            bw.flush();
            bw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}













