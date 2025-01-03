package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double totalScore = 0.0;
        double totalSubject = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubject++;
            }
        }
        return totalScore / totalSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0.0;
            double totalSubject = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double averageScore = totalScore / totalSubject;
            labels.add(new Label(pupil.name(), averageScore));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        int totalStudents = pupils.size();
        LinkedHashMap<String, Integer> subjectScore = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScore.merge(subject.name(), subject.score(), Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> entry : subjectScore.entrySet()) {
            String subjectName = entry.getKey();
            int sumOfScores = entry.getValue();
            double averageScore = (double) sumOfScores / totalStudents;
            labels.add(new Label(subjectName, averageScore));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double totalScore = 0.0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            labels.add(new Label(pupil.name(), totalScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.isEmpty() ? null : labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        LinkedHashMap<String, Integer> subjectScore = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScore.merge(subject.name(), subject.score(), Integer::sum);
            }
        }

        for (Map.Entry<String, Integer> entry : subjectScore.entrySet()) {
            String subjectName = entry.getKey();
            int sumOfScores = entry.getValue();
            labels.add(new Label(subjectName, sumOfScores));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.isEmpty() ? null : labels.get(labels.size() - 1);
    }
}