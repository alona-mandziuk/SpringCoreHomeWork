package hw2.task_1;

class FirstMovie implements Movie{
   String genre = "Fantasy";
   String title;
   String director;

    public FirstMovie(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void init() {
        System.out.println("Genre: " + genre);
    }

    @Override
    public void getInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Director: " + getDirector());
    }
}
