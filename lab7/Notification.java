public abstract class Notification {
    protected String message; // Сообщение уведомления

    public Notification(String message) {
        this.message = message;
    }

    // Абстрактный метод для отправки уведомления
    public abstract void send();

    // Метод для установки сообщения
    public void setMessage(String message) {
        this.message = message;
    }

    // Метод для получения сообщения
    public String getMessage() {
        return message;
    }
}