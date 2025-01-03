public class ParentUser extends User {
    private boolean canDeleteAccounts; // ����� ������� �����
    private boolean canDeleteNotes; // ����� ������� �������
    private boolean canViewLogs; // ����� ������������� ����

    public ParentUser(String name, String email, String password, Logs logs, boolean canDeleteAccounts, boolean canDeleteNotes, boolean canViewLogs) throws MyExcpetions {
        super(name, email, password, 1, logs); // ������������� ������ ����� ������ 1
        this.canDeleteAccounts = canDeleteAccounts;
        this.canDeleteNotes = canDeleteNotes;
        this.canViewLogs = canViewLogs;
    }

    // ����� ��� �������� ����� ������������
    public void deleteAccount(User user, Account account) {
        if (canDeleteAccounts) {
            user.getAccounts().remove(account);
            System.out.println("���� " + account.getName() + " ����� � ������������ " + name);
        } else {
            System.out.println("� ��� ��� ���� �� �������� ������.");
        }
    }


    // ����� ��� �������� ������� ������������
    public void deleteNote(User user, Note note) {
        if (canDeleteNotes) {
            user.getNotes().remove(note);
            System.out.println("������� " + note.getTitle() + " ������ � ������������ " + name);
        } else {
            System.out.println("� ��� ��� ���� �� �������� �������.");
        }
    }

    // ����� ��� ��������� ����� ������� ������������
    public void viewUserLogs(User user) {
        if (canViewLogs) {
            getLogs().readLogs(user.getId());
        } else {
            System.out.println("� ��� ��� ���� �� �������� ����� ������ �������������.");
        }
    }

    @Override
    public void printUser() {
        // � ������� ������ �������� ������
        super.printUser(); // ����� ������ �������� ������
        System.out.println("�������������� ����� ��������������:");
        System.out.println("����� ������� �����: " + (canDeleteAccounts ? "��" : "���"));
        System.out.println("����� ������� �������: " + (canDeleteNotes ? "��" : "���"));
        System.out.println("����� ������������� ����: " + (canViewLogs ? "��" : "���"));
    }

    // ���������� ������ ��� ������ ���������� � ������ ������� (��� ������ �������� ������)
    public void printUserWithoutBaseCall() {
        System.out.printf("�������������: %s, Email: %s, �����: �������� ������: %s, �������� �������: %s, �������� �����: %s\n",
                name, email,
                canDeleteAccounts ? "��" : "���",
                canDeleteNotes ? "��" : "���",
                canViewLogs ? "��" : "���");

    }

}
