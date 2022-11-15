import java.util.Scanner;

public class Main {
    public static final String ADD = "ADD";
    public static final String LIST = "LIST";
    public static final String EDIT = "EDIT";
    public static final String DELETE = "DELETE";
    public static String command;
    public static void main(String[] args) {
        while (true) {
            command = new Scanner(System.in).nextLine();

            if (command.contains(ADD)) {
                String text = "";
                char index = command.charAt(command.lastIndexOf(" ")+1);
                if(Character.isDigit(index)){
                    text = command.substring(command.lastIndexOf(ADD)+3, command.lastIndexOf(" "));
                    String number = command.substring(command.lastIndexOf(" ")+1, command.length());
                    int position = Integer.parseInt(number);
                    System.out.println(ToDoList.add(text.trim(),position));
                }
                else {text = command.substring(command.lastIndexOf(ADD)+3, command.length());
                    System.out.println(ToDoList.add(text.trim()));}
            }
            if (command.contains(LIST)) {
                System.out.println(ToDoList.list());
            }

        }
    }
}