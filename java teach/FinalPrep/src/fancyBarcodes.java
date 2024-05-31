import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fancyBarcodes {
    public class FancyBarcode {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            for (; n > 0; n--) {
                System.out.println(checkBarCode(scanner.nextLine()));
            }
        }

        private static String checkBarCode(String barCode) {
            Pattern pattern = Pattern.compile("^@[#]+[A-Z][a-zA-Z0-9]{4,}[A-Z]@[#]+$");
            Matcher matcher = pattern.matcher(barCode);
            if (matcher.matches()) {
                String group = barCode.replaceAll("[@#A-Za-z]", "");
                return group.isEmpty() ? "Product group: 00" : String.format("Product group: %s", group);
            } else {
                return "Invalid barcode";
            }
        }
    }
}