import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CurrencyChange {
    private String code; // Код валюты
    private String name; // Название валюты
    private float rate; // Курс обмена

    // Конструктор по умолчанию
    CurrencyChange() {
        this.code = "";
        this.name = "";
        this.rate = 0;
    }

    // Конструктор с параметром
    CurrencyChange(String request) {
        setCurrencyChange(request);
    }

    // Метод для установки курса обмена валюты
    public void setCurrencyChange(String request) {
        try (BufferedReader reader = new BufferedReader(new FileReader("CurrencyRate.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Разделяем строку на части
                if (parts.length == 3 && parts[0].equals(request)) {
                    this.code = parts[0]; // Код валюты
                    this.rate = Float.parseFloat(parts[1]); // Курс обмена
                    this.name = parts[2]; // Название валюты
                    return;
                }
            }
            System.out.println("Выбранный обменный курс не найден.");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для выполнения обмена валюты
    public void change(float amount) {
        System.out.println("Обмен " + name);
        System.out.printf("%.3f = %.3f\n", amount, amount * rate);
    }
}