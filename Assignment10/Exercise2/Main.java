package Exercise2;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("jobs.json"));

            JsonNode jobsNode = rootNode.get("jobs");
            if (jobsNode.isArray()) {
                for (JsonNode jobNode : jobsNode) {
                    String employer = extractNode(jobNode, "employer");
                    String title = extractNode(jobNode, "title");
                    String description = extractNode(jobNode, "description");
                    String start = extractNode(jobNode, "duration", "start");
                    String end = extractNode(jobNode, "duration", "end");

                    System.out.println("Employer: " + employer);
                    System.out.println("Title: " + title);
                    System.out.println("Description: " + description);
                    System.out.println("Start: " + start);
                    System.out.println("End: " + end);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractNode(JsonNode parentNode, String... fieldNames) {
        JsonNode currentNode = parentNode;
        for (String fieldName : fieldNames) {
            currentNode = currentNode.get(fieldName);
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode.asText();
    }
}