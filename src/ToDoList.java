import java.io.BufferedReader;
import java.util.ArrayList;

public class ToDoList {
    public static final String ADD = "ADD";
    public static final String LIST = "LIST";
    public static final String EDIT = "EDIT";
    public static final String DELETE = "DELETE";
    public static ArrayList<String> myList = new ArrayList<>();

    public static void startList(String text){
        int index = checkIndex(text);
        if(text.contains(ADD)){
            add(text,index);
        }
        if(text.contains(LIST)){
            list();
        }
        if(text.contains(EDIT)){
            //EDIT();
        }
    }
    public static int checkIndex(String text){
        char symbol = text.charAt(text.lastIndexOf(" ") + 1);
        if(Character.isDigit(symbol)){
            int index = Integer.parseInt(text.substring(text.lastIndexOf(" ") + 1, text.length()));
            return index;
        }
        else return -1;
    }
    public static void add(String text, int index){
        int indexStart = text.lastIndexOf(ADD) + 4;
        System.out.println(index);
        if (index < 0) {
            text = text.substring(indexStart, text.length());
            myList.add(text);}
        else if (index > myList.size()){
            text = text.substring(indexStart,text.lastIndexOf(" ") + 1).trim();
            myList.add(text);
        }
        else {
            text = text.substring(indexStart,text.lastIndexOf(" ") + 1).trim();
            myList.add(index,text);}
        System.out.println("Добавлено дело \"" + text + "\"");
    }


    public static void edit(int index, String text){

    }

    public static void list(){
        StringBuilder tasks = new StringBuilder();
        for (int i = 0 ; i < myList.size(); i++){
            tasks.append(i).append(" - ").append(myList.get(i)).append("\r\n");
        }
        System.out.println(tasks);
    }


}
