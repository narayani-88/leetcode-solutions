class Solution {
    public String convert(String s, int numRows) {

        // 1 box means nothing moves, so the answer is the same string
        if (numRows == 1) {
            return s;
        }

        // make the boxes: numRows empty StringBuilders
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int box = 0;          // where I'm standing
        int direction = 1;    // +1 forward, -1 backward

        // go through each letter of the string
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            rows[box].append(letter);     // drop the letter into the current box

            if (box == 0) {
                direction = 1;
            }
            if (box == numRows - 1) {
                direction = -1;
            }

            box = box + direction;        // take one step
        }

        // read the boxes one after another
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            answer.append(rows[i]);
        }

        return answer.toString();
    }
}