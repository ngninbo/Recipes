import java.util.*;

class Date {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String date = scn.nextLine();
        String monthPattern = "(0[0-9])|(1[0-2])";
        String yearPattern = "(19|20)[0-9][0-9]";
        String dayPattern = "([0-2][0-9])|(3[0-1])";
        String dateRegex =  String.format("((%s)[/.-](%s)[/.-](%s))|((%s)[/.-](%s)[/.-](%s))",
                yearPattern, monthPattern, dayPattern,
                dayPattern, monthPattern, yearPattern);

        System.out.println(date.matches(dateRegex) ? "Yes" : "No");
    }
}