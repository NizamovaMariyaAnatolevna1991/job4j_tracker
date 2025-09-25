package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;
    SqlTracker tracker = new SqlTracker(connection);

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenAddMultipleItemsThenAllSaved() {
        Item item1 = tracker.add(new Item("Task 1"));
        Item item2 = tracker.add(new Item("Task 2"));

        List<Item> all = tracker.findAll();
        assertThat(all).hasSize(2)
                .extracting(Item::getName)
                .contains("Task 1", "Task 2");
    }

    @Test
    void whenReplaceExistingItemThenUpdated() {
        Item item = tracker.add(new Item("Old"));
        boolean result = tracker.replace(item.getId(), new Item("New"));

        assertThat(result).isTrue();
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("New");
    }

    @Test
    void whenReplaceNonExistentIdThenFalse() {
        boolean result = tracker.replace(999, new Item("Not exists"));

        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteItemThenNotFound() {
        Item item = tracker.add(new Item("To delete"));
        tracker.delete(item.getId());

        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenDeleteTwiceThenNoError() {
        Item item = tracker.add(new Item("Once"));
        tracker.delete(item.getId());
        tracker.delete(item.getId());

        assertThat(tracker.findById(item.getId())).isNull();

    }

    @Test
    void whenFindAllThenReturnList() {
        tracker.add(new Item("One"));
        tracker.add(new Item("Two"));

        List<Item> all = tracker.findAll();

        assertThat(all).hasSize(2);
    }

    @Test
    void whenNoItemsThenEmptyList() {
        List<Item> all = tracker.findAll();

        assertThat(all).isEmpty();
    }

    @Test
    void whenFindByNameThenReturnMatching() {
        tracker.add(new Item("Bug"));
        tracker.add(new Item("Bug"));

        List<Item> found = tracker.findByName("Bug");

        assertThat(found).hasSize(2)
                .allMatch(item -> "Bug".equals(item.getName()));
    }

    @Test
    void whenFindByNameNoMatchThenEmpty() {
        tracker.add(new Item("Feature"));

        List<Item> found = tracker.findByName("Bug");

        assertThat(found).isEmpty();
    }

    @Test
    void whenFindByIdThenReturnItem() {
        Item item = tracker.add(new Item("Found by ID"));

        Item found = tracker.findById(item.getId());

        assertThat(found).usingRecursiveComparison().isEqualTo(item);
    }

    @Test
    void whenFindByIdNotExistsThenNull() {
        Item found = tracker.findById(999);

        assertThat(found).isNull();
    }
}