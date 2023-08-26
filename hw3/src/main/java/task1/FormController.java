package task1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FormController {
    private int recordCount;

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String data, Model model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println(data);
            recordCount++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("recordCount", recordCount);
        return "success";
    }

    @GetMapping("/view")
    public String viewRecords(Model model) {
        List<String> records = readRecordsFromFile();
        model.addAttribute("records", records);
        return "view";
    }

    private List<String> readRecordsFromFile() {
        List<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
