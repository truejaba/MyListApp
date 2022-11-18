import java.io.BufferedReader;
import java.util.ArrayList;

public class ToDoList {
    public static final String ADD = "ADD";
    public static final String LIST = "LIST";
    public static final String EDIT = "EDIT";
    public static final String DELETE = "DELETE";
    public static ArrayList<String> myList = new ArrayList<>();

    public static void startList(String text){
        if(text.isBlank()){return;}
        text = text.trim();
        int index = checkIndex(text);
        if(text.contains(ADD)){
            add(text,index);
        }
        if(text.contains(LIST)){
            list();
        }
        if(text.contains(EDIT)){
            edit(text);
        }
        if(text.contains(DELETE)){
            delete(index, text);
        }
    }
    public static int checkIndex(String text){
        char symbol = text.charAt(text.lastIndexOf(" ") + 1);
        if(Character.isDigit(symbol)){
            return Integer.parseInt(text.substring(text.lastIndexOf(" ") + 1, text.length()));
        }
        else return -1;
    }

    public static void add(String text, int index){
        if (text.equals(ADD)){return;}
        int indexStart = text.lastIndexOf(ADD) + 4;
        if (index >= 0 && index <= myList.size()) {
            text = text.substring(indexStart, text.lastIndexOf(" ") + 1).trim();
            myList.add(index,text);
        }
        if(index < 0){text = text.substring(indexStart, text.length()).trim(); myList.add(text);}
        if(index > myList.size()) {text = text.substring(indexStart, text.lastIndexOf(" ") + 1).trim(); myList.add(text);}
        System.out.println("Добавлено дело \"" + text + "\"");
    }


    public static void edit(String text){
        if (text.equals(EDIT)){return;}
        int positionNumber = -1;
        int indexStart = text.indexOf(" ") + 1;
        if(Character.isDigit(text.charAt(indexStart))) {
            int indexEnd = text.indexOf(" ", indexStart);
            if(indexEnd > 0){
            String position = text.substring(indexStart, indexEnd);
            positionNumber = Integer.parseInt(position);
        }}
        else {return;}
        if(positionNumber < myList.size() && positionNumber >= 0 ){
            String message = text.substring((text.indexOf((" "),indexStart) + 1), text.length());
            myList.set(positionNumber, message);
        }
        else {return;}
    }

    public static void list(){
        StringBuilder tasks = new StringBuilder();
        for (int i = 0 ; i < myList.size(); i++){
            tasks.append(i).append(" - ").append(myList.get(i)).append("\r\n");
        }
        System.out.println(tasks);
    }
    public static void delete(int index, String text){
        if (text.equals(DELETE) || index >= myList.size() || index < 0){return;}
        myList.remove(index);
    }

}
