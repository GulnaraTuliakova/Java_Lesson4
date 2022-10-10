import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class lesson_4 {
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        ArrayList<String[]> name = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        LinkedList<Integer> id = new LinkedList<>();

        boolean lr = true;
        while (lr) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user name (Ivanov Ivan Ivanovich): ");
            name.add(sc.nextLine().split(" "));

            System.out.println("Is user man or woman: ");
            sex.add(sc.nextLine());

            System.out.println("Enter user age: ");
            age.add(Integer.parseInt(sc.nextLine()));
            id.add(name.size() - 1);

            System.out.println("User name: " +
                    name.get(name.size() - 1)[0] + " " +
                    name.get(name.size() - 1)[1].toUpperCase().charAt(0) + "." +
                    name.get(name.size() - 1)[2].toUpperCase().charAt(1) + ". " +
                    "User id: " + name.get(id.size() - 1).hashCode());
        
            System.out.println("New user? Y/N ");
            
            if (sc.nextLine().contains("N")) lr = false;
        }
        
        id.forEach(n -> System.out.println("User name: " +
                name.get(n)[0] + " " +
                name.get(n)[1].toUpperCase().charAt(0) + "." +
                name.get(n)[2].toUpperCase().charAt(0) + ". " +
                "User id: " + name.get(id.size() - 1).hashCode()));
        System.out.println();

        int cnt = id.size() - 1;
        while (cnt > -1) {
            int maxAge = age.get(id.get(cnt));
            int index = cnt;

            for (int i = 0; i < cnt; i++) {
                int j = id.get(i);
                if (maxAge < age.get(id.get(i))) {
                    index = i;
                    maxAge = age.get(id.get(i));
                }
            }
            int tmp = id.get(index);
            id.set(index, id.get(cnt));
            id.remove(cnt);
            id.add(tmp);
            cnt--;
        }
        id.forEach(n -> System.out.println("User: " +
                name.get(n)[0] + " " +
                name.get(n)[1].toUpperCase().charAt(0) + "." +
                name.get(n)[2].toUpperCase().charAt(0) + "." +
                " age=" + age.get(n) + " is a " + sex.get(n) + " id: " + name.get(n).hashCode()));
    }
}
