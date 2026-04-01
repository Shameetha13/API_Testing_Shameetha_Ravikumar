package RequestBody;

public class Payload {

    public static String CreateAProject() {
        return "{\r\n"
                + "  \"createdBy\": \"ABCDE\",\r\n"
                + "  \"projectName\": \"PECC2\",\r\n"
                + "  \"status\": \"Ongoing\",\r\n"
                + "  \"teamSize\": 0\r\n"
                + "}";
    }
}