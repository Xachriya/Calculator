package CIS2206.Unit_13;

/**
 * Tower of Hanoi
 *
 * @author Ilias Tachmazidis
 * @version September 2022
 */
import java.util.Stack;


public class TowerOfHanoi {

    // Number of disks
    public static int numOfDisks = 3;

    static Stack<Integer> stackA = new Stack();
    static Stack<Integer> stackB = new Stack();
    static Stack<Integer> stackC = new Stack();

    public static void main(String[] args) {

        // Push disks into first tower
        for (int i = numOfDisks; i > 0; i--) {
            stackA.push(i);
        }

        printTowers();
        move(numOfDisks, stackA, stackB, stackC);
    }

    /**
     * Solve Hanoi Tower
     *
     * @param n Disk to be moved
     * @param source Stack indicating the source
     * @param destination Stack indicating the destination
     * @param auxiliary Stack used as middle point
     */
    public static void move(int n,
                            Stack<Integer> source,
                            Stack<Integer> destination,
                            Stack<Integer> auxiliary) {
        if (n > 0) {
            move(n - 1, source, auxiliary, destination);
            int tmp = source.pop();
            auxiliary.push(tmp);
            printTowers();
            move(n - 1, destination, source, auxiliary);
        }
    }


    /**
     * Print Towers
     */
    public static void printTowers() {

        System.out.println("  A  |  B  |  C");
        System.out.println("---------------");

        for (int i = numOfDisks - 1; i >= 0; i--) {
            String a = " ", b = " ", c = " ";

            if (i < stackA.size()) {
                a = "" + stackA.get(i);
            }
            if (i < stackB.size()) {
                b = "" + stackB.get(i);
            }
            if (i < stackC.size()) {
                c = "" + stackC.get(i);
            }

            System.out.println("  " + a + "  |  " + b + "  |  " + c);
        }
        System.out.println("\n");
    }
}
