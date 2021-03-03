package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet {

	ArrayList<Task> tasksList = new ArrayList<Task>();

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

		float border = 0.1f * width;
		textAlign(CENTER, CENTER);
		// float drawable = width - (border * 2.0f);
		// /float gap = drawable / 10.0f;
		for (int i = 0; i <= 30; i++) {
			float x = map(i, 0, 30, border, width - border);

			for (int p = 0; p < tasksList.size(); p++) {
				float y = map(p, 0, tasksList.size(), border, height - border);

				text(p, border / 2, y);

			}
			stroke(0, 0, 255);
			line(x, border, x, height - border);

			fill(255);
			text(i, x, border / 2);

		}
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
	}

	public void draw() {
		background(0);
		displayTasks();
	}
}
