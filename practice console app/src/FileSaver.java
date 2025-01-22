import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

class FileSaver {
    public static void saveToFile(
            double grossIncome,
            Map<String, Double> fixedDeductions,
            Map<String, Double> percentageDeductions,
            double totalFixedDeductions,
            double totalPercentageDeductions,
            double netIncome
    ) {
        try {
            String filePath = "paycheck_summary.md";
            FileWriter writer = new FileWriter(filePath);

            writer.write("# Paycheck Summary\n");
            writer.write("*Generated by, NIP (Net Income Processor)*\n\n");
            writer.write("## Gross Income\n");
            writer.write("| Description | Amount |\n");
            writer.write("|-------------|--------|\n");
            writer.write("| Gross Income | $" + grossIncome + " |\n");

            writer.write("\n## Fixed Deductions\n");
            writer.write("| Deduction Name | Amount |\n");
            writer.write("|----------------|--------|\n");

            // Write fixed deductions from map
            for (Map.Entry<String, Double> entry : fixedDeductions.entrySet()) {
                writer.write("| " + entry.getKey() + " | $" + entry.getValue() + " |\n");
            }
            writer.write("| **Total Fixed Deductions** | **$" + totalFixedDeductions + "** |\n");

            writer.write("\n## Percentage Deductions\n");
            writer.write("| Deduction Name | Rate (%) | Amount |\n");
            writer.write("|----------------|----------|--------|\n");

            // Write percentage deductions from map
            for (Map.Entry<String, Double> entry : percentageDeductions.entrySet()) {
                writer.write("| " + entry.getKey() + " | " + entry.getValue() + "% | $" + percentageDeductions.get(entry.getKey()) + " |\n");
            }
            writer.write("| **Total Percentage Deductions** |  | **$" + totalPercentageDeductions + "** |\n");

            writer.write("\n## Net Income\n");
            writer.write("| Description | Amount |\n");
            writer.write("|-------------|--------|\n");
            writer.write("| Net Income | $" + netIncome + " |\n");

            writer.close();

            File file = new File(filePath);
            System.out.println("Paycheck summary has been saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
