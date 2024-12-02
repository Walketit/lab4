public class EmailNotification extends Notification {
    private String email; // Адрес электронной почты

    public EmailNotification(String message, String email) {
        super(message);
        this.email = email;
    }

    @Override
    public void send() {
        System.out.println("Отправка уведомления по электронной почте на адрес " + email);
        System.out.println("Сообщение: " + message);
    }
}