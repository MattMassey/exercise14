import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 016308 on 5/1/2019.
 */
public class Main {
    static ToDo task1;
    static ToDo task2;

    public static void main(String[] args) {
        deserializeToDos();
        serializeToDo();
    }

    static void serializeToDo() {

        Gson gson = new Gson();
        ToDo[] taskList = {task1, task2};

        try {
            FileWriter writer = new FileWriter("data.json");
            gson.toJson(taskList,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserializeToDos() {

        String jsonObj1 = "{\"body\": \"Walk the dog\"," +
                " \"done\": false, \"id\": 0, \"priority\":" +
                " 3, \"title\": \"dog\"}";
        String jsonObj2 = "{\"body\": \"Pay the bills\"," +
                "\"done\": false,\"id\": 1,\"priority\": 1," +
                "\"title\": \"bills\"}";

        Gson gson = new Gson();
        task1 = gson.fromJson(jsonObj1, ToDo.class);
        task2 = gson.fromJson(jsonObj2,ToDo.class);
        System.out.println(task1);
        System.out.println(task2);
    }

}

class ToDo {
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public ToDo(String body, boolean done, int id, int priority, String title) {
        this.body = body;
        this.done = done;
        this.id = id;
        this.priority = priority;
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "body='" + body + '\'' +
                ", done=" + done +
                ", id=" + id +
                ", priority=" + priority +
                ", title='" + title + '\'' +
                '}';
    }
}
