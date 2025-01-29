import java.sql.*;

public class Admin {
    public void addTour(Tour tour) {
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO tours (name, location, price, dates) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, tour.getName());
            pstmt.setString(2, tour.getLocation());
            pstmt.setDouble(3, tour.getPrice());
            pstmt.setString(4, tour.getDates());
            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    tour.setId(keys.getInt(1));
                    System.out.println("Tour added with ID: " + tour.getId());
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to add tour: " + e.getMessage());
        }
    }

    public void addGuide(Guide guide) {
        try (Connection conn = DatabaseHandler.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO guides (name, language) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, guide.getName());
            pstmt.setString(2, guide.getLanguage());
            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    guide.setId(keys.getInt(1));
                    System.out.println("Guide added: " + guide);
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to add guide: " + e.getMessage());
        }
    }
}
