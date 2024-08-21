//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StatickFila<Integer> pilhaQuerida = new StatickFila<>(5);

        pilhaQuerida.add(5);
        pilhaQuerida.add(8);
        pilhaQuerida.remove();
        pilhaQuerida.remove();
        System.out.println(pilhaQuerida.isEmpty());
        pilhaQuerida.add(5);
        pilhaQuerida.add(8);
        pilhaQuerida.add(5);
        pilhaQuerida.add(8);
        pilhaQuerida.add(5);
        System.out.println(pilhaQuerida.isEmpty());
        System.out.println(pilhaQuerida.isFull());
        pilhaQuerida.clear();
        System.out.println(pilhaQuerida.isEmpty());
    }
}