package main.java.ua.opnu;

public class TimeSpan {

    // Поля
    private int hours;
    private int minutes;

    // Конструктор без аргументів
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    // Конструктор з одним аргументом (хвилини)
    public TimeSpan(int minutes) {
        if (minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = minutes / 60;
            this.minutes = minutes % 60;
        }
    }

    // Конструктор з двома аргументами (години та хвилини)
    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    // Конструктор з аргументом типу TimeSpan
    public TimeSpan(TimeSpan span) {
        if (span == null) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = span.hours;
            this.minutes = span.minutes;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // Додавання TimeSpan
    public void add(TimeSpan span) {
        if (span == null) return;
        this.hours += span.hours;
        this.minutes += span.minutes;
        normalize();
    }

    // Додавання годин та хвилин
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) return;
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    // Додавання хвилин
    public void addMinutes(int minutes) {
        if (minutes < 0) return;
        this.minutes += minutes;
        normalize();
    }

    // Віднімання TimeSpan
    public void subtract(TimeSpan span) {
        if (span == null) return;
        int totalMinutes = this.toMinutes() - span.toMinutes();
        if (totalMinutes < 0) return;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Віднімання годин та хвилин
    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) return;
        int totalMinutes = this.toMinutes() - (hours * 60 + minutes);
        if (totalMinutes < 0) return;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    // Віднімання хвилин
    public void subtractMinutes(int minutes) {
        if (minutes < 0) return;
        int totalMinutes = this.toMinutes() - minutes;
        if (totalMinutes < 0) return;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void scale(int factor) {
        if (factor <= 0) return;
        int totalMinutes = this.toMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    public int getTotalMinutes() {
        return toMinutes();
    }

    // Переводимо у хвилини
    private int toMinutes() {
        return hours * 60 + minutes;
    }

    // Нормалізація хвилин
    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        }
    }
}
