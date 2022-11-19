import java.util.HashSet;

public class EmailList {
    static HashSet<String> myEmailList = new HashSet<>();
    public static void startList(String text){
        if(text.isBlank()){return;}
        text = text.trim();
        if(text.contains(ToDoList.ADD)){EmailList.add(text);}
        if(text.contains(ToDoList.LIST)){EmailList.list(text);}

    }
    public static void add(String text){
        if(text.equals(ToDoList.ADD)){return;}
        text = text.substring(text.indexOf("ADD") + 4, text.length());
        String regex = "[A-Za-z0-9-_]+@[a-z]+\\.[a-z]+";
        if(text.matches(regex)){myEmailList.add(text);}
        else System.out.println("Неверно введен email");;
    }
    public static void list(String text){
        System.out.println(myEmailList);
    }

}
