package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator < Object[]>addNewContact(){
        List <Object[]>list = new ArrayList<>();

        list.add(new  Object[]{"Oliver" , "Yas", "2345346789", "ga@gmail.com", "texas", "QA"});
        list.add(new  Object[]{"Oliver3" , "Yas3", "2349874589", "ga@gmail.com", "texas", "QA"});
        list.add(new  Object[]{"Oliver2" , "Yas2", "28765566789", "ga@gmail.com", "texas", "QA"});
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> addNewContactWithCsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader("src/test/resources/Contact.csv"));
        String line = reader.readLine();
        while (line != null) {
            if (!line.trim().isEmpty()) {
                String[] split = line.split(",");
                if (split.length >= 6) {
                    list.add(new Object[]{new Contact()
                            .setName(split[0])
                            .setLastName(split[1])
                            .setPhone(split[2])
                            .setEmail(split[3])
                            .setAddress(split[4])
                            .setDescription(split[5])});
                } else {
                    System.err.println("⚠️ Пропущена строка: " + line);
                }
            }
            line = reader.readLine();
        }
        return list.iterator();
    }
}
