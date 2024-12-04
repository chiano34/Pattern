import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
class Students_db {
    private lateinit var connection: Connection
    init {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Student",
                "postgres",
                "admin"
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun executeQuery(query: String): ResultSet? {
        return try {
            val stmt = connection.createStatement()
            stmt.executeQuery(query)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}