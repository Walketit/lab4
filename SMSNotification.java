public class SMSNotification extends Notification {
    private String phoneNumber; // Номер телефона

    public SMSNotification(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println("Отправка SMS уведомления на номер " + phoneNumber);
        System.out.println("Сообщение: " + message);
    }
}