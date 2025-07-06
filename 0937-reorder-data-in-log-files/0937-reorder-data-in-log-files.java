import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            // 공백 기준으로 처음 한 번만 split → [identifier, content]
            String[] split = log.split(" ", 2);
            String content = split[1];

            if (Character.isDigit(content.charAt(0))) {
                digitLogs.add(log); 
            } else {
                letterLogs.add(log); 
            }
        }

        // letter-log 정렬
        Collections.sort(letterLogs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            int cmp = split1[1].compareTo(split2[1]); // 내용 기준 정렬
            if (cmp == 0) {
                return split1[0].compareTo(split2[0]); // 내용이 같으면 식별자 기준
            } else {
                return cmp;
            }
        });

        List<String> result = new ArrayList<>();
        result.addAll(letterLogs);
        result.addAll(digitLogs);

        return result.toArray(new String[0]);
    }
}
