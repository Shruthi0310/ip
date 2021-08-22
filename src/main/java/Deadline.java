import java.util.Scanner;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) throws DukeException {
        super(description, "deadline");
        this.by = by;
    }

    @Override
    public String saveTaskFormat(){
        return "D" + super.saveTaskFormat() + String.format("|%s", by);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}