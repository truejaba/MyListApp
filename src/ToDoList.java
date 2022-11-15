import java.util.ArrayList;

public class ToDoList {
    public static ArrayList<String> myList = new ArrayList<>();

    public static String add(String value){
        myList.add(value);
        return "Добавлено дело \"" + value + "\"";
    }

    public static String add(String value,int index){
        if (index > myList.size()){add(value);}
        else {myList.add(index, value);}
        return "Добавлено дело \"" + value + "\"";
    }

    public static void edit(int index, String text){

    }

    public static StringBuilder list(){
        StringBuilder tasks = new StringBuilder();
        for (int i = 0 ; i < myList.size(); i++){
            tasks.append(i).append(" - ").append(myList.get(i)).append("\r\n");
        }
        return tasks;
    }


}
