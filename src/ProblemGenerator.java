/**
 * Created by AJ on 1/9/2015.
 */
public class ProblemGenerator {

    public static String[] GenerateProblems(String type, int numProblems){
        if (numProblems <= 0) return new String[]{"-- Invalid problem count. Must be > 0"};
        String[] returnStr;
        switch(type){
            case "log": returnStr = GenerateLogarithms(numProblems);
                break;
            case "exp":
                break;
        }
        System.out.println(type + " " + numProblems);
        return new String[]{"Placeholder"};
    }
    public static String[] GenerateLogarithms(int numProblems){


        return new String[]{"Placeholder"};
    }
}
