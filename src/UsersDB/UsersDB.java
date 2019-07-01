package UsersDB;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class UsersDB {
    private static final UsersDB instance = new UsersDB();
    private Player player;
    private static final String DB_NAME = "Players.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:" + System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Fruit Ninja Game/" + DB_NAME;
    private static final int INDEX_PLAYERS_NAME = 1;
    private static final int INDEX_PLAYERS_CLASSICSCORE = 2; // COLUMN_PLAYERS_CLASSICSCORE = "classicScore"
    private static final int INDEX_PLAYERS_ARCADESCORE = 3; // COLUMN_PLAYERS_ARCADESCORE = "arcadeScore"
    private static final String INSERT_STATEMENT = "INSERT INTO players(name, classicScore, arcadeScore) VALUES(?, ?, ?)";
    private static final String SEARCH_STATEMENT = "SELECT name FROM players where name = ?";
    private static final String QUERY_STATEMENT = "SELECT * FROM players";
    private static final String UPDATE_STATEMENT = "UPDATE players SET classicScore = ?, arcadeScore = ? where name = ?";
    private static final int ORDER_BY_CLASSICSCORE = 1;
    private static final int ORDER_BY_ARCADESCORE = 2;
    private List<Player> players = new ArrayList<>();
    private Connection connection;

    //        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery()
    private void open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists players (name text not null," +
                    " classicScore int not null, arcadeScore int not null) ");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static UsersDB getInstance() {
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                this.player = player;
            }
        }
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addUser(String username, int arcadeScore, int classicScore) {
        open();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)) {
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, classicScore);
            preparedStatement.setInt(3, arcadeScore);
            preparedStatement.execute();
            players.add(new Player(username, arcadeScore, classicScore));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public boolean verify(String username) {
        open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SEARCH_STATEMENT);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet == null);
            assert resultSet != null;
            return !resultSet.next(); // returns true if has next, so we reverse it to check if it's full or empty

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            close();
        }
    }

    public List<Player> query(int order) {
        open();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        StringBuilder stringBuilder = new StringBuilder(QUERY_STATEMENT);
        try {
            if (order == ORDER_BY_CLASSICSCORE) {
                stringBuilder.append(" order by classicScore DESC");
            } else if (order == ORDER_BY_ARCADESCORE) {
                stringBuilder.append(" order by arcadeScore DESC");
            } else {
                stringBuilder.append(" order by name DESC");
            }
            preparedStatement = connection.prepareStatement(String.valueOf(stringBuilder));
            resultSet = preparedStatement.executeQuery();

            List<Player> players = new ArrayList<>();
            while (resultSet.next()) {
                players.add(new Player(resultSet.getString(INDEX_PLAYERS_NAME)
                        , resultSet.getInt(INDEX_PLAYERS_ARCADESCORE),
                        resultSet.getInt(INDEX_PLAYERS_CLASSICSCORE)));
            }
            return players;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close();
        }
    }

    public void updatePlayer() {
        open();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)) {
            preparedStatement.setInt(1, player.getClassicScore());
            preparedStatement.setInt(2, player.getArcadeScore());
            preparedStatement.setString(3, player.getUsername());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public int getHighestScore(int gameMode) {
        open();
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement()) {
            StringBuilder stringBuilder = new StringBuilder();

            if (gameMode == 1) {
                stringBuilder.append("SELECT classicScore from players order by classicScore DESC");
            } else if (gameMode == 2) {
                stringBuilder.append("SELECT arcadeScore from players order by arcadeScore DESC");
            }
            resultSet = statement.executeQuery(String.valueOf(stringBuilder));
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close();
        }
    }
}
