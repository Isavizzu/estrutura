//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StatickStack<Integer> pilhaQuerida = new StatickStack<>(5);

        pilhaQuerida.push(5);
        pilhaQuerida.push(8);
        pilhaQuerida.pop();
        pilhaQuerida.pop();
        System.out.println(pilhaQuerida.isEmpty());
        pilhaQuerida.push(5);
        pilhaQuerida.push(8);
        pilhaQuerida.push(5);
        pilhaQuerida.push(8);
        pilhaQuerida.push(5);
        System.out.println(pilhaQuerida.isEmpty());
        System.out.println(pilhaQuerida.isFull());
        pilhaQuerida.clear();
        System.out.println(pilhaQuerida.isEmpty());
    }
}