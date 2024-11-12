import java.io.*;

public class Logs {
    private String name;
    private Time time;

    public Logs() {
        this.name = "";
        this.time = new Time();
    }

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

    public void logfileUpdate(int id, String name) {
        time.currentTime();
        String mes = name + time.getFullDate();

        this.name = "logs" + id;
        try (FileWriter writer = new FileWriter(this.name + ".txt", true)) {
            writer.write(mes + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readLogs(int id) {
        String filename = "logs" + id + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("История операций:");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    String operation = parts[0];
                    String dateStr = parts[1];

                    time.parseDate(dateStr);

                    System.out.println("Название операции: " + operation);
                    System.out.println("Дата: " + time.getFullDate());
                    System.out.println("-----------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Time getTime() {
        return time;
    }
}
