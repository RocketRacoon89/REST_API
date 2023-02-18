package fileManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fileManager.model.File;
import net.bytebuddy.description.method.MethodDescription;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class TestClass {
    public static void main(String[] args) throws IOException {
//        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(FileEntity.class)
//                .addAnnotatedClass(UserEntity.class)
//                .addAnnotatedClass(EventEntity.class)
//                .buildSessionFactory();
////
//        Session session = sessionFactory.getCurrentSession();
////
//        try {
//            session.beginTransaction();
//            EventEntity eventEntity = session.get(EventEntity.class, 6);
//            session.delete(eventEntity);
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//            session.close();
//        }

//        UserRepo userRepo = new UserRepo();
//
//        System.out.println(userRepo.getAllUsers());
//        List<User> users = new ArrayList<>();
//
//        User user1 = new User();
//        user1.setId(1);
//        user1.setName("Ivan");
//
//        User user2 = new User();
//        user2.setId(2);
//        user2.setName("Oleg");
//
//        User user3 = new User();
//        user3.setId(3);
//        user3.setName("Vasya");
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
//
//
//


//        UserController userController = new UserController();
//
//        List<User> users = new ArrayList<>();
//        User user = userController.getByIdUser(11);
//        users.add(user);
//
//        String user_file_path = "src//main//resources//User.json";
//        File file = new File(user_file_path);
//        Gson gson = new GsonBuilder().create();
//
//        System.out.println(file.exists());
//
//        try (FileWriter writer = new FileWriter(user_file_path)){
//            gson.newBuilder().setPrettyPrinting().create();
//            gson.toJson(users, writer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



//        24
//        UserController userController = new UserController();
//        System.out.println(userController.createUser("Test4"));

//        8
//        FileController fileController = new FileController();
//        System.out.println(fileController.createFile("FileTest4", "PathTest4"));

//        8
//        EventController eventController = new EventController();
//        System.out.println(eventController.createEvent(24, 8));

//        String strId1 = "/File/1";
////        Long id = Long.parseLong(strId1.substring("/File/".length()));
////        Long id = Long.parseLong(strId1.substring("/File/".length()));
//        Integer id = Integer.parseInt(strId1.substring("/File/".length()));
//        System.out.println(id);

//        File file = new File("test1.txt");
//        System.out.println(file.getAbsolutePath());
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        String line = bufferedReader.readLine();
//        while (line!=null) {
//            System.out.println(line);
//            line = bufferedReader.readLine();
//        }

//        String test = "----------------------------476659906322780777193563Content-Disposition: form-data; name=\"name\"config400----------------------------476659906322780777193563Content-Disposition: form-data; name=\"filePath\"Y----------------------------\n" +
//                "476659906322780777193563--";
////        System.out.println(test.substring(1,2));
//        String rep = test.replace("-", " ");
//        System.out.println("");
//        System.out.println(rep);
//        System.out.println("");
//        String testName = test.substring(test.indexOf("\"name\"")+6);
//        testName = testName.substring(0, testName.indexOf("-"));
//        String testFilePath = test.substring(test.indexOf("\"filePath\"")+9);
//        testFilePath = testFilePath.substring(0, testFilePath.indexOf("-"));
//        System.out.println("TEST NAME "+testName);
//        System.out.println("TEST FILEPATH "+testFilePath);


//        String strId1 = "\"File\"15";
//        strId1 = strId1.substring("/File/".length());
//        int id = 0;
//        if(strId1.length()>0) {
//            id = Integer.parseInt(strId1);
//        }

//        System.out.println(id);

        StringBuilder result = new StringBuilder();
        URL url = new URL("http://localhost:8088/File/15");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        Gson gson = new Gson();
        File file = gson.fromJson(String.valueOf(result), File.class);

        System.out.println(file);
        }


    }

