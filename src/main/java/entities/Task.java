/**
 * Task class.
 * Author: Fardin Faruk
 * Modified by: NA
 * Date created: Nov 10, 2022
 * Last Modified: NA
 */
package entities;
public class Task {
    private String title;

    protected Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
