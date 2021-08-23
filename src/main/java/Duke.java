import java.io.IOException;
import java.util.Scanner;

public class Duke {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        this.storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.load(), ui);
        } catch (DukeException e) {
            ui.printError(e.getMessage());
            taskList = new TaskList(ui);
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                isExit = Parser.parse(fullCommand, taskList, ui, storage);
            } catch (DukeException e) {
                ui.printError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }

    }


    public static void main(String[] args) throws IOException {
        new Duke("duke.txt").run();
    }
}