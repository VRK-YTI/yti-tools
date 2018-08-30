package fi.vm.yti.localecreator;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;


public class CsvFileWriter {

    private static final String CONTENT_HEADER_CODEVALUE = "CODEVALUE";
    private static final String CONTENT_HEADER_ID = "ID";
    private static final String CONTENT_HEADER_STATUS = "STATUS";
    private static final String CONTENT_HEADER_HIERARCHYLEVEL = "HIERARCHYLEVEL";
    private static final String CONTENT_HEADER_PREFLABEL_FI = "PREFLABEL_FI";
    private static final String CONTENT_HEADER_PREFLABEL_SV = "PREFLABEL_SV";
    private static final String CONTENT_HEADER_PREFLABEL_EN = "PREFLABEL_EN";
    private static final String CONTENT_HEADER_DEFINITION_FI = "DEFINITION_FI";
    private static final String CONTENT_HEADER_DEFINITION_SV = "DEFINITION_SV";
    private static final String CONTENT_HEADER_DEFINITION_EN = "DEFINITION_EN";
    private static final String CONTENT_HEADER_DESCRIPTION_FI = "DESCRIPTION_FI";
    private static final String CONTENT_HEADER_DESCRIPTION_SV = "DESCRIPTION_SV";
    private static final String CONTENT_HEADER_DESCRIPTION_EN = "DESCRIPTION_EN";
    private static final String CONTENT_HEADER_SHORTNAME = "SHORTNAME";
    private static final String CONTENT_HEADER_STARTDATE = "STARTDATE";
    private static final String CONTENT_HEADER_ENDDATE = "ENDDATE";

    private static final String CONTENT_VALUE_STATUS = "VALID";
    private static final String CONTENT_VALUE_ID = "";
    private static final String CONTENT_VALUE_HIERARCHYLEVEL = "";
    private static final String CONTENT_VALUE_SHORTNAME = "";
    private static final String CONTENT_VALUE_ENDDATE = "";
    private static final String CONTENT_VALUE_STARTDATE = "";
    private static final String CONTENT_VALUE_DESCRIPTION_FI = "";
    private static final String CONTENT_VALUE_DESCRIPTION_SV = "";
    private static final String CONTENT_VALUE_DESCRIPTION_EN = "";
    private static final String CONTENT_VALUE_DEFINITION_FI = "";
    private static final String CONTENT_VALUE_DEFINITION_SV = "";
    private static final String CONTENT_VALUE_DEFINITION_EN = "";


    private static final String FILEOUT = "out/locale_codelist.csv";
    CsvSchema schema;

    CsvFileWriter() {
        this.schema = CsvSchema.builder().addColumn("langLocale").addColumn("langTrans").build();
    }

    public void writeJsonToCsvFile(List<LocaleCode> localeCodes) {
        try {
            final StringBuilder csv = new StringBuilder();
            final String separator = ",";

            appendValue(csv, separator, CONTENT_HEADER_CODEVALUE);
            appendValue(csv, separator, CONTENT_HEADER_ID);
            appendValue(csv, separator, CONTENT_HEADER_STATUS);
            appendValue(csv, separator, CONTENT_HEADER_HIERARCHYLEVEL);
            appendValue(csv, separator, CONTENT_HEADER_PREFLABEL_FI);
            appendValue(csv, separator, CONTENT_HEADER_PREFLABEL_SV);
            appendValue(csv, separator, CONTENT_HEADER_PREFLABEL_EN);
            appendValue(csv, separator, CONTENT_HEADER_DEFINITION_FI);
            appendValue(csv, separator, CONTENT_HEADER_DEFINITION_SV);
            appendValue(csv, separator, CONTENT_HEADER_DEFINITION_EN);
            appendValue(csv, separator, CONTENT_HEADER_DESCRIPTION_FI);
            appendValue(csv, separator, CONTENT_HEADER_DESCRIPTION_SV);
            appendValue(csv, separator, CONTENT_HEADER_DESCRIPTION_EN);
            appendValue(csv, separator, CONTENT_HEADER_SHORTNAME);
            appendValue(csv, separator, CONTENT_HEADER_STARTDATE);
            appendValue(csv, separator, CONTENT_HEADER_ENDDATE, true);
            //csv.append("\n");

            for (LocaleCode localeCode : localeCodes) {

                appendValue(csv, separator, localeCode.getLangLocale());
                appendValue(csv, separator, CONTENT_VALUE_ID);
                appendValue(csv, separator, CONTENT_VALUE_STATUS);
                appendValue(csv, separator, CONTENT_VALUE_HIERARCHYLEVEL);
                appendValue(csv, separator, localeCode.getTransFi());
                appendValue(csv, separator, localeCode.getTransSv());
                appendValue(csv, separator, localeCode.getTransEn());
                appendValue(csv, separator, CONTENT_VALUE_DEFINITION_FI);
                appendValue(csv, separator, CONTENT_VALUE_DEFINITION_SV);
                appendValue(csv, separator, CONTENT_VALUE_DEFINITION_EN);
                appendValue(csv, separator, CONTENT_VALUE_DESCRIPTION_FI);
                appendValue(csv, separator, CONTENT_VALUE_DESCRIPTION_SV);
                appendValue(csv, separator, CONTENT_VALUE_DESCRIPTION_EN);
                appendValue(csv, separator, CONTENT_VALUE_SHORTNAME);
                appendValue(csv, separator, CONTENT_VALUE_STARTDATE);
                appendValue(csv, separator, CONTENT_VALUE_ENDDATE, true);
            }

            writeToFile(csv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(StringBuilder data) {
        File file = new File(FILEOUT);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(data.toString());
            writer.close();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void appendValue(final StringBuilder builder,
                     final String separator,
                     final String value) {
        appendValue(builder, separator, value, false);
    }

    private void appendValue(final StringBuilder builder,
                     final String separator,
                     final String value,
                     final boolean isLast) {
        if (value != null && (value.contains(",") || value.contains("\n"))) {
            builder.append("\"");
            builder.append(checkEmptyValue(value));
            builder.append("\"");
        } else {
            builder.append(checkEmptyValue(value));
        }
        if (isLast) {
            builder.append("\n");
        } else {
            builder.append(separator);
        }
    }

    private String checkEmptyValue(final String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
