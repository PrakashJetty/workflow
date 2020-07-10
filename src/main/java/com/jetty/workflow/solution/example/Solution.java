package com.jetty.workflow.solution.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class solution {

    private static class TimeInfo implements Comparable {
        public int start;
        public int end;
        public String subject;

        public TimeInfo(int start, int end, String subject) {
            this.start = start;
            this.end = end;
            this.subject = subject;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TimeInfo)) return false;

            TimeInfo timeInfo = (TimeInfo) o;

            return subject != null ? subject.equals(timeInfo.subject) : timeInfo.subject == null;
        }

        @Override
        public int hashCode() {
            return subject != null ? subject.hashCode() : 0;
        }

        public int compareTo(Object o) {
            TimeInfo t = (TimeInfo) o;
            if (this.start > t.start) {
                return 1;
            } else if (this.start < t.start) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Set<TimeInfo> timeInfos = new HashSet<>();
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int t1 = sc.nextInt();
            for (int m = 0; m < t1; m++) {
                String s = sc.next();
                String[] subjectInfo = s.split(" ");
                TimeInfo timeInfo = new TimeInfo(Integer.parseInt(subjectInfo[1]), Integer.parseInt(subjectInfo[2]), subjectInfo[0]);
                timeInfos.add(timeInfo);
            }
        }


    }
}