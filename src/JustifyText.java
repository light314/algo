import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JustifyText {
    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        int currLineLength = 0;
        ArrayList<String> result = new ArrayList<String>();
        for (String a : A){
            if((result.size() == 0 && ((a.length() + 1) < B)) || ((currLineLength + a.length() + 1 > B) && a.length()<=B) ){
                result.add(a);
                currLineLength = a.length();
            } else if(currLineLength + a.length() + 1 <= B){
                result.set(result.size()-1, result.get(result.size()-1)+" "+a);
                currLineLength += a.length()+1;
            }
        }
        result = formatSpaces(result,B);
        return (result);


    }

    private ArrayList<String> formatSpaces(ArrayList<String> result, int B) {
        for (int i = 0; i < result.size()-1; i++) {
            String target_line = "";
            String[] tokens = result.get(i).split("\\s+");
            int line_char_count = 0;
            for (int n = 0; n< tokens.length;n++){
                line_char_count+=tokens[n].length();
            }
           if (tokens.length == 1) {
                target_line = suffixSpace(tokens[0], (B - tokens[0].length()));
                result.set(i, target_line);
            } else if(tokens.length > 1){
               int eq_spaces = (B-line_char_count- (tokens.length-1))/(tokens.length-1);
               int extra_spaces = (B-line_char_count- (tokens.length-1))%(tokens.length-1);
               for (int j = 0; j<tokens.length-1;j++){
                    String target_token= tokens[j]+" ";
                    target_token = suffixSpace(target_token,eq_spaces);
                    if(extra_spaces>0){
                        target_token+=" ";
                        extra_spaces--;
                    }
                target_line = target_line+target_token;
                }
                target_line+=tokens[tokens.length-1];
                result.set(i, target_line);

            }
        }
        if(result.size()>=1)
            result.set(result.size()-1, suffixSpace(result.get(result.size()-1), B-result.get(result.size()-1).length()));
        return result;
    }

    private String suffixSpace(String token, int t) {
        token = token+(IntStream.range(0, t).mapToObj(i -> " ").collect(Collectors.joining("")));
        return token;
    }
}
