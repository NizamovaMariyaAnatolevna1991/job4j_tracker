package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscByNameAndAscByPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorJobAscByName() {
        Comparator<Job> cmpAscName = new JobAscByName();
        int rsl = cmpAscName.compare(
                new Job("Anna", 0),
                new Job("Masha", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorJobDescByName() {
        Comparator<Job> cmpAscName = new JobDescByName();
        int rsl = cmpAscName.compare(
                new Job("Anna", 0),
                new Job("Masha", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorJobAscByPriority() {
        Comparator<Job> cmpAscPriority = new JobAscByPriority();
        int rsl = cmpAscPriority.compare(
                new Job("Anna", 1),
                new Job("Masha", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorJobDescByPriority() {
        Comparator<Job> cmpAscPriority = new JobDescByPriority();
        int rsl = cmpAscPriority.compare(
                new Job("Anna", 1),
                new Job("Masha", 0)
        );
        assertThat(rsl).isLessThan(0);
    }
}