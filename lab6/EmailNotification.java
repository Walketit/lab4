public class EmailNotification extends Notification {
    private String email; // ����� ����������� �����

    public EmailNotification(String message, String email) {
        super(message);
        this.email = email;
    }

    @Override
    public void send() {
        System.out.println("�������� ����������� �� ����������� ����� �� ����� " + email);
        System.out.println("���������: " + message);
    }
}