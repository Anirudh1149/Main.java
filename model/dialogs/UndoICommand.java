package model.dialogs;

public class UndoICommand implements ICommand {
    @Override
    public void execute() {

        CommandHistory.undo();
    }
}
