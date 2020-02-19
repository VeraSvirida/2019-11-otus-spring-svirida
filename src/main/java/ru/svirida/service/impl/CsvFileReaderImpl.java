package ru.svirida.service.impl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.svirida.domain.Question;
import ru.svirida.service.QuestionReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvFileReaderImpl implements QuestionReader {
    private final Resource questionResource;
    private static final String[] FILE_HEADER_MAPPING = {"id", "Question", "Answer"};
    private static final CSVFormat CSV_FILE_FORMAT = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

    public CsvFileReaderImpl(Resource questionResource) {
        this.questionResource = questionResource;
    }

    @Override
    public List<Question> readFile() {
        try (FileReader fileReader = new FileReader(questionResource.getFile());
             CSVParser csvFileParser = new CSVParser(fileReader, CSV_FILE_FORMAT)) {
            List<Question> questionList = new ArrayList<>();
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                Question question = new Question(Long.parseLong(record.get("id")), record.get("Question"), record.get("Answer"));
                questionList.add(question);
            }
            return questionList;
        } catch (Exception e) {
            System.out.println("Error in ru.svirida.service.CsvFileReader !!!");
            e.printStackTrace();
            return null;
        }


    }
}
