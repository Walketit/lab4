public class ParentUser extends User{
    private boolean canDeleteAccounts; // Право удалять счета
    private boolean canDeleteNotes; // Право удалять заметки
    private boolean canViewLogs; // Право просматривать логи

    public ParentUser(String name, String email, String password, Logs logs, boolean canDeleteAccounts, boolean canDeleteNotes, boolean canViewLogs) throws MyExcpetions {
        super(name, email, password, 1, logs); // Администратор всегда имеет статус 1
        this.canDeleteAccounts = canDeleteAccounts;
        this.canDeleteNotes = canDeleteNotes;
        this.canViewLogs = canViewLogs;
    }

    // Перегруженный метод для удаления счета пользователя
    public void deleteAccount(User user, Account account) {
        if (canDeleteAccounts) {
            user.getAccounts().remove(account);
            System.out.println("Счёт " + account.getName() + " удалён у пользователя " + user.getName());
        } else {
            System.out.println("У вас нет прав на удаление счетов.");
        }
    }


    // Перегруженный метод для удаления заметки пользователя
    public void deleteNote(User user, Note note) {
        if (canDeleteNotes) {
            user.getNotes().remove(note);
            System.out.println("Заметка " + note.getTitle() + " удалёна у пользователя " + user.getName());
        } else {
            System.out.println("У вас нет прав на удаление заметок.");
        }
    }

    // Метод для просмотра логов другого пользователя
    public void viewUserLogs(User user) {
        if (canViewLogs) {
            getLogs().readLogs(user.getId());
        } else {
            System.out.println("У вас нет прав на просмотр логов других пользователей.");
        }
    }

}
