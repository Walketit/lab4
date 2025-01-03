import java.util.*;

public class main {
    public static void main(String[] args) throws MyExcpetions {
        Logs logs = new Logs();
        
        // ��� ������ ������������ ������������ ������, ���������� ����� ������������ �������� ������
        ParentUser admin = new ParentUser("��������", "parent@example.com", "parentpassword", logs, true, true, true);

        // ����� �������������� ������ � �������������� �������� ������
        admin.printUser();

        System.out.println("\n");
        // ����� �������������� ������ ��� ������������� �������� ������
        admin.printUserWithoutBaseCall();
        System.out.println("\n");

        // �������� ������ �����������
        List<Notification> notifications = new ArrayList<>();

        // ���������� ��������� ����� �����������
        notifications.add(new EmailNotification("���� ������ ���� ��������!", "user@example.com"));
        notifications.add(new SMSNotification("��� ������ ����� 100 ������", "+1234567890"));

        // �������� ���� �����������
        for (Notification notification : notifications) {
            notification.send();
            System.out.println("-----------");
        }

        // ������������ ����������
        User user = new User("John Doe", "john@example.com", "password", 0, new Logs());
        user.exportToCSV("user.csv");
        user.exportToJSON("user.json");

        Account originalAccount = new Account("Main Account", 1000.0, "USD");

        // ������ ������������
        Account shallowClone = originalAccount.clone();
        System.out.println("������ ������������:");
        System.out.println("��������: " + originalAccount.getName() + ", ������: " + originalAccount.getBalance());
        System.out.println("����: " + shallowClone.getName() + ", ������: " + shallowClone.getBalance());

        // �������� ������������
        Account deepClone = originalAccount.deepClone();
        System.out.println("�������� ������������:");
        System.out.println("��������: " + originalAccount.getName() + ", ������: " + originalAccount.getBalance());
        System.out.println("����: " + deepClone.getName() + ", ������: " + deepClone.getBalance());

    }
}