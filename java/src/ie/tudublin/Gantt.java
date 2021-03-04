package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet {

	ArrayList<Task> tasksList = new ArrayList<Task>();

	private float leftBorder;
	private float rightBorder;

	int whichTask = -1;
	boolean isEnd = false;

	public void settings() {
		size(800, 600);

	}

	public void loadTasks() {

		Table table = loadTable("tasks.csv", "header");
		for (TableRow row : table.rows()) {
			Task t = new Task(row);
			tasksList.add(t);
		}

	}

	public void printTasks() {
		for (Task t : tasksList) {
			println(t);
		}

	}

	public void displayTasks() {

		stroke(255);
		fill(255);
		textAlign(CENTER, CENTER);
		for (int i = 1; i <= 30; i++) {
			float x = map(i, 1, 30, leftBorder, width - rightBorder);
			line(x, rightBorder, x, height - rightBorder);
			text(i, x, rightBorder / 2);
		}

		for (int i = 0; i < tasksList.size(); i++) {
			float y = map(i, 0, tasksList.size(), rightBorder + 50, height - rightBorder);
			Task t = tasksList.get(i);
			float x1 = map(t.getStart(), 1, 30, leftBorder, width - rightBorder);
			float x2 = map(t.getEnd(), 1, 30, leftBorder, width - rightBorder);
			int c = (int) map(i, 0, tasksList.size(), 0, 255);
			noStroke();
			fill(c, 255, 255);
			rect(x1, y - 10, x2 - x1, 40);
			fill(255);
			textAlign(LEFT, CENTER);
			text(t.getTasks(), 20, y);

		}
		/*
		 * 
		 * float border = 0.1f * width; for (TableRow row : table.rows()) { Task t = new
		 * Task(row); float y = map(t.getTasks(), 0, tasksList.size(), border, height -
		 * border);
		 * 
		 * }
		 * 
		 * Task(); float border = 0.1f * width; textAlign(CENTER, CENTER); // float
		 * drawable = width - (border * 2.0f); // /float gap = drawable / 10.0f; for
		 * (int i = 0; i <= 30; i++) { float x = map(i, 0, 30, border, width - border);
		 * 
		 * for (int p = 0; p < tasksList.size(); p++) {
		 * 
		 * Task t = tasksList.get(p);
		 * 
		 * float y = map(t.getTasks(), 0, tasksList.size(), border, height - border);
		 * fill(255); text(t.getTasks(), y, x);
		 * 
		 * } stroke(0, 0, 255); line(x, border, x, height - border);
		 * 
		 * fill(255); text(i, x, border / 2);
		 * 
		 * }
		 */
	}

	public void mousePressed() {
		println("Mouse pressed");

	}

	public void mouseDragged() {
		println("Mouse dragged");
	}

	public void setup() {
		colorMode(HSB);
		loadTasks();
		printTasks();
		leftBorder = width * 0.2f;
		rightBorder = width * 0.05f;
	}

	public void draw() {
		background(0);
		displayTasks();
	}
}
