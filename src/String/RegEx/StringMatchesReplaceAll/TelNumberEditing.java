package String.RegEx.StringMatchesReplaceAll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelNumberEditing {
    Database contact;
    public static void main(String[] args) {

    }

    public String getDialString() {
        Pattern pattern = Pattern.compile("(\\+*\\d+)\\((\\d+)\\)(\\d+)-(\\d+)-*(\\d*)");
        Matcher match = pattern.matcher(contact.getPhoneNumber());
        if (match.find()) {
            return "callto://" + match.group(1)+match.group(2) + match.group(3) + match.group(4) + match.group(5);
        }
        return "callto://+" + contact.getPhoneNumber().replaceAll("\\D", ""); //         !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! replaceAll("[^0-9]", "")
    }

    private static class Database {
        String getPhoneNumber() {return null;}
    }
}
