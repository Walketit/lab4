public abstract class Notification {
    protected String message; // ��������� �����������

    public Notification(String message) {
        this.message = message;
    }

    // ����������� ����� ��� �������� �����������
    public abstract void send();

    // ����� ��� ��������� ���������
    public void setMessage(String message) {
        this.message = message;
    }

    // ����� ��� ��������� ���������
    public String getMessage() {
        return message;
    }
}