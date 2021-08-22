public class Todo extends Task {

    public Todo(String description) throws DukeException {
        super(description, "todo");
    }

    @Override
    public String saveTaskFormat(){
        return "T" + super.saveTaskFormat();
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
