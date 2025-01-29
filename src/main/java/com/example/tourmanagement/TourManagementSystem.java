public class TourManagementSystem {
    public static void main(String[] args) {
        DatabaseHandler db = DatabaseHandler.getInstance();
        Admin admin = new Admin();

        // Создаём и добавляем тур
        Tour tour = new Tour("Dubai Islands", "Dubai", 4000.50, "2025-04-15 to 2025-04-20");
        admin.addTour(tour);

        if (tour.getId() == 0) {
            System.out.println(" Error: Tour ID is 0. Guide assignment will fail!");
            return;
        }

        // Создаём гидов
        Guide guide1 = new Guide("Sultan Cadykov", "Kazakh");
        admin.addGuide(guide1);

        Guide guide2 = new Guide("Maria Griz", "English");
        admin.addGuide(guide2);

        if (guide1.getId() == 0 || guide2.getId() == 0) {
            System.out.println(" Error: Guide ID is 0. Guide assignment will fail!");
        } else {
            System.out.println(" Assigning guides to tour...");
            // Логика назначения гидов (если добавлена)
        }

        // Вывод всех гидов
        System.out.println("\nAll guides in system:");
        admin.viewAllGuides();

        // Вывод всех туров
        System.out.println("\nAll tours in system:");
        admin.viewAllTours();
    }
}
