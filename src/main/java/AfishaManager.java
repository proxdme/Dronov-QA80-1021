public class AfishaManager {
    private String[] movies; // массив
    private int lastfilms; // ограничитель добавленных фильмов

    public AfishaManager() {
        this.lastfilms = 5;
        this.movies = new String[0];
    } // по умолчанию выводилось последние 5 добавленных фильма

    public AfishaManager(int lastfilms) {
        this.lastfilms = lastfilms;
        this.movies = new String[0];
    } // значение лимита для менеджера из параметра конструктора

    public void newMovie(String film) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = film;
        movies = tmp;
    }

    // Вывод всех фильмов в порядке добавления (findAll).
    public String[] findAll() {
        return movies;
    }

    // Вывод максимально лимит* штук последних добавленных фильмов в обратном от добавления порядке (findLast).
    public String[] findLast() {
        int resultLength;
        if (lastfilms < movies.length) {
            resultLength = lastfilms;
        } else {
            resultLength = movies.length;
        } // находим правильный ожидаемый размер результирующего массива-ответа
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        } // в обратном от добавления порядке
        return result;
    }

}
