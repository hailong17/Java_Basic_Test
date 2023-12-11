import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParserJson {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String userDirectory = System.getProperty("user.dir");
            String jsonFile   = userDirectory.replace("\\", "/") + "/ParserJson/jobs.json";
            JsonNode rootNode = objectMapper.readTree(new File(jsonFile));
            JsonNode jobsNode = rootNode.get("jobs");

            for (JsonNode jobNode : jobsNode) {
            	String nodeName = jobNode.fieldNames().next();
                String employer = extractNode(jobNode, "employer");
                String title = extractNode(jobNode, "title");
                String description = extractNode(jobNode, "description");
                String start = extractNode(jobNode.get("duration"), "start");
                String end = extractNode(jobNode.get("duration"), "end");

                System.out.println("Node Name: " + nodeName);
                System.out.println("employer: " + employer);
                System.out.println("Duration - start: " + start);
                System.out.println("Duration - end: " + end);
                System.out.println("Title: " + title);
                System.out.println("description: " + description);

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractNode(JsonNode parentNode, String fieldName) {
        JsonNode node = parentNode.get(fieldName);
        return node != null ? node.asText() : "";
    }
}