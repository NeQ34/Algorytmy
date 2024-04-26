package lib;

public class Main {
    public static void main(String[] args) {
        partA();
    }
    public static void partA(){
        TaskManager man = new TaskManager();
        man.addTask("eat");
        man.addTask("sleep");
        man.addTask("code");
        man.addTask("repeat");
        System.out.println(man);

        man.deleteTask();
        man.deleteTask();
        System.out.println(man);
    }
}
