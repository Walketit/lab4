public class SMSNotification extends Notification {
    private String phoneNumber; // ����� ��������

    public SMSNotification(String message, String phoneNumber) {
        super(message);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        System.out.println("�������� SMS ����������� �� ����� " + phoneNumber);
        System.out.println("���������: " + message);
    }
}