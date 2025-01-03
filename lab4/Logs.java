import java.io.*;

public class Logs {
    private String name; // Имя файла логов
    private Time time; // Объект для работы с датой и временем

    // Конструктор по умолчанию
    public Logs() {
        this.name = "";
        this.time = new Time();
    }

    // Метод для создания файла логов
    public void logfileCreate(int id) {
        name = "logs" + id;
        try {
            File file = new File(name + ".txt");
            if (!file.createNewFile()) {
                System.out.println("Ошибка создания файла!");
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для обновления файла логов
    public void logfileUpdate(int id, String name) {
        time.currentTime(); // Получаем текущее время
        String mes = name + time.getFullDate(); // Формируем сообщение с датой и временем

        this.name = "logs" + id;
        try (FileWriter writer = new FileWriter(this.name + ".txt", true)) {
            writer.write(mes + "\n"); // Добавляем сообщение в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения логов
    public void readLogs(int id) {
        String filename = "logs" + id + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("История операций:");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|"); // Разделяем строку на части
                if (parts.length == 2) {
                    String operation = parts[0]; // Название операции
                    String dateStr = parts[1]; // Дата и время операции

                    time.parseDate(dateStr); // Парсим дату и время

                    System.out.println("Название операции: " + operation);
                    System.out.println("Дата: " + time.getFullDate());
                    System.out.println("-----------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Геттер для объекта Time
    public Time getTime() {
        return time;
    }
}