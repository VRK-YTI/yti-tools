package fi.vm.yti.localecreator;


public class Main {

    public static void main(String[] args) {

        LocaleMerger merger = new LocaleMerger();
        CsvFileWriter writer = new CsvFileWriter();
        writer.writeJsonToCsvFile(merger.LocaleMerger());
    }
}
