import java.util.Scanner;

/**
 * Created by PARK on 2017-02-15.
 */
public class Q3613 {
    public static void main(String[] args){
        String input;
        boolean isJava = false;
        Scanner scan = new Scanner(System.in);

        input = scan.nextLine();

        //check first char
        if(!Character.isLowerCase(input.charAt(0))){
            System.out.println("Error!");
            return ;
        }

        //check Last char
        if(input.charAt(input.length()-1) == '_'){
            System.out.println("Error!");
            return ;
        }


        //check language
        for(int i=0; i<input.length(); i++){
            if(Character.isUpperCase(input.charAt(i))){
                isJava = true;
                break;
            }
        }

        //check String
        if(isJava){
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '_'){
                    System.out.println("Error!");
                    return ;
                }
            }
        } else {
            for (int i = 0; i < input.length()-1; i++) {
                if(input.charAt(i) == '_' && input.charAt(i+1) == '_'){
                    System.out.println("Error!");
                    return ;
                }
            }
        }

        //change string
        String result = "";
        if(isJava) {
            for (int i = 0; i < input.length(); i++) {
                if(Character.isUpperCase(input.charAt(i))){
                    result += "_"+Character.toLowerCase(input.charAt(i));
                } else {
                    result += input.charAt(i);
                }
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '_'){
                    result += Character.toUpperCase(input.charAt(i+1));
                    i++;
                } else {
                    result += input.charAt(i);
                }
            }
        }


        System.out.println(result);
    }
}

