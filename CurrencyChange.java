import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CurrencyChange {
    private String code;
    private String name;
    private float rate;

    public CurrencyChange() {
        this.code = "";
        this.name = "";
        this.rate = 0;
    }

    public CurrencyChange(String request) {
        setCurrencyChange(request);
    }

    public void setCurrencyChange(String request) {
        try (BufferedReader reader = new BufferedReader(new FileReader("CurrencyRate.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(request)) {
                    this.code = parts[0];
                    this.rate = Float.parseFloat(parts[1]);
                    this.name = parts[2];
                    return;
                }
            }
            System.out.println("Выбранный обменный курс не найден.");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void change(float amount) {
        System.out.println("Обмен " + name);
        System.out.printf("%.3f = %.3f\n", amount, amount * rate);
    }
}
