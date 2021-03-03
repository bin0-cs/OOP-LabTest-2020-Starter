package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Task {

    private String tasks;
    private int start;
    private int end;

    public Task(String tasks, int start, int end) {
        this.tasks = tasks;
        this.start = start;
        this.end = end;
    }

    public Task(TableRow row) {

        this(row.getString("Task"), row.getInt("Start"), row.getInt("End")

        );
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task [end=" + end + ", start=" + start + ", tasks=" + tasks + "]";
    }

}
