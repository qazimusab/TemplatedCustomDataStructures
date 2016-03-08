import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by qazimusab on 3/5/16.
 */
@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>(stringComparor);
        binarySearchTree.insert("1");
        binarySearchTree.insert("2");
        binarySearchTree.insert("3");
        binarySearchTree.insert("4");
        binarySearchTree.insert("5");
        binarySearchTree.insert("6");
        binarySearchTree.insert("7");
        System.out.println(binarySearchTree.size());
    }

    public static BinarySearchTree.Comparor<Integer> integerComparor = (dataInCurrentNode, dataToCompare) -> {
        if (dataToCompare > dataInCurrentNode) {
            return 1;
        } else if (dataToCompare < dataInCurrentNode) {
            return -1;
        } else {
            return 0;
        }
    };


    public static BinarySearchTree.Comparor<String> stringComparor = (dataInCurrentNode, dataToCompare) -> dataInCurrentNode.compareTo(dataToCompare);

    public static double angleBetweenHourAndMinuteHands(int hour, int minute) {
        double minuteAngleFrom12oClockPivot = minute * 6;
        double hourAngleFrom12oClockPivot = 30 * (hour % 12) + .5 * minute;
        return Math.abs(hourAngleFrom12oClockPivot - minuteAngleFrom12oClockPivot);
    }

    public static int[][] initializeRandom(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = (int)(Math.random()*10);
            }
        }
        return temp;
    }

    public static boolean areAllCharactersUniqueWithArrayList(String string) {
        if(string == null || string.equals("")) {
            return false;
        }
        if(string.length() > 256) {
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(char c: string.toCharArray()){
            if(arrayList.contains((int) c)) {
                return false;
            }
            arrayList.add((int) c);
        }
        return true;
    }

    public static boolean areAllCharactersUniqueWithSet(String string) {
        if(string == null || string.equals("")) {
            return false;
        }
        if(string.length() > 256) {
            return false;
        }
        Set<Character> characterSet = new TreeSet<>();
        for(char c: string.toCharArray()){
            characterSet.add(c);
        }
        return characterSet.size() == string.length();
    }

    public static boolean areAllCharactersBooleanArray(String string) {
        if(string == null || string.equals("")) {
            return false;
        }
        if(string.length() > 256) {
            return false;
        }
        boolean[] booleanArray = new boolean[256];
        for(char c : string.toCharArray()) {
            if(booleanArray[c]) {
                return false;
            }
            else {
                booleanArray[c] = true;
            }
        }
        return true;
    }

    public static String compressString(String string) {
        if(string == null) {
            return "null string";
        }
        if(string.equals("")) {
            return string;
        }
        return getCompressedString(string);
    }

    private static String getCompressedString(String stringToBeCompressed) {
        CharacterCountHashMap characterCountHashMap = new CharacterCountHashMap(stringToBeCompressed);
        System.out.println(characterCountHashMap.toString());
        StringBuilder compressedString = new StringBuilder();
        for(char c : characterCountHashMap.getAllCharacters()) {
            compressedString.append(c).append(characterCountHashMap.getOccurrencesOf(c));
        }
        if(compressedString.toString().length() > characterCountHashMap.getOriginalString().length()) {
            System.out.println("Original string is shorter than compressed string.");
            return characterCountHashMap.getOriginalString();
        }
        else {
            return compressedString.toString();
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] array : matrix) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    public static int[][] zeroedMatrix(int[][] matrix) {
        printMatrix(matrix);
        boolean zeroFound = false;
        if(matrix == null) {
            throw new NullPointerException();
        }
        int[][] zeroedMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    zeroFound = true;
                    for(int x = 0; x < matrix[0].length; x++) {
                        zeroedMatrix[i][x] = -1;
                    }
                    for(int y = 0; y < matrix.length; y++) {
                        zeroedMatrix[y][j] = -1;
                    }
                }
            }
        }
        if(!zeroFound) {
            return matrix;
        }
        printMatrix(zeroedMatrix);
        for(int i = 0; i < zeroedMatrix.length; i++) {
            for(int j = 0; j < zeroedMatrix[i].length; j++) {
                if(zeroedMatrix[i][j] == -1) {
                    zeroedMatrix[i][j] = 0;
                }
                else {
                    zeroedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        printMatrix(zeroedMatrix);
        return zeroedMatrix;
    }
}
